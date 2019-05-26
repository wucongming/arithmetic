package cn.ustc.manacher;

public class Manacher {

    public static void run() {
        new Manacher().longestPalindrome("acbbca");

    }

    public String longestPalindrome(String s) {
        /**
         * 根据马拉车算法思想
         * 第一步我们需要将原字符串构造成一个由#间隔的字符串（也可以由别的字符，但是最好是不会出现在字符串s中的）。
         * 例如："abc" ==> "#a#b#c#"
         *       "abcd" ==> "#a#b#c#d#"
         *       这样不管原字符串是否是奇数个还是偶数个字符，都变成了奇数个字符
         *       在处理的时候就不需要对字符是偶数还是奇数做分类判断了。
         *
         */
        String newString = s.replace("", "#");

        /**
         * 存放字符串中 以该字符为中心最大的回文字符串的“半径”
         * 例如："#a#b#b#a#c#'
         * 对应的值   str[0] = # radius[0] = 1   回文字符串为：#
         *           str[1] = a radius[1] = 2   回文字符串为：#a#
         *           str[2] = # radius[2] = 1   回文字符串为：#
         *           str[3] = b radius[3] = 2   回文字符串为：#b#
         *           str[4] = # radius[4] = 5   回文字符串为：#a#b#b#a#
         *           str[5] = b radius[5] = 2   回文字符串为：#b#
         *           str[6] = # radius[6] = 1   回文字符串为：#
         *           str[7] = a radius[7] = 2   回文字符串为：#a#
         *           str[8] = # radius[8] = 1   回文字符串为：#
         *           str[9] = c radius[9] = 2   回文字符串为：#c#
         *           str[10] = # radius[10] = 1   回文字符串为：#
         *
         */
        int[] radius = new int[s.length() * 2 + 1];

        int maxLength = 0, index = 0;
        /**
         * 构造完新的字符串后，从头开始遍历字符串。
         * 设第i位字符为中心，然后从中心慢慢展开并比较是否相同。
         */
        int id = 0, mx = 0;
        for(int i = 0; i < newString.length(); i++) {
            /**
             * 核心部分(也是中心扩展方法优化的部分）:
             *
             */
            if(i < mx) radius[i] = Math.min(radius[id * 2 - i], mx - i);
            else radius[i] = 1;
            //以i为中心扩展
            while(i - radius[i] >= 0 &&
                    i + radius[i] < newString.length()
                    && newString.charAt(i - radius[i]) == newString.charAt(i + radius[i]))
                radius[i]++;

            /**
             * 核心部分（即更新上面优化部分的参数）
             */
            if(mx < i + radius[i]) {
                id = i;
                mx = i + radius[i];
            }
            if(maxLength < radius[i]) {
                maxLength = radius[i];
                index = i;
            }


        }

        index /= 2;
        int start = index - (maxLength - 1) / 2;

        return s.substring(start, start + maxLength - 1 );
    }

}
