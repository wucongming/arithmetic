package cn.ustc.six;

import java.util.Stack;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;
        if(n == 1 && head.next == null) return head.next;
        while(q.next != null) {
            q = q.next;
            if(n != 0) n--;
            else p = p.next;
        }
        if(n == 1) return head.next;
        else if(n == 0) p.next = p.next.next;
        return head;
    }

}

 class ListNode {
    Stack<String>  stack = new Stack();
     {
         StringBuilder builder = new StringBuilder();

//         builder.substring
//         stack.p
     }
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
