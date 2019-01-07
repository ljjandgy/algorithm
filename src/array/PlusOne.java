package array;

/**
 * 给数组对应的数字+1
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOne {
    /**
     * 我的5ms解答内容
     * @param digits
     * @return
     */
    int[] my(int[] digits){
        if(digits==null){
            return null;
        }
        int length = digits.length;
        for(int i=1;i<=length;i++){
            int a = digits[length-i]+1;
            if(a==10){
                if(i==length){
                    int[] newA = new int[length+1];
                    newA[0] = 1;
                    return newA;
                }
                digits[length-i] = 0;
            }else{
                digits[length-i] = a;
                break;
            }
        }
        return digits;
    }

    /**
     * 大佬0ms解答
     * @param digits
     * @return
     */
    int[] dalao(int[] digits){
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                if (i == 0) {
                    int[] result = new int[digits.length + 1];
                    result[0] = 1;
                    return result;
                }
                digits[i] = 0;
            } else {
                digits[i] += 1;
                break;
            }
        }
        return digits;
    }
}
