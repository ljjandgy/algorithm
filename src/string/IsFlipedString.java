package string;

/**
 * 判断字符串是否能够通过轮转变得一样
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 *
 * 示例1:
 *
 *  输入：s1 = "waterbottle", s2 = "erbottlewat"
 *  输出：True
 * 示例2:
 *
 *  输入：s1 = "aa", s2 = "aba"
 *  输出：False
 * 提示：
 *
 * 字符串长度在[0, 100000]范围内。
 * 说明:
 *
 * 你能只调用一次检查子串的方法吗？这句话没懂
 *
 */
public class IsFlipedString {
    /**
     * 解题思路：
     * 所谓是否能轮转，就是判断字符串通过左移/右移后是否能与另外个字符串一致。
     * 解题步骤：
     * 1.如果s1和s2本来就相等，则直接返回true
     * 2.右移s1一个字符，判断s1和s2是否一致，如果一致则返回true
     * 3.如果s1全部右移后也没有一致，则返回false
     *
     * 居然超时了
     */
    public boolean isFlipedString(String s1, String s2) {
        if (s1.equals(s2)){
            return true;
        }
        for(int i=0;i<s1.length();++i){
            if (s1.equals(s2)){
                return true;
            }
            s1 = s1.charAt(s1.length()-1)+s1.substring(0,s1.length()-1);
        }
        return false;
    }

    /**
     * 自己+自己就能包含所有轮转的情况了。所以题目中才有是否只用一次子串判断方法的问题。
     */
    public boolean isFlipedStringFastest(String s1, String s2) {
        return s1.length()==s2.length()&& (s1 + s1).contains(s2);
    }
}
