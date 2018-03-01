import java.util.ArrayList;

/**
 * Print concentric rectangular pattern in a 2d matrix. Let us show you some
 * examples to clarify what we mean.
 * 
 * Example 1:
 * 
 * Input: A = 4. Output:
 * 
 * 4 4 4 4 4 4 4 
 * 4 3 3 3 3 3 4 
 * 4 3 2 2 2 3 4 
 * 4 3 2 1 2 3 4 
 * 4 3 2 2 2 3 4 
 * 4 3 3 3 3 3 4 
 * 4 4 4 4 4 4 4 
 * 
 * Example 2:
 * 
 * Input: A = 3. Output:
 * 
 * 3 3 3 3 3 
 * 3 2 2 2 3 
 * 3 2 1 2 3 
 * 3 2 2 2 3 
 * 3 3 3 3 3 
 * 
 * The outermost rectangle is
 * formed by A, then the next outermost is formed by A-1 and so on.
 * 
 * You will be given A as an argument to the function you need to implement, and
 * you need to return a 2D array.
 */

public class ConcentricMatrix{
  public static void main (String args[]){
    System.out.println("ConcentricMatrix");
    System.out.println(new ConcentricMatrix().PrintConcentricMatrix(3));
  }

  public ArrayList<ArrayList<Integer>> PrintConcentricMatrix(int A){
    // int[][] result = new int[2*A-1][2*A-1];
    // int currentPos = 0;
    // int currentNum = A;
    // int size = 2*A-2;

    //// Set matrix values
    // while(currentPos < A){
    //   for(int i=currentPos; i <= size; i++){
    //     result[currentPos][i] = currentNum;        
    //     result[i][size] = currentNum;
    //     result[size][i] = currentNum;
    //     result[i][currentPos] = currentNum;
    //   }
    //   size--;      
    //   currentPos++;
    //   currentNum--;
    // }

    //// Print array
    // result[currentPos-1][currentPos-1] = 1;
    // for(int i=0; i < 2*A-1; i++){
    //   for(int j=0; j < 2*A-1; j++){
    //     System.out.print(result[i][j] + " ");
    //   }
    //   System.out.println();      
    // }

    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(2*A-1);
    int currentPos = 0;
    int currentNum = A;
    int size = 2*A-2;

    ArrayList<Integer> temp;

    // Initialize array list
    for(int i=0; i <= size; i++){
      temp = new ArrayList<Integer>(2*A-1);
      for(int j=0; j <= size; j++){
        temp.add(j, 0);
      }
      result.add(i, temp);
    }

    // Set matrix values
    while(currentPos < A){
      for(int i=currentPos; i <= size; i++){
        result.get(currentPos).set(i, currentNum);
        result.get(i).set(size, currentNum);
        result.get(size).set(i, currentNum);
        result.get(i).set(currentPos, currentNum);
      }
      size--;      
      currentPos++;
      currentNum--;
    }

    return result;
  }
}