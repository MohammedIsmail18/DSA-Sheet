# Contains Duplicate

## Problem
Given an integer array, return `true` if any element appears at least twice; otherwise, return `false`.

**Example:** `{2, 4, 3, 5, 2, 1}` → `true`

## 1. Brute Force — Nested Loops

**Idea:** Compare each element with every element that comes after it.

```java
boolean result = false;

for (int i = 0; i < arr.length; i++) {
    for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] == arr[j]) {
            result = true;
            break;
        }
    }
}
```

- **Time:** `O(n²)` — compares pairs of elements.
- **Auxiliary Space:** `O(1)` — uses a fixed number of variables.

**Pattern:** Select element → compare with remaining elements → detect a match.

## 2. Optimal — HashSet

**Idea:** Store visited elements in a `HashSet`. If an element already exists in the set, a duplicate is found.

```java
Set<Integer> set = new HashSet<>();

for (int num : arr) {
    if (set.contains(num)) {
        return true;
    }
    set.add(num);
}

return false;
```

*Place this logic inside a method that returns `boolean`.*

- **Time:** `O(n)` average — HashSet lookup and insertion take average `O(1)` each.
- **Auxiliary Space:** `O(n)` — the set can store up to `n` elements.

**Pattern:** Check existence → if present, return `true` → otherwise, insert → if the loop finishes, return `false`.

## 3. Key Difference

| Approach | Time | Auxiliary Space |
|---|---|---|
| Brute force | `O(n²)` | `O(1)` |
| HashSet | `O(n)` average | `O(n)` |

**Why is HashSet faster?**

It avoids comparing every pair of elements by checking whether an element has already been seen.

## Pattern to Remember

- **Brute force:** Compare pairs using nested loops.
- **Optimal:** Use a HashSet to remember previously visited elements.

**Important:** The HashSet approach uses extra memory to improve time complexity. In the brute-force approach, `break` exits only the inner loop; returning `true` immediately exits the method.
