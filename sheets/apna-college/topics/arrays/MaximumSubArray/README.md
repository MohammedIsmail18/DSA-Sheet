# Maximum Subarray Sum

## Problem

Given an integer array, find the maximum sum of any non-empty contiguous subarray.

**Example:**

Input: `{-2, 3, -1, 6, 9, -5, 4}`

Output: `17`

Maximum-sum subarray: `{3, -1, 6, 9}`

## 1. Brute Force — Generate All Subarrays

**Idea:** Select every possible starting index, extend the subarray one element at a time, and keep track of the maximum sum.

### Java Code

```java
int[] arr = {-2, 3, -1, 6, 9, -5, 4};
int maxSum = Integer.MIN_VALUE;

for (int i = 0; i < arr.length; i++) {
    int sum = 0;

    for (int j = i; j < arr.length; j++) {
        sum += arr[j];

        if (sum > maxSum) {
            maxSum = sum;
        }
    }
}

System.out.println("Maximum SubArray: " + maxSum);
```

**Output:** `Maximum SubArray: 17`

### How It Works

- The outer loop selects the starting index `i`.
- The inner loop selects the ending index `j`.
- `sum += arr[j]` adds the next element to the running sum.
- `maxSum` stores the largest sum found so far.
- `sum = 0` resets the running sum for every new starting index.

**Time Complexity:** `O(n²)` — the total number of iterations is `n(n+1)/2`, which simplifies to `O(n²)`.

**Auxiliary Space:** `O(1)` — only a fixed number of variables are used.

**Why not `O(n³)`?** The sum is updated incrementally instead of recalculating the sum of each subarray from scratch.

## 2. Optimal — Kadane’s Algorithm

**Idea:** Traverse the array once. At each element, decide whether to extend the existing subarray or start a new subarray from the current element.

Maintain two variables:

- `currentSum` — the maximum sum of a subarray ending at the current position.
- `maxSum` — the maximum sum found anywhere so far.

### Java Code

```java
int[] arr = {-2, 3, -1, 6, 9, -5, 4};

int currentSum = arr[0];
int maxSum = arr[0];

for (int i = 1; i < arr.length; i++) {
    currentSum = Math.max(arr[i], currentSum + arr[i]);
    maxSum = Math.max(maxSum, currentSum);
}

System.out.println("Maximum SubArray: " + maxSum);
```

**Output:** `Maximum SubArray: 17`

### How It Works

At every element, compare two choices:

1. Start a new subarray with `arr[i]`.
2. Extend the existing subarray with `currentSum + arr[i]`.

Choose the larger value:

```java
currentSum = Math.max(arr[i], currentSum + arr[i]);
```

Then update the maximum sum found so far:

```java
maxSum = Math.max(maxSum, currentSum);
```

**Time Complexity:** `O(n)` — the array is traversed once, with constant-time operations per element.

**Auxiliary Space:** `O(1)` — only a fixed number of variables are required.

**Important:** Initializing both variables with `arr[0]` means the loop must start at `i = 1`. This avoids processing the first element twice and correctly handles all-negative arrays.

## 3. Key Difference

| Approach | Time Complexity | Auxiliary Space |
|---|---|---|
| Brute force | `O(n²)` | `O(1)` |
| Kadane’s algorithm | `O(n)` | `O(1)` |

**Why is Kadane’s algorithm faster?**

Brute force explores every possible subarray. Kadane’s algorithm avoids generating them all by maintaining the best sum ending at each position and deciding whether to extend or restart.

## 4. Pattern to Remember

**Brute force:** Choose starting index → extend subarray → accumulate sum → update maximum.

**Optimal:** Compare starting fresh vs. extending → update `currentSum` → update `maxSum`.

**Kadane’s core formula:**

```java
currentSum = Math.max(arr[i], currentSum + arr[i]);
maxSum = Math.max(maxSum, currentSum);
```

## 5. Common Mistakes

- Initializing `maxSum = 0` can give the wrong answer when all elements are negative.
- Resetting `sum` inside the inner loop instead of the outer loop breaks the brute-force logic.
- Starting Kadane’s loop at `i = 0` while initializing `currentSum = arr[0]` processes the first element twice.
- A subarray must be contiguous; skipping an element in the middle is not allowed.

## 6. Practice Checklist

- [ ] Solve using brute force without referring to the notes.
- [ ] Solve using Kadane’s algorithm without referring to the notes.
- [ ] Test `{2, -3, 5, -1, 4}`. Expected sum: `8`.
- [ ] Test `{-8, -3, -6, -2, -5}`. Expected sum: `-2`.
- [ ] Explain why brute force is `O(n²)` and Kadane’s algorithm is `O(n)`.