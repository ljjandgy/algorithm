package test.string;

import org.junit.Test;

public class StrStrTest {
    @Test
    public void test(){
        System.out.println(kmpStr("hello","ll"));
        System.out.println(kmpStr("mississippi","mississippi"));
        System.out.println(kmpStr("mississippi","issip"));
    }
    private int strStr(String haystack, String needle) {
        if(needle==null||"".equals(needle)){
            return 0;
        }
        if(haystack==null||"".equals(haystack)){
            return -1;
        }
        if(haystack.length()<needle.length()){
            return -1;
        }
        boolean flag = true;
        while (flag){

        }
        return 0;
    }
    private int kmpStr(String haystack, String needle){
        int strLen = haystack.length(), subLen = needle.length();
        if (subLen == 0) return 0;
        if (strLen == 0) return -1;
        // 构建状态机
        int[][] FSM = new int[subLen][256];
        int X = 0, match = 0;
        for (int i = 0; i < subLen; i++) {
            match = (int) needle.charAt(i);
            for (int j = 0; j < 256; j++) {
                // 当前状态 + 匹配失败字符 = 孪生词缀状态 + 匹配字符
                FSM[i][j] = FSM[X][j];
            }
            FSM[i][match] = i + 1;
            if (i > 1) {
                // 下一孪生前缀状态 = X + match
                X = FSM[X][match];
            }
        }
        // 匹配子串
        int state = 0;
        for (int i = 0; i < strLen; i++) {
            state = FSM[state][haystack.charAt(i)];
            if (state == subLen) {
                return i - subLen + 1;
            }
        }
        return -1;
    }
}