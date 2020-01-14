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
		//scanner to check input as wel as main code to fetch method
		String string = "";
		Scanner enter = new Scanner(System.in);
		while (!string.contentEquals("quit")) {
			System.out.println("Enter fractions");
			String input = enter.nextLine();
			String FINAL = produceAnswer(input);
			System.out.println(FINAL);
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
	public static String getA(String fra1) { 
		// TODO: Implement this function to produce the solution to the input
		//splits up fraction 2
		if (fra1.indexOf("/") == -1) {
			String w1= fra1.substring(0, fra1.length());
			String n1= "0";
			String d1= "1";
			String answer = "whole:" + w1+ " numerator:" + n1+ " denominator:" + d1 ;
			return answer;
		} else if (fra1.indexOf("_") == -1 ) {
			String w1= "0";
			String n1= fra1.substring(0, fra1.indexOf("/"));
			String d1= fra1.substring(fra1.indexOf("/") + 1, fra1.length());
			String answer = "whole:" + w1+ " numerator:" + n1+ " denominator:" + d1 ;
			return answer;
		} else if (fra1.indexOf("/") != -1 && fra1.indexOf("_") != -1) {
			String w1 = fra1.substring(0, fra1.indexOf("_"));
			String n1= fra1.substring(fra1.indexOf("_") + 1, fra1.indexOf("/"));
			String d1= fra1.substring(fra1.indexOf("/") + 1, fra1.length());
			String answer = "whole:" + w1+ " numerator:" + n1+ " denominator:" + d1 ;
			return answer;
		} else {
			String answer = "whole:-1 numerator:-1 denominator:-1";
			return answer;
		}
	}
	//splits up fractions again
	public static String produceAnswer(String input) { 
		String[] next = input.split("\\s+");
		String fra1 = next[2];
		String first = getA(fra1);
		String fra2 = next[0];
		String second = getA(fra2);
		String oper = next[1];
		
		String[] split = first.split("\\s+");
		String hole = split[0].substring(split[0].indexOf(":") + 1, split[0].length());
		String numer = split[1].substring(split[1].indexOf(":") + 1, split[1].length());
		String denom = split[2].substring(split[2].indexOf(":") + 1, split[2].length());
		String[] sec = second.split("\\s+");
		String hole2 = sec[0].substring(sec[0].indexOf(":") + 1, sec[0].length());
		String numer2 = sec[1].substring(sec[1].indexOf(":") + 1, sec[1].length());
		String denom2 = sec[2].substring(sec[2].indexOf(":") + 1, sec[2].length());
		String FINAL;
		//fraction 1
		int hole_int = Integer.parseInt(hole);
		int numer_int = Integer.parseInt(numer);
		int denom_int = Integer.parseInt(denom);
		//fraction 2
		int hole_int_two = Integer.parseInt(hole2);
		int numer_int_two = Integer.parseInt(numer2);
		int denom_int_two = Integer.parseInt(denom2);
		
		if (hole_int_two / Math.abs(hole_int_two) == -1 || hole_int / Math.abs(hole_int) == -1) {
			if (oper.contentEquals("+")) {
				if(denom_int == denom_int_two) {
					if(hole_int_two / Math.abs(hole_int_two) == -1) {
						int finalnumer1 = numer_int - numer_int_two;
						int finalhole1 = (hole_int * -1) - hole_int_two;
						int finaldenom1 = denom_int;
						FINAL = Integer.toString(finalhole1) + "_" + Integer.toString(finalnumer1) + "/" + Integer.toString(finaldenom1);
						
						return FINAL;
				}
					if(hole_int / Math.abs(hole_int) == -1) {
					int finalnumer1 = numer_int + numer_int_two;
					int finalhole1 = (hole_int * -1) + hole_int_two;
					int finaldenom1 = denom_int;
					FINAL = Integer.toString(finalhole1) + "_" + Integer.toString(finalnumer1) + "/" + Integer.toString(finaldenom1);
					
					return FINAL;
					}
				}
				
			} else if (oper.contentEquals("-")) {
				if(denom_int == denom_int_two) {
					if(hole_int_two / Math.abs(hole_int_two) == -1) {
						int finalnumer1 = numer_int + numer_int_two;
						int finalhole1 = (hole_int * -1) + hole_int_two;
						int finaldenom1 = denom_int;
						FINAL = Integer.toString(finalhole1) + "_" + Integer.toString(finalnumer1) + "/" + Integer.toString(finaldenom1);
						
						return FINAL;
				}
					if(hole_int / Math.abs(hole_int) == -1) {
					int finalnumer1 = numer_int + numer_int_two;
					int finalhole1 = (hole_int * -1) + hole_int_two;
					int finaldenom1 = denom_int;
					FINAL = Integer.toString(finalhole1) + "_" + Integer.toString(finalnumer1) + "/" + Integer.toString(finaldenom1);
					
					return FINAL;
					}
				}
			} else if (oper.contentEquals("*")) {
				if (hole_int / Math.abs(hole_int) == -1) {
					int finalnumer1 = ((hole_int * denom_int) + (numer_int)) * ((hole_int_two * denom_int_two) + (numer_int_two));
					int finaldenom1 = (denom_int * denom_int_two);
					int finalhole1 = finalnumer1 / finaldenom1;
					finalnumer1 = finalnumer1 % finaldenom1;
					FINAL = Integer.toString(finalhole1) + "_" + Integer.toString(finalnumer1) + "/" + Integer.toString(finaldenom1);

					return FINAL;
				}
				
			} else if (oper.contentEquals("/") ) {
				
			} else {
				return null;
			}
		}

		//calculations +
		if (oper.contentEquals("+") == true) {
			if(denom_int == denom_int_two) {
				int finalnumer1 = numer_int + numer_int_two;
				int finalhole1 = hole_int + hole_int_two;
				int finaldenom1 = denom_int;
				FINAL = Integer.toString(finalhole1) + "_" + Integer.toString(finalnumer1) + "/" + Integer.toString(finaldenom1);
				
				return FINAL;
			}
			int lcm = lcm(denom_int, denom_int_two);
			int finalnumer1 = ((((denom_int * hole_int) + numer_int) * lcm) + (((denom_int_two * hole_int_two) + numer_int_two)) * lcm);
			int finaldenom1 = (lcm * denom_int);
			int finalhole1 = finalnumer1 / finaldenom1;
			finalnumer1 = finalnumer1 % finaldenom1;
			finalnumer1 = finalnumer1 / lcm;
			finaldenom1 = finaldenom1 / lcm;
			FINAL = Integer.toString(finalhole1) + "_" + Integer.toString(finalnumer1) + "/" + Integer.toString(finaldenom1);
			
			return FINAL;
		//calculation -
		} else if (oper.contentEquals("-") == true) {
			int lcm = lcm(denom_int, denom_int_two);
			int finalnumer1 = ((((denom_int * hole_int) + numer_int) * lcm) - (((denom_int_two * hole_int_two) + numer_int_two)) * lcm);
			int finaldenom1 = lcm * denom_int;
			int finalhole1 = finalnumer1 / finaldenom1;
			finalnumer1 = finalnumer1 % finaldenom1;
			
			FINAL = Integer.toString(finalhole1) + "_" + Integer.toString(finalnumer1) + "/" + Integer.toString(finaldenom1);

			return FINAL;
		//calculation *
		} else if (oper.contentEquals("*") == true) {
			int finalnumer1 = ((hole_int * denom_int) + (numer_int)) * ((hole_int_two * denom_int_two) + (numer_int_two));
			int finaldenom1 = (denom_int * denom_int_two);
			int finalhole1 = finalnumer1 / finaldenom1;
			finalnumer1 = finalnumer1 % finaldenom1;
			FINAL = Integer.toString(finalhole1) + "_" + Integer.toString(finalnumer1) + "/" + Integer.toString(finaldenom1);

			return FINAL;
		//calculation /
		} else if (oper.contentEquals("/") == true) {
			if (numer_int == 0 || numer_int_two == 0) {
				return FINAL = "0";
				}
			int finalnumer1 = denom_int * numer_int_two;
			int finaldenom1 = numer_int * denom_int_two;
			int finalhole1 = hole_int / hole_int_two;
			if (finalhole1 == 0) {
				FINAL = Integer.toString(finalnumer1) + "/" + Integer.toString(finaldenom1);

				return FINAL;
			}
			FINAL = Integer.toString(finalhole1) + "_" + Integer.toString(finalnumer1) + "/" + Integer.toString(finaldenom1);

			return FINAL;
		} else {
			return null;
		}

	}
	//assist coding for greatest common denominator and least common multiple
	public static int lcm(int a, int b) 
    { 
        return (a*b)/gcd(a, b); 
    }
	public static int gcd(int a, int b) 
    { 
    if (a == 0) {
        return b;
    }
    return gcd(b % a, a);  
    } 
     
    
	
}
// TODO: Fill in the space below with any helper methods that you think you will
// need
