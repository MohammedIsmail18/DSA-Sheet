# Chocolate Distribution Problem

## Problem
Given an array where each element represents the number of chocolates in a packet, distribute packets to `m` students such that the difference between the maximum and minimum chocolates is minimized.

**Example:**

Input: `{3, 7, 56, 9, 11, 9, 5, 1, 22}`, `m = 5`

Output: `6`

## 1. Brute Force
**Idea:** Consider every possible combination of `m` packets and calculate the difference between the maximum and minimum chocolates in each combination. Return the smallest difference.

- **Time:** Combinatorial; examining all combinations takes at least `O(C(n,m))` combinations, with additional work to find each combination's minimum and maximum.
- **Auxiliary Space:** Depends on the implementation.

## 2. Optimal — Sorting + Sliding Window

**Idea:** Sort the array, then examine every group of `m` consecutive elements. Find the smallest difference between the last and first elements of each group.

### Java Code

```java
import java.util.Arrays;

int[] arr = {3, 7, 56, 9, 11, 9, 5, 1, 22};
int m = 5;

if (m <= 0 || m > arr.length) {
    System.out.println("Invalid number of students");
} else {
    Arrays.sort(arr);
    int result = Integer.MAX_VALUE;

    for (int i = 0; i <= arr.length - m; i++) {
        int difference = arr[i + m - 1] - arr[i];
        result = Math.min(result, difference);
    }

    System.out.println("Minimum difference: " + result);
}
```

**Output:** `Minimum difference: 6`

### How It Works

- Sort the array: `{1, 3, 5, 7, 9, 9, 11, 22, 56}`.
- Each window contains `m = 5` consecutive packets.
- Calculate the difference: `arr[i + m - 1] - arr[i]`.
- Update `result` whenever a smaller difference is found.

**Time:** `O(n log n)` — sorting takes `O(n log n)` and checking the windows takes `O(n)`.

**Auxiliary Space:** Typically `O(log n)` including the sorting stack for Java primitive-array sorting. The window loop itself uses `O(1)` extra space.

## 3. Key Difference

| Approach | Time Complexity | Auxiliary Space |
|---|---|---|
| Brute force | Combinatorial | Implementation-dependent |
| Sorting + sliding window | `O(n log n)` | Typically `O(log n)` including sort stack |

## Pattern to Remember

**Sort → choose a window of size `m` → calculate last element minus first element → update minimum.**

**Important concepts:**

- `Integer.MAX_VALUE`: initialize a minimum tracker.
- `Integer.MIN_VALUE`: initialize a maximum tracker.
- For an array of length `n`, valid indexes are `0` through `n - 1`.
- For a window starting at `i` with size `m`, the last index is `i + m - 1`.
- The last valid starting index is `n - m`, so the loop condition is `i <= arr.length - m`.
- Validate that `m > 0` and `m <= arr.length` before processing.
