package array;

import java.util.Arrays;

/**
 * 查找最大的H系数
 */
public class HIndex {
    /**
     * 类似于找中间值
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }
}
