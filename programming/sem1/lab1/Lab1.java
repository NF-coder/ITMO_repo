/**
 * Программа для первой лабы
*/
public class Lab1 {
    public static void main(String[] args) {
        long[] z = new long[14];
        for (int i = 2; i <= 15; i++) {
            z[i-2] = (long) i; // int -> long
        }
        
        float[] x = new float[12];
        for (int i = 0; i < 12; i++) {
            float random_num = (float) Math.random(); // double -> float
            x[i] = -15 + random_num*28;
        }

        zOut(
            zGenerator(x, z)
        );
    }

    /**
    * Вывод двумерного массива
    */
    public static void zOut(float[][] arr){
        for (float[] line: arr){
            for (float sym: line){
                System.out.format("%.3f ", sym);
            }
            System.out.println();
        }
    }

    /**
    * Создание двумерного массива
    */
    public static float[][] zGenerator(float[] x, long[] z_) {
        float[][] z = new float[14][12];

        for (int i = 0; i < 14; i ++){
            for (int j = 0; j<12; j++){
                z[i][j] = switch ((int) z_[i]){
                    case 9 -> cond1(x[j]);
                    case 2,6,11,12,13,14,15 -> cond2(x[j]);
                    default -> cond3(x[j]);
                };
            }
        }

        return z;
    }

    /**
    * Условие генерации строки двумерного массива №1
    */
    public static float cond1(float x){
        float result = (float) Math.pow(
            Math.cbrt(
                Math.sin(x)
            ) * (
                (
                    2/3*x - 1/3
                )/(
                    Math.atan(
                        (x-1)/28
                    )
                ) - 1
            ),
            2
        ); // don't need high precision
        return result;
    }

    /**
    * Условие генерации строки двумерного массива №2
    */
    public static float cond2(float x){
        float result = (float) Math.tan(
            Math.cos(
                Math.pow(
                    x - 1/4,
                    x
                )
            )
        ); // don't need high precision
        return result;
    }

    /**
    * Условие генерации строки двумерного массива №3
    */
    public static float cond3(float x){
        float result = (float) Math.sin(
            Math.pow(
                (Math.tan(x)/6),
                Math.cos(Math.cos(x))
            )
        ); // don't need high precision + some optimizations
        return result;
    }
}