package com.example.demo.shell;

import java.util.List;
import java.util.Map;

public class CommonUtil {

    // 매개변수 객체 empty를 체크하는 함수
    public static boolean isEmpty(Object obj) {
        if (obj == null) { return true; }

        if ((obj instanceof String) && (((String)obj).trim().length() == 0)) { return true; }
        if (obj instanceof Map) { return ((Map<?, ?>)obj).isEmpty(); }
        if (obj instanceof List) { return ((List<?>)obj).isEmpty(); }
        if (obj instanceof Object[]) { return (((Object[])obj).length == 0); }

        return false;
    }

    // Long 타입의 두 객체가 같은지를 체크하는 함수
    public static boolean isEqual(Long value1, Long value2) {
        if(value1 == null || value2 == null) return false;
        if(value1.compareTo(value2) == 0) return true;
        return false;
    }
}
