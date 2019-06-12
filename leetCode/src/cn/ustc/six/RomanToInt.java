package cn.ustc.six;

/**
 * 在数量不多时，
 * 使用map来进行查找的效率不高
 */
public class RomanToInt {

    public int romanToInt(String s) {
        // Map<String, Integer> map = new HashMap<String, Integer>();
        // map.put("I", 1);
        // map.put("V", 5);
        // map.put("X", 10);
        // map.put("L", 50);
        // map.put("C", 100);
        // map.put("D", 500);
        // map.put("M", 1000);
        // int val = 0;
        // for(int i = 0; i < s.length(); i++) {
        //     String str1 = s.substring(i, i + 1);
        //     if(i + 1 < s.length()) {
        //         String str2 = s.substring(i + 1, i + 2);
        //         if(map.get(str1) < map.get(str2)) continue;
        //     }
        //     val += map.get(str1);
        //     if(i - 1 >= 0) {
        //         String str2 = s.substring(i - 1, i);
        //         if(map.get(str1) > map.get(str2)) {
        //             val -= map.get(str2);
        //         }
        //     }
        // }
        int val = 0;
        for(int i = 0; i < s.length(); i++) {
            String str1 = s.substring(i, i + 1);
            if(str1.equals("I")) {
                val = val + 1;
            } else if(str1.equals("V")) {
                val = 5 + val;
                if(i - 1 >= 0) {
                    String str2 = s.substring(i - 1, i);
                    if(str2.equals("I")) {
                        val = val - 2;
                    }
                }
            } else if(str1.equals("X")) {
                val = 10 + val;
                if(i - 1 >= 0) {
                    String str2 = s.substring(i - 1, i);
                    if(str2.equals("I")) {
                        val = val - 2;
                    }
                }
            } else if(str1.equals("L")) {
                val = 50 + val;
                if(i - 1 >= 0) {
                    String str2 = s.substring(i - 1, i);
                    if(str2.equals("X")) {
                        val = val - 20;
                    }
                }
            } else if(str1.equals("C")) {
                val = 100 + val;
                if(i - 1 >= 0) {
                    String str2 = s.substring(i - 1, i);
                    if(str2.equals("X")) {
                        val = val - 20;
                    }
                }
            } else if(str1.equals("D")) {
                val = 500 + val;
                if(i - 1 >= 0) {
                    String str2 = s.substring(i - 1, i);
                    if(str2.equals("C")) {
                        val = val - 200;
                    }
                }
            } else {
                val = 1000 + val;
                if(i - 1 >= 0) {
                    String str2 = s.substring(i - 1, i);
                    if(str2.equals("C")) {
                        val = val - 200;
                    }
                }
            }
        }
        return val;

    }

}
