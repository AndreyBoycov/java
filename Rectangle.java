import java.util.Scanner;


public class Rectangle implements inter {
    private double a;
    private double b;
    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double area(){
        double S=a*b;
        return  S;
    }
    public double perimetr(){
        double P=2*(a+b);
        return P;
    }
}
