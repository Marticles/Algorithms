package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *
 * 1. 将两个字符串排序，若排序后不同则肯定不是异位词
 *    时间复杂度O(nlogn)，空间复杂度O(1)。
 *
 * 2. 维护一个大小为26的Hash Table, 分别遍历字符串A和B，A中出现的字母在Hash Table中自加，B中的则自减，
 *    最后检查Hash Table中所有元素是否为0即可（如果<0则可以立即返回false，避免后续不必要的遍历与检查）
 *    时间复杂度O(n)，空间复杂度O(1)。
 *
 * 3. 若包含Unicode编码字符则可以使用HashMap
 *
 * Tag: Sort, Hash Table
 *
 */
public class LC242_ValidAnagram {

    // 排序
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    // HashMap
    public boolean isAnagram1(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null) {
                return false;
            } else if (count > 1) {
                map.put(ch, count - 1);
            } else {
                map.remove(ch);
            }
        }
        return map.isEmpty();
    }

    // HashTable
    public boolean isAnagram2(String s, String t) {
        int[] sCounts = new int[26];
        int[] tCounts = new int[26];
        for (char ch : s.toCharArray()) {
            sCounts[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            tCounts[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sCounts[i] != tCounts[i]) {
                return false;
            }
        }
        return true;
    }

}
