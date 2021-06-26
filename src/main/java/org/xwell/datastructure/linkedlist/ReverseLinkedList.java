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
        // 递归终止条件是当前节点为空，或者下一个节点为空
        if(head==null||head.next==null){
            return head;
        }

        // curr 即反转好的头节点
        ListNode curr = reverseList(head.next);
        // 递归，将当前节点的下一个节点指向当前节点
        head.next.next = head;
        // 防止链表成环，断开
        head.next=null;
        // 每层递归都返回 curr，也就是反转的头指针
        return curr;
    }

    /**
     * 迭代实现
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // prev 记录反转好的头结点，初始为 null
        ListNode prev = null;
        // curr 记录待反转的头结点，即当前节点
        ListNode curr = head;
        while (curr != null) {
            // 记录当前节点的下一个节点
            ListNode next = curr.next;
            // 然后将当前节点指向 prev
            curr.next = prev;
            // prev 和 curr 节点都前进一位
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = ListUtils.stringToListNode("[1,2,3,4,5]");

        ListNode result = reverseList(head);

        ListUtils.prettyPrint(result);
    }
}
