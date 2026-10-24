# Sorting Algorithms

Java sorting exercises for integer arrays and simple records containing a numeric key and character label.

## Included algorithms

- Insertion sort (`insersionSort` in the source).
- Selection sort and bubble sort, including record-array variants.
- Merge sort and quicksort.
- Counting sort and a radix-sort experiment.
- A commented-out bucket-sort sketch.

## Run

With a Java JDK installed, from the repository directory:

```bash
javac -d out src/Sorting.java
java -cp out Sorting
```

No external dependencies or build tool are required. `main` sorts the built-in array `{10, 1, 4, 33, 5, 9}` using quicksort and prints the result. Edit its sample data and selected method call to try other exercises; there is no interactive input.

## Learning-project caveats

- Merge sort's right-half remainder loop reads from the wrong index, so that implementation is not reliable.
- Radix sort has its digit-step update (`dv *= b`) commented out and can loop indefinitely.
- Counting sort assumes nonnegative values below its supplied range size. Inputs and array bounds are not validated.
- The commented bucket-sort sketch is incomplete and is not an available implementation.

Treat these as study implementations, not a production sorting library. All source is in [`src/Sorting.java`](src/Sorting.java).
