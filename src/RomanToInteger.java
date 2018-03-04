/**
 * 
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * Read more details about roman numerals at Roman Numeric System(wiki)
 * 
 * Example :
 * 
 * Input : "XIV" Return : 14 Input : "XX" Output : 20
 * 
 * 
 * Symbol 	I 	V 	X 	L 	C 	  D 		M 
 * Value 	  1 	5 	10 	50 	100   500 	1,000
 *
 * 
 */

public class RomanToInteger {
  public static void main(String args[]) {
    System.out.println("RomanToInteger");
    System.out.println(new RomanToInteger().convert("XiV"));          // 14    
    // System.out.println(new RomanToInteger().convert("MCMLIV"));    // 1954
  }

  public int convert(String A) {
    A = A.toUpperCase();
    int result = 0;
    int cur = 0;
    int prev = 0;

    for (int i = 0; i < A.length(); i++) {
      cur = getIntegerFromRoman("" + A.charAt(i));
      if (prev != 0 && prev < cur){
        result -= 2*prev;
        result += cur;         
      } else {
        result += cur;
      }
      prev = cur;
    }

    return result;
  }

  public int getIntegerFromRoman(String s) {
    switch (s) {
    case "M":
      return 1000;
    case "D":
      return 500;
    case "C":
      return 100;
    case "L":
      return 50;
    case "X":
      return 10;
    case "V":
      return 5;
    case "I":
      return 1;
    default:
      return 0;
    }
  }
}
