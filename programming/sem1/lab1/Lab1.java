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

        z_out(
            z_generator(x, z)
        );
    }

    public static void z_out(float[][] arr){
        for (float[] line: arr){
            for (float sym: line){
                System.out.format("%.3f ", sym);
            }
            System.err.println();
        }
    }

    public static float[][] z_generator(float[] x, long[] z_) {
        float[][] z = new float[14][12];

        for (int i = 0; i < 14; i ++){
            for (int j = 0; j<12; j++){
                if (z_[i] == 9){
                    z[i][j] = cond1(x[j]);
                } else if (z_[i] == 2 || z_[i] == 6 || (11 <= z_[i] & z_[i] <= 15)) {
                    z[i][j] = cond2(x[j]);
                } else {
                    z[i][j] = cond3(x[j]);
                }
            }
        }

        return z;
    }

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