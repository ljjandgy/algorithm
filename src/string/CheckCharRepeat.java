package string;

/**
 * @author ljj
 * @version sprint 37
 * @className CheckCharRepeat
 * @description 检查字符串是否存在重复
 * @date 2021-02-19 19:42:54
 */
public class CheckCharRepeat {
    /**
     * 自己写的,利用String的indexOf方法实现，其实不能算是算法
     */
    public boolean isUnique(String astr) {
        if(astr==null||astr.length()==0){
            return true;
        }
        for(int i=0;i<astr.length();i++){
            if(astr.indexOf(astr.charAt(i))!=astr.lastIndexOf(astr.charAt(i))){
                return false;
            }
        }
        return true;
    }
    /**
     * 基于数组，我们可以用一个长度为26的数组表示26个字母a->0,z->25,这样对每个字母出现的次数进行计数
     */
    public boolean isUniqueByArray(String astr) {
        if(astr==null||astr.length()==0){
            return true;
        }
        int[] charArray = new int[26];
        for (char c : astr.toCharArray()){
            int index = c - 'a';
            if (charArray[index]==0){
                charArray[index]++;
            }else {
                return false;
            }
        }
        return true;
    }
    /**
     * 位运算
     * 利用一个int型数据的32位中的26位去对应26的字母，一旦某个字母之前出现过，则int类型数据的值在该位就是1，然后和一个与字母对应的位数的整型值做与，如果得到的值不为0，就说明这个字母之前出现过
     */
    public static boolean isUniqueByBit(String astr) {
        if(astr==null||astr.length()==0){
            return true;
        }
        //代表字母的整型数字初始值为0
        int charBit = 0;
        for (char c : astr.toCharArray()){
            //计算当前字母对应的整型值（2进制的方式对应）
            int charInt = 1 << c -'a';
            //获取当前字符值和代表所有字母值的与值，如果不为0，所有这个值之前出现过了
            int value = charBit & charInt;
            if (value != 0){
                return false;
            }else{
                /** 通过或操作保存当前字母位信息
                 *  00000000000010000
                 *  00000000000100000
                 *= 00000000000110000
                 */
                charBit = charBit | charInt;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.print(isUniqueByBit("abyeiwlsa"));
    }
}
