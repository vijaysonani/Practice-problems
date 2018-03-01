/**
 * Given a column title as appears in an Excel sheet, return its corresponding column number.
 * Example:
 *
 *    A -> 1 
 *    B -> 2 
 *    C -> 3
 *    
 *    ...
 *    
 *    Z -> 26
 *    
 *    AA -> 27
 *    
 *    AB -> 28
 *  
 * 
 * Input Output 
 * 	26 		Z 
 * 	51 		AY 
 * 	52 		AZ 
 * 	80 		CB 
 * 	676 	YZ 
 * 	702 	ZZ 
 * 	705 	AAC
 */

public class Excel{
  public static void main (String args[]){
    System.out.println("Excel");
    System.out.println(new Excel().convert(54));
  }

  public String convert(int A){
    StringBuilder sb = new StringBuilder();
 
    while(A > 0){
        A--;
        char ch = (char) (A % 26 + 'A');
        A/= 26;
        sb.append(ch);
    }
 
    sb.reverse();
    return sb.toString();
  }
}