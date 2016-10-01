package com.zhulinfeng.toolkit.api;

public enum CommandKeyWords {
    NEWLINE (0L, ""),
    ARG     (1L, "arg"),
    TO      (2L, "to"),
    OF      (3L, "of"),
    IN      (4L, "in"),
    AT      (5L, "at"),
    FROM    (6L, "from"),
    FOR     (7L, "for"),
    HELP    (8L, "help"),
    DISPLAY (9L, "display"),
    QUIT    (10L, "quit"),
    EXIT    (11L, "exit"),
    MAX     (12L, "max"),
    MIN     (13L, "min"),
    ADD     (14L, "add"),
    SUB     (15L, "sub"),
    LENGTH  (16L, "length"),
    VALUE   (17L, "value"),
    SIZE    (18L, "size"),
    TRUE    (19L, "true"),
    FALSE   (20L, "false"),
    INFO    (21L, "info"),
    BASIC   (22L, "basic"),
    ALL     (23L, "all"),
    TABLE   (24L, "table"),

    BOOL    (31L, "bool"),
    CHAR    (32L, "char"),
    BYTE    (33L, "byte"),
    SHORT   (34L, "short"),
    INT     (35L, "int"),
    LONG    (36L, "long"),
    FLOAT   (37L, "float"),
    DOUBLE  (38L, "double"),
    STRING  (39L, "string"),
    UNSIGNED(40L, "unsigned"),
    BINARY  (41L, "binary"),
    OCTAL   (42L, "octal"),
    DECIMAL (43L, "decimal"),
    HEX     (44L, "hex"),
    ASCII   (45L, "ascii"),
    TYPE    (46, "type"),

    IPV4(611L, "ipv4"),
    IPV6(62L, "ipv6");

    private final long commandIndex;
    private final String keyWord;

    CommandKeyWords(long commandIndex, String keyWord) {
        this.commandIndex = commandIndex;
        this.keyWord = keyWord;
    }

    public long getCommandIndex() {
        return commandIndex;
    }

    public String getKeyWord() {
        return keyWord;
    }
}