package com.company;

import java.util.HashMap;

public class LeetCodeStreak {
    public static void main(String[] args) {
        TimeMap map = new TimeMap();
        map.set("foo", "bar", 1);
        System.out.println(map.get("foo", 1));
        System.out.println(map.get("foo", 2));
        System.out.println(map.get("foo", 5));
        map.set("foo", "bar2", 3);
        System.out.println(map.get("foo", 5));
    }
}

class TimeMap {
    HashMap<String, HashMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new HashMap<>());
        }
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        while (timestamp > 0) {
            if (map.get(key).containsKey(timestamp)) return map.get(key).get(timestamp);
            timestamp--;
        }
        return "";
    }
}
