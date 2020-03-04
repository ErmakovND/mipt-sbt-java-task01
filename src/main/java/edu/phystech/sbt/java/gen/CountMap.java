package edu.phystech.sbt.java.gen;

import java.util.HashMap;
import java.util.Map;

public class CountMap<T> {
    private Map<T, Integer> map;

    public CountMap() {
        map = new HashMap<>();
    }

    public void add(T o) {
        int count = map.getOrDefault(o, 0);
        map.put(o, count + 1);
    }

    public int getCount(T o) {
        return map.getOrDefault(o, 0);
    }

    public int remove(T o) {
        Integer count = map.remove(o);
        return count ==  null ? 0 : count;
    }

    public int size() {
        return map.size();
    }

    public void addAll(CountMap<T> source) {
        for (Map.Entry<T, Integer> pair : source.toMap().entrySet()) {
            T k = pair.getKey();
            int count = map.getOrDefault(k, 0);
            map.put(k, count + pair.getValue());
        }
    }

    public Map<T, Integer> toMap() {
        return map;
    }

    public void toMap(Map<T, Integer> destination) {
        destination.clear();
        destination.putAll(map);
    }
}
