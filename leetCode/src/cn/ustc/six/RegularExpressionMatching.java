package cn.ustc.six;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 *
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 *     s 可能为空，且只包含从 a-z 的小写字母。
 *     p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 *
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 *
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        //回溯法
        // if(p.isEmpty()) return s.isEmpty();
        // boolean first_match = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        // if(p.length() >= 2 && p.charAt(1) == '*') {
        //     return
        //         (
        //             (first_match && isMatch(s.substring(1), p)) ||
        //             isMatch(s, p.substring(2))
        //         );
        // } else {
        //     return first_match && isMatch(s.substring(1), p.substring(1));
        // }

        //动态规划
//        int[] height = {1 , 2};
//        height.length
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        // boolean[s.length() + 1][p.length() + 1] = true;
        for(int i = s.length(); i >= 0; i--) {
            for(int j = p.length(); j >= 0; j--) {
                // 若 s=“”, p=""9 则一定能匹配
                if(i == s.length() && j == p.length()) dp[i][j] = true;
                else if(j < p.length()) {
                    boolean first_match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                    if(j + 1 < p.length() && p.charAt(j + 1) == '*') {
                        dp[i][j] = (first_match && dp[i + 1][j]) || dp[i][j + 2];
                        // System.out.println(dp[i][j]);
                    } else {
                        dp[i][j] = first_match && dp[i + 1][j + 1];
                        // System.out.println(dp[i][j]);
                    }
                }
            }
        }

        // for(int i = 0; i < s.length() + 1; i++) {
        //     for(int l = 0; l < p.length() + 1; l++) {
        //         System.out.print(dp[i][l] + " ");
        //     }
        //     System.out.println();
        // }
        return dp[0][0];

    }
}