package org.xwell.datastructure.linkedlist;

import org.xwell.common.ListNode;
import org.xwell.common.ListUtils;
import org.junit.Test;

/**
 * no.21 合并两个有序链表
 *
 * @author xwell
 * @date 2020/9/14
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode res;
        ListNode lo;
        ListNode hi;
        if (l1.val <= l2.val) {
            lo = l1;
            hi = l2;
            res = l1;
        } else {
            lo = l2;
            hi = l1;
            res = l2;
        }
        while (lo != null && hi != null) {
            while (lo.next != null && lo.next.val < hi.val) {
                lo = lo.next;
            }
            ListNode biNext = hi.next;
            hi.next = lo.next;
            lo.next = hi;
            lo = hi;
            hi = biNext;
        }
        return res;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = (l1 == null ? l2 : l1);

        return preHead.next;
    }

    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val <= l2.val) {
            l1.next = mergeTwoLists3(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists3(l1, l2.next);
            return l2;
        }
    }

    @Test
    public void test1() {
        ListNode l1 = ListUtils.stringToListNode("[1,2,4]");
        ListNode l2 = ListUtils.stringToListNode("[1,3,4]");

        ListNode listNode = mergeTwoLists3(l1, l2);
        ListUtils.prettyPrint(listNode);
    }

    @Test
    public void test2() {
        ListNode l1 = ListUtils.stringToListNode("[2]");
        ListNode l2 = ListUtils.stringToListNode("[1]");

        ListNode listNode = mergeTwoLists3(l1, l2);
        ListUtils.prettyPrint(listNode);
    }
}
