package rsn170330.sp07;

import java.util.Iterator;

/**
 * CS 5V81.001: Implementation of Data Structures and Algorithms
 * Short Project SP07: Double Hashing Implementation
 * Team SP43:
 * @author Rahul Nalawade (rsn170330)
 * 
 * Date: October 21, 2018
 */
public class DoubleHashing<T> {
	
	private int size;
	Entry<T>[] table;
	private double loadFactor = 0.5; // default for open-addressing
	int capacity;
	
	static class Entry<T>{
		T element;
		boolean isDeleted;

		public Entry(T x){
			this.element = x;
			this.isDeleted = false;
		}
	}
	
	public DoubleHashing() {
		capacity = 1024;
		table = new Entry[1024];
		size = 0;
	}
	
	public DoubleHashing(int initialSize) {
		capacity = initialSize;
		table = new Entry[initialSize];
		size = 0;
	}
	
	/**
	 * TODO: This might look to give random sequence
	 * but, we will give in the sequence of our table
	 */
	public Iterator<T> iterator() {
		return null;
	}
	
	/**
	 * Code extracted from Java HashMap. 
	 * This function ensures that hashCodes that differ only by 
	 * constant multiples at each bit position have a bounded 
	 * number of collisions (approximately 8 at default load factor).
	 * @param h input number
	 * @return the hash value
	 */
	static int hash(int h){
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ ( h >>> 7) ^ (h >>> 4);
	}
	
	/**
	 * Returns appropriate index where key is to be stored
	 * @param h a (hash?) value
	 * @param length
	 * @return index in hash table
	 */
	static int indexFor(int h, int length) {
		// length = table.length is a power of 2
		return h & (length - 1);
	}

	/*
	 * hashCode(): implemented by converting the internal address of 
	 * the object into an integer
	 * Key is stored at table[hash( x.hashCode() ) & ( table.length − 1 ) ]
	 */
	private int h(T x) {
		return indexFor(hash(x.hashCode()), table.length);
	}
	
	/**
	 * Returns single digit non-zero number
	 * @param x the input
	 * @return the hashDigit
	 */
	private int h2(T x) {
		return 1 + x.hashCode() % 9;
	}
	
	/**
	 * Search for x and return index of x. 
	 * If x is not found, return index where x can be added.
	 * @param x the element
	 * @return index of x
	 */
	private int find(T x) {
		
		int index = 0;
		int k = 0;
		
		while (true) {
			
			// update index as per Double Hashing algorithm
			index = (h(x) + k * h2(x)) % table.length;
			
			// When the index is freshly available or there is already x at that index
			if (table[index] == null || x.equals(table[index].element)) 
				return index;
			
			// When the index is available because of some other element was removed
			else if (table[index].isDeleted) 
				break;
			
			// When the index is unavailable
			else 
				k++;
		}
		// We know we got an previously occupied place
		int xSpot = index;
		
		/* What if our x is in further probe sequence? 
		 * So, finding if x is in next probe sequences,
		 * If present return that index. 
		 * If freshly unoccupied spot found, x was never there. 
		 */
		while (table[index] != null) {
			
			// updating index for next index in probe sequence 
			k++;
			index = (h(x) + k * h2(x)) % table.length;
			
			// When we found freshly available index
			if (table[index] == null) 
				return xSpot;

			// When x was there, return that index
			if (x.equals(table[index].element)) 
				return index;
		}
		// avoiding NPE**
		return xSpot; // so returning xSpot
	}
	
	/**
	 * If x is there is the Collection.
	 * @param x the input element
	 * @return true if present, false otherwise
	 */
	public boolean contains(T x) {
		int location = find(x);
		
		// When that location is not NULL AND the elements match AND it is not deleted
		return (table[location] != null && x.equals(table[location].element) && !table[location].isDeleted);
	}
	
	/**
	 * Adds the specified element to this set if it is not already present.
	 * @param x the element to be added
	 * @return true if successful insertion, false otherwise
	 */
	public boolean add(T x) {
		int location = find(x);
		
		// When that location is not NULL AND the elements match AND it is not deleted
		if (table[location] != null && x.equals(table[location].element) && !table[location].isDeleted)
			return false;
		
		// Now we need to actually add x.
		else {
			// We will create a new Entry for x.
			Entry<T> newEntry = new Entry(x);
			table[location] = newEntry;
			size++;
			if (size > loadFactor * table.length) {
				resize();
			}
			return true;
		}
	}
	
	/**
	 * Removes the specified element from this set if it is present.
	 * @param x the element to be removed
	 * @return true, if successfully removed, false otherwise
	 */
	public boolean remove(T x) {
		int location = find(x);
		
		// When that location is not NULL AND the elements match AND it is not deleted
		if (table[location] != null && x.equals(table[location].element) && !table[location].isDeleted) {
			//T result = table[location].element;
			table[location].isDeleted = true;
			size--;
			return true;
		}
		
		return false;
	}
	
	// Returns current size
	public int size() {
		return size;
	}
	
	// Returns true if this set contains no elements.
	public boolean isEmpty() {
		return size() == 0;
	}
	
	/**
	 * Re-builds Hash Table with new length 
	 * as twice the previous length
	 */
	private void resize() {
		
		Entry<T>[] temp = table;
		capacity = capacity * 2;
		
		table = new Entry[capacity];
		size = 0;
		
		for (Entry<T> e: temp) {
			if (e != null && !e.isDeleted) {
				this.add( e.element);
			}
		}
	}
	
	// Debugging
	private void printer(){
		if (size == 0) {
			System.out.println("HashTable is empty");
		}
		
		else {
			for (int i = 0; i < table.length; i++) {
				if(table[i] != null && !table[i].isDeleted){
					System.out.print(i + ":" + table[i].element + "  ");
				}
			}
		}
	}
	
	// Debugging
	private void printTable() {
		System.out.print("Table: ");
		for (int j = 0; j < table.length; j++) {
			if (table[j] != null && table[j].isDeleted == false)
				System.out.print(table[j].element + " ");
			else
				System.out.print("* ");
		}
		System.out.println();
	}
	
	/**
	 * Calculate distinct elements in an array
	 * @param arr: Array of Integers which may or may not have duplicates.
	 * @return: returns the count of distinct elements in the provided array.
	 */
	public static<T> int distinctElements(T[] arr){
		DoubleHashing<T> dist = new DoubleHashing<>();
		
		for (T e : arr) { dist.add(e); }
		return dist.size();
	}
}
