package utils;

public interface Differentiable {
    double diff(double x) throws NoDifferentialException;

    double diff2(double x) throws NoDifferentialException;
}
