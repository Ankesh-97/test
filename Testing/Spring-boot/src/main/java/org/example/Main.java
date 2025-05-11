package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Main {

    private static final Pattern LINK_PATTERN = Pattern.compile("<a\\s+[^>]*href=[\"']([^\"']+)[\"'][^>]*>(.*?)<\\/a>", Pattern.CASE_INSENSITIVE);
    private static final Pattern TOKEN_PATTERN = Pattern.compile("\\{\\{([^\\}\\}]*)\\}\\}", Pattern.CASE_INSENSITIVE);
    private static final Pattern BOLD_PATTERN = Pattern.compile("<b>([^<\\/b>]*)<\\/b>", Pattern.CASE_INSENSITIVE);
    private static final Pattern UNDERLINE_PATTERN = Pattern.compile("<u>([^<\\/u>]*)<\\/u>", Pattern.CASE_INSENSITIVE);
    private static final Pattern BR_PATTERN = Pattern.compile("<br\\s*\\/?>", Pattern.CASE_INSENSITIVE);


    public static void main(String[] args) {

        Map<String, Object> elementData = new HashMap<>();
        int index = 0;
        //String line = " {{company_name}} System Approvals.";
        String line = " Participant : {{participant}}";
        elementData.put("startIndex", index);

        elementData.put("type", "text");

        StringBuilder content = new StringBuilder();
        for (int currentIndex = index; currentIndex < line.length(); currentIndex++) {
            if (isPlainText(line, currentIndex)) {
                content.append(line.charAt(currentIndex));
            } else {
                break;
            }
            elementData.put("endIndex", currentIndex);
        }
        elementData.put("content", content.toString());
    }

    public static boolean isPlainText(String line, int index) {
        return !isToken(line, index) && !isLink(line, index) && !isBold(line, index) && !isUnderline(line, index);
    }

    public static boolean isToken(String line, int index) {
        return line.length() > index + 1 && line.substring(index, index + 2).equals("{{") && line.substring(index).matches(TOKEN_PATTERN.pattern());
    }

    public static boolean isLink(String line, int index) {
        return line.length() > index + 2 && line.substring(index, index + 3).equals("<a ") && line.substring(index).matches(LINK_PATTERN.pattern());
    }

    public static boolean isBold(String line, int index) {
        return line.length() > index + 3 && line.substring(index, index + 3).equals("<b>") && line.substring(index).matches(BOLD_PATTERN.pattern());
    }

    public static boolean isUnderline(String line, int index) {
        return line.length() > index + 3 && line.substring(index, index + 3).equals("<u>") && line.substring(index).matches(UNDERLINE_PATTERN.pattern());
    }

    public static boolean isBr(String line, int index) {
        return line.length() > index + 4 && line.substring(index, index + 5).equals("<br/>") && line.substring(index).matches(BR_PATTERN.pattern());
    }


}
