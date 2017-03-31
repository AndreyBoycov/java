import java.util.Scanner;


public class Figures {
    public static void main(String[] args) {
        System.out.print("1-Triangle\n" + "2-Circle\n" + "3-Rectangle\n" + "4-Square\n" + "Select figure number: ");
        try {
            Scanner figurenumber = new Scanner(System.in);
            int i = figurenumber.nextInt();
            inter figure = null;
            if (i > 4 || i < 1) {
                System.out.println("Not Found");
            }
            if (i == 1) {
                System.out.print("Enter the base side A ");
                Scanner sideA = new Scanner(System.in);
                int a = sideA.nextInt();
                System.out.print("Enter the base side B ");
                Scanner sideB = new Scanner(System.in);
                int b = sideB.nextInt();
                System.out.print("Enter the base side C ");
                Scanner sideC = new Scanner(System.in);
                int c = sideC.nextInt();
                figure = new Triangle(a, b, c);
            }
            if (i == 2) {
                System.out.print("Enter the radius ");
                Scanner radius = new Scanner(System.in);
                int r = radius.nextInt();
                figure = new Circle(r);
            }
            if (i == 3) {
                System.out.print("Enter side a");
                Scanner sideA = new Scanner(System.in);
                int a = sideA.nextInt();
                System.out.print("Enter side b");
                Scanner sideB = new Scanner(System.in);
                int b = sideB.nextInt();
                figure = new Rectangle(a, b);
            }
            if (i == 4) {
                System.out.print("Enter side a ");
                Scanner sideA = new Scanner(System.in);
                int a = sideA.nextInt();
                figure = new Square(a);
            }
            System.out.println("S=" + figure.area());
            System.out.println("P=" + figure.perimetr());
        }
        catch(NumberFormatException e){
            System.out.println("invalid value");
        }
    }

}

