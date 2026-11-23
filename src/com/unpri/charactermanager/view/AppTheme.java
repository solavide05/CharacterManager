
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.CharacterType;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public final class AppTheme {

    private AppTheme() {
    }

    // WARNA UTAMA
    public static final Color BG_MAIN =
            new Color(19, 19, 31);

    public static final Color BG_CARD =
            new Color(32, 32, 51);

    public static final Color TEXT_MAIN =
            new Color(223, 230, 233);

    public static final Color TEXT_LIGHT =
            Color.WHITE;

    public static final Color GOLD =
            new Color(253, 203, 110);

    public static final Color WARRIOR =
            new Color(214, 48, 49);

    public static final Color MAGE =
            new Color(9, 132, 227);

    public static final Color ARCHER =
            new Color(0, 184, 148);

    public static final Color HEALER =
            new Color(162, 155, 254);

    public static final Color BORDER_COLOR =
            new Color(65, 65, 85);

    // FONT
    public static final Font FONT_TITLE =
            new Font("SansSerif", Font.BOLD, 24);

    public static final Font FONT_SUBTITLE =
            new Font("SansSerif", Font.PLAIN, 14);

    public static final Font FONT_BODY =
            new Font("SansSerif", Font.PLAIN, 14);

    public static final Font FONT_CARD_TITLE =
            new Font("SansSerif", Font.BOLD, 17);

    public static final Font FONT_MONO =
            new Font("Monospaced", Font.PLAIN, 13);

    public static final Font FONT_STAT =
            new Font("SansSerif", Font.BOLD, 18);

    // BORDER
    public static final Border MAIN_BORDER =
            BorderFactory.createEmptyBorder(22, 25, 22, 25);

    public static final Border CARD_PADDING =
            BorderFactory.createEmptyBorder(12, 14, 12, 14);

    public static final Border EMPTY_BORDER =
            BorderFactory.createEmptyBorder();

    public static final Border STAT_BORDER =
            BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(BORDER_COLOR),
                    BorderFactory.createEmptyBorder(16, 18, 16, 18)
            );

    // WARNA BERDASARKAN ROLE
    public static Color colorFor(CharacterType type) {

        if (type == null) {
            return Color.GRAY;
        }

        switch (type) {
            case WARRIOR:
                return WARRIOR;

            case MAGE:
                return MAGE;

            case ARCHER:
                return ARCHER;

            case HEALER:
                return HEALER;

            default:
                return Color.GRAY;
        }
    }

    // DESKRIPSI ROLE
    public static String describe(CharacterType type) {

        if (type == null) {
            return "Role tidak diketahui";
        }

        switch (type) {
            case WARRIOR:
                return "Petarung dengan kemampuan serangan kuat.";

            case MAGE:
                return "Pengguna sihir dengan kemampuan magis.";

            case ARCHER:
                return "Pemanah dengan serangan jarak jauh.";

            case HEALER:
                return "Karakter pendukung yang membantu pemulihan.";

            default:
                return "Role karakter tidak diketahui.";
        }
    }

    // BORDER KARTU BERDASARKAN ROLE
    public static Border cardBorder(CharacterType type) {

        return BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(
                        0, 5, 0, 0, colorFor(type)
                ),
                CARD_PADDING
        );
    }
}
