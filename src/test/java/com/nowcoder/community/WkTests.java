package com.nowcoder.community;

import java.io.IOException;

public class WkTests {

    public static void main(String[] args) {
        String command = "wkhtmltoimage --quality 75 https://www.nowcoder.com ~/Documents/workspace/data/wk-img/3.png";
        try {
            Runtime.getRuntime().exec(new String[] {"/bin/sh","-c",command});
            System.out.println("ok.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
