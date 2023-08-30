package string;

/**
 * 合并字符串
 */
public class MergeAlternately {
    /**
     * 遍历法合并字符串：
     * 思路：
     * 1.首选取最大的长度，用于循环
     * 2.取值前先判断有没有超长，没超长就进行合并，超长就不合并了
     * 3.返回合并的值
     */
    public String mergeAlternately(String word1, String word2) {
        int length = word1.length()>word2.length()?word1.length():word2.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<length;++i){
            if(i<word1.length()){
                sb.append(word1.charAt(i));
            }
            if(i<word2.length()){
                sb.append(word2.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * 双指针法
     * 定义两个指针，分别去遍历两个字符串
     * 指针不断后移，直到分别达到字符串尾部，和遍历其实逻辑差不多，只不过指针分开了
     */
    public String mergeAlternatelyPointer(String word1, String word2) {

        int m = word1.length(), n = word2.length();
        int i = 0, j = 0;

        StringBuilder ans = new StringBuilder();
        while (i < m || j < n) {
            if (i < m) {
                ans.append(word1.charAt(i));
                ++i;
            }
            if (j < n) {
                ans.append(word2.charAt(j));
                ++j;
            }
        }
        return ans.toString();
    }
}
