package com.github.maybesilent.parseformat.formatter;

import com.github.vertical_blank.sqlformatter.SqlFormatter;

import java.util.regex.Pattern;

public class SqlsFormatter {
    // judge one string contains sql
    private static final Pattern pattern = Pattern.compile("(?i)\\b(SELECT|INSERT|UPDATE|DELETE|CREATE|DROP|ALTER)\\b.*?");

    public static boolean containsSql(String text) {
        return pattern.matcher(text).matches();
    }

    public static String formatSql(String text) {
        return SqlFormatter.format(text);
    }
}
