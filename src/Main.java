public class Main {
    private static final double E = Math.pow(10, -4);
    private static final double B = 1;
    private static final double A = -1;
    private static final int N = 10;

    public static void main(String[] args) {
        NonLinearEquations processor = new NonLinearEquations() {
            @Override
            public double f(double x) {
                return Math.pow(x, 2) + 1 - Math.acos(x);
            }

            @Override
            public double diff(double x) {
                return 2 * x + 1 / (Math.sqrt(1 - Math.pow(x, 2)));
            }

            @Override
            public double diff2(double x) {
                return x / (Math.pow((1 - Math.pow(x, 2)), 1.5)) + 2;
            }
        };

        try {
            System.out.println("Ответ: " + processor.newtonMethod(A, B, E, N));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}