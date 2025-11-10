package models.crypto.enums.mode;

import lombok.Getter;

@Getter
public enum AsymmetricModeEncoder {
    ECB("ECB"),
    NONE(""); // Для ECIES где нет явного режима

    private final String modeName;

    AsymmetricModeEncoder(String modeName) {
        this.modeName = modeName;
    }

    @Override
    public String toString() {
        return modeName;
    }
}