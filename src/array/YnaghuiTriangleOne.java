package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取杨辉三角的特定行
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 */
public class YnaghuiTriangleOne {
    /**
     * 我的low逼方法，3ms
     * @return
     */
    List<Integer> my(int rowIndex){
        List<List<Integer>> allRow = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        if(rowIndex==0){
            return list1;
        }
        allRow.add(list1);
        for(int i=1;i<=rowIndex;i++){
            List<Integer> row = new ArrayList<>();
            List<Integer> pre = allRow.get(i-1);
            row.add(1);
            for(int j=1;j<i;j++){
                row.add(pre.get(j-1)+pre.get(j));
            }
            row.add(1);
            allRow.add(row);
        }
        return allRow.get(rowIndex);
    }
    /**
     * 大佬的方法，直接计算特定行，0ms
     */
    List<Integer> dalao(int rowIndex){
        //杨辉三角为组合数展开(a+b)^2,c(n,0),...,c(n,n)
        List<Integer> result = new ArrayList<>();
        result.add(1);
        if (rowIndex==0) return result;
        if (rowIndex==1)
        {
            result.add(1);
            return result;
        }
        int count=1;
        long temp = 1;
        for (int i=1;i<rowIndex;i++)
        {
            temp *= (rowIndex-i+1);
            temp /= count++;
            result.add((int)temp);
        }
        result.add(1);
        return result;
    }
}
