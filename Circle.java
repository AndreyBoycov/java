import java.util.Scanner;

/**
 * Created by boecn on 28.03.2017.
 */
public class Circle implements inter {
    private double r;
    double pi = 3.14;
    public Circle(double r) {
        this.r=r;
    }

    public double area() {
        double S=pi * Math.pow(r, 2);
        return S;
    }
    public double perimetr() {
        double P=2*pi*r;
        return P;
    }
}
