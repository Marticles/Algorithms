package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 3
 * Output: [1,3,3,1]
 * Follow up:
 *
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 * Tag: Math, Dynamic Programming
 *
 * 1. 同LC118，但不需要保存中间结果
 * 2. 公式法
 *
 */
public class LC119_PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        int pre = 1;
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                cur.set(j, cur.get(j - 1) + cur.get(j));
            }
            cur.add(1);
        }
        return cur;
    }

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        for (int k = 0; k <= rowIndex; k++) {
            ans.add(combination(rowIndex, k));
        }
        return ans;
    }

    private int combination(int n, int k) {
        long res = 1;
        for (int i = 1; i <= k; i++)
            res = res * (n - k + i) / i;
        return (int) res;
    }
}
