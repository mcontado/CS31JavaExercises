package mystacks;

import java.util.Scanner;
import java.util.Stack;

public class Assignment9_Stacks {
	
	public static boolean isNumber(String str)  
	{  
	  try  
	  {   
	    int d = Integer.parseInt(str);
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	private static int eval(String pExpr)

	{

		// Split the string
		String[] parts = pExpr.split(" ");

		// Read the string backwards, push values of subexpressions
		// on a stack as the subexpressions are evaluated.
		// When and operator is encountered, pop the last two values
		// from the stack, apply the operator, and push the result.
		// If the expression is well formed, the result is the
		// single value left on the stack at the end.

		Stack<Integer> stack = new Stack<Integer>();

		for (int k = parts.length - 1; k >= 0; k--)
		{

			if (isNumber(parts[k]))

				stack.push(Integer.parseInt(parts[k]));

			else

			{

				// We have an operator * or +:

				// Pop two values off of the stack and apply the operator

				// and then push the result.

				int leftOperand = stack.pop();

				int rightOperand = stack.pop();

				if (parts[k].equals("*"))

					stack.push(leftOperand * rightOperand);

				if (parts[k].equals("+"))

					stack.push(leftOperand + rightOperand);

			}

		}

		return stack.pop();

	}
	
	public static void main(String[] args) {
		String input;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the expression:");
		input = in.nextLine();
		System.out.println("Output: " + eval(input));
	
	}

}
