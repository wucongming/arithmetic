package cn.ustc.six;

/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ImplementStrstr {
    public int strStr(String haystack, String needle) {
        int nlen = needle.length();
        int hlen = haystack.length();
        if(nlen == 0) return 0;
        if(hlen < nlen) return -1;
        char[] needles = needle.toCharArray();
        char[] haystacks = haystack.toCharArray();
        int[] array1 = new int[nlen];
        array1[0] = -1;
        int j = - 1, i = 0;


        while(i + 1 < nlen) {
            if(j == -1 || needles[j] == needles[i]) {
                i++;
                array1[i] = ++j;
                // System.out.print("\t" + array1[i]);
            } else {
                j = array1[j];
            }
        }
        // System.out.println("结束");
        int addr = -1;
        i = 0;
        j = 0;
        while(i < hlen && j < nlen) {
            if(haystacks[i] == needles[j]) {
                i++;
                j++;
                if(j == nlen) {
                    addr = i - nlen;
                }
            } else {
                if(j == 0) {
                    i++;
                } else {
                    j = array1[j];
                }
            }
        }
        return addr;
    }
}
