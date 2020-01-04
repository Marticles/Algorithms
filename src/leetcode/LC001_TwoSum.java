package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * 暴力法：两层嵌套循环，第一层遍历所有元素，第二层遍历查找对应的target-x元素是否存在。
 * 时间复杂度O(n^2)，空间复杂度O(1)。
 *
 * HashMap：先将所有元素放入HashMap中，第二次遍历所有元素并在HashMap中查找target-x元素是否存在。
 * 时间复杂度O(n)，空间复杂度O(n)。
 *
 */
public class LC001_TwoSum {

    /**
     * 一遍HashMap
     * 在第一步遍历数组元素并插入HashMap时就可以直接查找当前HashMap中是否存在target-x元素
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return null;

    }

    /**
     * 两遍HashMap
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; j++) {
            int complement = target - nums[j];
            if (map.containsKey(complement) && map.get(complement) != j) {
                return new int[] { j, map.get(complement) };
            }
        }
        return null;
    }

    /**
     * 两遍循环暴力法
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

}
