package string;

import org.junit.Assert;

import java.util.Stack;

/**
 * @author ljj
 * @version sprint 38
 * @className Palindrome
 * @description 回文排列
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 *
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 *
 * 回文串不一定是字典当中的单词。
 *
 * @date 2021-02-22 13:09:41
 */
public class Palindrome {
    /**
     * 自己的版本，所谓回文字符串，就是字符出现次数至多只有一个是奇数次的，也就是中间那个字符。这样我们就可以继续使用char数组来记录字符出现次数然后进行判断。
     * 虽然提交通过了，但是存在一个问题，就是次数判断问题，应该是判断出现次数是否为偶数次，而不应该判断是否是2和0，过于局限
     */
    public static boolean canPermutePalindrome(String s) {
        int[] charArray = new int[128];
        for(char c : s.toCharArray()){
            ++charArray[c];
        }
        int num = 0;
        for(int i : charArray){

            if(i!=0&&i!=2){
                ++num;
            }
        }
        return num<=1;
    }
    /**
     * 正确的版本
     */
    public static boolean canPermutePalindromeCorrect(String s) {
        int[] charArray = new int[128];
        for(char c : s.toCharArray()){
            ++charArray[c];
        }
        int num = 0;
        for(int i : charArray){
            if(i%2!=0){
                ++num;
            }
        }
        return num<=1;
    }

    public static void main(String[] args) {
        String s = "aaaaacaaaaa";
        System.out.println(canPermutePalindrome(s));
        System.out.println(canPermutePalindromeCorrect(s));
    }
}
