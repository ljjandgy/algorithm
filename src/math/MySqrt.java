package math;

/**
 *  给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 */
public class MySqrt {
    /**
     * 二分查找实现平方根运算
     * 由于 xxx 平方根的整数部分 ans\textit{ans}ans 是满足 k2≤xk^2 \leq xk
     * 2
     *  ≤x 的最大 kkk 值，因此我们可以对 kkk 进行二分查找，从而得到答案。
     *
     * 二分查找的下界为 000，上界可以粗略地设定为 xxx。在二分查找的每一步中，我们只需要比较中间元素 mid\textit{mid}mid 的平方与 xxx 的大小关系，并通过比较的结果调整上下界的范围。由于我们所有的运算都是整数运算，不会存在误差，因此在得到最终的答案 ans\textit{ans}ans 后，也就不需要再去尝试 ans+1\textit{ans} + 1ans+1 了。
     *
     */
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
