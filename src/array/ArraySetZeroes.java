package array;

import java.util.HashSet;
import java.util.Set;

/**
 * 更新二维数组值为0
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2：
 *
 * 输入：
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出：
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 */
public class ArraySetZeroes {
    /**
     * 自己的版本
     * 解题思路：创建两个个一维数组，分别存需要清0的行和列，然后遍历原数组，把需要清0的行列记录下来，等遍历完后在统一请0.
     * 1.创建一个数组，记录需要清0的行，再创建一个数组，记录需要清0的列
     * 2.变量数组元素，判断是否为0，如果为0，则把行放入行数组，列放入列数组
     * 3.遍历完成后，再遍历原数组，清零相应行列即可
     * 时间复杂度：O(MN)
     * 空间复杂度：O(M+N)
     */
    public static void setZeroes(int[][] matrix) {
        int[] lineArray = new int[matrix.length];
        int[] colArray = new int[matrix[0].length];
        for (int i=0;i<matrix.length;++i){
            for (int j=0;j<matrix[i].length;++j){
                if (matrix[i][j]==0){
                    lineArray[i] = 1;
                    colArray[j] = 1;
                }
            }
        }
        for (int i=0;i<lineArray.length;++i){
            for (int j=0;j<colArray.length;++j){
                //如果这个元素在需要被清零的行或者是列，则元素置为0
                if (lineArray[i]==1||colArray[j]==1){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][4];
        matrix[0][0] = 1;
        matrix[0][1] = 0;
        matrix[0][2] = 3;
        matrix[0][3] = 3;
        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;
        matrix[1][3] = 6;
        matrix[2][0] = 0;
        matrix[2][1] = 8;
        matrix[2][2] = 9;
        matrix[2][3] = 9;
        setZeroes(matrix);
        foreachArray(matrix);
    }

    private static void foreachArray(int[][] matrix){
        for (int i=0;i<matrix.length;++i){
            System.out.println();
            for (int j=0;j<matrix[i].length;++j){
                System.out.print(matrix[i][j]+" ");
            }
        }
        System.out.println();
        System.out.println("-----------------------------");
    }
}
