package com.unpri.charactermanager.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class AppTheme {

    public static final Color BACKGROUND =
            new Color(20, 27, 45);

    public static final Color PANEL =
            new Color(31, 41, 65);

    public static final Color CARD =
            new Color(42, 54, 80);

    public static final Color PRIMARY =
            new Color(59, 130, 246);

    public static final Color SUCCESS =
            new Color(34, 197, 94);

    public static final Color DANGER =
            new Color(239, 68, 68);

    public static final Color TEXT =
            new Color(241, 245, 249);

    public static final Color MUTED =
            new Color(156, 163, 175);

    public static final Border NORMAL_BORDER =
            BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(
                            new Color(71, 85, 105), 1
                    ),
                    BorderFactory.createEmptyBorder(
                            8, 10, 8, 10
                    )
            );

    public static final Border ERROR_BORDER =
            BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(
                            DANGER, 2
                    ),
                    BorderFactory.createEmptyBorder(
                            7, 9, 7, 9
                    )
            );

    public static Font font(int size, boolean bold) {

        return new Font(
                "Segoe UI",
                bold ? Font.BOLD : Font.PLAIN,
                size
        );
    }

    public static void styleTextField(JTextField field) {

        field.setFont(font(14, false));
        field.setForeground(TEXT);
        field.setBackground(CARD);
        field.setCaretColor(TEXT);
        field.setBorder(NORMAL_BORDER);
    }

    public static void styleButton(
            JButton button,
            Color color
    ) {

        button.setFont(font(13, true));
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setFocusPainted(false);
        button.setBorder(
                BorderFactory.createEmptyBorder(
                        11, 20, 11, 20
                )
        );
        button.setCursor(
                new java.awt.Cursor(
                        java.awt.Cursor.HAND_CURSOR
                )
        );
    }

    private AppTheme() {
    }
}