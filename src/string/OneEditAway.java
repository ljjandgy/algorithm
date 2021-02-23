package string;

/**
 * @author ljj
 * @version sprint 38
 * @className OneEditAway
 * @description
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * 示例 1:
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *  
 *
 * 示例 2:
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 * @date 2021-02-22 17:29:11
 */
public class OneEditAway {
    /**
     * 自己写的版本
     * 思路分析：
     * 由于题目要求的是一次操作就能让两个字符串相同，所以可以理解为两个字符串只能有一个字符是不一样的，并且顺序是一样的。
     * 所以采用了循环比较的思路进行处理。如果比较过程中有出现了两个不一样的字符，则肯定不能通过一次操作让它们一致。
     * 我选择采用了双指针来实现上述思路，如果出现不同，就会把更长的字符串的指针先+1再比较、
     */
    public static boolean oneEditAway(String first, String second) {
        int sunLength = first.length()-second.length();
        if ((sunLength<0?-sunLength:sunLength)>1){
            return false;
        }
        int defNum = 0,index1=0,index2=0;
        while (index1<first.length()&&index2<second.length()){
            if(first.charAt(index1)-second.charAt(index2)!=0){
                ++defNum;
                if (sunLength<0){
                    ++index2;
                }else if (sunLength>0){
                    ++index1;
                }
                if (index1<first.length()&&index2<second.length()&&first.charAt(index1)-second.charAt(index2)!=0&&sunLength!=0){
                    ++defNum;
                }
            }
            if (defNum>1){
                return false;
            }
            ++index1;
            ++index2;
        }
        return true;
    }

    /**
     * 用时最短的例子
     * 思路分析：
     * 具体思路和我差不多，也是变量字符串，然后进行比较。判断不同的字符是否大于1（考虑顺序）
     * 只不过下面的代码提前对情况进行了区分，我是把所有情况都糅合在了一起
     * 有个值得学习的地方是通过截取来让两个字符串长度一致
     */
    public static boolean oneEditAwayEfficient(String first, String second) {
        int i = 0;
        if(first.length()==second.length()-1){
            if(first.length()==0){
                return true;
            }
            for (int j = 0; j < first.length(); j++) {
                if(first.charAt(j)!=second.charAt(j)){
                    ++i;
                    if(i!=1){
                        return false;
                    }
                    --j;
                    second = second.substring(1);
                }
            }
        }else if(first.length()==second.length()){
            if(first.equals(second)){
                return true;
            }
            for (int j = 0; j < first.length(); j++) {
                if(first.charAt(j)!=second.charAt(j)){
                    ++i;
                    if(i!=1){
                        return false;
                    }
                }
            }
        }else if(first.length()-1==second.length()){
            if(second.length()==0){
                return true;
            }
            for (int j = 0; j < second.length(); j++) {
                if(first.charAt(j)!=second.charAt(j)){
                    ++i;
                    if(i!=1){
                        return false;
                    }
                    --j;
                    first = first.substring(1);
                }
            }
        }else {
            return false;
        }
        return true;
    }

    /**
     * 使用空间最少的例子
     * 思路分析:
     * 这里面有两个值得学习的操作，第一个是通过反转入参，把长度判断简化了。通过递归控制分支
     * 第二个是通过截取操作来代替指针移动操作，阅读起来更加直观
     */
    public static boolean oneEditAwayLeastMemory(String first, String second) {
        if(Math.abs(first.length() - second.length()) > 1){
            return false;
        }
        if(first.length() < second.length()){
            return oneEditAwayLeastMemory(second, first);
        }
        for(int i = 0; i < first.length(); i++){
            if(i == first.length() - 1){
                return true;
            }
            if(first.charAt(i) != second.charAt(i)){
                return first.length() == second.length() ? first.substring(i + 1).equals(second.substring(i + 1)) :
                        first.substring(i + 1).equals(second.substring(i));
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(oneEditAway("islander", "slander"));
        System.out.println(oneEditAway("bcdxabcde", "abcdeabcdx"));
        System.out.println(oneEditAway("a", "b"));
        System.out.println(oneEditAway("intention", "execution"));
        System.out.println(oneEditAway("park","spake"));
        System.out.println(oneEditAway("teacher", "taches"));
    }
}
