module Main

import Matrix
import Gaussian
import IOHelpers
import Data.List
import System


-- Наводим красоту
beautifulDelim : Nat -> Char -> String -> IO()
beautifulDelim n sym title =
  let delim = pack(replicate n sym)
  in putStrLn (delim ++ " " ++ title ++ " " ++ delim)

beautifulDelimDefault : String -> IO()
beautifulDelimDefault title = beautifulDelim 15 '=' title


-- Основная часть проги
calc : Matrix -> IO ()
calc matrx = do
  putStrLn ""
  beautifulDelimDefault "Solution Start"

  putStrLn "Исходная матрица:"
  printMatrix matrx
  
  let (triMaybe, swap) = forward matrx 0

  tri <- case triMaybe of
    Nothing => do
      putStrLn "Система вырожденная! Треугольная матрица не существует."
      exitFailure
    Just t => do
      putStrLn "\nТреугольная матрица:"
      printMatrix t
      pure t

  detVal <- case det (Just tri) swap of
    Nothing => do
      putStrLn "Не удалось посчитать определитель!"
      exitFailure
    Just x => pure x

  putStrLn "\nОпределитель:"
  putStrLn (show (roundTo3 detVal))

  sol <- case backSub (Just tri) of
    Nothing => do
      putStrLn "Система вырожденная! Решений нет или бесконечно много."
      exitFailure
    Just x => pure x

  putStrLn "\nВектор решений:"
  printVector sol

  res <- case residual (Just matrx) (Just sol) of
    Nothing => do
      putStrLn "Не удалось посчитать вектор невязок"
      exitFailure
    Just r => pure r

  putStrLn "\nВектор невязок:"
  printVector res


  beautifulDelimDefault "Solution Finish"
  putStrLn ""

mainLoop : IO ()
mainLoop = do
  putStrLn "1 - ввод с клавиатуры"
  putStrLn "2 - ввод из файла"
  putStrLn "иное - выход"

  mode <- getLine

  m <- case mode of
    "1" => do
      putStr "Введите n (<=20): "
      ns <- getLine

      n <- case (safeInt ns) of
       Nothing => do
        putStrLn "Ошибка: n должно быть целым числом"
        exitFailure
       Just v =>
        if v <= 0 || v > 20 then do
          putStrLn "Ошибка: n должно быть в диапазоне 1..20"
          exitFailure
        else pure v

      putStrLn "Введите строки расширенной матрицы (a1 ... an b):"
      readMatrix n (cast n + 1)
    "2" => do
      putStr "Введите имя файла: "
      f <- getLine
      readMatrixFile f
    _ => do
      putStrLn "Неверный режим. Завершение программы"
      exitFailure
  
  calc m
  mainLoop

main : IO ()
main = mainLoop