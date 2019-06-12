package com.ustc.force;

import com.ustc.Resource;
import com.ustc.Solution;

import java.util.ArrayList;
import java.util.List;

public class Force implements Solution {

    private int time = 0;
    private List<Resource.Good> goods = new ArrayList<>();
    Resource resource = new Resource();

    @Override
    public void run() {
        System.out.println("run");
        force(0);
        System.out.println(time);
    }

    void force(int i) {
        time++;
        if(i + 1 > resource.goods.size()) {
            System.out.println("-----------------------完成------------------");
            show();
        } else {
            Resource.Good good = resource.goods.get(i);
            if(resource.currentVolume + good.getVolume() <= resource.maxVolume) {
                goods.add(good);
                resource.currentVolume += good.getVolume();
                force(i + 1);
            }
            if(goods.contains(good)) {
                goods.remove(good);
                resource.currentVolume -= good.getVolume();
            }
            force(i + 1);

        }
    }

    void show() {
        for(Resource.Good good : goods) {
            System.out.println(good);
        }
    }

}
