package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 小孩能不能拥有最大的糖果数目
 * 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
 *
 * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目
 */
public class KidsWithCandies {
    /**
     * 解题思路 找出在给糖果之前拥有最多通过的孩子，然后循环判断每个孩子在拥有了额外糖果后能不能赶上最多的孩子，如果不能，则返回false
     * 时间复杂度为O(n)
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxNum = 0;
        for(int i=0;i<candies.length;++i){
            if(candies[i]>maxNum){
                maxNum = candies[i];
            }
        }
        List<Boolean> resultList = new ArrayList<>();
        for(int i=0;i<candies.length;++i){
            resultList.add(candies[i]+extraCandies>=maxNum);
        }
        return resultList;
    }
}
