package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 生成特定层数的杨辉三角
 *
 */
public class GenerateYanghuiTriangle {
    /**
     * 我的解答，1ms
     * 需要注意的内容：
     * 针对ArrayList
     * 1.add方法当index一致时，和不带索引的add方法结果一致
     * 2.add方法不能跳过索引，否则会报错，如：不能直接add最后一位
     */
    List<List<Integer>> my(int numRows){
        List<List<Integer>> list = new ArrayList<>();
        if(numRows==0){
            return list;
        }
        for(int i=0;i<numRows;i++){
            List<Integer> listOne = new ArrayList<>();
            listOne.add(0,1);
            List<Integer> listbef = null;
            //需要利用上一层的值进行求和时
            if(list.size()>=2){
                listbef = list.get(i-1);//上一层
                for(int j=1;j<i;j++){
                    listOne.add(listbef.get(j)+listbef.get(j-1));
                }
            }
            if(i>0){
                listOne.add(i,1);
            }
            list.add(listOne);
        }
        return list;
    }

    /**
     * 大佬的解法 0ms
     * @param numRows
     * @return
     */
    List<List<Integer>> dalao(int numRows){
        List<List<Integer>> retList = new ArrayList<>(numRows);
        Integer[] pre = null;
        for (int i = 0; i < numRows; i++) {
            Integer[] rowItems = new Integer[i + 1];
            rowItems[0] = 1;
            rowItems[rowItems.length - 1] = 1;
            if (pre == null) {
                pre = rowItems;
                retList.add(Arrays.asList(rowItems));
                continue;
            }
            for (int j = 1; j < rowItems.length - 1; j++) {
                int val = pre[j - 1] + (j < pre.length ? pre[j] : 0);
                rowItems[j] = val;
            }
            retList.add(Arrays.asList(rowItems));
            pre = rowItems;
        }
        return retList;
    }

    /**
     * 官方解答----动态规划
     * 如果能够知道一行杨辉三角，我们就可以根据每对相邻的值轻松地计算出它的下一行。
     *
     * 算法
     * 虽然这一算法非常简单，但用于构造杨辉三角的迭代方法可以归类为动态规划，因为我们需要基于前一行来构造每一行。
     * 首先，我们会生成整个 triangle 列表，三角形的每一行都以子列表的形式存储。然后，我们会检查行数为 00 的特殊情况，否则我们会返回 [1][1]。如果 numRows > 0numRows>0，那么我们用 [1][1] 作为第一行来初始化 triangle with [1][1]，并按如下方式继续填充：
     * 时间复杂度：O(numRows^2)O(numRows^2)
     * 空间复杂度：O(numRows^2)O(numRows^2)
     */
    List<List<Integer>> official(int numRows){
                List<List<Integer>> triangle = new ArrayList<List<Integer>>();

                // First base case; if user requests zero rows, they get zero rows.
                if (numRows == 0) {
                    return triangle;
                }

                // Second base case; first row is always [1].
                triangle.add(new ArrayList<>());
                triangle.get(0).add(1);

                for (int rowNum = 1; rowNum < numRows; rowNum++) {
                    List<Integer> row = new ArrayList<>();
                    List<Integer> prevRow = triangle.get(rowNum-1);

                    // The first row element is always 1.
                    row.add(1);

                    // Each triangle element (other than the first and last of each row)
                    // is equal to the sum of the elements above-and-to-the-left and
                    // above-and-to-the-right.
                    for (int j = 1; j < rowNum; j++) {
                        row.add(prevRow.get(j-1) + prevRow.get(j));
                    }

                    // The last row element is always 1.
                    row.add(1);

                    triangle.add(row);
                }

                return triangle;
        }
}
