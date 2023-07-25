package string;

/**
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
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
 * 'A' = 64
 */
public class TitleToNumber {
    /**
     * 我的解法，用到了库
     */
    public int titleToNumberMy(String columnTitle) {
        int index = 0;
        for(int i=columnTitle.length()-1;i>=0;--i){
            char c = columnTitle.charAt(i);
            index +=(c-64)*Math.pow(26,columnTitle.length()-1-i);
        }
        return index;
    }
    /**
     * 官方解法
     * 由此可以得到如下实现：首先将列序号初始化为
     * 0
     * 0，然后从右往左遍历列名称，对于列名称的从右往左的第
     * �
     * i 位（
     * 0
     * ≤
     * �
     * <
     * �
     * 0≤i<n），如果是第
     * �
     * k 个字母（
     * 1
     * ≤
     * �
     * ≤
     * 26
     * 1≤k≤26），则将列序号的值增加
     * �
     * ×
     * 2
     * 6
     * �
     * k×26
     * i
     *  。遍历结束时即可得到列序号。
     *
     */
    public int titleToNumber(String columnTitle) {
        int number = 0;
        int multiple = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int k = columnTitle.charAt(i) - 'A' + 1;
            number += k * multiple;
            multiple *= 26;
        }
        return number;
    }
}
