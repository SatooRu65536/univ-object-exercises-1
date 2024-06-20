package jp.ac.ait.k23075;

import java.util.HashMap;
import java.util.Map;

public class SearchRes {
    // ヒットしなかった郵便番号
    private Map<String, String> notFoundPostalCode = new HashMap<>();

    // 複数件ヒットした郵便番号
    private Map<String, String> multiPostalCode = new HashMap<>();

    // 1件だけヒットした郵便番号
    private Map<String, String> onePostalCode = new HashMap<>();

    // ヒットしなかった住所
    private Map<String, String> notFoundAddress = new HashMap<>();

    // 複数件ヒットした住所
    private Map<String, String> multiAddress = new HashMap<>();

    // 1件だけヒットした住所
    private Map<String, String> oneAddress = new HashMap<>();

    /**
     * ヒットしなかった郵便番号を取得する
     */
    public Map<String, String> getNotFoundPostalCode() {
        return notFoundPostalCode;
    }

    /**
     * ヒットしなかった郵便番号を設定する
     */
    public void putNotFoundPostalCode(String notFoundPostalCode, String searchWord) {
        this.notFoundPostalCode.put(notFoundPostalCode, searchWord);
    }

    /**
     * 複数件ヒットした郵便番号を取得する
     */
    public Map<String, String> getMultiPostalCode() {
        return multiPostalCode;
    }

    /**
     * 複数件ヒットした郵便番号を設定する
     */
    public void putMultiPostalCode(String multiPostalCode, String searchWord) {
        this.multiPostalCode.put(multiPostalCode, searchWord);
    }

    /**
     * 1件だけヒットした郵便番号を取得する
     */
    public Map<String, String> getOnePostalCode() {
        return onePostalCode;
    }

    /**
     * 1件だけヒットした郵便番号を設定する
     */
    public void putOnePostalCode(String onePostalCode, String searchWord) {
        this.onePostalCode.put(onePostalCode, searchWord);
    }

    /**
     * ヒットしなかった住所を取得する
     */
    public Map<String, String> getNotFoundAddress() {
        return notFoundAddress;
    }

    /**
     * ヒットしなかった住所を設定する
     */
    public void putNotFoundAddress(String notFoundAddress, String searchWord) {
        this.notFoundAddress.put(notFoundAddress, searchWord);
    }

    /**
     * 複数件ヒットした住所を取得する
     */
    public Map<String, String> getMultiAddress() {
        return multiAddress;
    }

    /**
     * 複数件ヒットした住所を設定する
     */
    public void putMultiAddress(String multiAddress, String searchWord) {
        this.multiAddress.put(multiAddress, searchWord);
    }

    /**
     * 1件だけヒットした住所を取得する
     */
    public Map<String, String> getOneAddress() {
        return oneAddress;
    }

    /**
     * 1件だけヒットした住所を設定する
     */
    public void putOneAddress(String oneAddress, String searchWord) {
        this.oneAddress.put(oneAddress, searchWord);
    }
}
