public abstract class NMNonlinearEquations  {
    public double bisectionMethod(double a, double b, double e) {
        double c;
        while (Math.abs(a - b) > e) {
            c = (a + b) / 2;
            if (f(a) * f(c) <= 0) b = c;
            else {
                a = c;
            }
        }
        return (a + b) / 2;
    }

    public double methodChord(double x_prev, double x_curr, double e) {
        double a = x_prev;
        double b = x_curr;
        double c = a;
        double g;
        do {
            g = c;
            c = (a * f(b) - b * f(a)) / (f(b) - f(a));
            if ((f(a) * f(c)) < 0)
                b = c;
            else
                a = c;
        } while (Math.abs(g - c) > e);
        return c;
    }

    public abstract double f(double x);
}
