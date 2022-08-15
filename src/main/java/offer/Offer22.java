package offer;

/**
 * @Author: YuRuixue
 * @Description:  链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2022/4/26 17:27
 */
public class Offer22 {
    public static void main(String[] args) {
        //生成链表
        ListNode listNode = new ListNode(1);
        ListNode head = listNode;
        ListNode pre = head;
        for (int i = 1; i < 5; i++) {
            pre.next = new ListNode(i+1);
            pre = pre.next;
        }
        getKthFromEnd(head,3);
    }
    public static ListNode getKthFromEnd(ListNode head, int k) {
        //快慢指针
        ListNode fastNode = null;
        ListNode slowNode = head;
        for (int i = 0; i < k ; i++) {
            fastNode = head;
            head = head.next;
        }
        while (fastNode.next != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        //System.out.println(slowNode.val);
        return slowNode;
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
  }
}
