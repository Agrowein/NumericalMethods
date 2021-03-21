public class Main {
    private static final double e = Math.pow(10, -5);
    private static double a = 0;
    private static double b = Math.PI * 2;

    public static void main(String[] args) {
        NMNonlinearEquations processor = new NMNonlinearEquations() {
            @Override
            public double f(double x) {
                return (Math.pow(x, 2)) * Math.sin(x) + Math.cos(Math.pow(x, 2));
            }
        };
        System.out.println(processor.bisectionMethod(a,b,e));
        System.out.println(processor.methodChord(a,b,e));

    }



}