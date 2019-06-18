package cn.ustc.six;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        Map<Integer, List<List<Integer>>> map = new HashMap<Integer, List<List<Integer>>>();
//        Arrays.
        int base = 97;
        List<List<String>> lists = new ArrayList<List<String>>();
        for(int i = 0; i < digits.length(); i++) {
            int number = Integer.valueOf(digits.substring(i, i + 1));
            List<String> list = new ArrayList<String>();
            int size = 3;
            if(number == 7 || number == 9) {
                size = 4;
            }
            base = 97 + (number - 2) * 3 + number / 8;
            for(int l = 0; l < size; l++) {
                list.add(String.valueOf((char)(base   + l)));
            }
            lists.add(list);
        }
        List<String> results = new ArrayList<String>();
        if(digits.equals("")) return results;
        listAll(lists, 0, new StringBuilder(), results);
        return results;
    }


    private void listAll(List<List<String>> lists, int x, StringBuilder builder, List<String> results) {
        if(x >= lists.size()) {
            results.add(builder.toString());
        } else {
            List<String> list = lists.get(x);
            for(int l = 0; l < list.size(); l++) {
                builder.append(list.get(l));
                listAll(lists,x + 1, builder, results);
            }
        }
        if(builder.length() != 0) builder.deleteCharAt(builder.length() - 1);

    }

}
