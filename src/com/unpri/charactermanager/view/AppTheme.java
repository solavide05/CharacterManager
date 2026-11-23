
package com.unpri.charactermanager.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public final class AppTheme {

    // Warna utama aplikasi
    public static final Color BG_MAIN = Color.decode("#13131f");
    public static final Color TEXT_MAIN = Color.decode("#dfe6e9");
    public static final Color TEXT_LIGHT = Color.WHITE;
    public static final Color GOLD = Color.decode("#fdcb6e");

    // Font aplikasi
    public static final Font FONT_TITLE =
            new Font("SansSerif", Font.BOLD, 22);

    public static final Font FONT_BODY =
            new Font("SansSerif", Font.PLAIN, 14);

    public static final Font FONT_MONO =
            new Font("Monospaced", Font.PLAIN, 13);

    // Border kartu karakter
    public static final Border CARD_BORDER =
            BorderFactory.createEmptyBorder(8, 12, 8, 12);

    // Constructor privat
    private AppTheme() {
    }

    // Menentukan warna berdasarkan tipe karakter
    public static Color colorFor(Object type) {

        String characterType = String.valueOf(type);

        return switch (characterType) {
            case "WARRIOR" -> Color.decode("#d63031");
            case "MAGE" -> Color.decode("#0984e3");
            case "ARCHER" -> Color.decode("#00b894");
            default -> Color.GRAY;
        };
    }

    // Memberikan deskripsi tipe karakter
    public static String describe(Object type) {

        String characterType = String.valueOf(type);

        return switch (characterType) {
            case "WARRIOR" -> "Warrior: jarak dekat, HP tinggi";
            case "MAGE" -> "Mage: serangan sihir, HP rendah";
            case "ARCHER" -> "Archer: jarak jauh, seimbang";
            default -> "Role belum terdaftar";
        };
    }
}
