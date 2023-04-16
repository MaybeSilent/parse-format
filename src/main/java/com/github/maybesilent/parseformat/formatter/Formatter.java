package com.github.maybesilent.parseformat.formatter;

import java.util.Objects;

public class Formatter {

    public static FormatInfo format(String text) {
        FormatInfo info = new FormatInfo(text);
        // judge sql
        if (SqlsFormatter.containsSql(text)) {
            info.setFormatType(FormatInfo.FormatType.SQL);
            text = SqlsFormatter.formatSql(text);
        }
        // judge sql
        if (JsonFormatter.containJson(text)) {
            info.setFormatType(Objects.isNull(info.getFormatType()) ? FormatInfo.FormatType.JSON :
                    FormatInfo.FormatType.JSON_AND_SQL);
            text = JsonFormatter.formatJson(text);
        }
        // set format content and format
        info.setFormatContent(text);
        boolean resSame = info.getFormatContent().equals(text);
        info.setIsFormat(!resSame);
        if (resSame) {
            info.setFormatType(FormatInfo.FormatType.UNKNOWN);
        }
        return info;
    }
}
