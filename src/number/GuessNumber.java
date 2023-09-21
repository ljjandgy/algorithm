package number;

/**
 * 猜数字大小
 */
public class GuessNumber {
    /**
     * 二分法找数
     * 二分法需要维护两个边缘指针，左指针+左右指针的平均数，就是中点，往左走，右指针指向中点，反之，左指针指向中点
     */
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left < right) { // 循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (guess(mid) <= 0) {
                right = mid; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }

    private int guess(int num){
        return 0;
    }
}
