module Gaussian

import Data.List
import Matrix


findNonZero : Matrix -> Int -> Int -> Maybe Int
findNonZero m col i =
  if i >= len m then Nothing
  else if at col (at i m) /= 0.0 then Just i
  else findNonZero m col (i + 1)

-- В лоб
-- forward : Matrix -> Int -> Matrix
-- forward m k =
--   if k >= len m then m else
--     let pivotRow = at k m
--         pivot = at k pivotRow

--         eliminate : Int -> Matrix -> Matrix
--         eliminate i mat =
--           if i >= len mat then mat else
--           if i <= k then eliminate (i + 1) mat else
--             let
--               rowi = at i mat
--               factor = (at k rowi) / pivot
--               newRow = subRow rowi (scaleRow factor pivotRow)
--               newMat = replace i newRow mat
--             in eliminate (i + 1) newMat
--     in forward (eliminate 0 m) (k + 1)

-- С перестановкой если опорный элемент 0 + подсчёт числа перестановок
export
forward : Matrix -> Int -> (Maybe Matrix, Int)
forward m k =
  if k >= len m then (Just m, 0) else
    let pivotRow = at k m
        pivot = at k pivotRow
    in
      if pivot == 0.0 then
        case findNonZero m k (k + 1) of
          Nothing => (Nothing, 0) -- матрица вырожденная
          Just r =>
            let swapped = swapRows k r m
                (m2, s) = forward swapped k
            in (m2, s + 1)
      else
        let
          eliminate : Int -> Matrix -> Matrix
          eliminate i mat =
            if i >= len mat then mat else
            if i <= k then eliminate (i + 1) mat else
              let
                rowi = at i mat
                factor = (at k rowi) / pivot
                newRow = subRow rowi (scaleRow factor pivotRow)
                newMat = replace i newRow mat
              in eliminate (i + 1) newMat
        in forward (eliminate 0 m) (k + 1)


export
backSub : Maybe Matrix -> Maybe Vector
backSub Nothing = Nothing
backSub (Just m) = solve (reverse m) []
  where
    solve : Matrix -> Vector -> Maybe Vector
    solve [] acc = Just acc
    solve (row :: rs) acc =
      let
        n = len row - 1
        b = at n row
        coeffs = takeInt n row
        known = sum (zipWith (*) (dropInt (n - len acc) coeffs) acc)
        aii = at (n - len acc - 1) coeffs
        x = (b - known) / aii
      in solve rs (x :: acc)

export
diagProduct : Matrix -> Int -> Double
diagProduct m i =
  if i >= len m then 1.0
  else (at i (at i m)) * diagProduct m (i + 1)

-- Определитель с учётом числа перестановок
export
det : Maybe Matrix -> Int -> Maybe Double
det Nothing _ = Nothing
det (Just m) swaps =
  let d = diagProduct m 0
  in Just (if mod swaps 2 == 0 then d else -d)

-- Вектор невязок
export
residual : Maybe Matrix -> Maybe Vector -> Maybe Vector
residual Nothing _ = Nothing
residual _ Nothing = Nothing
residual (Just []) _ = Just []
residual (Just (row :: rs)) (Just x) =
  let
    n = len row - 1
    coeffs = takeInt n row
    b = at n row
    lhs = sum (zipWith (*) coeffs x)
  in case residual (Just rs) (Just x) of
       Nothing => Nothing
       Just rest => Just ((lhs - b) :: rest)