package number;

/**
 * @author ljj
 * @version sprint 39
 * @className ReverseBits
 * @description 翻转数位
 * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
 *
 * 示例 1：
 *
 * 输入: num = 1775(110111011112)
 * 输出: 8
 * 示例 2：
 *
 * 输入: num = 7(01112)
 * 输出: 4
 *
 * @date 2021-03-27 14:03:09
 */
public class ReverseBits {
    /**
     * 题目分析：
     * 题目说可以让一个数位从0变成1，就表示我们或者1的长度时最多能包含一个1.需要注意的是，正数的符号位为0，负数的符号位为1。
     * 我想到的是用双指针法求解。32位的意思是每个数都会用0把32位填满。
     * 学到了一点，位运算一般都不需要把原十进制全部转换为二进制之后再进行操作，通常都是可以根据位运算实现位操作的。
     * 也学到了滑动窗口（双指针的进阶操作，基于双指针实现）
     * 还有10进制负数转二进制过程：
     * 去绝对值后，获取正数的二进制并取反然后再+1就是负数对应的二进制了
     * 解题步骤：
     * 1.定义一个数组，记录二进制信息
     * 2.定义快慢指针，慢指针指向1开始的位置，慢指针指向第二个0前一个1，然后做减法获取包含1的数量。
     * 3.用一个变量记录遍历过程中出现的最大值
     */
    public int reverseBits(int num) {
        int count = 0;
        int pos = -1;
        int res = 0;
        for(int i = 0; i < 33; i++) {
            if((num & 1) == 1) {
                count++;
            }else {
                res = Math.max(count, res);
                count = i - pos;
                pos = i;
            }
            num = num >>> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();
        reverseBits.reverseBits(-1);
    }
}
