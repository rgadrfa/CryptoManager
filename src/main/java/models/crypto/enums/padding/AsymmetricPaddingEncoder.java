package models.crypto.enums.padding;

import lombok.Getter;

@Getter
public enum AsymmetricPaddingEncoder {
    NoPadding("NoPadding"),
    PKCS1Padding("PKCS1Padding"),
    OAEPWithSHA1AndMGF1Padding("OAEPWithSHA-1AndMGF1Padding"),
    OAEPWithSHA256AndMGF1Padding("OAEPWithSHA-256AndMGF1Padding"),
    OAEPWithSHA384AndMGF1Padding("OAEPWithSHA-384AndMGF1Padding"),
    OAEPWithSHA512AndMGF1Padding("OAEPWithSHA-512AndMGF1Padding");

    private final String paddingName;

    AsymmetricPaddingEncoder(String paddingName) {
        this.paddingName = paddingName;
    }
}