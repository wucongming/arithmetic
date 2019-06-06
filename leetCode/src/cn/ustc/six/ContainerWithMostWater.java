package cn.ustc.six;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 *
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        // System.out.println(height.length());
//         int heightValue = 1;
//         int start = -1, end = -1;
//         int area = 0;
//         for(int l = 0; l < height.length; l++) {
//             heightValue = height[l];
//             for(int i = 0; i < height.length; i++) {
//                 if(height[i] >= heightValue) {
//                     if(start == -1) start = i;
//                     end = i;
//                 }
//             }
//             // System.out.println("start=" + start + " end=" + end + " value=" + (end - start) * heightValue);
//             if(start > -1) area = area > (end - start) * heightValue ? area : (end - start) * heightValue;

//             if(start == -1) break;
//             start = -1;
//         }
        int area = 0;
        int start = 0, end = height.length - 1;
        for(int i = 0; i <height.length; i++) {
            int temp = (end - start) * (height[start] < height[end] ? height[start] : height[end]);
            area = area > temp ? area : temp;
            if(height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return area;
    }
}
