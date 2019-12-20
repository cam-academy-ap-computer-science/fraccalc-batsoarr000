package fracCalc;

import java.util.*;

public class FracCalc {
	/*
	 * Create code that sets strings that the user assigns, ask 'calculate fraction
	 * or quit' run string through produce answer method
	 * 
	 * produce answer breaks up string into three parts, first fraction, operator,
	 * second fraction adds and returns there answer
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
			String finish = findanswer(first, produceAnswertwo(string), proAns(string));
			System.out.println(finish);
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
		String fracone = split[0];
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
	public static String proAns(String input) {
		String[] split = input.split("\\s+");
		String operator = split[1];
		return operator;
	}
	public static String findanswer(String first, String second, String operator) {
		int wfirst = Integer.parseInt(first.substring(first.indexOf("whole:"), first.indexOf("numberator:")) );
		int nfirst = Integer.parseInt(first.substring(first.indexOf(":"), first.indexOf("d") ));
		int dfirst = Integer.parseInt(first.substring(first.indexOf("r"), first.length() ));
		int wsecond = Integer.parseInt(second.substring(second.indexOf(":"), second.indexOf("n") ));
		int nsecond = Integer.parseInt(second.substring(second.indexOf(":"), second.indexOf("d") ));
		int dsecond = Integer.parseInt(second.substring(second.indexOf("r"), second.length() ));
		if (operator.indexOf("+") != -1) {
			String end = "";
			int wfinal = wfirst + wsecond;
			int nfinal = nfirst + nsecond;
			int dfinal = dfirst + dsecond;
			end = wfinal + "_" + nfinal + "/" + dfinal;
			return end;
		} else if (operator.indexOf("-") != -1) {
			String end = "";
			int wfinal = wfirst - wsecond;
			int nfinal = nfirst - nsecond;
			int dfinal = dfirst - dsecond;
			end = wfinal + "_" + nfinal + "/" + dfinal;
			return end;
		} else if (operator.indexOf("*") != -1) {
			String end = "";
			int wfinal = wfirst * wsecond;
			int nfinal = nfirst * nsecond;
			int dfinal = dfirst * dsecond;
			end = wfinal + "_" + nfinal + "/" + dfinal;
			return end;
		} else if (operator.indexOf("/") != -1) {
			String end = "";
			int wfinal = wfirst / wsecond;
			int nfinal = nfirst * dsecond;
			int dfinal = dfirst * nsecond;
			end = wfinal + "_" + nfinal + "/" + dfinal;
			return end;
		} else {
			String end = "no";
			return end;
		}
	}
	// TODO: Fill in the space below with any helper methods that you think you will
	// need

}
