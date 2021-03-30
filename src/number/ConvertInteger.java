package number;

/**
 * @author ljj
 * @version sprint 39
 * @className ConvertInteger
 * @description 求汉明距离
 * 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
 *
 * 示例1:
 *
 *  输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
 *  输出：2
 * 示例2:
 *
 *  输入：A = 1，B = 2
 *  输出：2
 * 提示:
 *
 * A，B范围在[-2147483648, 2147483647]之间
 * @date 2021-03-30 16:18:49
 */
public class ConvertInteger {
    public int convertInteger(int A, int B) {
        /**
         * 题目分析：
         * 说是判断需要改变几位才能变的一样。逆向一波就是判断二进制有几位不一样。
         * 解题步骤：
         * 一位一位的比较，判断有多少不同的位即可
         **/
        int count = 0;
        for(int i=0;i<32;++i){
            int tmp = 1<<i;
            if((A&tmp)!=(B&tmp)){
                ++count;
            }
        }
        return count;
    }
}
