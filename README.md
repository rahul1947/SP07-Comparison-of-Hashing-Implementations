## Short Project SP07: Comparison of Hashing Implementations
* Comparison of one or more Hashing Algorithms from - Double Hashing, Robin Hood Hashing, Hopscotch Hashing, Cuckoo Hashing with Java's inbuilt HashMap/ HastSet over millions of add(), contains() and remove() operations. 
* Finding distinct elements from a large array of randomly generated integers using the above Hashing Implementation(s). 

#### Author
* [Rahul Nalawade](https://github.com/rahul1947)

#### Date
* October 21, 2018

_______________________________________________________________________________
### Problems:

#### A. Team Task: 

**Problem 1.**
a. Implement one or more hashing algorithms from the following: 
   Double hashing / Robin Hood / Hopscotch / Cuckoo Hashing.
   
   Compare its/their performance with Java's HashMap/HashSet on millions of operations: add, contains, and remove.

**Solution:** 
1. [Double Hashing](https://github.com/rahul1947/SP07-Comparison-of-Hashing-Algorithms/blob/master/DoubleHashing.java) 
2. [Robin Hood Hashing](https://github.com/rahul1947/SP07-Comparison-of-Hashing-Algorithms/blob/master/RobinHood.java) 
3. [Cuckoo Hashing](https://github.com/rahul1947/SP07-Comparison-of-Hashing-Algorithms/blob/master/Cuckoo.java)

```
Sample Run: 
rahul:test$ javac rsn170330/*.java
rahul:test$ java rsn170330.HashingDriver1 rsn170330/sp07-test/lp2-t03.txt 0
HashSet result: 721
HashSet size: 499
Time: 16 msec.
Memory: 3 MB / 117 MB.
rahul:test$ java rsn170330.HashingDriver1 rsn170330/sp07-test/lp2-t03.txt 1
Double Hashing result: 721
Double Hashing size: 499
Time: 17 msec.
Memory: 3 MB / 117 MB.
rahul:test$ java rsn170330.HashingDriver1 rsn170330/sp07-test/lp2-t03.txt 2
Robin Hood result: 721
Robin Hood size: 499
Time: 18 msec.
Memory: 3 MB / 117 MB.
rahul:test$ java rsn170330.HashingDriver1 rsn170330/sp07-test/lp2-t03.txt 3
Cuckoo Hashing result: 721
Cuckoo Hashing size: 499
Time: 15 msec.
Memory: 3 MB / 117 MB.

```
For verbose you can use:
```
rahul:test$ java rsn170330.HashingDriver1 rsn170330/sp07-test/lp2-t06.txt 0 true > sp07-t06-verbose.txt
rahul:test$ java rsn170330.HashingDriver1 rsn170330/sp07-test/lp2-t06.txt 3 true > sp07-t06-cuckoo.txt
```

b. Generate an array of random integers, and calculate how many distinct numbers it has: 
```
static<T> int distinctElements(T[ ] arr) { ... } 
```
   Compare running times of HashSet and your hashing implementation, for large n.


