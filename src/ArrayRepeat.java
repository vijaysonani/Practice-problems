import java.util.HashSet;

/*
* Given a read only array of n + 1 integers between 1 and n, find one number that repeats 
* in linear time using less than O(n) space and traversing the stream sequentially O(1) times.
*
* Sample Input:
* [3 4 1 4 1]
*
* Sample Output:
* 1
*
* If there are multiple possible answers ( like in the sample case above ), output any one.
*
* If there is no duplicate, output -1 
*
* Notes:
* array of n + 1 integers between 1 and n == atleast one number duplicate number
* O(n) space == can copy all elements into another data structure (set in this case)
*
*/

 public class ArrayRepeat {
	public static void main(String args[]) {
		int[] arr = {3, 4, 1, 4, 1};
		ArrayRepeat obj = new ArrayRepeat();
		obj.findDuplicate(arr);
	}

	public void findDuplicate(int[] arr) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int var : arr) {
			if (set.contains(var)) {
				System.out.println(var);
				break;
			} else {
				set.add(var);
			}
		}
	}
}
