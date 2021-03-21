import utils.Differentiable;
import utils.NoDifferentialException;
import utils.NoSolutionException;
import utils.Segment;

public abstract class NonLinearEquations implements Differentiable {
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

    public double newtonMethod(double a, double b, double e, int N) throws NoSolutionException, NoDifferentialException {
        Segment localized = localize(a, b, N);
        assert localized != null;
        a = localized.getA();
        b = localized.getB();

        double x;
        if (f(a) * diff2(a) > 0) {
            x = a;
        } else if (f(b) * diff2(b) > 0) {
            x = b;
        } else {
            throw new NoSolutionException();
        }
        int iter = 0;
        while (Math.abs(f(x)) >= e) {
            iter++;
            x = x - f(x) / diff(x);
        }
        System.out.println("Итераций: " + iter);
        return x;
    }

    Segment localize(double a, double b, int N) {
        Segment seg = new Segment(a, b);
        double h = (b - a) / N;
        for (int k = 0; k < N; k++) {
            double xk = a + k * h;
            double xkPlus1 = a + (k + 1) * h;
            if (f(xk) * f(xkPlus1) < 0) {
                seg.setA(xk);
                seg.setB(xkPlus1);
                return seg;
            }
        }
        return null;
    }

    @Override
    public double diff2(double x) throws NoDifferentialException {
        throw new NoDifferentialException();
    }

    @Override
    public double diff(double x) throws NoDifferentialException {
        throw new NoDifferentialException();
    }

    public abstract double f(double x);
}
