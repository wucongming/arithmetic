package cn.ustc.six;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

//         int m = lists.length;
//         if(m == 0) return null;
//         ListNode head = new ListNode(0);
//         ListNode tail = head;
//         int n = m;
//         int index = 0;

//         while(n != 1) {
//             ListNode p = null;
//             n = m;
//             for(int i = 0; i < m; i++) {
//                 if(lists[i] == null) {
//                     n--;
//                     continue;
//                 }
//                 if(p == null) {
//                     p = lists[i];
//                     index = i;
//                 }
//                 else if(p.val > lists[i].val) {
//                      p = lists[i];
//                     index = i;
//                 }
//             }
//             if(lists[index] == null) return null;
//             tail.next = p;
//             tail = tail.next;
//             lists[index] = lists[index].next;
//         }
//         tail.next = lists[index];
//         return head.next;
        int m = lists.length;
        if(m == 0) return null;
        int mid = m / 2;
        while(mid != 0) {
            for(int i = 0; i < mid; i++) {
                lists[i] = mergeTwoLists(lists[i], lists[mid + i + m % 2]);
            }
            m = mid + m % 2;
            mid = m / 2;
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
