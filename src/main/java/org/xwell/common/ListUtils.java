package org.xwell.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表工具类
 *
 * @author xwell
 * @date 2020/8/22
 */
public class ListUtils {

    /**
     * 将输入的格式化字符串转为整形数组
     *
     * @param input 格式化字符串，其格式为 [1,2,3]
     * @return 整形数组，[1,2,3]
     */
    public static int[] stringToIntegerArray(String input) {
        if (input == null) {
            return new int[0];
        }
        input = input.trim();
        if (input.length() <= 0) {
            return new int[0];
        }
        input = input.substring(1, input.length() - 1);
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            output[i] = Integer.parseInt(parts[i].trim());
        }
        return output;
    }

    /**
     * 字符串转为链表
     *
     * @param input 格式化的字符串，格式为 [1,2,3]
     * @return 链表，1->2->3
     */
    public static ListNode stringToListNode(String input) {
        // 首先将字符串转为整形数组
        int[] nodeValues = stringToIntegerArray(input);
        // 定义一个虚拟的头节点，用来建立链表
        ListNode dummyHead = new ListNode(0);
        // 迭代指针
        ListNode ptr = dummyHead;
        for (int v : nodeValues) {
            ptr.next = new ListNode(v);
            ptr = ptr.next;
        }
        return dummyHead.next;
    }


    /**
     * 格式化打印链表，格式为 3->2->1
     *
     * @param node
     */
    public static void prettyPrint(ListNode node) {
        while (node != null && node.next != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        if (node != null) {
            System.out.println(node.val);
        } else {
            System.out.println("empty linked list");
        }
    }

    /**
     * 将字符串转为 ArrayList
     * @param src 字符串，格式为 [1,2,3]
     * @return 整形列表，类型为 ArrayList
     */
    public static List<Integer> stringToArrayList(String src) {
        int[] integerArray = stringToIntegerArray(src);
        List<Integer> res = new ArrayList<>();
        for (int i : integerArray) {
            res.add(i);
        }
        return res;
    }

    /**
     * 将嵌套字符串转换为列表的列表
     * @param src 字符串，格式为 [[1,2],[1,3,5],[1]]
     * @return 列表的列表，格式为 <code>ArrayList<ArrayList<Integer>></code>
     */
    public static List<List<Integer>> stringToWrapArrayList(String src) {
        List<List<Integer>> res = new ArrayList<>();
        if (src == null) {
            return res;
        }
        src = src.trim();
        if (src.length() <= 0) {
            return res;
        }
        src = src.substring(1, src.length() - 1);
        String[] parts = src.split("(?<=\\]),");

        for (String s : parts) {
            res.add(stringToArrayList(s));
        }
        return res;
    }
}
