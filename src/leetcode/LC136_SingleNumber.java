package leetcode;

import java.util.*;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 *
 * 1. HashSet，先遍历所有元素，第一次遇到则直接插入，第二次遇到则从HashSet中删掉该元素，最后返回HashSet中剩下的元素即可。
 * 时间复杂度O(n)，空间复杂度O(n)。
 *
 * 2. 将所有数进行异或运算，因为 "0 ⊕ X = X", "X ⊕ X = 0"，所以最后得到的数就是只出现一次的数。
 * 时间复杂度O(n)，空间复杂度O(1)。
 *
 * Tag: Hash Table, Bit Manipulation
 */
public class LC136_SingleNumber {

    // 两层循环，暴力法，时间复杂度O(n^2)，空间复杂度O(n)
    public int singleNumber(int[] nums) {
        if (nums.length == 0)
            throw new IllegalArgumentException("Input list is empty!");

        List<Integer> ans = new ArrayList<>();
        for (Integer num : nums) {
            if (ans.contains(num)) {
                ans.remove(num);
            } else {
                ans.add(num);
            }
        }
        return !ans.isEmpty() ? ans.get(0) : -1;
    }

    // HashSet
    public int singleNumber2(int[] nums) {
        if (nums.length == 0)
            throw new IllegalArgumentException("Input list is empty!");

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                set.remove(nums[i]);
            }
        }
        return set.iterator().next();
    }

    // 异或
    public int singleNumber3(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }


}
