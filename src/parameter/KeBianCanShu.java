package parameter;

public class KeBianCanShu {
    public static void main(String[] args) {
		change();
	}
    
    public static void change(Integer ... args) {
    	System.out.println(args.length);
    	for (Integer integer : args) {
		     System.out.println(integer);
    		
		}
    }
}
