package array;

/**
 * 能不能种下符合要求的花
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false 。
 */
public class CanPlaceFlowers {
    /**
     * 个人解题思路：
     * 直接遍历数组，判断每个节点是否可以种花，可以的话，就把目标数-1，最后判断目标数有没有减完（花有没有种完）
     */
    public boolean canPlaceFlowersMy(int[] flowerbed, int n) {
        int prev = 0;
        int next = 0;
        for(int i=0;i<flowerbed.length;++i){
            if(i+1<flowerbed.length){
                next = flowerbed[i+1];
            }else{
                next = 0;
            }
            if(prev==0&&next==0&&flowerbed[i]==0){
                flowerbed[i] = 1;
                --n;
            }
            prev = flowerbed[i];
        }
        return n<1;
    }
    /**
     * 贪心法判断是否满足要求
     *  根据上述计算方法，计算花坛中可以种入的花的最多数量，判断是否大于或等于 nnn 即可。具体做法如下。
     *
     * 维护 prev\textit{prev}prev 表示上一朵已经种植的花的下标位置，初始时 prev=−1\textit{prev}=-1prev=−1，表示尚未遇到任何已经种植的花。
     *
     * 从左往右遍历数组 flowerbed\textit{flowerbed}flowerbed，当遇到 flowerbed[i]=1\textit{flowerbed}[i]=1flowerbed[i]=1 时根据 prev\textit{prev}prev 和 iii 的值计算上一个区间内可以种植花的最多数量，然后令 prev=i\textit{prev}=iprev=i，继续遍历数组 flowerbed\textit{flowerbed}flowerbed 剩下的元素。
     *
     * 遍历数组 flowerbed\textit{flowerbed}flowerbed 结束后，根据数组 prev\textit{prev}prev 和长度 mmm 的值计算最后一个区间内可以种植花的最多数量。
     *
     * 判断整个花坛内可以种入的花的最多数量是否大于或等于 n。
     *
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int m = flowerbed.length;
        int prev = -1;
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 1) {
                if (prev < 0) {
                    count += i / 2;
                } else {
                    //区间内能种花的位置数目+1/2就是区间内能种花的最大数目
                    count += (i - prev - 2) / 2;
                }
                if (count >= n) {
                    return true;
                }
                prev = i;
            }
        }
        //这个是为了计算最后个区间里面能种多少花
        if (prev < 0) {
            count += (m + 1) / 2;
        } else {
            count += (m - prev - 1) / 2;
        }
        return count >= n;
    }
}
