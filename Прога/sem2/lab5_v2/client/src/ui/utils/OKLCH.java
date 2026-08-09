package ui.utils;

public class OKLCH {
    // Convert OKLCH to RGB [0, 255]
    public static int[] run(double l, double c, double hDegrees) {
        // Convert LCH to Lab
        double hRad = Math.toRadians(hDegrees);
        double a = Math.cos(hRad) * c;
        double b = Math.sin(hRad) * c;

        // OKLab to linear RGB
        double L = l;
        double M = L + 0.3963377774 * a + 0.2158037573 * b;
        double S = L - 0.1055613458 * a - 0.0638541728 * b;

        // Cubed
        double l_ = L * L * L;
        double m_ = M * M * M;
        double s_ = S * S * S;

        // Linear RGB
        double rLin = +4.0767416621 * l_ - 3.3077115913 * m_ + 0.2309699292 * s_;
        double gLin = -1.2684380046 * l_ + 2.6097574011 * m_ - 0.3413193965 * s_;
        double bLin = -0.0041960863 * l_ - 0.7034186147 * m_ + 1.7076147010 * s_;

        // Gamma correction
        int r = (int) Math.round(255 * toSrgb(rLin));
        int g = (int) Math.round(255 * toSrgb(gLin));
        int b_ = (int) Math.round(255 * toSrgb(bLin));

        // Clamp values to [0,255]
        return new int[]{
                clamp(r, 0, 255),
                clamp(g, 0, 255),
                clamp(b_, 0, 255)
        };
    }

    // Helper function for sRGB gamma correction
    private static double toSrgb(double c) {
        return c <= 0.0031308 ? 12.92 * c : 1.055 * Math.pow(c, 1.0 / 2.4) - 0.055;
    }

    // Clamp helper
    private static int clamp(int val, int min, int max) {
        return Math.max(min, Math.min(max, val));
    }

    // Example usage
    public static void main(String[] args) {
        // Example: OKLCH(0.8, 0.1, 90)
        int[] rgb = OKLCH.run(0.73, 0.1, 49);
        System.out.printf("RGB: %d, %d, %d\n", rgb[0], rgb[1], rgb[2]);
    }
}