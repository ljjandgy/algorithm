package number;

/**
 * @author ljj
 * @version sprint 39
 * @className InsertBits
 * @description
 * 给定两个整型数字 N 与 M，以及表示比特位置的 i 与 j（i <= j，且从 0 位开始计算）。
 *
 * 编写一种方法，使 M 对应的二进制数字插入 N 对应的二进制数字的第 i ~ j 位区域，不足之处用 0 补齐。具体插入过程如图所示。
 *
 * 题目保证从 i 位到 j 位足以容纳 M， 例如： M = 10011，则 i～j 区域至少可容纳 5 位。
 *
 * 示例1:
 *
 *  输入：N = 1024(10000000000), M = 19(10011), i = 2, j = 6
 *  输出：N = 1100(10001001100)
 *
 * @date 2021-03-25 18:17:32
 */
public class InsertBits {
    /**
     * 题目分析：
     * 题目核心就在于让m的二进制信息去替换n的特定位置的二进制信息，并且需要高位补0
     * 解题步骤：
     * 1.定义一个数组，记录N的二进制信息
     * 2.求M的二进制信息，然后按着替换i-j，如果最后指针没有到j，则全部补0
     */
    public int insertBits(int N, int M, int i, int j) {
        StringBuilder sb = new StringBuilder();
        int tmp = N/2;
        while(tmp>0){
            if (tmp==1){
                sb.append("0");
            }else{
                sb.append("1");
            }
            tmp = tmp/2;
        }
        char[] c = sb.toString().toCharArray();
        tmp = M/2;
        int index = i;
        while (index!=j){
            if (tmp<2){
                c[index++] = '0';
            }else{
                c[index++] = '1';
            }
            tmp = tmp/2;
        }

    }

}
