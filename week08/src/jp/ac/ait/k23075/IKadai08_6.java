package jp.ac.ait.k23075;

import java.util.Map;

public interface IKadai08_6 {
    Map<String, String> searchByCode(String postalCode);

    Map<String, String> searchByAddress(String addressText);
}
