package BackTracking;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    /*
    * s：表示待分割的字符串，start：当前考虑的起始位置，current：已经画分出来分子串列表，result：所有可能的分割方案*/
    private void backtrack(String s, int start, List<String> current, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                current.add(s.substring(start, i + 1));
                backtrack(s, i + 1, current, result);
                current.remove(current.size() - 1);
                /*
                * 当搜索到最后一个子串时，已经将所有可行的子串添加到了 result 中，
                * 此时需要回溯，将最后一个添加的子串删除，以便搜索其他可行方案。*/
            }
        }
    }

    /*两个指针，指向最左边和最右边，并判断两个指针指向的字符是否相同*/
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
