package DTO;

public enum Charsets {
	
    BIG5("big5"),
    DEC8("dec8"),
    CP850("cp850"),
    HP8("hp8"),
    KOI8R("koi8r"),
    LATIN1("latin1"),
    LATIN2("latin2"),
    SWE7("swe7"),
    ASCII("ascii"),
    UJIS("ujis"),
    SJIS("sjis"),
    HEBREW("hebrew"),
    TIS620("tis620"),
    EUCKR("euckr"),
    KOI8U("koi8u"),
    GB2312("gb2312"),
    GREEK("greek"),
    CP1250("cp1250"),
    GBK("gbk"),
    LATIN5("latin5"),
    ARMSCII8("armscii8"),
    UTF8("utf8"),
    UCS2("ucs2"),
    CP866("cp866"),
    KEYBCS2("keybcs2"),
    MACCE("macce"),
    MACROMAN("macroman"),
    CP852("cp852"),
    LATIN7("latin7"),
    UTF8MB4("utf8mb4"),
    CP1251("cp1251"),
    UTF16("utf16"),
    UTF16LE("utf16le"),
    CP1256("cp1256"),
    CP1257("cp1257"),
    UTF32("utf32"),
    BINARY("binary"),
    GEOSTD8("geostd8"),
    CP932("cp932"),
    EUCJPMS("eucjpms");

    private final String charsetName;

    Charsets(String charsetName) {
        this.charsetName = charsetName;
    }

    public String getCharsetName() {
        return charsetName;
    }
}
