package BackTracking;

import java.util.List;

public class test {
    public static void main(String[] args) {
        String s = "aabbcc";
        Solution solution = new Solution();
        List<List<String>> result = solution.partition(s);
        for (List<String> list : result) {
            System.out.println(list.toString());
        }
    }

}
