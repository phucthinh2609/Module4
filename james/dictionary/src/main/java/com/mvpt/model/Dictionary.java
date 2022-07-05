package com.mvpt.model;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    Map<String, String> result = new HashMap<>();

    public Dictionary() {
        result.put("hello", "Xin chào");
        result.put("goobye", "Tạm biệt");
        result.put("vinh", "Buồi");
    }

    public Map<String, String> getTranslate(){
        return result;
    }
}
