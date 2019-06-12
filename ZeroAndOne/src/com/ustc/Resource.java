package com.ustc;

import java.util.Arrays;
import java.util.List;

public class Resource {

    public final int maxVolume = 10;
    public int currentVolume = 0;
    public List<Good> goods = Arrays.asList(new Good(1, 1), new Good(7, 1), new Good(2, 1), new Good(9, 100));

    public static class Good {
        private int volume;
        private int value;

        @Override
        public String toString() {
            return "Good{" +
                    "volume=" + volume +
                    ", value=" + value +
                    '}';
        }

        public Good(int volume, int value) {
            this.volume = volume;
            this.value = value;
        }

        public int getVolume() {
            return volume;
        }

        public void setVolume(int volume) {
            this.volume = volume;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
