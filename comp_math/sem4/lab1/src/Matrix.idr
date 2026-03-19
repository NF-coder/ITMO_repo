module Matrix

import Data.List


public export
Vector : Type
Vector = List Double

public export
Matrix : Type
Matrix = List Vector

public export
len : List a -> Int
len xs = cast (length xs)

public export
at : Int -> List a -> a
at _ [] = believe_me ()
at 0 (x :: xs) = x
at n (x :: xs) = at (n - 1) xs

public export
replace : Int -> a -> List a -> List a
replace _ _ [] = []
replace 0 v (_ :: xs) = v :: xs
replace n v (x :: xs) = x :: replace (n - 1) v xs

public export
scaleRow : Double -> Vector -> Vector
scaleRow k r = map (*k) r

public export
subRow : Vector -> Vector -> Vector
subRow r1 r2 = zipWith (-) r1 r2

public export
takeInt : Int -> List a -> List a
takeInt n xs = if n <= 0 then [] else
  case xs of
    [] => []
    (x :: xs') => x :: takeInt (n - 1) xs'

public export
dropInt : Int -> List a -> List a
dropInt n xs = if n <= 0 then xs else
  case xs of
    [] => []
    (_ :: ys) => dropInt (n - 1) ys

public export
swapRows : Int -> Int -> Matrix -> Matrix
swapRows i j m =
  let ri = at i m
      rj = at j m
      m1 = replace i rj m
  in replace j ri m1