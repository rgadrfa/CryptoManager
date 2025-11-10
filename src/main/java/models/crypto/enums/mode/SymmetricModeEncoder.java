package models.crypto.enums.mode;

import lombok.Getter;

@Getter
public enum SymmetricModeEncoder {
    ECB("ECB"),
    CBC("CBC"),
    CFB("CFB"),
    OFB("OFB"),
    CTR("CTR"),
    GCM("GCM"),
    CCM("CCM"),
    PCBC("PCBC");

    private final String modeName;

    SymmetricModeEncoder(String modeName) {
        this.modeName = modeName;
    }

    @Override
    public String toString() {
        return modeName;
    }
}
