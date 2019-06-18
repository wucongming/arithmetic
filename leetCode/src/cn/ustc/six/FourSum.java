package cn.ustc.six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        for(int i = 0; i < n - 3; i++) {
            if(i - 1 >= 0 && nums[i - 1] == nums[i]) continue;
            if (nums[i] + nums[n-1] + nums[n-2] + nums[n-3] < target) continue;
            if (nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) break;
            for(int l = i + 1; l < n - 2; l++) {
                if (nums[i] + nums[l] + nums[l + 1] + nums[l + 2] > target) break; // 当前组合取出最大值的时候仍然小于 target 跳过
                if (nums[i] + nums[l] + nums[n - 1] + nums[n - 2] < target) continue; // 当前组合取最大值的时候仍然小于 target
                if(l - 1 >= i + 1 && nums[l - 1] == nums[l]) continue;
                int low = l + 1, height = n - 1;
                while(low < height) {
                    if(target - (nums[i] + nums[l] + nums[low] + nums[height]) > 0) {
                        low++;
                    } else if(target - (nums[i] + nums[l] + nums[low] + nums[height]) < 0) {
                        height--;
                    } else {
                        results.add(Arrays.asList(nums[i], nums[l], nums[low], nums[height]));
                        do {
                            low++;
                        } while(low < n && nums[low - 1] == nums[low]);
                    }
                }
            }
        }

        return results;

    }

}
