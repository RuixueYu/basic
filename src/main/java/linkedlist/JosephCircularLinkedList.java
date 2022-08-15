package linkedlist;

/**
 * @Author: YuRuixue
 * @Description: 约瑟夫问题
 * 有41个结点的循环链表，从第一个结点开始计数，每计到3就移除该结点，并从下一个结点重新开始从1计数，输出结点移除的顺序
 * @date 2022/4/21 11:27
 */
public class JosephCircularLinkedList {
    public static void main(String[] args) {
        /**
         * 解决约瑟夫问题
         */

        //1.构建有41个结点的循环链表
        Node<Integer> first = null;
        Node<Integer> pre = null;
        for (int i = 1; i < 42; i++) {
            if(i == 1){
                first = new Node<>(i,null);
                pre = first;
            }else {
                pre.next = new Node(i,null);
                pre = pre.next;
                if(i == 41){
                    pre.next = first;
                }
            }
        }
        //2.声明计数器用于计数
        int count = 0;
        Node<Integer> n = first;
        Node<Integer> before = null;
        //3.判断并删除
        while (n.next != n){
            count ++;
            if(count == 3){
                before.next = n.next;
                count = 0;
                System.out.print(n.item+" ");
                n = n.next;
            }else {
                before = n;
                n = n.next;
            }
        }
        System.out.println(n.item);
    }

    /**
     * 构造结点类
     * @param <T>
     */
    private static class Node<T>{
        //存储数据
        T item;
        //下一个节点
        Node next;
       public Node(T item,Node next){
           this.item = item;
           this.next = next;
       }
    }
}
