package math;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 *
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 */
public class CombinationSum3 {
    /**
     * 解题方法：递归
     * 解题思路：待品味
     */
    public static List<List<Integer>> ls = new ArrayList<>();
    public static LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        list.clear();
        ls.clear();
        back(k,n,1,0);
        return ls;
    }
    public static void back(int k,int n,int start,int sum){
        if(sum == n && list.size() == k){
            ls.add(new ArrayList<>(list));
            return;
        }
        if(sum > n) return;
        for(int i = start;i <= 9; i ++){
            list.add(i);
            sum += i;
            back(k,n,i+1,sum);
            sum -= i;
            list.removeLast();
        }
    }
}
