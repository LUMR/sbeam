package com.lumr.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lumr freedomyes@sina.com
 * @since 2019-04-04
 **/
public class Test2 {


    @Test
    public void test() {
        int way = 63;

        List<Integer> ways = new ArrayList<>();

        while (way < 4033) {
            if (checkis(way)) {
                ways.add(way);
            }

            way++;
        }

        int nums = 0;

        for (int i = 0; i < ways.size(); i++) {
            Integer go = ways.get(i);

            for (int i1 = 0; i1 < ways.size(); i1++) {
                Integer back = ways.get(i1);

                if (checkdiff(go, back)) {
                    nums++;
                }
            }
        }

        System.out.println("结束：共" + nums);


    }


    private boolean checkis(int x) {
        String bs = Integer.toBinaryString(x);

        long num = bs.chars().filter(a -> a == 49).count();
        return num == 6;
    }


    private boolean checkdiff(int x, int y) {
        String bx = Integer.toBinaryString(x);
        bx = reserve(bx);
        String by = Integer.toBinaryString(y);
        by = reserve(by);

        int lx = bx.length();
        int ly = by.length();

        int max = Integer.max(lx, ly);

        int sumx = 0;
        int sumy = 0;

        for (int i = 0; i < 12; i++) {
            if (i < lx)
                sumx += (int) bx.charAt(i) == 49 ? 1 : 0;
            if (i < ly)
                sumy += (int) by.charAt(i) == 49 ? 1 : 0;

            int cax = i < lx ? bx.charAt(i) : 48;
            int cay = i < ly ? by.charAt(i) : 48;

            if (sumx == sumy && cax == cay) {
                return false;
            }
        }

        return true;
    }


    private String reserve(String s) {
        char[] oc = s.toCharArray();
        char[] nc = new char[oc.length];

        for (int i = 0; i < oc.length; i++) {
            nc[oc.length - i - 1] = oc[i];
        }
        return String.valueOf(nc);
    }


}
