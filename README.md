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
4. [HashingDriver1.java](https://github.com/rahul1947/SP07-Comparison-of-Hashing-Implementations/blob/master/HashingDriver1.java)

```
Sample Run: 
$ javac rsn170330/*.java

$ java rsn170330.HashingDriver1 rsn170330/sp07-test/lp2-t03.txt 0
HashSet result: 721
HashSet size: 499
Time: 16 msec.
Memory: 3 MB / 117 MB.

$ java rsn170330.HashingDriver1 rsn170330/sp07-test/lp2-t03.txt 1
Double Hashing result: 721
Double Hashing size: 499
Time: 17 msec.
Memory: 3 MB / 117 MB.

$ java rsn170330.HashingDriver1 rsn170330/sp07-test/lp2-t03.txt 2
Robin Hood result: 721
Robin Hood size: 499
Time: 18 msec.
Memory: 3 MB / 117 MB.

$ java rsn170330.HashingDriver1 rsn170330/sp07-test/lp2-t03.txt 3
Cuckoo Hashing result: 721
Cuckoo Hashing size: 499
Time: 15 msec.
Memory: 3 MB / 117 MB.
```

```
For verbose you can use:
$ java rsn170330.HashingDriver1 rsn170330/sp07-test/lp2-t06.txt 0 true > sp07-t06-verbose.txt
$ java rsn170330.HashingDriver1 rsn170330/sp07-test/lp2-t06.txt 3 true > sp07-t06-cuckoo.txt
```

```
Comparison Table: 
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
NOTE: 
- Time is in millisconds and Memory is in MBs
- Existing Processor: **Intel® Core™ i5-8250U CPU @ 1.60GHz × 8**. Memory: **7.5 GiB**


**Problem 1:**

b. Generate an array of random integers, and calculate how many distinct numbers it has: 
```
static<T> int distinctElements(T[ ] arr) { ... } 
```
   Compare running times of HashSet and your hashing implementation, for large n.

**Solution:** 
1. [Double Hashing](https://github.com/rahul1947/SP07-Comparison-of-Hashing-Algorithms/blob/master/DoubleHashing.java) 
2. [Robin Hood Hashing](https://github.com/rahul1947/SP07-Comparison-of-Hashing-Algorithms/blob/master/RobinHood.java) 
3. [Cuckoo Hashing](https://github.com/rahul1947/SP07-Comparison-of-Hashing-Algorithms/blob/master/Cuckoo.java)
4. [HashingDriver2.java](https://github.com/rahul1947/SP07-Comparison-of-Hashing-Implementations/blob/master/HashingDriver2.java)
5. [sp07b-script-results.txt](https://github.com/rahul1947/SP07-Comparison-of-Hashing-Implementations/blob/master/sp07b-script-results.txt)

```
Sample Run:
$ javac rsn170330/*.java

$ java rsn170330.HashingDriver2 1000000 2
Choice: 2
Time: 322 msec.
Memory: 41 MB / 208 MB.
```


```
Comparison Table: 
+--------------------------------------------------------------------------------------------------+
|  Array   |     Java HashSet    |    Double Hashing   |  Robin Hood Hashing |    Cuckoo Hashing   |
|   Size   |---------------------|---------------------|---------------------|---------------------|
|          |  Time |   Memory    |  Time |   Memory    |  Time |   Memory    |  Time |   Memory    |
|----------|-------|-------------|-------|-------------|-------|-------------|-------|-------------|
|      1 M |   379 |   153 / 242 |   448 |   166 / 353 |   317 |    41 / 208 |  1125 |   178 / 709 |
|----------|-------|-------------|-------|-------------|-------|-------------|-------|-------------|
|      2 M |  1004 |   194 / 454 |  1057 |   224 / 415 |   876 |   166 / 234 |  2646 |  587 / 1258 |
|----------|-------|-------------|-------|-------------|-------|-------------|-------|-------------|
|      3 M |  1644 |   269 / 438 |  1684 |   226 / 515 |  1479 |   177 / 319 |  3390 |  814 / 1210 |
|----------|-------|-------------|-------|-------------|-------|-------------|-------|-------------|
|      4 M |  2056 |  353 / 1963 |  2177 |  578 / 1963 |  1871 |  334 / 1963 |  4817 |  637 / 1820 |
|----------|-------|-------------|-------|-------------|-------|-------------|-------|-------------|
|      5 M |  2581 |  483 / 1963 |  2640 |  649 / 1963 |  2532 |  353 / 1963 |  5638 | 1349 / 1820 |
|----------|-------|-------------|-------|-------------|-------|-------------|-------|-------------|
|      8 M |  4402 |  796 / 1963 |  4532 | 1180 / 1820 |  3900 |  667 / 1963 | 17280 | 1229 / 1820 |
|----------|-------|-------------|-------|-------------|-------|-------------|-------|-------------|
|     10 M |  6232 | 1043 / 2944 |  5944 | 1066 / 2518 |  5429 |  960 / 2944 | 15038 | 1491 / 2731 |
+--------------------------------------------------------------------------------------------------+
```
NOTE: 
- Kept *numTrials = 10* for the above results. Increasing *numTrials*, the precision of the results could be improved but it would take more resources as Time and Memory. 