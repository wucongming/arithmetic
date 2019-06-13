package cn.ustc.six;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
//         List<Paramter> list = new ArrayList<Paramter>();
//         for(int i = 0; i < strs.length; i++) {


//             for(int l = 0; l < strs[i].length(); l++) {
//                 Paramter paramter = list.size() > l ? list.get(l) : null;
//                 if(paramter == null) {
//                     paramter = new Paramter();
//                     paramter.setCh(strs[i].charAt(l));
//                     paramter.setCount(1);
//                     list.add(paramter);
//                 } else {
//                     if(paramter.getCh() == strs[i].charAt(l)) {
//                         paramter.setCount(paramter.getCount() + 1);
//                     } else {
//                         paramter.setCount(0);
//                     }
//                 }
//             }

//         }
//         int index = 0;
//         for(index = 0; index < list.size(); index++) {
//             if(list.get(index).getCount() != strs.length) break;
//         }
//         return strs.length > 0 ? strs[0].substring(0, index) : "";
        if(strs.length == 0) return "";
        String str = fenzhi(0, strs.length - 1, strs);
        return str;

    }

    private String fenzhi(int start, int end, String[] strs) {
        if(end == start) {
            return strs[end];
        }
        int mid = (end + start) / 2;
        String str1 = fenzhi(start, mid, strs);
        String str2 = fenzhi(mid + 1, end, strs);
        return getPrefix(str1, str2);
    }

    private String getPrefix(String str1, String str2) {
        int index = 0;
        for(index = 0; index < str1.length() && index < str2.length(); index++) {
            if(str1.charAt(index) != str2.charAt(index)) break;
        }
        return str1.substring(0, index);
    }

}


// class Paramter {
//     private char ch;
//     private int count;
//     public char getCh() {
//         return this.ch;
//     }
//     public void setCh(char ch) {
//         this.ch = ch;
//     }
//     public int getCount() {
//         return this.count;
//     }
//     public void setCount(int count) {
//         this.count = count;
//     }

// }