import java.util.Scanner;

public class komplex {
    public static void main(String[] args) {
        System.out.println("Enter transaction number:\n1-sum,\n2-residual,\n3-multiplication,\n4-degree,\n5-radical ");
        Scanner scanner = new Scanner(System.in);
        String name_figure = scanner.next();
        System.out.print("Enter  A1=");
        Scanner A1 = new Scanner(System.in);
        double a1 = A1.nextInt();

        System.out.print("Enter  B1=");
        Scanner B1 = new Scanner(System.in);
        double b1 = B1.nextInt();

        System.out.print("Enter  A2=");
        Scanner A2 = new Scanner(System.in);
        double a2 = A2.nextInt();

        System.out.print("Enter  B2=");
        Scanner B2 = new Scanner(System.in);
        double b2 = B2.nextInt();
        double A,B;
        switch (name_figure.toLowerCase()){
            //sum
            case "1": {
                A=a1+a2;
                B=b1+b2;
                System.out.println("Z=" + A + "+" + B + "i");
            }
            //residual
            case "2": {
                A=a1-a2;
                B=b1-b2;
                System.out.println("Z=" + A + "+" + B + "i");
            }
            case "3": {

                if (b1<0 || b2<0) {
                    A = (a1*a2)+(-1*(b2*b1));
                    B = (a1*b2)+(b1*a2);
                }
                else {
                    A = a1*a2;
                    B = (a1*b2)+(b1*a2)+(b2*b1);
                }
                System.out.println("Z=" + A + "+" + B + "i");
            }
            case "4": {
                if (b2<0 || b1<0){
                    A=((a1*a2)+(-1*(b1*b2))/((a1*a1)+(b2*b2)));
                    B=((a1*b2)+(b1*a2))/((a1*a1)+(b2*b2));
                }
                else{
                    A = (a1*a2)+(-1*(b2*b1));
                    B = (a1*b2)+(b1*a1);
                }
                System.out.println("Z=" + A + "+" + B + "i");
            }
        }
    }
}
