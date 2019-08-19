package com.philcoding.blog.util;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

/**
 * Utility class for hashing.
 *
 * @author bigo
 */
public class HashUtil {

    private static final Pattern PATTERN_SHA1 = Pattern.compile("^[a-f0-9]{40}$");
    private static final Pattern PATTERN_SHA256 = Pattern.compile("^[a-f0-9]{64}$");

    public static boolean isSha1(String s) {
        return PATTERN_SHA1.matcher(s).matches();
    }

    public static boolean isSha256(String s) {
        return PATTERN_SHA256.matcher(s).matches();
    }

    /**
     * Generate SHA-1 as hex string (all lower-case).
     *
     * @param input Input as string.
     * @return Hex string.
     */
    public static String sha1(String input) {
        return sha1(input.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Generate SHA-1 as hex string (all lower-case).
     *
     * @param input Input as bytes.
     * @return Hex string.
     */
    public static String sha1(byte[] input) {
        byte[] digest = messageDigest(input, "SHA1");
        return ByteUtil.toHexString(digest);
    }

    /**
     * Generate SHA-1 as hex string (all lower-case).
     *
     * @param input Input as String.
     * @return byte[] as result.
     */
    public static byte[] sha1AsBytes(String input) {
        return sha1AsBytes(input.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Generate SHA-1 as bytes.
     *
     * @param input Input as bytes.
     * @return byte[] as result.
     */
    public static byte[] sha1AsBytes(byte[] input) {
        return messageDigest(input, "SHA1");
    }

    /**
     * Generate SHA-256 as hex string (all lower-case).
     *
     * @param input Input as String.
     * @return Hex string.
     */
    public static String sha256(String input) {
        return sha256(input.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Generate SHA-256 as hex string (all lower-case).
     *
     * @param input Input as bytes.
     * @return Hex string.
     */
    public static String sha256(byte[] input) {
        byte[] digest = messageDigest(input, "SHA-256");
        return ByteUtil.toHexString(digest);
    }

    /**
     * Generate SHA-256 as hex string (all lower-case).
     *
     * @param input Input as String.
     * @return byte[] as result.
     */
    public static byte[] sha256AsBytes(String input) {
        return sha256AsBytes(input.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Generate SHA-256 as bytes.
     *
     * @param input Input as bytes.
     * @return byte[] as result.
     */
    public static byte[] sha256AsBytes(byte[] input) {
        return messageDigest(input, "SHA-256");
    }

    /**
     * Do HMAC-SHA256.
     *
     * @return Hex string.
     */
    public static String hmacSha256(String data, String key) {
        return hmacSha256(data.getBytes(StandardCharsets.UTF_8), key.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Do HMAC-SHA256.
     *
     * @return Hex string.
     */
    public static String hmacSha256(byte[] data, byte[] key) {
        return ByteUtil.toHexString(hmacSha256AsBytes(data, key));
    }

    /**
     * Do HMAC-SHA256.
     *
     * @return byte[] as result.
     */
    public static byte[] hmacSha256AsBytes(String data, String key) {
        return hmacSha256AsBytes(data.getBytes(StandardCharsets.UTF_8), key.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Do HMAC-SHA256.
     *
     * @return byte[] as result.
     */
    public static byte[] hmacSha256AsBytes(byte[] data, byte[] key) {
        return hmac(data, key, "HmacSHA256");
    }

    private static byte[] messageDigest(byte[] input, String algorithm) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        md.update(input);

        return md.digest();
    }

    private static byte[] hmac(byte[] data, byte[] key, String algorithm) {

        SecretKey skey = new SecretKeySpec(key, algorithm);
        Mac mac;
        try {
            mac = Mac.getInstance(algorithm);
            mac.init(skey);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
        mac.update(data);

        return mac.doFinal();
    }
}
