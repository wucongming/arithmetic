package cn.ustc.six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    private List<List<Integer>> list = new ArrayList<List<Integer>>();
    public List<List<Integer>> threeSum(int[] nums) {
//        -1,0,1,2,-1,-4
//        -4,-1,0,1,2
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {

            while(i - 1 >= 0 && i < nums.length && nums[i] == nums[i - 1]) i++;
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end) {

                System.out.println(nums[i] + ".............." + nums[start] + "-----------" + nums[end]);
                if(nums[i] + nums[start] + nums[end] == 0) {
                    System.out.println(nums[start] + "***********" + nums[end]);

                    List<Integer> l = new ArrayList<Integer>();
                    l.add(nums[i]);
                    l.add(nums[start]);
                    l.add(nums[end]);
                    list.add(l);
                    do {
                        start++;
                    }while(start < end && nums[start - 1] == nums[start]);
                    if(start + 1 == end) break;
                } else if(nums[i] + nums[start] + nums[end] > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        // int[] temp = new int[3];
        // for(int i = 0; i < nums.length - 2; i++) {
        //     huisuo(temp, 0, nums, i);
        // }
        return list;
    }


    public static void main(String[] args) {
        int[] array = new int[]{-2,0,1,1,2};
        ThreeSum sum = new ThreeSum();
        List<List<Integer>> lists = sum.threeSum(array);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
//        System.out.println("拉多咯");
    }

}
