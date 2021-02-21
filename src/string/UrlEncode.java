package string;

/**
 * 替换url里面的空格为%20，必须用char数组进行操作
 */
public class UrlEncode {
    /**
     * 我的版本
     * 利用字符串S的长度直接创建数组，不过这样会有空值的情况，所以我最后生成字符串的时候去掉了收尾的空格。
     */
    public String replaceSpaces(String S, int length) {
        char[] charArray = new char[S.length()];
        for(int i=0;i<length;++i){
            char c = S.charAt(i);
            if(' ' == c){
                charArray[i]='%';
                charArray[++i]='2';
                charArray[++i]='0';
            }else{
                charArray[i]=c;
            }
        }
        return new String(charArray).trim();
    }
    /**
     * 指针法
     * 就是创建两个指针i和j，分别指向字符串的最后一位(i)和字符串有效位的最后一位(j)，然后再进行遍历
     */
    public String replaceSpacesByPointer(String S, int length) {
        char[] charArray = S.toCharArray();
        int i = S.length()-1,j=length-1;
        while (j>=0){
            //倒过来进行拼接
            if (' '== charArray[j]){
                charArray[i--] = '0';
                charArray[i--] = '2';
                charArray[i--] = '%';
            }else{
                charArray[i--] = charArray[j];
            }
            --j;
        }
        //因为在--时i指针会指到前一位，所以需要+1才能指向实际需要的元素
        //第二个参数为count，也就是需要取值的个数（subArray's length），并且也算标准的截取操作（取首不取尾）
        return new String(charArray,i+1,S.length()-i-1);
    }
}
