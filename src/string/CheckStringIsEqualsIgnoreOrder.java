package string;

import sun.security.rsa.RSASignature;

/**
 * 检查字符串在不考虑顺序的情况下是否一样
 */
public class CheckStringIsEqualsIgnoreOrder {
    /**
     * 自己的版本，判断不考虑排序是否一致就是判断字符串的组成是否一样，也就是字符及其出现次数是否一致
     * 创建数组表示26个字母，然后判断数组中字母出现次数是否一样，如果一样，说明两个字符串组成是一样的，如果不一样，则说明两个字符串是不一样的
     * 我这个只在单
     */
    public boolean CheckPermutation(String s1, String s2) {
        //还需要考虑长度不一样的情况，这个情况也应该直接返回false
        if(s1.length()==0||s2.length()==0){
            return false;
        }
        int[] charArray1 = new int[26];
        for(char c1 :s1.toCharArray()){
            int index = c1 - 'a';
            ++charArray1[index];
        }
        int[] charArray2 = new int[26];
        for(char c2:s2.toCharArray()){
            int index = c2 - 'a';
            ++charArray2[index];
        }
        for(int i=0;i<26;i++){
            if(charArray1[i]!=charArray2[i]){
                return false;
            }
        }
        return true;
    }
    /**
     * 单个数组的情况，只在长度一致时生效，但是长度不一样肯定就是不一样的字符串，所以该方法可行
     */
    public boolean CheckPermutationByOneArray(String s1, String s2) {
        if (s1.length()!=s2.length()){
            return false;
        }
        //不考虑汉字，在计算机中有128个字符
        int[] charArray = new int[128];
        for(int i=0;i< s1.length();++i){
            charArray[s1.charAt(i)]++;
            charArray[s2.charAt(i)]--;
        }
        for (int i:charArray){
            if (i!=0){
                return false;
            }
        }
        return true;
    }
}
