public class Factorial {
	public static void main(String[] args){
		
		try{
		System.out.println(f(Integer.parseInt(args[0])));
		
		}
		catch(NumberFormatException a){
		System.out.println("Введено неправильное выражение");
		}
	}
	public static int f(int a){
		if(a==1)
			return 1;
		return f(a-1)*a;
		
		}
}