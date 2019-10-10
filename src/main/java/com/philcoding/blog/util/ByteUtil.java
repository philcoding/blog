package com.philcoding.blog.util;

/**
 * Utility class for bytes.
 *
 * @author bigo
 */
public class ByteUtil {

    private static final String HEX_STRING = "0123456789abcdef";
    private static final char[] HEX_CHARS = HEX_STRING.toCharArray();

    /**
     * Convert bytes to hex string (all lower-case).
     *
     * @param b Input bytes array.
     * @return Hex string.
     */
    public static String toHexString(byte[] b) {
        StringBuilder sb = new StringBuilder(b.length * 2);
        for (byte x : b) {
            int hi = (x & 0xf0) >> 4;
            int lo = x & 0x0f;
            sb.append(HEX_CHARS[hi]);
            sb.append(HEX_CHARS[lo]);
        }
        return sb.toString().trim();
    }

    /**
     * Convert byte to hex string (all lower-case).
     *
     * @param b Input bytes.
     * @return Hex string.
     */
    public static String toHexString(byte b) {
        int hi = (b & 0xf0) >> 4;
        int lo = b & 0x0f;
        char[] cs = {HEX_CHARS[hi], HEX_CHARS[lo]};
        return new String(cs);
    }

    public static byte toHexByte(String s) {
        if (s.length() != 2) {
            throw new IllegalArgumentException("Invalid length of string.");
        }
        char c1 = s.charAt(0);
        char c2 = s.charAt(1);
        return toHex(c1, c2);
    }

    public static byte[] toHexBytes(String s) {
        if (s.length() % 2 == 1) {
            throw new IllegalArgumentException("Invalid length of string.");
        }
        byte[] data = new byte[s.length() / 2];
        for (int i = 0; i < data.length; i++) {
            char c1 = s.charAt(i * 2);
            char c2 = s.charAt(i * 2 + 1);
            data[i] = toHex(c1, c2);
        }
        return data;
    }

    private static byte toHex(char c1, char c2) {

        int n1 = HEX_STRING.indexOf(c1);
        int n2 = HEX_STRING.indexOf(c2);
        if (n1 == (-1)) {
            throw new IllegalArgumentException("Invalid char in string: " + c1);
        }
        if (n2 == (-1)) {
            throw new IllegalArgumentException("Invalid char in string: " + c2);
        }
        int n = (n1 << 4) + n2;

        return (byte) n;
    }
}
