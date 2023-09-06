package string;

/**
 * 判断s是否为t的子串
 */
public class IsSubsequence {
    /**
     * 我的解法：
     * 1.定义快慢指针，其中一个指向s，一个指向t
     * 2.只有当指向t的指针对应的字符和s相同时，s才往前移动
     * 3.如果s还没移动完，t就移动完了，所以字符无法匹配上，不是子串，反之，t没移动完，s移动完了，说明是子串
     */
    public boolean isSubsequenceMy(String s, String t) {
        if(s.length()>t.length()){
            return false;
        }
        int tp = 0;
        int sp = 0;
        while(tp<t.length()&&sp<s.length()){
            char sc = s.charAt(sp);
            char tc = t.charAt(tp);
            while(sc!=tc){
                if(tp==t.length()-1){
                    return false;
                }
                tp++;
                tc = t.charAt(tp);
            }
            sp++;
            tp++;
        }
        return sp==s.length();
    }

    /**
     * 官方简化版本
     */
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}
