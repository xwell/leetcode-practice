package org.xwell.datastructure.linkedlist;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xwell
 * @date 2020/9/8
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        if (n < 2) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Integer idx = map.get(nums[i]);
            if (idx != null) {
                return new int[]{idx, i};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return new int[0];
    }

    @Test
    public void test1() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Assert.assertArrayEquals(new int[]{0, 1}, twoSum(nums, target));
    }
}
