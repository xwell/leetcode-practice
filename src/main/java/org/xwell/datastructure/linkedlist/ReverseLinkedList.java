package org.xwell.datastructure.linkedlist;

import org.xwell.common.ListNode;
import org.xwell.common.ListUtils;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 *
 * @author xwell
 * @date 2020/8/22
 */
public class ReverseLinkedList {
    /**
     * 递归实现
     * <p>
     * 假设所处在 k，后续链表都已反转
     * 1->2->3->...->k->k+1<-...<-n
     * 所以，我们希望 k+1 的下一节点指向 k
     * 即：k.next.next = k。
     * 需要注意，1 的下一个节点必须指向 null，否则会出现环形链表
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        return  null;
    }

    /**
     * 迭代实现
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }

        ListNode prev = head;
        ListNode cur = head.next;
        while(prev!=null&&cur!=null){
            ListNode next = cur.next;
            cur.next = prev;
            head.next = next;

            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = ListUtils.stringToListNode("[1,2,3,4,5]");

        ListNode result = reverseList2(head);

        ListUtils.prettyPrint(result);
    }
}
