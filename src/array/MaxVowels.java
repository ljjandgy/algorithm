package array;

/**
 * 给你字符串 s 和整数 k 。
 *
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 *
 * 英文中的 元音字母 为（a, e, i, o, u）。
 */
public class MaxVowels {
    /**
     * 滑动窗口获取定长子数组元音字母的长度
     * 具体逻辑为：
     * 1、先计算第一个长度为K的窗口里面元音字母的数量
     * 2、往右移动窗口，知道窗口和数组最后重叠
     * 3、移动过程中，不断计算窗口中元音字母长度，并记录最大值（计算方式为-去退出去的元音字母长度+新进来的长度）
     */
    public int maxVowels(String s, int k) {
        int n = s.length();
        int vowel_count = 0;
        for (int i = 0; i < k; ++i) {
            vowel_count += isVowel(s.charAt(i));
        }
        int ans = vowel_count;
        for (int i = k; i < n; ++i) {
            vowel_count += isVowel(s.charAt(i)) - isVowel(s.charAt(i - k));
            ans = Math.max(ans, vowel_count);
        }
        return ans;
    }

    public int isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ? 1 : 0;
    }
}
