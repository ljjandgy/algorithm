package dataStructure.lru;

/**
 * 单链表实现LRU算法
 */
public class SingleLinkedListLru {
    /**
     * 头指针一直指向第一个节点
     */
    private Node head = new Node(null,null);
    /** 链表长度，用于模拟内存使用 **/
    private int length;
    private static final int MAX_LENGTH = 10;

    public Node find(String data){
        if (head.next == null){
            addOne(data);
        }
        Node temp = head.next;
        Node preTemp = head;
        while (temp!=null){
            if (data.equals(temp.data)){
                refresh(temp,preTemp);
                return temp;
            }
            preTemp = temp;
            temp = temp.next;
        }
        //没找到,添加缓存
        //满员，先干掉最长时间没用到的缓存
        if (length==MAX_LENGTH){
            deleteLastOne();
        }
        return addOne(data);
    }

    private void deleteLastOne(){
        Node temp = head.next;
        Node preTemp = head;
        while (temp.next!=null){
            preTemp = temp;
            temp = temp.next;
        }
        preTemp.next = null;
        --length;
    }

    private Node addOne(String data){
        head.next = new Node(head.next,data);
        ++length;
        return head.next;
    }

    private void refresh(Node node,Node preNode){
        preNode.next = node.next;
        node.next = head.next;
        head.next = node;
    }

    public void showLinked(){
        Node temp = head.next;
        while (temp!=null){
            System.out.print(" "+temp.data);
            temp = temp.next;
        }
    }

    class Node{
        Node next;
        String data;

        Node(Node next,String data){
            this.next = next;
            this.data = data;
        }
    }

    public static void main(String[] args) {
        SingleLinkedListLru singleLinkedListLru = new SingleLinkedListLru();
        for (int i=0;i<10;++i){
            singleLinkedListLru.find(String.valueOf(i));
        }
        singleLinkedListLru.showLinked();
        System.out.println();
       /* singleLinkedListLru.find("1");
        singleLinkedListLru.showLinked();
        System.out.println();*/
        singleLinkedListLru.find("55");
        singleLinkedListLru.showLinked();
    }
}
