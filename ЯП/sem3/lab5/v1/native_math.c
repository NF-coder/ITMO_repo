// gcc -shared -o native_math.so -fPIC native_math.c

#ifdef _WIN32
  #define DLLEXPORT __declspec(dllexport)
#else
  #define DLLEXPORT
#endif

// Рекурсивная реализация (для демонстрации накладных расходов и нагрузки CPU)
DLLEXPORT long long fib_c_recursive(int n) {
    if (n <= 1) return n;
    return fib_c_recursive(n - 1) + fib_c_recursive(n - 2);
}

// Итеративная реализация (оптимизированная)
DLLEXPORT long long fib_c_iterative(int n) {
    if (n <= 1) return n;
    long long a = 0, b = 1, temp;
    for (int i = 2; i <= n; i++) {
        temp = a + b;
        a = b;
        b = temp;
    }
    return b;
}