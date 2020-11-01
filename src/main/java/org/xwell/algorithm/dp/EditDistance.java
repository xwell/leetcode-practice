package org.xwell.algorithm.dp;

/**
 * no.72 编辑距离
 * <p>
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * - 插入一个字符
 * - 删除一个字符
 * - 替换一个字符
 * <p>
 * <p>
 * 示例1：
 * ```
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * ```
 * 示例2：
 * ```
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * ```
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xwell
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return -1;
        }
        char[] a = word1.toCharArray();
        char[] b = word2.toCharArray();
        int n = a.length;
        int m = b.length;
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        // 状态定义
        // dp[i][j] 表示 a 的前 i 个字符与 b 的前 j 个字符的编辑距离
        int[][] dp = new int[n + 1][m + 1];
    
        // 初始化边界状态
        // 初始化第 0 行："" 与 b[0..j-1] 的编辑距离，全部插入即可
        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = j;
        }
        // 初始化第 0 列，a[0..i-1] 与 "" 的编辑距离，全部插入即可
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }
    
        // 动态递推，状态可以由前一个状态进行三种操作转移过来：插入、删除、替换
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // 如果前一个字符相等，就不需要替换操作了
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
    
    private int min(int a, int b, int c) {
        int min = a;
        if (min > b) {
            min = b;
        }
        if (min > c) {
            min = c;
        }
        return min;
    }
}