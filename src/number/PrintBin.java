package number;

/**
 * @author ljj
 * @version sprint 39
 * @className PrintBin
 * @description 二进制数转字符串
 * 二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字无法精确地用32位以内的二进制表示，则打印“ERROR”。
 *
 * 示例1:
 *
 *  输入：0.625
 *  输出："0.101"
 * 示例2:
 *
 *  输入：0.1
 *  输出："ERROR"
 *  提示：0.1无法被二进制准确表示
 * 提示：
 *
 * 32位包括输出中的"0."这两位。
 *
 * @date 2021-03-26 14:54:56
 */
public class PrintBin {
    /**
     * 题目分析：
     * 题目要求我们打印小数的二进制信息。如果长度大于32就输出error。所以核心在于十进制小数转二进制小数。
     * 具体过程为把十进制小数不断乘以2，每次都取积的整数部分作为二进制的小数位（从左向右，顺序排列），直到积不包含小数为止
     * 解题步骤：
     * 1.定义字符串拼接类，先拼接上"0."
     * 2.开始十进制到二进制的转换，然后记录每一次转换结果
     */
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder("0.");
        while (num!=0&&num!=1){
            if (sb.length()>=32){
                return "ERROR";
            }
            if ((num*2-1)>=0){
                num = num*2-1;
                sb.append("1");
            }else{
                num = num*2;
                sb.append("0");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        PrintBin printBin = new PrintBin();
        System.out.println(printBin.printBin(0.625));
    }
}
