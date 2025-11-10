package models.crypto.enums.padding;

import lombok.Getter;

@Getter
public enum SymmetricPaddingEncoder {
    NoPadding("NoPadding"),
    PKCS5Padding("PKCS5Padding"),
    PKCS7Padding("PKCS7Padding"),
    ISO10126Padding("ISO10126Padding");

    private final String paddingName;

    SymmetricPaddingEncoder(String paddingName) {
        this.paddingName = paddingName;
    }
}
