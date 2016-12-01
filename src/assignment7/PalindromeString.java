package assignment7;

public class PalindromeString {
	public static boolean palindromeHelper(String s) {
		int len = s.length();
		
		/// base case I
	    if (len <= 1)
	        return true;
	    
	    /// base case II
	    else if (s.charAt(0) != s.charAt(len-1))
	        return false;
	    else
	        return palindromeHelper(s.substring(1, len-1));
		
		
	}
	
	public static boolean palindrome(String s){
		s = s.toLowerCase().replaceAll("\\W", "");
		
		return palindromeHelper(s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Able was I, ere I saw Elba";
		System.out.println(s1 + " is palindrome? : " +palindrome(s1));
		
		String s2 = "A man, a plan, a canal Panama";
		System.out.println(s2 + " is palindrome? : " +palindrome(s2));
		
		String s3 = "Desserts I stressed";
		System.out.println(s3 + " is palindrome? : " +palindrome(s3));
		
		String s4 = "Kayak";
		System.out.println(s4  + " is palindrome? : " + palindrome(s4));
	}

}
