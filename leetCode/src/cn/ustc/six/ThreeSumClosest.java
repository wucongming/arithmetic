package cn.ustc.six;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
//        String.val
        Entity entity = new Entity();

        Arrays.sort(nums);
        for(int i = 0; i < nums.length -2; i++) {
            int start = i + 1, end = nums.length - 1;
            while(start < end) {
                // System.out.println(nums[i] + "---" + nums[start] + "---" + nums[end] + "  " + Math.abs(target - (nums[i] + nums[start] + nums[end])) + "。。。。" + entity.getSub());
                if(Math.abs(target - (nums[i] + nums[start] + nums[end])) < entity.getSub() || entity.getSub() == -1) {
                    entity.setSub(Math.abs(target - (nums[i] + nums[start] + nums[end])));
                    entity.setValue(nums[i] + nums[start] + nums[end]);
                }
                if(nums[i] + nums[start] + nums[end] > target) {
                    // System.out.println("end--");
                    end--;
                } else {
                    // System.out.println("start++");
                    start++;
                }
            }
        }
        return entity.getValue();

    }
}
class Entity {
    private int sub = -1;
    private int value;
    public void setSub(int sub) { this.sub = sub; }
    public int getSub() { return this.sub; }
    public void setValue(int value) { this.value = value; }
    public int getValue() { return this.value; }
}