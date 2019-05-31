package cn.ustc.five;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class reverse {

        public int reverse(int x) {
            int i = 0;

            int y = x;
            while((y = y /10) != 0) i++;
            int val = 0;
            for(int index = 0; index <= i; index++) {
                val += (int)((x % Math.pow(10, index + 1)) / Math.pow(10, index)) * Math.pow(10, i - index);
                // System.out.println((int)((x % Math.pow(10, index + 1)) / Math.pow(10, index)) * Math.pow(10, i - index));
            }
            if(val >= (int)(Math.pow(2, 31) - 1) || val <= -(int)Math.pow(2,31)) return 0;

            if(x < 0) val = val < 0 ? val : -val;
            if(x > 0) val = val < 0 ? -val : val;
            return val;
        }
}
