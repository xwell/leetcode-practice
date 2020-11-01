package org.xwell.datastructure.linkedlist;

import org.xwell.common.ListNode;
import org.xwell.common.ListUtils;

/**
 * @author xwell
 * @date 2020/8/26
 */
public class SwapPairs {

    /**
     * 递归解法
     *
     * 从链表的头结点 head 开始递归
     * 每次递归都负责交换一对节点，由 a 和 b 表示要交换的两个节点
     * 若链表还有下一对节点，则继续递归。下一次递归则是下一对需要交换的节点。
     * 交换了两个节点以后，返回 b，因为它是交换后的头结点。
     * 在所有节点交换完成以后，我们返回交换后的头节点，实际上是原始链表的第二个节点。
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        // 递归出口，当前节点为空或者当前节点的下一个节点为空
        if(head==null||head.next==null){
            return head;
        }
        // 指定要交换的一对节点
        ListNode a = head;
        ListNode b = head.next;

        // 交换节点，其中 a 节点的下一个节点指向后续的一对交换节点
        a.next = swapPairs(b.next);
        b.next = a;

        // 返回交换好的头结点（当所有递归返回，最外层的 b 节点是原链表的第二个节点）
        return b;
    }

    /**
     * 迭代解法
     *
     * 将链表分成两部分，即奇数节点为一部分，偶数节点为一部分。
     * 使用 a 表示交换节点对的第一个节点，使用 b 表示后一个节点。
     * 在完成它们的交换以后，还需要一个指针 prev 记录 A 的前驱节点（即已完成交换链表的尾节点）。
     *
     * 我们还是用一个虚拟节点 dummy 用来连接初始链表的头结点，用于最后返回交换后链表的头节点
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs2(ListNode head) {
        // 定义一个虚拟节点，连接初始链表的头节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 使用 prev 记录已交换的链表的最后一个节点
        ListNode prev = dummy;
        while (head != null && head.next != null) {
            // 准备交换的节点
            ListNode a = head;
            ListNode b = head.next;

            // 交换节点
            a.next = b.next;
            b.next = a;
            // 第一次交换完成，dummy 指向了 b 节点（原始链表的第二个节点，也就是最终链表的头节点）
            prev.next = b;

            // 指针前移
            prev = a;
            head = a.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListUtils.stringToListNode("[1,2,3,4]");
        ListNode result = swapPairs(head);

        ListUtils.prettyPrint(result);
    }
}
