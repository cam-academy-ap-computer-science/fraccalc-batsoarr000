package fracCalc;

import java.util.*;

public class FracCalc {
	/*
	 * Create code that sets strings that the user assigns, ask 'calculate fraconetion
	 * or quit' run string through produceanswer method
	 * 
	 * produceanswer breaks up string into three parts, first fraconetion, operator,
	 * second fraconetion adds and returns ther answer
	 * 
	 * main continues to ask for string until user types quit
	 */

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation
		String string = "";
		Scanner enter = new Scanner(System.in);
		while (!string.contentEquals("quit")) {
			System.out.println("Enter fractions");
			string = enter.nextLine();
			String first = produceAnswer(string);
			System.out.println(first);
			String second = produceAnswertwo(string);
			Stirng finish = findanswer(first, second);
			if (string.contentEquals("quit")) {
				System.out.println("Bye");
			}
		}
	}

	/*
	 * ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
	 * test your code This function takes a String 'input' and produces the result
	 *
	 * input is a fraction string that needs to be evaluated. For your program, this
	 * will be the user input. e.g. input ==> "1/2 + 3/4"
	 * 
	 * The function should return the result of the fraction after it has been
	 * calculated e.g. return ==> "1_1/4"
	 */
	public static String produceAnswer(String input) { 
		// TODO: Implement this function to produce the solution to the input
		String[] split = input.split("\\s+");
		String fracone = split[2];
		if (fracone.indexOf("/") == -1) {
			String whole = fracone.substring(0, fracone.length());
			String numerator = "0";
			String denominator = "1";
			String answer = "whole:" + whole + " numerator:" + numerator + " denominator:" + denominator;
			return answer;
		} else if (fracone.indexOf("_") == -1 ) {
			String whole = "0";
			String numerator = fracone.substring(0, fracone.indexOf("/"));
			String denominator = fracone.substring(fracone.indexOf("/") + 1, fracone.length());
			String answer = "whole:" + whole + " numerator:" + numerator + " denominator:" + denominator;
			return answer;
		} else if (fracone.indexOf("/") != -1 && fracone.indexOf("_") != -1) {
			String whole = fracone.substring(0, fracone.indexOf("_"));
			String numerator = fracone.substring(fracone.indexOf("_") + 1, fracone.indexOf("/"));
			String denominator = fracone.substring(fracone.indexOf("/") + 1, fracone.length());
			String answer = "whole:" + whole + " numerator:" + numerator + " denominator:" + denominator;
			return answer;
		} else {
			String answer = "whole:-1 numerator:-1 denominator:-1";
			return answer;
		}
	}
	public static String produceAnswertwo(String input) { 
		// TODO: Implement this function to produce the solution to the input
		String[] split = input.split("\\s+");
		String fracone = split[1];
		if (fracone.indexOf("/") == -1) {
			String whole = fracone.substring(0, fracone.length());
			String numerator = "0";
			String denominator = "1";
			String answer = "whole:" + whole + " numerator:" + numerator + " denominator:" + denominator;
			return answer;
		} else if (fracone.indexOf("_") == -1 ) {
			String whole = "0";
			String numerator = fracone.substring(0, fracone.indexOf("/"));
			String denominator = fracone.substring(fracone.indexOf("/") + 1, fracone.length());
			String answer = "whole:" + whole + " numerator:" + numerator + " denominator:" + denominator;
			return answer;
		} else if (fracone.indexOf("/") != -1 && fracone.indexOf("_") != -1) {
			String whole = fracone.substring(0, fracone.indexOf("_"));
			String numerator = fracone.substring(fracone.indexOf("_") + 1, fracone.indexOf("/"));
			String denominator = fracone.substring(fracone.indexOf("/") + 1, fracone.length());
			String answer = "whole:" + whole + " numerator:" + numerator + " denominator:" + denominator;
			return answer;
		} else {
			String answer = "whole:-1 numerator:-1 denominator:-1";
			return answer;
		}
	}
	public static string findanswer(String first, String second) {
		String operator = split[1];
	}
	// TODO: Fill in the space below with any helper methods that you think you will
	// need

}
