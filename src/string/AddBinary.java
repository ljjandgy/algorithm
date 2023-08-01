package string;

/**
 *  二进制求和
 *
 *  给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 */
public class AddBinary {
    /**
     * 利用系统封装的10进制转2进制的方法进行运算
     */
    public String addBinaryMy(String a, String b) {

        return Integer.toBinaryString(
                //二转10求和再转2
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }

    /**
     * 利用unicode‘0’进行运算，得出
     */
    public String addBinary(String a, String b) {

        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            //巧妙处理是否进一的问题
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }
}
