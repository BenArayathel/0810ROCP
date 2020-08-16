package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;



public class EvaluationService {

	/**
	 * 1.A Speed Converter - Convert to MilesPerHour
	 * 
	 * Write a method called toMilesPerHour that has 1 parameter of type double with
	 * the name kilometersPerHour. This method needs to return the rounded value of
	 * the calculation of type long.
	 * 
	 * If the parameter kilometersPerHour is less than 0, the method toMilesPerHour
	 * needs to return -1 to indicate an invalid value.
	 * 
	 * Otherwise if it is positive, calculate the value of miles per hour, round it
	 * and return it. For conversion and rounding use Math.round().
	 */
	static class SpeedConverter {

		public static long toMilesPerHour(double kilometersPerHour) {
		    
			if (kilometersPerHour < 0 ) {
		
				return -1L;
				}
			
				else
				{
					double milesPerHour = kilometersPerHour * 0.62;
		
					milesPerHour = Math.round(milesPerHour);
					return  (long)milesPerHour ;
							
				
			    }  //else
			
			
		}  // public static long toMilesPerHour

		/**
		 * 1.B Speed Converter - Print Conversion
		 * 
		 * Write another method called printConversion with 1 parameter of type double
		 * with the name kilometersPerHour. This method needs to return a String and
		 * needs to calculate milesPerHour from the kilometersPerHour parameter.
		 * 
		 * The String should print in the format: "XX km/h = YY mi/h"
		 * 
		 * XX represents the original value kilometersPerHour. YY represents the rounded
		 * milesPerHour from the kilometersPerHour parameter.
		 * 
		 * If the parameter kilometersPerHour is < 0, then print the text "Invalid
		 * Value"
		 */
		public static String printConversion(double kilometersPerHour) {
			
			if (kilometersPerHour < 0 ) 
			    {
				return  ("Invalid Value");
			    }
			else
				{
				double milesPerHour= Math.round(kilometersPerHour *0.62);
				return kilometersPerHour + " km/h  = " + milesPerHour + " mi/h "  ;
		        }
	}  // public static String printConversion
	

	/**
	 * 2. MegaBytes and KiloBytes
	 * 
	 * Write a method called printMegaBytesAndKiloBytes that has 1 parameter of type
	 * int with the name kiloBytes.
	 * 
	 * The method should return a String and it needs to calculate the megabytes and
	 * remaining kilobytes from the kilobytes parameter.
	 * 
	 * Then it needs to print a message in the format "XX KB = YY MB and ZZ KB".
	 * 
	 * XX represents the original value kiloBytes. YY represents the calculated
	 * megabytes. ZZ represents the calculated remaining kilobytes.
	 * 
	 * For examples, when the parameter kiloBytes is 2500 it needs to print "2500 KB
	 * = 2 MB and 452 KB"
	 * 
	 * If the parameter kiloBytes is less than 0 then print the text "Invalid
	 * Value".
	 */
	public String printMegaBytesAndKiloBytes(int XX) {
		if (XX < 0) {
			return "Invalid Value";
			}
		else {
		    int megaBytes = XX/1024;
		    int remainder = XX%1024;
		    return XX + " KB = " + megaBytes + " MB and" + remainder + " KB";
		    }
		
	} // String printMegaBytesAndKiloBytes

	/**
	 * 3. Barking Dog
	 * 
	 * We have a dog that loves to bark. We need to wake up if the dog is barking at
	 * night!
	 * 
	 * Write a method shouldWakeUp that has 2 parameters.
	 * 
	 * 1st parameter should be of type boolean and be named "barking". It represents
	 * if our dog is currently barking. 2nd parameter represents the hour of the day
	 * and is of type int with the name hourOfDay and has a valid range of 0-23.
	 * 
	 * We have to wake up if the dog is barking before 8 or after 22 hours, so in
	 * that case return true.
	 * 
	 * In all other cases return false.
	 * 
	 * If the hourOfDay parameter is less than 0 or greater than 23, return false.
	 */
	public boolean shouldWakeUp(boolean isBarking, int hourOfDay) {
		 if (hourOfDay < 0 || hourOfDay >23 || !isBarking) 
		 {
			 return false;
		 }
		 if (hourOfDay < 8 && isBarking) 
		 {
			 return true;
		 }
		 if (hourOfDay > 22 && isBarking) 
		 {
		     return true;
		 }
		 else {
		     return false;
		 }
	}

	/**
	 * 4. DecimalComparator
	 * 
	 * Write a method areEqualByThreeDecimalPlaces with two parameters of type
	 * double.
	 * 
	 * The method should return boolean and it needs to return true if two double
	 * numbers are the same up to three decimal places.
	 * 
	 * Otherwise, return false;
	 */
	public boolean areEqualByThreeDecimalPlaces(double firstNum, double secondNum) {
		
		// first, move the decimal over three places.
		firstNum = firstNum *1000;
		
		secondNum = secondNum *1000;
		
		//now, we need to truncate safely because these doubles may be too large to be cast into an int.
		// this if then will essentially truncate the value to something point zero.
		if (firstNum < 0)
		{
			firstNum = Math.ceil(firstNum);
		}
		else
		{
			firstNum = Math.floor(firstNum);
		}
		if (secondNum < 0)
		{
			secondNum = Math.ceil(secondNum);
		}
		else
		{
			secondNum = Math.floor(secondNum);
		}
		if (firstNum == secondNum) 
		{
		   return true;
		}
		else 
		{
		return false;
		}
	} // public boolean areEqualByThreeDecimalPlaces

	/**
	 * 5. Teen Number Checker
	 * 
	 * We'll say that a number is "teen" if it is in the range 13 -19 (inclusive).
	 * Write a method named hasTeen with 3 parameters of type int.
	 * 
	 * The method should return boolean and it needs to return true if ONE of the
	 * parameters is in range 13(inclusive) - 19 (inclusive). Otherwise return
	 * false.
	 */
	static class TeenNumberChecker {

		public static boolean hasTeen(int x, int y, int z) 
		{
			boolean firstAge;
			if (x >= 13 && x <=19) {
				firstAge =true;	
			}
			else {
				firstAge =false;
			}
			
			boolean secondAge; ;
			if (y >= 13 && y <=19) {
				secondAge =true;	
			}
			else {
				secondAge =false;
			}
			boolean thirdAge;
			if (z >= 13 && z <=19) {
				thirdAge =true;	
			}
			else {
				thirdAge =false;
			}
			
			
			if (firstAge || secondAge || thirdAge) 
			{
				return true;
			}
			else {
			
			    return false;
			}
		} //public static boolean hasTeen

	}  //static class teen numberchecker
			
			
	

	/**
	 * 6. Minutes To Years and Days Calculator
	 * 
	 * Write a method printYearsAndDays with parameter of type long named minutes.
	 * The method should not return anything (void) and it needs to calculate the
	 * years and days from the minutes parameter.
	 * 
	 * If the parameter is less than 0, print text "Invalid Value".
	 * 
	 * Otherwise, if the parameter is valid then it needs to print a message in the
	 * format "XX min = YY y and ZZ d".
	 * 
	 * XX represents the original value minutes. YY represents the calculated years.
	 * ZZ represents the calculated days.
	 */
	public String printYearsAndDays(long minutes) {
		long minInYear= 60*24*365;
		if (minutes<0 ) 
		{
			System.out.println("Invalid Value");
		}
		long year = minutes/minInYear;
		long day =  ((minutes/60/24)%365);
		return (minutes + " minutes = " + year + " years and " + day + " days");
	
		
		
	}  // public String printYearsAndDays

	/**
	 * 7. Number In Word
	 * 
	 * Write a method called printNumberInWord. The method has one parameter number
	 * which is the whole number. The method needs to print "ZERO", "ONE", "TWO",
	 * ... "NINE", "OTHER" if the int parameter number is 0, 1, 2, .... 9 or other
	 * for any other number including negative numbers. You can use if-else
	 * statement or switch statement whatever is easier for you.
	 */
	public String printNumberInWord(int number) {
		switch (number) {
		  case 0:
		    return "ZERO";
		    
		  case 1:
			  return"ONE";
		   
		  case 2:
			  return "TWO";
		   
		  case 3:
			  return "THREE";
		    
		  case 4:
			  return "FOUR";
		    
		  case 5:
			  return"FIVE" ;
		   
		  case 6:
			  return "SIX";
		   
		  case 7:
			  return"SEVEN";
		    
		  case 8:
			  return"EIGHT";
			
		  case 9:
			  return"NINE";
			
		  default:
			  return"OTHER";
		
		
	      }  //switch
		
		
	}  // String printNumberInWord

	/**
	 * 8. Greatest Common Divisor
	 * 
	 * Write a method named getGreatestCommonDivisor with two parameters of type int
	 * named first and second.
	 * 
	 * If one of the parameters is < 10, the method should return -1 to indicate an
	 * invalid value. The method should return the greatest common divisor of the
	 * two numbers (int).
	 * 
	 * The greatest common divisor is the largest positive integer that can fully
	 * divide each of the integers (i.e. without leaving a remainder).
	 * 
	 * For example 12 and 30: 12 can be divided by 1, 2, 3, 4, 6, 12 30 can be
	 * divided by 1, 2, 3, 5, 6, 10, 15, 30
	 * 
	 * The greatest common divisor is 6 since both 12 and 30 can be divided by 6,
	 * and there is no resulting remainder.
	 */
	public int getGreatestCommonDivisor(int first, int second) {
		// TODO Write an implementation for this method declaration
		if (first<10 || second <10) {
		return -1;
	    }
		
        int gcd = 1;

        for (int i = 1; i <= first && i <= second; i++) {
            if (first % i == 0 && second % i == 0) {
                gcd = i;
            }
        }
       
      
        return gcd;
      }


	/**
	 * 9. First and Last Digit Sum
	 * 
	 * Write a method named sumFirstAndLastDigit with one parameter of type int
	 * called number.
	 * 
	 * The method needs to find the first and the last digit of the parameter number
	 * passed to the method, using a loop and return the sum of the first and the
	 * last digit of that number.
	 * 
	 * If the number is negative then the method needs to return -1 to indicate an
	 * invalid value.
	 */
	public int sumFirstAndLastDigit(int num) {
		if (num <0) {
			return -1;
		}
		else
		{
	
		    int firstNumber =num;
		    int lastNumber;
			while(firstNumber >= 10)
			{
				firstNumber = firstNumber / 10;
			}	
			lastNumber = num%10;	
			return firstNumber+lastNumber;
		}
		
	}

	/**
	 * 10. Reverse String
	 * 
	 * Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 */
	public String reverse(String string) {
		
		// if string is null, don't do anything.
		if (string == null) {
	        return string;
	    }
	 
	    String reversedString = "";
	 // build the string from the last letter to the first
	    for (int i = string.length() - 1; i >= 0; i--) {
	    	reversedString = reversedString + string.charAt(i);
	    }
	 
	    return reversedString;
	}

	/**
	 * 11. Acronyms
	 * 
	 * Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 */
	public String acronym(String phrase) {
		// remove white space from beginning and end of string, just in case.  this does not change the string
		phrase = phrase.trim();
		
	        String result = String.valueOf(phrase.charAt(0));
	        while (phrase.indexOf(" ") != -1){
	            result += phrase.charAt(phrase.indexOf(" ")+1);
	            phrase = phrase.substring(phrase.indexOf(" ")+1);
	        }
	        return result.toUpperCase();
	    }
		
	}

	/**
	 * 12. Triangles
	 * 
	 * Determine if a triangle is equilateral, isosceles, or scalene. An equilateral
	 * triangle has all three sides the same length. An isosceles triangle has at
	 * least two sides the same length.
	 * 
	 * (It is sometimes specified as having exactly two sides the same length, but
	 * for the purposes of this exercise we'll say at least two.) A scalene triangle
	 * has all sides of different lengths.
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if (this.sideOne == this.sideTwo && this.sideOne== this.sideThree) 
			    {
				return true;
				}
			else 
			   {
			   return false;
		       }
		}

		public boolean isIsosceles() {
			if (this.sideOne == this.sideTwo && this.sideOne == this.sideThree && this.sideTwo == this.sideThree) 
			{
			return true;
			}
			else {
			return false;
			}	
		}

		public boolean isScalene() {
			if (this.sideOne != this.sideTwo && this.sideOne != this.sideThree && this.sideTwo != this.sideThree) 
			{
			return true;
			}
			else 
			{
			return false;
			}	
		}  // public boolean isScalene

	}  //static class Triangle {

	/**
	 * 13. Scrabble Score
	 * 
	 * Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "Cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 */
	public int getScrabbleScore(String string) {
		int score = 0;
		string  = string.toLowerCase();
		// remove white space from beginning and end of string, just in case.  this does not change the string
		string = string.trim();
        for (int i = 0; i < string.length(); i++) {

            if (string.charAt(i) == 'a' || string.charAt(i) == 'e' ||
            		string.charAt(i) == 'i' || string.charAt(i) == 'o'
                    || string.charAt(i) == 'u' || string.charAt(i) == 'l'
                    || string.charAt(i) == 'n' || string.charAt(i) == 'r'
                    || string.charAt(i) == 's' || string.charAt(i) == 't') 
            {
                score += 1;
            } 
            	else if (string.charAt(i) == 'd' || string.charAt(i) == 'g') 
            	{
                   score += 2;
            	} 
            	else if (string.charAt(i) == 'b' || string.charAt(i) == 'c'
                    || string.charAt(i) == 'm' || string.charAt(i) == 'p') 
            	{
                   score += 3;
            	} 
            	else if (string.charAt(i) == 'f' || string.charAt(i) == 'h'
                    || string.charAt(i) == 'v' || string.charAt(i) == 'w'
                    || string.charAt(i) == 'y') 
            	{
                   score += 4;
                } 
            	else if (string.charAt(i) == 'k') 
            	{
                   score += 5;   
                } 
            	else if (string.charAt(i) == 'j' || string.charAt(i) == 'x') 
            	{
                   score += 8;
                } 
            	else if (string.charAt(i) == 'q' || string.charAt(i) == 'z') 
            	{
                   score += 10;
                }
        }

        return score;
	}

	/**
	 * 14. Clean the Phone Number
	 * 
	 * Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253, 613-995-0253, 1 613 995 0253, 613.995.0253 should all produce
	 * the output:
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 * 
	 * Note: If telephone number is invalid (non-numerical character, more than 11 digits
	 * or an invalid country code), throw an 'IllegalArgumentException.class'.
	 */
	public String cleanPhoneNumber(String string) {
		String newSmsString =new String();
		
		
		if (string.length() < 9)  //has to be at least 9 characters.
		 {
			throw new IllegalArgumentException("telephone number is invalid");
		   }
		//now, get rid of all the non number characters, spaces, etc. worry about the leading one later
		for (int i = 0; i < string.length(); i++) {

            if (string.charAt(i) == '0' || string.charAt(i) == '1' ||
            		string.charAt(i) == '2' || string.charAt(i) == '3'
                    || string.charAt(i) == '4' || string.charAt(i) == '5'
                    || string.charAt(i) == '6' || string.charAt(i) == '7'
                    || string.charAt(i) == '8' || string.charAt(i) == '9')
            {
            	newSmsString = newSmsString + string.charAt(i);
            }  
	    }  //for loop
		// a number would have a length of 10 if the first character was a 1 as in 18472555000.
		if (newSmsString.length() == 10 && newSmsString.charAt(0)== 1)
		{	newSmsString.substring(1);  //chop off the one at start of phone number if there is one there
		}
		
		//if the length of the number is greater than 9, invalid number.
		if (newSmsString.length() > 9)
		{ 
			throw new IllegalArgumentException("telephone number is invalid");
		}
		// now we should be left with a 9 character string.  check to see if first char is one, otherwise return string.
		if (newSmsString.charAt(0)== 1)
          {
			throw new IllegalArgumentException("telephone number is invalid");
		   }
		else {
			return newSmsString;
		}
		
		
	}

	/**
	 * 15. Recurring Word Counter
	 * 
	 * Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" should return a map with key-value pairs of;
	 *  olly: 2, in: 1, come: 1, free: 1.
	 */
	public Map<String, Integer> wordCount(String string) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		String words[] = string.split(" ");
		
		for (String s:words) {
		    
		    if (!map.containsKey(s)) {  // first time we've seen this string
		      map.put(s, 1);
		    }
		    else {
		      int count = map.get(s);
		      map.put(s, count + 1);
		    }
		  }
		  return map;
		
		
	}  // public Map<String, Integer> wordCount

	/**
	 * 16. Armstrong Number
	 * 
	 * An Armstrong number is a number that is the sum of its own digits each raised
	 * to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 */
	public boolean isArmstrongNumber(int input) {
		 int  count = 0; 
		 int a, b, c;
		 int sum = 0;


         a = input;                
         c = input;          
         while(a > 0)                    
         {
             a = a / 10;
             count++;
           
         }
         while(input > 0)
         {
             b = input % 10;
             sum = (int) (sum+Math.pow(b, count));
             input = input / 10;
           
         }
         if(sum == c)                                     //  checking  if number is Armstrong
         {
             return true;
           
         }
         else
         {
             return false;
         }
             
	}  //public boolean isArmstrongNumber

	/**
	 * 17. Prime Factors
	 * 
	 * Compute the prime factors of a given natural number. A prime number is only
	 * evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 */
	
	
    
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		// Print the number of 2s that divide n 
		ArrayList<Long> primeFactors = new ArrayList<Long>();
		
       
        
       
        for(long i = 2; i< l; i++) {
           while(l%i == 0) {
              
              primeFactors.add(i);
              l = l/i;
           }
        }
        if(l >2) {
    //       System.out.println(number);
        	primeFactors.add(l);
        }
        return primeFactors;
        
     }  //public List<Long> calculatePrimeFactorsOf
        
		


	/**
	 * 18. Calculate Nth Prime
	 * 
	 * Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 */
	public int calculateNthPrime(int k) {
		
        int i = 2, count = 0;
        boolean isPrime;
        
        while (true) 
        {
            isPrime = true;
            for(int j = 2; j < i; ++j) 
            {
                if(i % j == 0)
                    isPrime = false;
            }
            if(isPrime) 
            {
                count++;
                if(count == k) 
                {
                    return i;
                    
                }
            } //if(isPrime)
            i++;
        }  //while loop
		
	} //public int calculateNthPrime

	/**
	 * 19. Pangram
	 * 
	 * Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 */
	public boolean isPangram(String string) {
		boolean[] alphaList = new boolean[26];  //the default value of a boolean is false
	      int index = 0;
	      boolean flag = true;
	      
	      // go through the string, and for each letter encountered, it's corresponding spot in the alphalist is set to true
	      for (int i = 0; i < string.length(); i++) {
	         if ( string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') 
	         {
	            index = string.charAt(i) - 'A';
	         }
	         else if( string.charAt(i) >= 'a' && string.charAt(i) <= 'z') 
	         {
	            index = string.charAt(i) - 'a';
	         }
	      alphaList[index] = true;
	      } // for (int i = 0;
	   for (int i = 0; i <= 25; i++) 
	   {
	      if (alphaList[i] == false)
	      flag = false;
	   }
		return flag;
	} //public boolean isPangram

	/**
	 * 20. Sum of Multiples 
	 * 
	 * Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 */
	public int getSumOfMultiples(int i, int[] set) {
		//Set<Integer> multiples = new HashSet<Integer>();
		int numberOfMultiples;
		
		int sum=0;
		int ans=0;
		for(Integer val: set)
		{
			numberOfMultiples = i / val;
			//sum of first m natural numbers 
		    sum = numberOfMultiples * (numberOfMultiples + 1) / 2; 
		    ans = i * sum; // sum of multiples 
		}
		
	
	  
	    return ans; 
		
	}
	
	/**
	 * 21. Three Magic Numbers
	 * 
	 * You work at a casino in Las Vegas.  Your job is to program a slot machine to
	 * return 3 random numbers using the java.util.Random class.
	 * 
	 * Write a method to return an int array of 3 random numbers between 1 - 100.
	 * Generate the 3 random numbers (1 - 100 inclusive) using the java.util.Random class.
	 */
	
	public int[] threeLuckyNumbers() {
		 Random rand = new Random();
		 int upperBound =101;
		 int randomInt1 =rand.nextInt(upperBound);  //returns a random from 0 up to upperBound-1
		 int randomInt2 =rand.nextInt(upperBound);  //returns a random from 0 up to upperBound-1
		 int randomInt3 =rand.nextInt(upperBound);  //returns a random from 0 up to upperBound-1
		 int[] numbers = new int[]{ randomInt1, randomInt2, randomInt3};
		
		return numbers;
	}
	
	/**
	 * 22. Easy Guessing Game
	 * 
	 * Create a program to generate a number between the given range:
	 * int x = minimum
	 * iny y = maximum (inclusive)
	 * 
	 * You must use the Math.random class to generate a random number between x and y.
	 */
	
	public int guessingGame(int x, int y) {
		
		return (int)Math.random() * (y - x + 1) + x;  //this returns a double, need to cast to an int.
	} //public int guessingGame
	}  //public class EvaluationService
	
