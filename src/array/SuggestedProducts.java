package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个产品数组 products 和一个字符串 searchWord ，products  数组中每个产品都是一个字符串。
 *
 * 请你设计一个推荐系统，在依次输入单词 searchWord 的每一个字母后，推荐 products 数组中前缀与 searchWord 相同的最多三个产品。如果前缀相同的可推荐产品超过三个，请按字典序返回最小的三个。
 *
 * 请你以二维列表的形式，返回在输入 searchWord 每个字母后相应的推荐产品的列表。
 */
public class SuggestedProducts {
    /**
     * 解题方法：暴力法
     * 解题思路：依次循环searchWord的各个字符，判断没输入一个字符时，哪些产品会被匹配出来
     */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products); // 先按字典序排序
        List<List<String>> ls = new ArrayList<>();
        for (int i = 1; i <= searchWord.length(); ++i) {
            String s = searchWord.substring(0, i); // 找出每个前缀
            List<String> l1 = new ArrayList<>();
            for (String str : products) {
                if (str.startsWith(s)) { // 将符合的前缀加到集合中
                    l1.add(str);
                }
                if (l1.size() == 3) { // 如果集合长度为3，就结束循环，不在继续寻找
                    break;
                }
            }
            ls.add(l1);
        }
        return ls;
    }
}
