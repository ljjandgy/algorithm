package array;

/**
 * 只出现一次的数字
 *
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 *
 *
 */
public class SingleNumber {
    /**
     * 通过异或运算来获得数组中只有一个的数字。利用了两个相同的数异或等于0及任何数和0异或都等于本身的特性来进行运算的
     */
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
