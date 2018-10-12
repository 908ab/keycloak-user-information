package miyakawalab.tool.user.util;

import java.nio.charset.Charset;

public class StringCodeUtil {
    private StringCodeUtil() {
    }

    public static String encode(String str, Charset fromCode, Charset toCode) {
        return new String(str.getBytes(fromCode), toCode);
    }
}
