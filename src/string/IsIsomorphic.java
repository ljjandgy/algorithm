package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 同构字符串
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 *
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 *  
 *
 */
public class IsIsomorphic {
    /**
     * 我的解法
     * 单个哈希表，同时使用了key和value进行判断，保证映射是唯一的
     * 一提到映射，就应该想到hash
     */
    public boolean isIsomorphicMy(String s, String t) {
        Map<String,String> map = new HashMap<>();
        for(int i=0;i<s.length();++i){
            String a = s.charAt(i)+"";
            String b = t.charAt(i)+"";
            if(map.get(a)==null){
                if(map.values().contains(b)){
                    return false;
                }
                map.put(a,b);
            }else if(!map.get(a).equals(b)){
                return false;
            }
        }
        return true;
    }

    /**
     * 官方的解法
     * 此题是「290. 单词规律」的简化版，需要我们判断
     * �
     * s 和
     * �
     * t 每个位置上的字符是否都一一对应，即
     * �
     * s 的任意一个字符被
     * �
     * t 中唯一的字符对应，同时
     * �
     * t 的任意一个字符被
     * �
     * s 中唯一的字符对应。这也被称为「双射」的关系。
     *
     * 以示例
     * 2
     * 2 为例，
     * �
     * t 中的字符
     * �
     * a 和
     * �
     * r 虽然有唯一的映射
     * �
     * o，但对于
     * �
     * s 中的字符
     * �
     * o 来说其存在两个映射
     * {
     * �
     * ,
     * �
     * }
     * {a,r}，故不满足条件。
     *
     * 因此，我们维护两张哈希表，第一张哈希表
     * s2t
     * s2t 以
     * �
     * s 中字符为键，映射至
     * �
     * t 的字符为值，第二张哈希表
     * t2s
     * t2s 以
     * �
     * t 中字符为键，映射至
     * �
     * s 的字符为值。从左至右遍历两个字符串的字符，不断更新两张哈希表，如果出现冲突（即当前下标
     * index
     * index 对应的字符
     * �
     * [
     * index
     * ]
     * s[index] 已经存在映射且不为
     * �
     * [
     * index
     * ]
     * t[index] 或当前下标
     * index
     * index 对应的字符
     * �
     * [
     * index
     * ]
     * t[index] 已经存在映射且不为
     * �
     * [
     * index
     * ]
     * s[index]）时说明两个字符串无法构成同构，返回
     * f
     * a
     * l
     * s
     * e
     * false。
     *
     * 如果遍历结束没有出现冲突，则表明两个字符串是同构的，返回true 即可。

     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<Character, Character>();
        Map<Character, Character> t2s = new HashMap<Character, Character>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }
}
