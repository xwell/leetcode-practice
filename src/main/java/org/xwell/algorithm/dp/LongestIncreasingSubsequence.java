package org.xwell.algorithm.dp;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * no.300 最长上升子序列
 * <p>
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * ```
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * ```
 * <p>
 * 说明:
 * <p>
 * - 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * - 你算法的时间复杂度应该为 `$O(n^2)$` 。
 * - 进阶: 你能将算法的时间复杂度降低到 `$O(n log n)$` 吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xwell
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums){
        int n = nums.length;
        if(n<=1){
            return n;
        }
        // 状态定义，dp[i] 表示以 nums[i] 结尾的最长子序列长度
        int[] dp = new int[n];
        
        // 初始化，所有位置的最长子序列至少是 1
        Arrays.fill(dp, 1);

        int res = 1;
        for(int i = 1; i<n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    @Test
    public void test1(){
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        Assert.assertEquals(4, lengthOfLIS(nums));
    }
}
