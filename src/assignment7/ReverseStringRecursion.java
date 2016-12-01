package assignment7;

public class ReverseStringRecursion {
	
	public static String reverse(String s) {
		if (s.length() == 1) {
			return s;
		} 
		return reverse(s.substring(1)) + s.charAt(0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "hello world";
		System.out.println(s + " ==> " + reverse(s));
		
		String s2 = "java";
		System.out.println(s2 + " ==> " + reverse(s2));
		
		String s3 = "recursion";
		System.out.println(s3 + " ==> " + reverse(s3));
	}

}
