# Minimize Set

## Problem Statement

Given two divisors (`divisor1` and `divisor2`) and their respective unique counts (`uniqueCnt1` and `uniqueCnt2`), you need to find the minimum size of a set such that:

1. The set contains at least `uniqueCnt1` elements divisible by `divisor1`.
2. The set contains at least `uniqueCnt2` elements divisible by `divisor2`.
3. The set contains at least `uniqueCnt1 + uniqueCnt2` elements divisible by the least common multiple (LCM) of `divisor1` and `divisor2`.

## Approach and Algorithm

1. **Calculate LCM:**
   - Find the least common multiple (LCM) of `divisor1` and `divisor2`.
   - Use the formula: LCM x GCD = a x b.

2. **Binary Search:**
   - Initialize `start` as the sum of `uniqueCnt1` and `uniqueCnt2`.
   - Initialize `end` as `Integer.MAX_VALUE`.

3. **Binary Search Loop:**
   - Perform a binary search between `start` and `end`.
   - In each iteration, calculate the middle point `mid`.
   - Check three conditions:
      - `c1`: The count of elements divisible by `divisor1` is at least `uniqueCnt1`.
      - `c2`: The count of elements divisible by `divisor2` is at least `uniqueCnt2`.
      - `c3`: The count of elements divisible by the LCM is at least `uniqueCnt1 + uniqueCnt2`.
   - Adjust `start` and `end` accordingly based on the conditions.

4. **Return Result:**
   - The final `start` value represents the minimum size of the set that satisfies all conditions.

## Complexity Analysis

- **Time Complexity:** O(log(end - start))
   - Binary search is performed on the range between `start` and `end`.

- **Space Complexity:** O(1)
   - Constant space is used for variables.

## Intuition

The approach involves finding the least common multiple (LCM) of the given divisors and then using binary search to find the minimum set size that satisfies the conditions specified in the problem. The binary search ensures efficient exploration of the possible set sizes, and the three conditions checked in each iteration ensure that the set meets the required divisibility criteria for both divisors and their LCM.
