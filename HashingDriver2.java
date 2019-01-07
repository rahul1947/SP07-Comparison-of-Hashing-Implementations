package rsn170330.sp07;

import java.util.Set;
import java.util.HashSet;
import java.util.Random;

/**
 * CS 5V81.001: Implementation of Data Structures and Algorithms
 * Short Project SP07: Comparison of Hashing Implementations
 * @author Rahul Nalawade
 * 
 * Date: January 4, 2019
 */
public class HashingDriver2 {
	public static Random random = new Random();
	public static int numTrials = 10;
	
	/**
	 * Calculate distinct elements in an array
	 * @param arr: Array of Integers which may or may not have duplicates.
	 * @return: returns the count of distinct elements in the provided array.
	 */
	public static int distinctElements(Integer[] arr){
		Set<Integer> hs = new HashSet<>();
		for (Integer e : arr) { hs.add(e); }
		return hs.size();
	}
	
	public static void main(String[] args) {
		int Million = 1000000;
		int n = Million;
		int choice = 0;
		long result = 0;
		
		if (args.length > 0) {
			n = Integer.parseInt(args[0]);
		}
		if (args.length > 1) {
			choice = Integer.parseInt(args[1]);
		}
		
		Integer[] arr = new Integer[n];
		for (int i = 0; i < n; i++) {
			arr[i] = random.nextInt(n);
		}
		
		Timer timer = new Timer();
		switch (choice) {
		case 1:
			//numTrials = 1; // Uncomment to Test
			for (int i = 0; i < numTrials; i++) {
				Shuffle.shuffle(arr);
				result = DoubleHashing.distinctElements(arr);	
			}
			//System.out.println("Double Hashing: " + result);
			break;
		case 2:
			//numTrials = 1; // Uncomment to Test
			for (int i = 0; i < numTrials; i++) {
				Shuffle.shuffle(arr);
				result = RobinHood.distinctElements(arr);	
			}
			//System.out.println("Robin Hood Hashing: " + result);
			break; 
		case 3:
			//numTrials = 1; // Uncomment to Test
			for (int i = 0; i < numTrials; i++) {
				Shuffle.shuffle(arr);
				result = Cuckoo.distinctElements(arr);
			}
			//System.out.println("Cuckoo Hashing: " + result);
			break;
		default:
			//numTrials = 1;
			for (int i = 0; i < numTrials; i++) {
				Shuffle.shuffle(arr);
				result = distinctElements(arr);
			}
			//System.out.println("Java HashSet: " + result);
			break;
		}
		timer.end();
		timer.scale(numTrials);
		System.out.println("Choice: " + choice + "\n" + timer);
	}
	
	/**
	 * Shuffle the elements of an array arr[from..to] randomly
	 * @author rbk : based on algorithm described in CLRS book
	 */
	public static class Shuffle {

		public static void shuffle(int[] arr) {
			shuffle(arr, 0, arr.length - 1);
		}

		public static <T> void shuffle(T[] arr) {
			shuffle(arr, 0, arr.length - 1);
		}

		public static void shuffle(int[] arr, int from, int to) {
			int n = to - from + 1;
			for (int i = 1; i < n; i++) {
				int j = random.nextInt(i);
				swap(arr, i + from, j + from);
			}
		}

		public static <T> void shuffle(T[] arr, int from, int to) {
			int n = to - from + 1;
			Random random = new Random();
			for (int i = 1; i < n; i++) {
				int j = random.nextInt(i);
				swap(arr, i + from, j + from);
			}
		}

		static void swap(int[] arr, int x, int y) {
			int tmp = arr[x];
			arr[x] = arr[y];
			arr[y] = tmp;
		}

		static <T> void swap(T[] arr, int x, int y) {
			T tmp = arr[x];
			arr[x] = arr[y];
			arr[y] = tmp;
		}

		public static <T> void printArray(T[] arr, String message) {
			printArray(arr, 0, arr.length - 1, message);
		}

		public static <T> void printArray(T[] arr, int from, int to, String message) {
			System.out.print(message);
			for (int i = from; i <= to; i++) {
				System.out.print(" " + arr[i]);
			}
			System.out.println();
		}
	}
}
