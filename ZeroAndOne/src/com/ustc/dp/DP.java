package com.ustc.dp;

import com.ustc.Resource;
import com.ustc.Solution;

public class DP implements Solution {

    private Resource resource = new Resource();

    Resource.Good[][] matrix = new Resource.Good[resource.maxVolume + 1][resource.goods.size() + 1];


    @Override
    public void run() {
        init();

    }

    private void init() {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = new Resource.Good(0, 0);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[0][i] = new Resource.Good(0, 0);
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int l = 1; l < matrix[i].length; l++) {
                Resource.Good good = resource.goods.get(l - 1);
                if (good.getVolume() <= i) {
                    matrix[i][l] = matrix[i][l - 1].getValue() > matrix[i - good.getVolume()][l].getValue() + good.getValue()
                            ? matrix[i][l - 1] : new Resource.Good(i, good.getValue() + matrix[i - good.getVolume()][l].getValue());
                } else {
                    matrix[i][l] = matrix[i][l - 1];
                }
            }
        }

        System.out.println(matrix[resource.maxVolume][resource.goods.size()]);
    }


}
