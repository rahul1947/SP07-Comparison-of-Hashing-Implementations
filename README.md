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

``
+----------------------------------------------------------------------------------------------------------------+
| Test        |  No of   |     Java HashSet    |    Double Hashing   |  Robin Hood Hashing |    Cuckoo Hashing   |
| Files       |  Operta- |---------------------|---------------------|---------------------|---------------------|
|             |  tions   |  Time |   Memory    |  Time |   Memory    |  Time |   Memory    |  Time |   Memory    |
|-------------|----------|-------|-------------|-------|-------------|-------|-------------|-------|-------------|
| lp2-t01.txt |       50 |     6 |     1 / 117 |     5 |     1 / 117 |     5 |     1 / 117 |     5 |     1 / 117 |
|-------------|----------|-------|-------------|-------|-------------|-------|-------------|-------|-------------|
| lp2-t02.txt |      201 |    10 |     1 / 117 |     9 |     1 / 117 |    10 |     1 / 117 |     9 |     1 / 117 |
|-------------|----------|-------|-------------|-------|-------------|-------|-------------|-------|-------------|
| lp2-t03.txt |     1001 |    18 |     3 / 117 |    16 |     3 / 117 |    15 |     3 / 117 |    16 |     3 / 117 |
|-------------|----------|-------|-------------|-------|-------------|-------|-------------|-------|-------------|
| lp2-t04.txt |    50001 |   128 |    23 / 117 |   124 |    24 / 117 |   130 |    25 / 117 |   131 |    29 / 117 |
|-------------|----------|-------|-------------|-------|-------------|-------|-------------|-------|-------------|
| lp2-t05.txt |   100000 |   183 |    43 / 147 |   176 |    45 / 147 |   188 |    43 / 147 |   216 |    54 / 147 |
|-------------|----------|-------|-------------|-------|-------------|-------|-------------|-------|-------------|
| lp2-t06.txt |  1000000 |  1168 |    94 / 578 |  1216 |    94 / 581 |  1194 |    60 / 572 |  1744 |   187 / 439 |
+----------------------------------------------------------------------------------------------------------------+
```

b. Generate an array of random integers, and calculate how many distinct numbers it has: 
```
static<T> int distinctElements(T[ ] arr) { ... } 
```
   Compare running times of HashSet and your hashing implementation, for large n.


