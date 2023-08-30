package string;

/**
 * 求字符串的最大公因子
 * 对于字符串 s 和 t，只有在 s = t + ... + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。
 *
 * 给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 x 能除尽 str2 。
 */
public class GcdOfStrings {
    /**
     * 如果两个字符串有公因子，那么两个字符串换位拼接的结果应该是相同的，如果不同，则表示两个字符串没有公因子
     * 在确定两个字符串有公因子后，就利用gcd算法获取最大公因子的长度，然后通过截取获得最大公因子即可
     * @param str1
     * @param str2
     * @return
     */
    public String gcdOfStrings(String str1, String str2) {
        if (!str1.concat(str2).equals(str2.concat(str1))) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    /**
     * gcd算法，专门用于计算最大公约数，也就是同时能整除两个长度的最大值
     */
    public int gcd(int a, int b) {
        int remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }
}
