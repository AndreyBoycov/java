public class Sum{
	public static void main(String[] args){
		try{
		System.out.println(Integer.parseInt(args[0])+Integer.parseInt(args[1]));
		
		}
		catch(NumberFormatException a){
		System.out.println("Введено неправильное выражение");
		}
	}
}