

// 1.	Write a program to implement Linear Search to find a target value in an array. Measure and log its execution time in microseconds for an array size of (n = 10,000), (50,000), and (100,000\) to demonstrate (O(n)) behavior.

public class LinearSearchTime {

    public static int linearSearch(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] sizes = {10000, 50000, 100000};

        for (int n : sizes) {

            int[] arr = new int[n];

            // Fill array
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }

            int target = n - 1;

            long start = System.nanoTime();

            linearSearch(arr, target);

            long end = System.nanoTime();

            long timeMicroseconds = (end - start) / 1000;

            System.out.println(
                "n = " + n +
                " | Time = " + timeMicroseconds + " microseconds"
            );
        }
    }
}


// 2.	Write a program to implement Binary Search on a pre-sorted array. Measure and log execution times for identical data sizes ((n = 10,000), (50,000), and (100,000)) to contrast (O(log n)) efficiency against linear search.

public class BinarySearchTime {

    public static int binarySearch(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] sizes = {10000, 50000, 100000};

        for (int n : sizes) {

            int[] arr = new int[n];

            // Sorted array
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }

            int target = n - 1;

            long start = System.nanoTime();

            binarySearch(arr, target);

            long end = System.nanoTime();

            long timeMicroseconds = (end - start) / 1000;

            System.out.println(
                "n = " + n +
                " | Time = " + timeMicroseconds + " microseconds"
            );
        }
    }
}


// 3.	Create a program containing two nested loops (e.g., executing a matrix-style operation or a basic bubble comparison loop). Record performance drop-offs as data size scales upward to demonstrate (O(n^2)) behavior.


public class NestedLoopTime {

    public static void main(String[] args) {

        int[] sizes = {1000, 5000, 10000};

        for (int n : sizes) {

            long start = System.nanoTime();

            int count = 0;

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    count++;
                }
            }

            long end = System.nanoTime();

            long timeMicroseconds = (end - start) / 1000;

            System.out.println(
                "n = " + n +
                " | Operations = " + count +
                " | Time = " + timeMicroseconds + " microseconds"
            );
        }
    }
}
