package string;

public class ReverseString {
    /**
     * 采用双指针法进行遍历，当左指针的下标大于等于右指针的下标时，遍历结束
     */
    public void reverseString(char[] s) {
        int n = s.length;
        for (int left = 0, right = n - 1; left < right; ++left, --right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }
}
