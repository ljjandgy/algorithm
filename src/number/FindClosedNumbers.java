package number;

/**
 * 下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。
 *
 * 示例1:
 *
 *  输入：num = 2（或者0b10）
 *  输出：[4, 1] 或者（[0b100, 0b1]）
 * 示例2:
 *
 *  输入：num = 1
 *  输出：[2, -1]
 * 提示:
 *
 * num的范围在[1, 2147483647]之间；
 * 如果找不到前一个或者后一个满足条件的正数，那么输出 -1。
 */
public class FindClosedNumbers {
    public int[] findClosedNumbers(int num) {
        /**
         * 题目解析：
         * 需要注意两个点：1.所有数1的个数必须相同。2.没有找到合适的值，返回-1。每个数都有32位
         * 稍小数：最后一个1置为0，最后个1的后一位0置为1。
         * 稍大数：最后一个1置0，然后前一个0置为1。
         * 解题步骤：
         * 1.先找最小数，通过位运算找到最后个1，置为0后，再把后一位置为1
         * 2.找最大树，和最小数操作相反
         * 最终采用的是穷举比较法，也就是穷举大数和小数，然后找最先出现的1个数相同的
         **/
        if(num == 2147483647) return new int[]{-1,-1};
        int i = num + 1;
        int j = num - 1;
        int count = numOfBitOne(num);

        while(numOfBitOne(i) != count){
            i++;
            if(i < 0){
                i = -1;
                break;
            }
        }
        while(numOfBitOne(j) != count){
            j--;
            if(j < 0){
                j = -1;
                break;
            }
        }
        return new int[]{i,j};
    }

    private int numOfBitOne(int num){
        int count = 0;
        while(num != 0){
            num &= (num - 1);
            count++;
        }
        return count;
    }
}
