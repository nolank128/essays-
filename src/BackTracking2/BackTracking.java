package BackTracking2;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(k, n, 1, new ArrayList<>(), result);
        return result;
    }

    /*
    * k=还需要找到的数字个数
    * n=表示目前还需要凑出来的数字之和
    * start=表示从某个数字开始搜索
    * current=当前已经找到的数字组成的列表
    * result=最终的结果集*/
    private void backtrack(int k, int n, int start, List<Integer> current, List<List<Integer>> result) {
        if (n == 0 && k == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (n < 0 || k < 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            current.add(i);
            backtrack(k - 1, n - i, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}

public class BackTracking {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 3;
        int n = 9;
        List<List<Integer>> result = solution.combinationSum3(k, n);
        for (List<Integer> list : result) {
            System.out.println(list.toString());
        }
    }
}

