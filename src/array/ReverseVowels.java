package array;

/**
 * 原音字母翻转
 */
public class ReverseVowels {
    /**
     * 双指针法翻转原音字母。
     * 定义两个指针i，j 其中i从头到尾遍历，j从尾到头遍历，然后遇到一直到两个都遇到原音字母，就交换，如果两个指针指向同一个位置时就停止遍历
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int i = 0, j = n - 1;
        while (i < j) {
            while (i < n && !isVowel(arr[i])) {
                ++i;
            }
            while (j > 0 && !isVowel(arr[j])) {
                --j;
            }
            if (i < j) {
                swap(arr, i, j);
                ++i;
                --j;
            }
        }
        return new String(arr);
    }

    public boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
