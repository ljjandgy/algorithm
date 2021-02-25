package array;

/**
 * @author ljj
 * @version sprint 38
 * @className MatrixRotate
 * @description 旋转矩阵数组（行转列，列转行）
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 *
 * 不占用额外内存空间能否做到？
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,0, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 * @date 2021-02-25 11:37:37
 */
public class MatrixRotate {
    /**
     * 思路分析：
     * 既然是矩阵数组操作，肯定就设计到数组角标的改变。所以应该寻找旋转时角标变化的规律，这样就能直接把遍历到的当前节点直接放到相应节点，然后把占用的位置的节点再放到合适的位置上去。
     *  操作步骤：
     *  1.取出第一行，第一列节点，根据角标计算公式计算出新的位置（y,n-1-x）,其中，在一开始x=i，y=j
     *  2.取出位置上原来的元素并替换
     *  3.未被替换的元素找到正确的位置并重复第二步，直到第一行数据{0,n-1}替换完成
     *  4.去第二行中{1,n-2}重复上述替换操作
     *  5.需要操作的行数为n/2即可
     *  这个方式是需要逐点旋转
     */
    public static void rotate(int[][] matrix) {
        if (matrix==null){
            return;
        }
        for(int i=0;i<matrix.length/2;++i){
            for (int j=i;j<matrix[i].length-i-1;++j){
                int x = j;
                int y = matrix.length-1-i;
                while (x!=i||y!=j){
                    //值交互
                    int tmp = matrix[x][y];
                    matrix[x][y] = matrix[i][j];
                    matrix[i][j] = tmp;
                    //计算新的坐标
                    int tempx = x;
                    x = y;
                    y = matrix.length-1-tempx;
                }
            }
        }
    }

    /**
     * 内存使用最少的案例，其效率也是O(n^2)
     * 解题思路：
     * 采用两次旋转完成整个矩阵旋转。我是一个点，一个点进行的四个方向的旋转。
     * 这个方法可以看成是正方形矩阵旋转的通用方法，先沿对角线（左右对角线）旋转，然后左右旋转（90度）。先上下旋转，再左右旋转（180度）,对角线（右左对角线）+左右旋转（270度）
     * @param matrix
     */
    public static void rotateSmallest(int[][] matrix) {
        int n = matrix.length;
        // 先以对角线（左上-右下）为轴进行翻转
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 再对每一行以中点进行翻转
        //右移一位等同于对2进行整除，不过位移运算效率更高
        int mid = n >> 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mid; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;
        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;
        rotate(matrix);
        foreachArray(matrix);
    }

    private static void foreachArray(int[][] matrix){
        for (int i=0;i<matrix.length;++i){
            System.out.println();
            for (int j=0;j<matrix.length;++j){
                System.out.print(matrix[i][j]+" ");
            }
        }
        System.out.println();
        System.out.println("-----------------------------");
    }
}
