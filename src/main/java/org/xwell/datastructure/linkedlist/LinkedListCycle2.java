package org.xwell.datastructure.linkedlist;

import java.util.HashSet;
import java.util.Set;

import org.xwell.common.ListNode;

public class LinkedListCycle2 {
    public ListNode detectListNode(ListNode head) {
        if(head==null||head.next==null){
            return null;
        }
        Set<ListNode> visited = new HashSet<>();
        ListNode node = head;
        while(node!=null){
            if(visited.contains(node)){
                return node;
            }
            visited.add(node);
            node = node.next;
        }
        return null;
    }

    public ListNode detectListNode2(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null){
            slow = slow.next;
            if(fast.next!=null){
                fast = fast.next.next;
            } else {
                return null;
            }
            if(fast==slow){
                ListNode ptr = head;
                while(ptr!=slow){
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
