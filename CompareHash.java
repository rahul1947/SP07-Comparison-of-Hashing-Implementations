package rsn170330.sp07;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.io.Serializable;

/**
 * Implement one or more hashing algorithms from the following: Double hashing /
 * Robin Hood / Hopscotch / Cuckoo Compare its/their performance with Java's
 * HashMap/HashSet on millions of operations: add, contains, and remove.
 * 
 * Generate an array of random integers, and calculate how many distinct numbers
 * it has: static<T> int distinctElements(T[ ] arr) { ... } Compare running
 * times of HashSet and your hashing implementation, for large n.
 * 
 * @author Rahul Nalawade (rsn170330)
 * @author Arunachalam Saravanan (axs170081)
 *
 */
public class CompareHash {

	public static void main(String[] args) {
		Random rand = new Random();
		
		int N = 1000000; // CHANGE YOUR LIMIT HERE
		Integer[] duplicates = new Integer[N];

		for (int i = 0; i < N; i++) {
			// NOTE: works efficiently for random positive integers
			// from 0 to 10*N
			duplicates[i] = rand.nextInt(N*10);
		}

		DoubleHashing<Integer> ds = new DoubleHashing<>();
		Set<Integer> hs = new HashSet<>();
		
		Timer timer = new Timer();
		timer.start();
		
		for (int i = 0; i < N; i++) {
			hs.add(duplicates[i]);
		}
		
		System.out.println("Distinct elements in HashSet " + hs.size());
		timer.end();
		System.out.println(timer);
		
		System.out.println();
		
		timer.start();
		System.out.println("Distinct elements in Double hashing " + DoubleHashing.distinctElements(duplicates));
		timer.end();
		System.out.println(timer);

	}
}
