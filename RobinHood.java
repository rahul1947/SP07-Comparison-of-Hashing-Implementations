package rsn170330.sp07;

import java.util.Random;

/**
 * CS 5V81.001: Implementation of Data Structures and Algorithms
 * Short Project SP07: Robin Hood Hashing Implementation
 * 
 * @author Rahul Nalawade (rsn170330)
 * Date: Jan 04, 2018
 */

// Hash table implementation using the Robin Hood hashing algorithm.
public class RobinHood<T> {
	
	Object[] table; // The hash table.

	// The largest displacement of any element.
	int maxDisp;
	
	int size; // The size of the table.

	// Initializes new hash table using Robin Hood.
	public RobinHood() {
		table = new Object[1024];
		maxDisp = 0;
		size = 0;
	}

	/**
	 * Adds x to the table.
	 *
	 * @param x the element to add
	 * @return true if x is not in the table, false otherwise
	 */
	public boolean add(T x) {
		if (size >= table.length / 2) {
			resize();
		}
		if (contains(x)) {
			return false;
		}
		int loc = hash(x);
		int d = 0;
		
		while (true) {
			if (table[loc] == null) {
				table[loc] = x;
				size++;
				return true;
			} 
			else if (displacement((T) table[loc], loc) >= d) {
				d++;
				loc = (loc + 1) % table.length;
				maxDisp = Math.max(d, maxDisp);
			} 
			else {
				T temp = x;
				x = (T) table[loc];
				table[loc] = temp;
				loc = (loc + 1) % table.length;
				d = displacement(x, loc);
				maxDisp = Math.max(d, maxDisp);
			}
		}
	}

	/**
	 * Returns true if x is in the table.
	 *
	 * @param x the element to find
	 * @return true if x is in the table, false otherwise
	 */
	public boolean contains(T x) {
		int loc = hash(x);
		for (int d = 0; d <= maxDisp; d++) {
			int index = (loc + d) % table.length;
			if (x.equals(table[index])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Removes x from the table.
	 *
	 * @param x the element to remove
	 * @return true if x was successfully removed, false otherwise
	 */
	public boolean remove(T x) {
		int loc = hash(x);
		
		for (int d = 0; d <= maxDisp; d++) {
			
			int index = (loc + d) % table.length;
			
			if (x.equals(table[index])) {
				table[index] = null;
				size--;
				return true;
			}
		}
		return false;
	}

	// Returns the number of elements in the table.
	public int size() {
		return size;
	}

	// Resizes the table to double the size.
	private void resize() {
		Object[] oldTable = table;
		table = new Object[table.length * 2];
		size = 0;
		maxDisp = 0;
		
		for (Object x : oldTable) {
			if (x != null) {
				add((T) x);
			}
		}
	}

	/**
	 * Returns the displacement of element x at location loc.
	 *
	 * @param x the element to calculate displacement of
	 * @param loc the location of x in the table
	 * @return the displacement of element x at location loc
	 */
	private int displacement(T x, int loc) {
		int h = hash(x);
		return loc >= h ? loc - h : table.length + loc - h;
	}

	/**
	 * Returns the hash of x.
	 *
	 * @param x the element to hash
	 * @return the hash of x
	 */
	private int hash(T x) {
		int h = x.hashCode();
		if (h < 0) {
			return (x.hashCode() + 1) % table.length + table.length - 1;
		}
		return x.hashCode() % table.length;
	}
}
