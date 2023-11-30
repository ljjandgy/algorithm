package array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给你一个下标从 0 开始的整数数组 costs ，其中 costs[i] 是雇佣第 i 位工人的代价。
 *
 * 同时给你两个整数 k 和 candidates 。我们想根据以下规则恰好雇佣 k 位工人：
 *
 * 总共进行 k 轮雇佣，且每一轮恰好雇佣一位工人。
 * 在每一轮雇佣中，从最前面 candidates 和最后面 candidates 人中选出代价最小的一位工人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
 * 比方说，costs = [3,2,7,7,1,2] 且 candidates = 2 ，第一轮雇佣中，我们选择第 4 位工人，因为他的代价最小 [3,2,7,7,1,2] 。
 * 第二轮雇佣，我们选择第 1 位工人，因为他们的代价与第 4 位工人一样都是最小代价，而且下标更小，[3,2,7,7,2] 。注意每一轮雇佣后，剩余工人的下标可能会发生变化。
 * 如果剩余员工数目不足 candidates 人，那么下一轮雇佣他们中代价最小的一人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
 * 一位工人只能被选择一次。
 * 返回雇佣恰好 k 位工人的总代价。
 */
public class TotalCost {
    /**
     * 解题方法：优先队列
     * 解题思路：待品味
     */
    public long totalCost(int[] costs, int k, int candidates) {
        Queue<Integer> left = new PriorityQueue<>();
        Queue<Integer> right = new PriorityQueue<>();
        int n=costs.length;
        long res=0;
        if(n>candidates*2){

            for(int i=0;i<candidates;i++){
                left.add(costs[i]);
            }
            for(int i=n-1;i>=n-candidates;i--){
                right.add(costs[i]);
            }
            int l=candidates;
            int r=n-candidates-1;
            for(int i=0;i<k;i++){
                int a=999999999;
                int b=999999999;
                if(left.peek()!=null)a=left.peek();
                if(right.peek()!=null)b=right.peek();
                //System.out.println(a+" "+b);
                if(a<=b){
                    res+=a;
                    left.poll();
                    if(l<=r){
                        left.add(costs[l]);
                        l++;
                    }
                }
                else{
                    res+=b;
                    right.poll();
                    if(l<=r){
                        right.add(costs[r]);
                        r--;
                    }
                }

            }
        }
        else{
            Arrays.sort(costs);
            for(int i=0;i<k;i++){
                res+=costs[i];
            }
        }
        return res;
    }
}
