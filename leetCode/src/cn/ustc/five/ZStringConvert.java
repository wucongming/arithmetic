package cn.ustc.five;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class ZStringConvert {
    public String convert(String s, int numRows) {
        // String value = "";
        // for(int i = 1; i <= numRows; i++) {
        //     int start = i - 1;
        //     while(start < s.length()) {
        //         value += s.charAt(start);
        //         //System.out.println(s.charAt(start));
        //         if(i <= numRows - 1) {
        //             start += 2 * (numRows - i);
        //         } else {
        //             start += 2 * (numRows - 1);
        //         }
        //     }
        // }
        // return value;
        String value = "";
        if(numRows == 1) return s;
        for(int i = 0; i < numRows; i++) {
            int start = i;
            int thum = 0;
            while(start < s.length()) {
                value += s.charAt(start);

                thum = numRows - 1 - i;
                start += thum * 2;
                if(thum < numRows - 1 && start < s.length()) {
                    if(thum != 0) value += s.charAt(start);
                    thum = numRows - 1 - thum;
                    start += thum * 2;
                }
            }


        }
        return value;
    }
}
