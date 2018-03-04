import java.util.ArrayList;

/**
 * Given a non-negative number represented as an array of digits,
 * add 1 to the number ( increment the number represented by the digits ).
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 * 
 * Example:
 * 
 * If the vector has [1, 2, 3]
 * 
 * the returned vector should be [1, 2, 4]
 * 
 * as 123 + 1 = 124.
 * 
 * NOTE: Certain things are intentionally left unclear in this question which
 * you should practice asking the interviewer. For example, for this problem,
 * following are some good questions to ask : Q : Can the input have 0’s before
 * the most significant digit. Or in other words, is 0 1 2 3 a valid input? A :
 * For the purpose of this question, YES Q : Can the output have 0’s before the
 * most significant digit? Or in other words, is 0 1 2 4 a valid output? A : For
 * the purpose of this question, NO. Even if the input has zeroes before the
 * most significant digit.
 * 
 *
 */
public class ArrayAddOne {
  public static void main(String args[]) {
    ArrayAddOne obj = new ArrayAddOne();
    ArrayList<Integer> A = new ArrayList<Integer>();

    // Sample test cases

    // A.add(0, 0);

    // A.add(0, 0);    
    // A.add(1, 3);
    // A.add(2, 7);

    // A.add(0, 0);    
    // A.add(1, 0);
    // A.add(2, 3);
    // A.add(3, 7);

    // A.add(0, 1);    
    // A.add(1, 0);
    // A.add(2, 0);
    // A.add(3, 3);

    System.out.println("Arraylist contains: " + obj.plusOne(A).toString());
  }

  public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
    ArrayList<Integer> result = A; // For better naming

    // Add one to the array
    for (int i = result.size() - 1; i >= 0; i--) {
      if (result.get(i).equals(9)) {
        if (i > 0) {
          result.set(i, 0);
        } else {
          // Else insert element 1 at begining of array
          if (result.get(i).equals(9)) {
            result.set(i, 0);
            result.add(0, 1);
          } else {
            result.set(i, result.get(i) + 1);
          }
          break;
        }
      } else {
        result.set(i, result.get(i) + 1);
        break;
      }
    }

    // Remove leading zeros
    for (int i = 0; i < result.size(); i++) {
      if (result.get(i).equals(0)) {
        result.remove(i);
        i--;
      } else {
        break;
      }
    }
    return result;
  }
}
