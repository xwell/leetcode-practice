package org.xwell.datastructure.linkedlist;

import java.util.HashSet;
import java.util.Set;

import org.xwell.common.ListNode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while(head!=null){
            if(set.contains(head)){
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
    public boolean hasCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
}
