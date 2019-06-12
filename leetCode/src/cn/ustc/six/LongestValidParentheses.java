package cn.ustc.six;

import java.util.Stack;

public class LongestValidParentheses {

    private Stack<Character> stack = new Stack<>();

    public int longestValidParentheses(String s) {
        int max = 0;
        int length = 0;
        // for(int i = 0; i < s.length(); i++) {
        //     int status = 0;
        //     for(int l = i; l < s.length(); l++) {
        //         char ch = s.charAt(l);
        //         if(ch == '(') {
        //             status += -1;
        //         } else if(ch == ')') {
        //             if(status >= 0) break;
        //             else status += 1;
        //         }
        //         if(status == 0) {
        //             max = max > l - i + 1 ? max : l - i + 1;
        //         }
        //     }
        //     if(max >= s.length() - i - 1) break;
        // }
        // return max;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Character peek = null;
            if(ch == '(') stack.push(new Character('('));
            else {
                try {
                    peek = stack.peek();
                } catch (Exception e) {

                }
                if(peek == null) {
                    stack.push(new Character(')'));
                    continue;
                }
                if(peek.charValue() == '(') {
                    length += 2;
                    stack.pop();
                } else {
                    max = max > length ? max : length;

                    length = 0;
                    stack.push(new Character(')'));
                }
            }


        }
        return max;

    }

}
