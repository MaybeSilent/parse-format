package com.github.maybesilent.parseformat.formatter;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormatInfo {

    public FormatInfo(String text) {
        this.formatContent = text;
    }

    public enum FormatType {
        SQL,
        JSON,
        JSON_AND_SQL,
        UNKNOWN
    }

    private FormatType formatType;

    private String formatContent;

    /**
     * is text changed
     */
    private Boolean isFormat;
}
