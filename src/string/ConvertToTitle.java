package string;

/**
 * 从1开始的26进制的转换
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 *
 * 例如：
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *
 */
public class ConvertToTitle {
    /**
     * 我的思路，就是利用26进制进行取余逆序排列的算法。需要注意的是从1开始的，所以每次取余前需要-1
     */
    public String convertToTitleMy(int columnNumber) {
        int num = columnNumber;
        String result = "";
        while(num>0){
            --num;
            char a = (char)('A'+(num%26));
            result =a + result;
            num = num/26;
        }

        return result;
    }
    /**
     * 官方的思路
     * 对于整数
     * �
     * n，若
     * �
     * n 能被
     * 26
     * 26 整除，则有：
     *
     * �
     * 26
     * =
     * ⌊
     * �
     * +
     * �
     * 26
     * ⌋
     * 26
     * n
     * ​
     *  =⌊
     * 26
     * n+r
     * ​
     *  ⌋
     *
     * 其中
     * 0
     * ≤
     * �
     * ≤
     * 25
     * 0≤r≤25。
     *
     * 因此有：
     *
     * number
     * ′
     * =
     * number
     * −
     * �
     * 0
     * 26
     * =
     * ⌊
     * (
     * number
     * −
     * �
     * 0
     * )
     * +
     * (
     * �
     * 0
     * −
     * 1
     * )
     * 26
     * ⌋
     * =
     * ⌊
     * number
     * −
     * 1
     * 26
     * ⌋
     * number
     * ′
     *
     * ​
     *
     * =
     * 26
     * number−a
     * 0
     * ​
     *
     * ​
     *
     * =⌊
     * 26
     * (number−a
     * 0
     * ​
     *  )+(a
     * 0
     * ​
     *  −1)
     * ​
     *  ⌋
     * =⌊
     * 26
     * number−1
     * ​
     *  ⌋
     * ​
     *
     *
     * 这里我们用到了
     * 0
     * ≤
     * �
     * 0
     * −
     * 1
     * ≤
     * 25
     * 0≤a
     * 0
     * ​
     *  −1≤25 这一性质。
     *  其实是利用了数学推导
     */
    public String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber != 0) {
            columnNumber--;
            sb.append((char)(columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }

}
