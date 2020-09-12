package ru.plot.utils;


import java.util.Collection;

/**
 * Различные утилиты
 */
public class CommonUtils {

    private CommonUtils() {
    }

    private static boolean isNull(Object o) {
        return o == null;
    }

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public static boolean isNotEmpty(String s) {
        return s != null && !s.isEmpty();
    }

    public static boolean isNullOrEmpty(Collection<?> coll) {
        return coll == null || coll.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> coll) {
        return coll != null && !coll.isEmpty();
    }

    public static String nullSafe (String str) {
        return (str == null) ? "" : str;
    }
}
