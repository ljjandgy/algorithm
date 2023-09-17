package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 判断数组中每个数字出现次数是否为第一无二的
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 */
public class UniqueOccurrences {
    /**
     * 通过hash表判断数字是否存在重复
     * 本质上是通过两个map进行判断，第一个map为数字和出现次数map，第二个是出现次数和次数出现次数的map
     * 如果第二个map存在重复获取，那么说明就有重复
     */
    public boolean uniqueOccurrencesMy(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(Integer num:arr){
            map.merge(num, 1, (a, b) -> a + b);
        }
        Map<Integer,Integer> map1 = new HashMap<>();
        for(Integer count:map.values()){
            if(map1.get(count)!=null){
                return false;
            }else{
                map1.put(count,1);
            }
        }
        return true;
    }

    /**
     * 官方解法，把map换成了set
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occur = new HashMap<Integer, Integer>();
        for (int x : arr) {
            occur.put(x, occur.getOrDefault(x, 0) + 1);
        }
        Set<Integer> times = new HashSet<Integer>();
        for (Map.Entry<Integer, Integer> x : occur.entrySet()) {
            times.add(x.getValue());
        }
        return times.size() == occur.size();
    }
}
