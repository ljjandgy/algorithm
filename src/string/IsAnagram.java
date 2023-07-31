package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 */
public class IsAnagram {
    /**
     * 我的解法，利用映射来记录数字，然后进行比较
     */
    public boolean isAnagramMy(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer> sMap = new HashMap<>();
        Map<Character,Integer> tMap = new HashMap<>();
        for(int i=0;i<s.length();++i){
            Character a = s.charAt(i);
            Character b = t.charAt(i);
            if(sMap.get(a)==null){
                sMap.put(a,1);
            }else{
                sMap.put(a,sMap.get(a)+1);
            }
            if(tMap.get(b)==null){
                tMap.put(b,1);
            }else{
                tMap.put(b,tMap.get(b)+1);
            }
        }
        for(Character c : sMap.keySet()){
            if(sMap.get(c).compareTo(tMap.get(c)==null?-1:tMap.get(c))!=0){
                return false;
            }
        }
        return true;
    }

    /**
     * 映射的逆向思维解法，通过做减法来判断是否完全相等。这个解法告诉了我们，需要考虑逆向思维，不能仅仅考虑正向思维
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> table = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) - 1);
            if (table.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }
}
