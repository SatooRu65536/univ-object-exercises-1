package jp.ac.ait.k23075;

public class StringUtilities {
    public static boolean isUnsignedInteger(String val) {
        if (val == null || val.length() == 0)
            return false;
        return java.util.regex.Pattern.compile("\\A[0-9]+\\z").matcher(val).find();
    }
}
