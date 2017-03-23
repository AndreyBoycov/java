public class Exponentiation{
	
	public static void main(String[] args){
		try{
			int x=1;
			for (int i=0; i<Integer.parseInt(args[1]); i++){
			x*=Integer.parseInt(args[0]);
			}
		System.out.println(x);
		}
		catch(NumberFormatException a){
		System.out.println("Введено неправильное выражение");
		}
	}
}