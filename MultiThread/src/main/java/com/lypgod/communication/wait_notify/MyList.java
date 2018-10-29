package com.lypgod.communication.wait_notify;

import java.util.ArrayList;
import java.util.List;

/**
 * @author richard
 */
class MyList {
    private static List<String> list = new ArrayList<>();

    static void add() {
        list.add("一个元素");
    }

    static int size() {
        return list.size();
    }
}
