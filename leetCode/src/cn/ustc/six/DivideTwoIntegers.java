package cn.ustc.six;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int max = 30;
        long value = 0;
        int num1Flag = dividend < 0 ?  -1 : 1;
        int num2Flag = divisor < 0 ? -1 : 1;
        long res = dividend < 0 ? 0l - dividend : dividend;
        long absDivisor = divisor < 0 ? 0l - divisor : divisor;
        // System.out.println((0l - dividend) + "  :  " + dividend + "  " + (dividend < 0));
        while(res >= absDivisor) {
            // System.out.println("哈哈");
            int i = getMaxNumber(res, absDivisor);
            // System.out.println(i + "res  =  " + res);
            value += 1 << i;
            res = res - (absDivisor << i);
        }
        // System.out.println("value = " + value);
        if(num1Flag - num2Flag == 0 && value > 2147483647) return 2147483647;
        else if(num1Flag - num2Flag != 0 && value > 2147483648l) return 2147483647;
        return (int)(num1Flag - num2Flag == 0 ? value : 0 - value);
    }

    public int getMaxNumber(long num1, long num2) {

        // System.out.println("开始");
        int low = 0, height = 30;
        int mid = 0;
        while(low < height) {
            mid = (low + height) >> 1;
            if(num1 - (num2 << mid) > 0) {
                // System.out.println("大于0");
                low = mid + 1;
            } else {
                // System.out.println("小于0");
                height = mid - 1;
            }
            // System.out.println(mid + " low  =  " + low + "  height  =  " + height);

        }
        mid = (low + height) >> 1;
        // System.out.println("mid  =  " + mid);
        return num1 - (num2 << mid) >= 0 ? mid : mid - 1;
    }
}
