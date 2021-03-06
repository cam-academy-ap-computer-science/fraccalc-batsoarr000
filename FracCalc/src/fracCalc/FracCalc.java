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

	@SuppressWarnings("resource")
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
		System.out.print(split[2]);
		String other = ("whole:" + hole + " numerator:" + numer + " denominator:" + denom);
		String[] sec = second.split("\\s+");
		String hole2 = sec[0].substring(sec[0].indexOf(":") + 1, sec[0].length());
		String numer2 = sec[1].substring(sec[1].indexOf(":") + 1, sec[1].length());
		String denom2 = sec[2].substring(sec[2].indexOf(":") + 1, sec[2].length());
		String FINAL;
		//fraction 1
		int w1 = Integer.parseInt(hole);
		int n1 = Integer.parseInt(numer);
		int d1 = Integer.parseInt(denom);
		//fraction 2
		int w2 = Integer.parseInt(hole2);
		int n2 = Integer.parseInt(numer2);
		int d2 = Integer.parseInt(denom2);
		
		//calculations +
		if (oper.contentEquals("+") == true) {
			if (w1 < 0) { 
				n1 *= -1;
			}

			if (w2 < 0) { 
				n2 *= -1;
			}
			if (d1 != d2) {
				int temp = d1;
				d1 = d1 * d2;
				n1 = n1 * d2;
				d2 = d2 * temp;
				n2 = n2 * temp;
			}
			n1 += n2;
			w1 += w2;
			w1 += (n1/d1);
			n1 = n1 % d1;

			if (w1 < 0 && n1 < 0) {
				n1 *= -1;
			}
			if (n1 > d1 || n1 == d1) {
				while(n1 > d1) {
					n1 -= d1;
					w1++;
				}
			}
			for(int z = n1; z > 1; z--) {
				if (n1 % z == 0 && d1 % z == 0) {
					n1 /= z;
					d1 /= z;
				}	
			}
			FINAL = split[2] + ",    " + other + ",     " + Integer.toString(w1) + "_" + Integer.toString(n1) + "/" + Integer.toString(d1);
			
			return FINAL;
		//calculation -
		} else if (oper.contentEquals("-") == true) {
			if (w1 < 0) { 
				n1 *= -1;
			}

			if (w2 < 0) { 
				n2 *= -1;
			}
			if (d1 != d2) {
				int temp = d1;
				d1 = d1 * d2;
				n1 = n1 * d2;
				d2 = d2 * temp;
				n2 = n2 * temp;
			}
			n1 -= n2;
			w1 -= w2;
			if (n1 < 0) {
				int temp = n1;
				w1 -= 1;
				n1 = d1;
				n1 -= temp;
			}
			if (w1 < 0 && n1 < 0) {
				n1 *= -1;
			}
			if (n1 > d1 || n1 == d1) {
				while(n1 > d1) {
					n1 -= d1;
					w1++;
				}
			}
			for(int z = n1; z > 1; z--) {
				if (n1 % z == 0 && d1 % z == 0) {
					n1 /= z;
					d1 /= z;
				}	
			}
			
			FINAL = split[2] + ",    " + other + ",     " + Integer.toString(w1) + "_" + Integer.toString(n1) + "/" + Integer.toString(d1);

			return FINAL;
		//calculation *
		} else if (oper.contentEquals("*") == true) {
			if(w1 < 0) {
				n1 *= -1;
			}
			if(w2 < 0) {
				n2 *= -1;
			}
			int frac1 = (w1 * d1) + n1;
			int frac2 = (w2 * d2) + n2;
			d1 *= d2;
			n1 = frac1 * frac2;
			w1 = n1 / d1;
			n1 = n1 % d1;
			if(w1 < 0 && n1 < 0) {
				n1 *= -1;
			}
			if(n1 > d1 || n1 == d1) {
				while(n1 > d1) {
					n1 -= d1;
					w1++;
				}
			}
			for(int z = n1; z > 1; z--) {
				if(n1 % z == 0 && d1 % z == 0) {
					n1 /= z ;
					d1 /= z;
				}
			}
			if ( n1 == 0) {
				FINAL = w1 + " ";
			}
			FINAL = split[2] + ",    " + other + ",     " + Integer.toString(w1) + "_" + Integer.toString(n1) + "/" + Integer.toString(d1);

			return FINAL;
		//calculation /
		} else if (oper.contentEquals(" / ") == true) {
			if (w1 < 0) { 
				n1 *= -1;
			}

			if (w2 < 0) { 
				n2 *= -1;
			} 

			n1 = (w1 * d1) + n1;
			n2 = (w2 * d2) + n2;

			int temp = n2;
			n2 = d2;
			d2 = temp;

			w1 = 0;
			w1 *= w2;
			n1 *= n2;
			d1 *= d2;
			if (w1 < 0 && n1 < 0) {
				n1 *= -1;
			}
			if (n1 < 0 && d1 < 0) {
				d1 *= -1;
				n1 *= -1;
			}
			if (n1 > d1 || n1 == d1) {
				while(n1 > d1) {
					n1 -= d1;
					w1++;
				}
			}
			
			for(int z = n1; z > 1; z--) {
				if (n1 % z == 0 && d1 % z == 0) {
					n1 /= z;
					d1 /= z;
				}	
			}
			
			FINAL = split[2] + ",    " + other + ",     " + Integer.toString(w1) + "_" + Integer.toString(n1) + "/" + Integer.toString(d1);

			return FINAL;
			} else {
				FINAL = "no";
				return FINAL;
				
			}
	}
		
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
// TODO: Fill in the space below with any helper methods that you think you will
// need
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