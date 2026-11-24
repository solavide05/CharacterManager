
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.CharacterType;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public final class AppTheme {

    private AppTheme() {
        // Mencegah pembuatan objek AppTheme
    }

    // =====================================
    // WARNA UTAMA
    // =====================================

    public static final Color BG_MAIN =
            Color.decode("#151526");

    public static final Color BG_CARD =
            Color.decode("#22223a");

    public static final Color BG_STATUS =
            Color.decode("#0d0d1a");

    public static final Color GOLD =
            Color.decode("#f5c542");

    public static final Color TEXT_MAIN =
            Color.decode("#ffffff");

    public static final Color TEXT_LIGHT =
            Color.decode("#d0d0e0");

    public static final Color TEXT_MUTED =
            Color.decode("#9d9dbf");


    // =====================================
    // WARNA ROLE KARAKTER
    // =====================================

    public static final Color WARRIOR_COLOR =
            Color.decode("#e76f51");

    public static final Color MAGE_COLOR =
            Color.decode("#9b72cf");

    public static final Color ARCHER_COLOR =
            Color.decode("#55b987");

    public static final Color HEALER_COLOR =
            Color.decode("#55bde0");


    // =====================================
    // FONT
    // =====================================

    public static final Font FONT_TITLE =
            new Font("Segoe UI", Font.BOLD, 24);

    public static final Font FONT_SUBTITLE =
            new Font("Segoe UI", Font.PLAIN, 12);

    public static final Font FONT_CARD_TITLE =
            new Font("Segoe UI", Font.BOLD, 16);

    public static final Font FONT_BODY =
            new Font("Segoe UI", Font.PLAIN, 13);

    public static final Font FONT_STAT =
            new Font("Segoe UI", Font.BOLD, 18);

    public static final Font FONT_MONO =
            new Font("Consolas", Font.PLAIN, 12);


    // =====================================
    // BORDER
    // =====================================

    public static final Border MAIN_BORDER =
            BorderFactory.createEmptyBorder(
                    15, 15, 15, 15
            );

    public static final Border EMPTY_BORDER =
            BorderFactory.createEmptyBorder(
                    5, 5, 5, 5
            );

    public static final Border CARD_BORDER =
            BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(
                            Color.decode("#3a3a55"), 1
                    ),
                    BorderFactory.createEmptyBorder(
                            12, 14, 12, 14
                    )
            );

    public static final Border STAT_BORDER =
            BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(
                            GOLD, 1
                    ),
                    BorderFactory.createEmptyBorder(
                            10, 12, 10, 12
                    )
            );


    // =====================================
    // WARNA BERDASARKAN ROLE
    // =====================================

    public static Color colorFor(CharacterType type) {

        if (type == null) {
            return TEXT_MUTED;
        }

        return switch (type) {
            case WARRIOR -> WARRIOR_COLOR;
            case MAGE -> MAGE_COLOR;
            case ARCHER -> ARCHER_COLOR;
            case HEALER -> HEALER_COLOR;
        };
    }


    // =====================================
    // BORDER KARTU BERDASARKAN ROLE
    // =====================================

    public static Border cardBorder(CharacterType type) {

        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                        colorFor(type), 1
                ),
                BorderFactory.createEmptyBorder(
                        12, 14, 12, 14
                )
        );
    }


    // =====================================
    // DESKRIPSI ROLE
    // =====================================

    public static String describe(CharacterType type) {

        if (type == null) {
            return "Role tidak diketahui";
        }

        return switch (type) {
            case WARRIOR ->
                    "Petarung dengan kemampuan menyerang";

            case MAGE ->
                    "Pengguna kekuatan sihir";

            case ARCHER ->
                    "Pemanah dengan serangan jarak jauh";

            case HEALER ->
                    "Pendukung yang membantu pemulihan";
        };
    }
}
