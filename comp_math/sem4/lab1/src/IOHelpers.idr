module IOHelpers

import Matrix
import System
import System.File
import Data.String

-- Переделки для валидированного ввода
export
safeDouble : String -> Maybe Double
safeDouble s =
  case parseDouble s of
    Just v => Just v
    Nothing => Nothing

export
safeInt: String -> Maybe Int
safeInt s =
  case parseInteger s of
    Just v => Just v
    Nothing => Nothing

parseDoubles : List String -> Maybe (List Double)
parseDoubles [] = Just []
parseDoubles (x :: xs) =
  case safeDouble x of
    Nothing => Nothing
    Just v =>
      case parseDoubles xs of
        Nothing => Nothing
        Just rest => Just (v :: rest)

readRow : Int -> Nat -> IO (List Double)
readRow n totalInLine = do
  line <- getLine
  let ws = words line

  if length ws /= totalInLine then do
    putStrLn ("Ошибка: нужно ввести " ++ show totalInLine ++ " чисел")
    readRow n totalInLine
    else
      case parseDoubles ws of
        Nothing => do
          putStrLn "Ошибка: все значения должны быть числами"
          readRow n totalInLine
        Just nums => pure nums

export
readMatrix : Int -> Nat -> IO Matrix
readMatrix 0 _ = pure []
readMatrix n totalInLine = do
  row <- readRow n totalInLine
  rest <- readMatrix (n - 1) totalInLine
  pure (row :: rest)

export
readMatrixFile : String -> IO Matrix
readMatrixFile path = do
  Right content <- readFile path
    | Left err => do
        putStrLn "Ошибка чтения файла"
        exitFailure

  let ls = lines content
  let parsed = map words ls

  let tryParse = traverse parseDoubles parsed

  case tryParse of
    Nothing => do
      putStrLn "Ошибка: файл содержит нечисловые значения"
      pure []
    Just rows => pure rows


-- Округление до n знаков после .
roundToN : Double -> Nat -> Double
roundToN number n =
  let roundingMul : Double
      roundingMul = pow 10 (cast n)
      y : Integer
      y = cast (number * roundingMul + 0.5)
  in cast y / roundingMul

export
roundTo3 : Double -> Double
roundTo3 x = roundToN x 3


-- Пад пробелами до n символов
formatToLen : Double -> Nat -> String
formatToLen number size =
  let s = show (roundTo3 number)
      padding = minus size (length s)
  in pack (replicate padding ' ') ++ s

formatTo8 : Double -> String
formatTo8 x = formatToLen x 8


-- Вывод векторов и матрицы
export
printVector : List Double -> IO ()
printVector [] = putStrLn ""
printVector (num :: rest) = do
  putStr (formatTo8 num ++ " ")
  printVector rest

export
printMatrix : Matrix -> IO ()
printMatrix [] = pure ()
printMatrix (vector :: rest) = do
  printVector vector
  printMatrix rest