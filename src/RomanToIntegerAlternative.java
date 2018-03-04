import java.util.HashMap;

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

public class RomanToIntegerAlternative {
  public static void main(String args[]) {
    System.out.println("RomanToIntegerAlternative");
    System.out.println(new RomanToIntegerAlternative().convert("XiV"));         // 14
    // System.out.println(new RomanToIntegerAlternative().convert("MCMLIV"));   // 1954
    
  }

  public int convert(String A) {
    A = A.toUpperCase();
    int result = 0;
    char curString;
    char nextString;
    int newValue = 0;
    String key;
    HashMap<String, Integer> lookupMap = setupMap();

    for (int i = 0; i < A.length(); i++) {
      curString = A.charAt(i);
      if (i < A.length() - 1) {
        nextString = A.charAt(i + 1);
        key = "" + curString + nextString;
        newValue = lookupMap.containsKey(key) ? lookupMap.get(key) : 0;
        if (newValue != 0) {
          result += newValue;
          newValue = 0;
          i++;
          continue;
        }
      }

      result += lookupMap.get("" + curString);
      curString = nextString = '\0';
    }

    return result;
  }

  public HashMap<String, Integer> setupMap(){
    HashMap<String, Integer> map = new HashMap<String, Integer>(13);
    map.put("M", 1000);
    map.put("CM", 900);
    map.put("D", 500);
    map.put("CD", 400);
    map.put("C", 100);
    map.put("XC", 90);
    map.put("L", 50);
    map.put("XL", 40);
    map.put("X", 10);
    map.put("IX", 9);
    map.put("V", 5);
    map.put("IV", 4);
    map.put("I", 1);
    return map;
  }
}
