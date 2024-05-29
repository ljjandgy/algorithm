package array;

public class Jump2 {
    /**
     * 使用贪心算法计算调完一个数组需要的最小步数
     * 贪心就是每次都想要做到极致，每次都要得到一个最优解。从本题出发就是每一步走完都需要跳到叠加后（不追求当前这一步最大，要求走完当前步后能到最远）最远的位置
     */
    public int jump2(int[] nums) {
        int length = nums.length;
        //当前格子能达到的最远的距离
        int end = 0;
        //走完end时能达到的最远的距离，也就是把上一步跳的范围的格子都走完，能到达的最远位置是多少
        int maxPosition = 0;
        //实际走的步数
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            //获取上一步走到的范围内，那个格子能跳的更远
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                //上一步范围走完，更新新的可选范围
                end = maxPosition;
                //更新范围相当于走新的一步，所以步数+1
                steps++;
            }
        }
        return steps;
    }
}
