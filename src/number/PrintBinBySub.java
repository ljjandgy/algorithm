package number;

/**
 * @author ljj
 * @version sprint 39
 * @className PrintBinBySub
 * @description 通过折半查找法实现十进制小数转二进制小数
 * @date 2021-03-26 15:40:08
 */
public class PrintBinBySub {
    /**
     * 因为该数num在0-1.0之间，因此可以采用折半比较法，与s（初始值0.5（二进制是0.1））进行比较:
     * 1.如果num比较小，则直接在小数点后面添加0,然后再让它与0.25（s/2,二进制是0.01）进行比较;
     * 2.如果num比较大，则小数点后的第一位则是1，更新num为num-s,此时num必定介于0-0.5之间，然后更新s为0.25。
     * 重复以上操作。
     * 2进制的小数相当于是0.5的n次方，n>=1;
     */
    public String printBin(double num) {
        if(num>1||num<0) return "ERROR";
        StringBuffer sb=new StringBuffer();
        double s=0.50;
        //该数是0-1之间的小数，因此先添加0.
        sb.append("0.");
        while(num>0){
            //超出32位的计算精度
            if(sb.length()>32) return "ERROR";
            if(num<s) sb.append("0");
            else{
                num=num-s;
                sb.append("1");
            }
            s/=2;
        }
        return sb.toString();
    }
}
