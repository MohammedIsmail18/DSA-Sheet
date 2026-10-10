# Reverse an Array

## Problem
Reverse the elements of an array.

**Example:** `[2, 3, 4, 6, 7, 9]` → `[9, 7, 6, 4, 3, 2]`

## 1. Brute Force — Use a New Array

**Idea:** Traverse the original array backward and copy each element into a new array.

```java
int n = arr.length;
int[] rev = new int[n];

for (int i = 0; i < n; i++) {
    rev[i] = arr[n - 1 - i];
}
```

- **Time:** `O(n)` — visits every element once.
- **Auxiliary Space:** `O(n)` — creates a new array of size `n`.

## 2. Optimal — Two Pointers

**Idea:** Swap elements at opposite ends of the same array and move toward the center.

```java
int left = 0;
int right = arr.length - 1;

while (left < right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;

    left++;
    right--;
}
```

- **Time:** `O(n)` — performs approximately `n/2` swaps, which simplifies to `O(n)`.
- **Auxiliary Space:** `O(1)` — uses only a fixed number of variables; no additional array.

## Key Difference

| Approach | Time | Auxiliary Space |
|---|---|---|
| Brute force | `O(n)` | `O(n)` |
| Optimal | `O(n)` | `O(1)` |

**Why is the optimal space `O(1)`?**

The array is modified in place. No second array is created, and the number of extra variables remains constant regardless of input size.

## Pattern to Remember

**Brute force:** Create a new array → copy elements in reverse order.

**Optimal:** Initialize two pointers → swap → move inward → stop when `left >= right`.

**Important:** Output size does not automatically determine auxiliary space. Creating a separate output array requires `O(n)` extra space; modifying the input array in place requires only `O(1)` auxiliary space.
