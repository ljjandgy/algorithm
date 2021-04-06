package math;

/**
 * 使用位运算，加法，减法等实现乘法
 */
public class Multiply {
    /**
     * 题目分析：
     * 就是利用递归然后在不使用乘法符号的情况下实现乘法。其实乘法就是多个数相加
     * 解题步骤：
     * 找到两数中的小数，用小的数不断-1然后累加即可。需要注意不能大于整型的最大值
     * 其实递归都可以想象成树，这次相当于是后序遍历操作
     **/
    public int multiply(int A, int B) {
        return add(Math.min(A,B),Math.max(A,B));
    }

    private int add(int a,int b){
        if(a<=0){
            return 0;
        }
        int sum = add(a-1,b);
        if(sum+b<Integer.MAX_VALUE){
            return sum+b;
        }else{
            return Integer.MAX_VALUE;
        }
    }
}
