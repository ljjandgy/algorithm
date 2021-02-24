package string;

/**
 * @author ljj
 * @version sprint 38
 * @className CompressString
 * @description 压缩字符串
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 *  示例1:
 *
 *  输入："aabcccccaaa"
 *  输出："a2b1c5a3"
 * @date 2021-02-23 19:20:17
 */
public class CompressString {
    /**
     * 自己的版本一开始想到的版本
     * 思路分析：
     * 压缩字符串，其实就是对字符串中相邻有重复的字符串进行压缩，所以我们需要遍历整个字符串，计算字符重现次数，如果字符发生改变，计数就重置，重置为1。
     * 有个需要注意的是当压缩后字符串比原来的长时需要返回原来的字符串
     * 为单指针+计数器版本
     */
    public static String compressStringByIncrease(String S) {
        if("".equals(S)||S==null){
            return S;
        }
        char[] charArray = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        int index = 1;
        while(index<=charArray.length){
            int num = 0;
            char cbase = charArray[index-1];
            char cnew = cbase;

            while (cbase==cnew){
                ++num;
                if (index==charArray.length){
                    ++index;
                    break;
                }
                cnew = charArray[index];
                ++index;
            }
            sb.append(cbase).append(num);
            if (sb.length()>=charArray.length){
                return S;
            }
        }
        return sb.toString();
    }

    /**
     * 双指针版本（慢指针和快指针）
     * 解题思路：用一个指针指向判断重复前的位置，用一个指针在判断重复时移动，直到出现不重复为止，然后计算指针角标差值就是当前字符连续出现次数
     */
   public static String compressStringByDoublePointer(String S) {
       if("".equals(S)||S==null){
           return S;
       }
       StringBuilder sb = new StringBuilder();
       char[] charArray = S.toCharArray();
       int i = 0,j = 0;
       while (j<charArray.length){
           while (j<charArray.length&&charArray[i]==charArray[j]){
               j++;
           }
           sb.append(charArray[i]).append(j-i);
           if (sb.length()>=charArray.length){
               return S;
           }
           //指针同步
           i=j;
       }
       return sb.toString();
   }

    /**
     * 最快的版本，比我的版本快了1ms。
     * 具体思路和双指针版本基本一致，但是有两个个值得学习的地方，技术把长度判断放到了最后，就不用每次遍历都判断一次
     * 第二个就是把很多代码都合并在一起了，就是在非必要时候，没必要定义额外变量。这样阅读起来会更方便
     */
   public String compressStringFastest(String S){
       StringBuilder sb = new StringBuilder();
       char[] chs = S.toCharArray();
       int len = chs.length;
       // 定义慢指针slow，指向每个重复连续字符串的第一个
       // 定义快指针fast，向右遍历直到字符不再连续重复
       int slow = 0, fast = 0;
       while(fast < len) {
           while(fast < len && chs[fast] == chs[slow]) {
               fast++;
           }
           sb.append(chs[slow]);
           sb.append(fast - slow);
           slow = fast;
       }
       return sb.length() >= len ? S : sb.toString();
   }

    /**
     * 内存使用最小的例子
     * 使用的是计数器的方法，内存使用小是因为没有使用额外的char数组，所以内存小
     */
   public String compressStringSmallest(String S){
       if(S == null || S.length() == 0) return "";
       StringBuffer sb = new StringBuffer();
       int idx = 0;
       char curChar = S.charAt(0);
       int len = S.length();
       int count;

       while(idx < len){
           count = 0;
           while(idx < len && curChar == S.charAt(idx)){
               idx++;
               count++;
           }

           sb.append(curChar).append(count);

           if(idx == len) break;

           curChar = S.charAt(idx);
       }
       return sb.length() < S.length()? sb.toString():S;
   }


   public static void main(String[] args) {
        System.out.println(compressStringByDoublePointer("aabcccccaa"));
        System.out.println(compressStringByDoublePointer("abbccd"));
        System.out.println(compressStringByDoublePointer("ccc"));
        System.out.println(compressStringByDoublePointer("rrrrrLLLLLPPPPPPRRRRRgggNNNNNVVVVVVVVVVDDDDDDDDDDIIIIIIIIIIlllllllAAAAqqqqqqqbbbNNNNffffff"));
    }
}
