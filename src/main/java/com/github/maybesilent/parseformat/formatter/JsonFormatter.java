package com.github.maybesilent.parseformat.formatter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonFormatter {
    private static final Pattern pattern = Pattern.compile("\\{.*?\\}|\\[.*?\\]");
    // GsonBuilder
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * @param text input text
     * @return judge input text contains json like {...} or [...]
     */
    public static boolean containJson(String text) {
        return pattern.matcher(text).find();
    }

    /**
     * @param text input text
     * @return format input json
     */
    public static String formatJson(String text) {
        Matcher matcher = pattern.matcher(text);

        int start = 0;
        StringBuilder result = new StringBuilder();
        try {
            while (matcher.find()) {
                // add non json string
                String nonJsonText = text.substring(start, matcher.start());
                result.append(nonJsonText);
                result.append('\n');

                // format json string
                JsonElement jsonElement = JsonParser.parseString(matcher.group());
                String formattedJson = gson.toJson(jsonElement);
                result.append(formattedJson);
                result.append('\n');
                // update start
                start  = matcher.end();
            }
        } catch (Exception e) {
            // ignore
            return text;
        }


        result.append(text.substring(start));
        return result.toString();
    }

}
