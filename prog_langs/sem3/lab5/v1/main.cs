//  export PYTHONNET_PYDLL="/home/nf/Рабочий стол/итмо/ITMO_repo/prog_langs/sem3/lab5/bin/python3.so"

using System;
using System.Runtime.InteropServices;
using System.Diagnostics;
using Python.Runtime;

namespace InteropLab
{
    class NativeWrapper
    {
        const string LibName = "native_math";

        [DllImport(LibName, CallingConvention = CallingConvention.Cdecl)]
        public static extern long fib_c_recursive(int n);

        [DllImport(LibName, CallingConvention = CallingConvention.Cdecl)]
        public static extern long fib_c_iterative(int n);
    }

    class PythonIntegrator
    {
        public static void RunDemo()
        {
            Console.WriteLine("\n--- Запуск Python из среды .NET ---");

            // Шаг 1: Инициализация Python Engine
            // Важно: Путь к Python DLL должен быть корректно настроен в системе
            if (!PythonEngine.IsInitialized)
            {
                PythonEngine.Initialize();
            }

            // Шаг 2: Захват GIL (Global Interpreter Lock)
            using (Py.GIL())
            {
                try
                {
                    // Демонстрация 1: Выполнение простого скрипта
                    PythonEngine.RunSimpleString("print('[Python] Привет из встроенного интерпретатора!')");

                    // Демонстрация 2: Импорт модулей и использование объектов
                    // Аналог в Python: import math
                    dynamic math = Py.Import("math");
                    
                    // Вызов функции Python из C#
                    double pi = math.pi;
                    double sinValue = math.sin(pi / 2);
                    
                    Console.WriteLine($"[C#] Получено из Python math.pi: {pi}");
                    Console.WriteLine($"[C#] Результат math.sin(pi/2): {sinValue}");

                    // Демонстрация 3: Обработка списков
                    // Создаем список в Python
                    dynamic pyList = new PyList();
                    pyList.append(10);
                    pyList.append(20);
                    pyList.append(30);

                    // Исполняем Python-код над переданным объектом
                    // Аналог: sum(pyList)
                    dynamic builtins = Py.Import("builtins");
                    dynamic sum = builtins.sum(pyList);

                    Console.WriteLine($"[C#] Сумма элементов списка, посчитанная в Python: {sum}");
                }
                catch (PythonException ex)
                {
                    Console.WriteLine($"[Ошибка Python] {ex.Message}");
                }
            }

            // Шаг 3: Корректное завершение работы (опционально, если приложение завершается)
            // PythonEngine.Shutdown(); 
        }
    }

    class Program
    {
        static long FibManaged(int n)
        {
            if (n <= 1) return n;
            return FibManaged(n - 1) + FibManaged(n - 2);
        }

        static void Main(string[] args)
        {
            int n = 42;
            Console.WriteLine($"[Анализ производительности] Вычисление Fib({n})");

            // 1. Managed C#
            var sw = Stopwatch.StartNew();
            long resCs = FibManaged(n);
            sw.Stop();
            Console.WriteLine($"C# Managed: {resCs} | Время: {sw.ElapsedMilliseconds} мс");

            // 2. Unmanaged C (Recursive)
            sw.Restart();
            long resC = NativeWrapper.fib_c_recursive(n);
            sw.Stop();
            Console.WriteLine($"C Native:   {resC} | Время: {sw.ElapsedMilliseconds} мс");

            // 3. Python
            sw.Restart();
            PythonIntegrator.RunDemo();
            sw.Stop();
            Console.WriteLine($"C# Managed: {resCs} | C Native:   {resC} | Время: {sw.ElapsedMilliseconds} мс");
        }
    }
}



