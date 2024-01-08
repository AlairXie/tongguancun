package com.example.tongguancun.chapter3_array.level2.topic2_5替换空格;

/**
 * @Author xieyunpeng
 * @Date 2024/1/8 20:10
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("We are happy.");
        System.out.println(replaceSpace1(sb));
    }

    public static String replaceSpace1(StringBuffer str) {
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' '){
                res += "%20";
            }else {
                res += c;
            }
        }
        return res;
    }
}
