package org.xwell.algorithm.pruning;

import java.util.*;

/**
 * no.51 N 皇后问题
 *
 * @author xwell
 * @date 2020/9/8
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        Set<Integer> cols = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        List<Integer> current = new ArrayList<>();

        helper(res, cols,pie,na,current,n, 0);

        return res;
    }

    private void helper(List<List<String>> res, Set<Integer> cols, Set<Integer> pie, Set<Integer> na,
                        List<Integer> current, int n, int row) {
        // 已经完成最后一行
        if (row == n) {
            res.add(genString(current, n));
            return;
        }
        // 遍历当前行的所有列，将皇后填充到合适位置
        for (int col = 0; col < n; col++) {
            // 如果当前位置在已存在皇后的攻击范围内，则跳过
            if (cols.contains(col) || pie.contains(row + col) || na.contains(row - col)) {
                continue;
            }
            cols.add(col);
            pie.add(row + col);
            na.add(row - col);
            List<Integer> newCur = new ArrayList<>(current);
            newCur.add(col);
            // 将皇后放在当前位置，并继续前往下一行
            helper(res, cols, pie, na, newCur, n, row + 1);

            // 回溯，皇后不放在当前位置，还原现场
            cols.remove(col);
            pie.remove(row + col);
            na.remove(row - col);
        }
    }

    /**
     * 打印当前解
     *
     * @param current 存储皇后的列索引
     * @return
     */
    private List<String> genString(List<Integer> current, int n) {
        List<String> ans = new ArrayList<>();
        for (Integer idx : current) {
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[idx] = 'Q';
            ans.add(new String(chars));
        }
        return ans;
    }
}
