
import java.util.Scanner;


public class Triangle implements inter {
    private double a;
    private double b;
    private double c;
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double area() {
        double p=(a+b+c)/2;
        double S=Math.sqrt(p*(p-a)*(p-b)*(p-b));
        return S;
    }
    public double perimetr(){
        double P=a+b+c;
        return P;
    }
}