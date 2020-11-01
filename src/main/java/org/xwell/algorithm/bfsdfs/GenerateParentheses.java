package org.xwell.algorithm.bfsdfs;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n.22 括号生成
 * <p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例：
 * <pre>
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xwell
 * @date 2020/9/6
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        gen(n, n, res, "");
        return res;
    }

    private void gen(int left, int right, List<String> res, String sub) {
        if (left == 0 && right == 0) {
            res.add(sub);
            return;
        }

        if (left > 0) {
            gen(left - 1, right, res, sub + "(");
        }
        if (right > left) {
            gen(left, right - 1, res, sub + ")");
        }
    }

    @Test
    public void test1() {
        List<String> res = generateParenthesis(3);
        List<String> expect = Arrays.asList("((()))",
                "(()())",
                "(())()",
                "()(())",
                "()()()");
        Assert.assertEquals(expect, res);
    }
}
