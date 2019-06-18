package cn.ustc.six;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        generate(list,n,n,"");
        return list;
    }

    public void generate(List<String> list,int p,int q, String str) {
        if(p == 0 && q == 0) {

            list.add(str);
            return;
        }
        if(p < q && p != 0) {
            generate(list,p - 1, q, str + "(");
            generate(list,p, q - 1, str + ")");
        } else if(q == p) {
            generate(list,p - 1, q, str + "(");
        } else if(p == 0) {
            generate(list,p, q - 1, str + ")");
        }
    }

}
