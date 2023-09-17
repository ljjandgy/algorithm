package string;

/**
 * 找出字符串中第一个匹配项的下标
 */
public class StrStr {
    /**
     * 循环查找第一个匹配项的下标
     */
    public int strStr(String haystack, String needle) {
        for(int i=0;i<haystack.length();++i){
            int count = 0;
            for(int j=0;j<needle.length()&&i+j<haystack.length();++j){
                char a = haystack.charAt(i+j);
                char b = needle.charAt(j);
                if(a==b){
                    count++;
                }else{
                    break;
                }
            }
            if(count==needle.length()){
                return i;
            }
        }
        return -1;
    }

    /**
     * KMP获取前缀第一个下标
     */
    public int strStrKMP(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }
}
