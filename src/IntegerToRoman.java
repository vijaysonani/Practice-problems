/**
 * 
 * Given an integer, convert it to a roman numeral, and return a string corresponding to its roman numeral version
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * Example :
 * 
 * Input : 5
 * Return : "V"
 * 
 * Input : 14
 * Return : "XIV"
 *
 */

public class IntegerToRoman {
  public static void main(String args[]) {
    System.out.println("IntegerToRoman");
    // System.out.println(new IntegerToRoman().convert(8)); // VIII
    System.out.println(new IntegerToRoman().convert(901)); // CMI
  }

  public String convert(int A) {
    String result = "";

    while (A > 0) {
      if (A >= 1000) {
        A -= 1000;
        result += "M";
      } else if (A >= 900) {
        A -= 900;
        result += "CM";
      } else if (A >= 500) {
        A -= 500;
        result += "D";
      } else if (A >= 400) {
        A -= 400;
        result += "CD";
      } else if (A >= 100) {
        A -= 100;
        result += "C";
      } else if (A >= 90) {
        A -= 90;
        result += "XC";
      } else if (A >= 50) {
        A -= 50;
        result += "L";
      } else if (A >= 40) {
        A -= 40;
        result += "XL";
      } else if (A >= 10) {
        A -= 10;
        result += "X";
      } else if (A >= 9) {
        A -= 9;
        result += "IX";
      } else if (A >= 5) {
        A -= 5;
        result += "V";
      } else if (A >= 4) {
        A -= 5;
        result += "IV";
      } else {
        A -= 1;
        result += "I";
      }
    }

    return result;
  }
}
