import java.util.Arrays;

/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Jiazheng Huang
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		if (k == 0)
			return 1;
		else if (n == k)
			return 1;
		else
			return combinations(n - 1, k - 1) + combinations(n - 1, k);
	}

	// Complete recursive method intWithCommas that returns the argument as a String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {
		if (n > 999)
			if (n % 1000 < 100 && n % 1000 > 10)
				return intWithCommas(n / 1000) + ",0" + Integer.toString(n % 1000);
			else if (n % 1000 < 10)
				return intWithCommas(n / 1000) + ",00" + Integer.toString(n % 1000);
			else
				return intWithCommas(n / 1000) + "," + Integer.toString(n % 1000);
		// TODO: Implement this method using recursion. Do not use a loop
		else
			return Integer.toString(n);
	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		// You need a private helper that needs additional arguments.
		// like x and x.length to keep track of array the indexes
		// with no loop. Here is an example with the private helper
		// immediately below.
		reverseArray(x, 0, x.length);
	}

	private void reverseArray(int[] x, int index, int len) {
		if (index < len - 1) {// Swap
			int temp = x[index];
			x[index] = x[len - 1];
			x[len - 1] = temp;
			reverseArray(x, ++index, --len);// Recursive
		}
	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		int max = a[0];
		int min = a[0];

		return arrayRange(max, min, a, 0, a.length);
	}

	private int arrayRange(int max, int min, int[] a, int index, int len) {
		if (index == len)
			return max - min;
		else if (a[index] > max)
			max = a[index];
		if (a[index] < min)
			min = a[index];
		return arrayRange(max, min, a, ++index, len);
	}

	// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		return isSorted(nums, 0);
	}

	private boolean isSorted(int[] nums, int i) {
		if (nums.length == 0 || nums.length == 1)
			return true;
		else if (i == nums.length - 1)
			return true;
		else if (nums[i] > nums[i + 1])
			return false;
		else
			return isSorted(nums, ++i);
	}

	// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		if (strs.length == 0)
			return false;
		else if (search.equals(strs[0]))
			return true;
		else
			strs = Arrays.copyOfRange(strs, 1, strs.length);
			return found(search, strs);
	}
}
