// Given an array of N integers, and a number sum, the task is to find the number of pairs of integers in the array whose sum is equal to sum.
// Input:  arr[] = {1, 5, 7, -1}, sum = 6
// Output:  2


import java.util.HashMap;

class CountPairsWithGivenSum {
	static int arr[] = new int[] { 1, 5, 7, -1, 5 };
	static int getPairsCount(int n, int sum) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (!hm.containsKey(arr[i]))
				hm.put(arr[i], 0);

			hm.put(arr[i], hm.get(arr[i]) + 1);
		}
		int twice_count = 0;
		for (int i = 0; i < n; i++) {
			if (hm.get(sum - arr[i]) != null)
				twice_count += hm.get(sum - arr[i]);
			if (sum - arr[i] == arr[i])
				twice_count--;
		}
		return twice_count / 2;
	}
	public static void main(String[] args) 	{

		int sum = 6;
		System.out.println(
			"Count of pairs is "
			+ getPairsCount(arr.length, sum));
	}
}
