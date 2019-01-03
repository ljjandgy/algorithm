package array;

/**
 * 移出数组中的特定元素
 */
public class RemoveElement {
    int my(int[] nums, int val){
        if(nums==null){
            return 0;
        }
        int newIndex = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[newIndex] = nums[i];
                newIndex++;
            }
        }
        return newIndex;
    }

    /**
     * 当要删除的元素很少时可以用--双指针
     * 思路
     *
     * 现在考虑数组包含很少的要删除的元素的情况。例如，num=[1，2，3，5，4]，Val=4num=[1，2，3，5，4]，Val=4。之前的算法会对前四个元素做不必要的复制操作。另一个例子是 num=[4，1，2，3，5]，Val=4num=[4，1，2，3，5]，Val=4。似乎没有必要将 [1，2，3，5][1，2，3，5] 这几个元素左移一步，因为问题描述中提到元素的顺序可以更改。
     *
     * 算法
     *
     * 当我们遇到 nums[i] = valnums[i]=val 时，我们可以将当前元素与最后一个元素进行交换，并释放最后一个元素。这实际上使数组的大小减少了 1。
     * @return
     */
    int professional(int[] nums, int val){
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}
