package linked;

/**
 * @author ljj
 * @version sprint 38
 * @className DeleteNode
 * @description 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 *
 *  
 *
 * 示例：
 *
 * 输入：单向链表a->b->c->d->e->f中的节点c
 * 结果：不返回任何数据，但该链表变为a->b->d->e->f
 *
 * @date 2021-03-02 13:23:51
 */
public class DeleteNode {
    /**
     * 解题思路：其实是个脑筋急转弯，因为不能获取前面的节点，所以要删除当前节点只能复制后面的数，然后再删除后面的节点
     * @param node 需要删除的节点
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
