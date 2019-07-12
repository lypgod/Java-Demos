package com.lypgod.test.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CollectionsSortOrder {
    private static void initCollection(Collection<String> collection) {
        collection.add("ewdefwfwe");
        collection.add("uykjuyk");
        collection.add("iop;iooi");
        collection.add("xcvcxvxc");
        collection.add("wthrb uts");
    }

    public static void main(String[] args) {
        Collection<String> collection = new HashSet<>();
        initCollection(collection);
        for (String s : collection) {
            System.out.println(s);
        }
        System.out.println();

        Map<String, String> map = new HashMap<>();
        map.put("ewdefwfwe", "ewdefwfwe");
        map.put("uykjuyk", "uykjuyk");
        map.put("iop;iooi", "iop;iooi");
        map.put("xcvcxvxc", "xcvcxvxc");
        map.put("wthrb uts", "wthrb uts");
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            System.out.println(stringStringEntry.getKey());
        }
    }
}
