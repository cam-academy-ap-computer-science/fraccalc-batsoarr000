package fracCalc;

import java.util.*;

public class FracCalc {
	/*
	 * Create code that sets strings that the user assigns, ask 'calculate fraction
	 * or quit' run string through produceanswer method
	 * 
	 * produceanswer breaks up string into three parts, first fraction, operator,
	 * second fraction adds and returns ther answer
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
			String answer = produceAnswer(string);
			System.out.println(answer);
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
		if (split.length == 13) {
			String whole = split[2].substring(0, 1);
			String operator = split[2].substring(3, 4);
			String numerator = split[2].substring(2, 3);
			String denominator = split[2].substring(4, 5);
			System.out.println("whole:" + whole + " numerator:" + numerator + " denominator:" + denominator);
			return split[2];
		} else {
			String frac = split[2];
			String[] second = new String[5];
			String[] second
			String whole = split[2].substring(0, 1);
			String operator = split[2].substring(1, 2);
			String numerator = split[2].substring(2, 3);
			String denominator = split[2].substring(4, 6);
			System.out.println("whole:" + whole + " numerator:" + numerator + " denominator:" + denominator);
			return split[2];
		}
	}
	//Can run 10 length, 13 length, cannot run when second fraction is whole/has no whole number attached to fraction

	// TODO: Fill in the space below with any helper methods that you think you will
	// need

}
