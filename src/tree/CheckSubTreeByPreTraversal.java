package tree;

import java.util.ArrayList;

/**
 * 通过先序遍历获取树的序列，然后比较T2是否是T1的子数组即可。
 * 先序遍历能保证每个节点的子树的节点是紧跟在自己后面的，相当于完整的记录了树的结构和信息。所以才能保证只要序列为子集，树也为子树（结构和值都一样）
 * 匹配的时候采用的是KMP算法
 */
public class CheckSubTreeByPreTraversal {
    //KMP算法解：1.先拿到两个树的先序序列化2.接下来就是看看t1产生的str数组是否能匹配t2产生的match数组
    public static void preSerial(TreeNode head,ArrayList<String> preList){
        if(head==null){
            preList.add("null");
            return;
        }
        preList.add(head.val+"");
        preSerial(head.left,preList);
        preSerial(head.right,preList);
    }
    public static boolean checkSubTree1(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;
        if (t1 == null) return false;
        ArrayList<String> str = new ArrayList<>();
        preSerial(t1,str);
        ArrayList<String> match = new ArrayList<>();
        preSerial(t2,match);
        return getIndexOf(str,match)!=-1;
    }

    private static int getIndexOf(ArrayList<String> str, ArrayList<String> match) {
        if(match.size()>str.size()) return  -1;
        int x = 0,y = 0;
        int[] nexts = getNextArray(match);
        while (x<str.size()&&y<match.size()){
            if(str.get(x).equals(match.get(y))){
                x++;y++;
            }else if(nexts[y]==-1){
                x++;
            }else{
                y = nexts[y];
            }
        }
        return y==match.size()?x-y:-1;
    }

    private static int[] getNextArray(ArrayList<String> match) {
        if(match.size()==1) return new int[]{-1};
        int[] next = new int[match.size()];
        next[0] = -1;
        next[1] = 0;
        int preNext = 0;
        int cur = 2;
        while (cur<match.size()){
            if(match.get(preNext).equals(match.get(cur))){
                next[cur++] = ++preNext;
            }else if(preNext>0){
                preNext = next[preNext];
            }else{
                next[cur++] = 0;
            }
        }
        return next;
    }
}
