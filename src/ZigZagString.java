import java.util.Arrays;
/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * P.......A........H.......N 
 * ..A..P....L....S....I...I....G
 * ....Y.........I........R
 * 
 * And then read line by line: PAHNAPLSIIGYIR
 * 
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * string convert(string text, int nRows); convert("PAYPALISHIRING", 3) should
 * return "PAHNAPLSIIGYIR" Example 2 : ** ABCD, 2 can be written as
 * 
 * A....C ...B....D and hence the answer would be ACBD.
 * 
 * Input: str = "GEEKSFORGEEKS" 
 * n = 3 
 * Output: GSGSEKFREKEOE
 *
 */

public class ZigZagString {
  public static void main (String args[]) {
    System.out.println("ZigZagString");
    System.out.println(new ZigZagString().convert("PAYPALISHIRING", 3));
    // System.out.println(new ZigZagString().convert("kHAlbLzY8Dr4zR0eeLwvoRFg9r23Y3hEujEqdio0ctLh4jZ1izwLh70R7SAkFsXlZ8UlghCL95yezo5hBxQJ1Td6qFb3jpFrMj8pdvP6M6k7IaXkq21XhpmGNwl7tBe86eZasMW2BGhnqF6gPb1YjCTexgCurS", 1));
  }

  public String convert(String A, int B){
    String[] subString = new String[B];
    Arrays.fill(subString, "");

    boolean reverse = true;
    int currentRow = 0;

    for(int i=0; i < A.length(); i++) {
      subString[currentRow] += A.charAt(i);

      if (B > 1) {
        if (currentRow == B-1 || currentRow == 0) {
          reverse = !reverse;
        }
        if (reverse) {
          currentRow--;
        } else {
          currentRow++;
        }
      }
    }

    return String.join("", subString);
  }
}
 