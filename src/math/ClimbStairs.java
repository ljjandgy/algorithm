package math;

/**
 * 爬楼梯
 */
public class ClimbStairs {
    //我没能解出来
    int my(){
        return 0;
    }

    /**
     * 大佬的解法 2ms
     * 动态规划--看不懂
     * @return
     */
    int dalao(int n){
        if (n < 1) {
            return 0;
        }

        int steps1 = 1;
        int steps2 = 1;
        for (int i = 2; i <= n; ++i) {
            int steps = steps1 + steps2;
            steps1 = steps2;
            steps2 = steps;
        }
        return steps2;
    }
}
