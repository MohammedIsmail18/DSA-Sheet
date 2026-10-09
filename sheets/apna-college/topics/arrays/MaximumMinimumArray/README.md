# Maximum & Minimum Element in an Array

## Problem
Find the minimum and maximum element in an array.

Example:
```text
[2, 3, 8, 5, 7]

Min = 2
Max = 8
```

---

## 1. Brute Force — Sort

### Idea
Sort the array → first element = minimum, last element = maximum.

```java
Arrays.sort(arr);

int min = arr[0];
int max = arr[arr.length - 1];
```

### Complexity
```text
Time  → O(n log n)
Space → O(log n)  // sorting's auxiliary stack space
```

### Why not optimal?
Sorting the entire array is unnecessary when we only need two values.

---

## 2. Optimal — Single Traversal ⭐

### Idea
Initialize `min` and `max` with the first element, then scan the array once.

```java
int min = arr[0];
int max = arr[0];

for (int i = 1; i < arr.length; i++) {
    if (arr[i] < min) {
        min = arr[i];
    } else if (arr[i] > max) {
        max = arr[i];
    }
}
```

### Complexity
```text
Time  → O(n)
Space → O(1)
```

### Why O(1) space?
Only a fixed number of variables are used:
```text
min, max, i
```

The number of variables doesn't grow with `n`.

---

## Key Pattern 🧠

> **Need min/max? Don't sort first.**
> **Initialize → traverse once → update.**

```text
Sort + access        → O(n log n)
Single traversal     → O(n)
```

### Complexity Quick Reference

```text
Time:
Single operation     → O(1)
One loop             → O(n)
Nested loops         → O(n²)
Binary search        → O(log n)
Sorting              → O(n log n)

Space:
Few variables        → O(1)
Extra array of n     → O(n)
Recursion depth n    → O(n)
Recursion depth log n→ O(log n)
Matrix n × n         → O(n²)
```

## Interview Takeaway

**Brute force:** Sort the array.

**Optimal:** One-pass traversal with `min` and `max`.

**Best answer:** `O(n)` time and `O(1)` auxiliary space.