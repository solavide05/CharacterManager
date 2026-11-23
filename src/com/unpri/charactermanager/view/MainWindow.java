
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class MainWindow extends JFrame {

    private static final int HIGH_LEVEL_THRESHOLD = 5;

    private final ArrayList<Character> characterList;
    private final double averageLevel;

    public MainWindow(
            ArrayList<Character> characterList,
            double averageLevel
    ) {

        super("Character Manager v0.4");

        this.characterList = characterList;
        this.averageLevel = averageLevel;

        initComponents();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(650, 550));
        pack();
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        JPanel mainPanel = new JPanel(
                new BorderLayout(0, 18)
        );

        mainPanel.setBackground(AppTheme.BG_MAIN);
        mainPanel.setBorder(AppTheme.MAIN_BORDER);
        mainPanel.setOpaque(true);

        // HEADER
        JPanel headerPanel = new JPanel();

        headerPanel.setLayout(
                new BoxLayout(headerPanel, BoxLayout.Y_AXIS)
        );

        headerPanel.setBackground(AppTheme.BG_MAIN);
        headerPanel.setOpaque(true);

        JLabel titleLabel = new JLabel(
                "CHARACTER MANAGER"
        );

        titleLabel.setFont(AppTheme.FONT_TITLE);
        titleLabel.setForeground(AppTheme.GOLD);
        titleLabel.setOpaque(false);

        JLabel subtitleLabel = new JLabel(
                "Dashboard Karakter - TP10 Sprint #4"
        );

        subtitleLabel.setFont(AppTheme.FONT_SUBTITLE);
        subtitleLabel.setForeground(AppTheme.TEXT_MAIN);
        subtitleLabel.setOpaque(false);

        headerPanel.add(titleLabel);
        headerPanel.add(Box.createVerticalStrut(7));
        headerPanel.add(subtitleLabel);

        // DAFTAR KARAKTER
        JPanel listPanel = new JPanel();

        listPanel.setLayout(
                new BoxLayout(listPanel, BoxLayout.Y_AXIS)
        );

        listPanel.setBackground(AppTheme.BG_MAIN);
        listPanel.setOpaque(true);

        JLabel listTitle = new JLabel(
                "DAFTAR KARAKTER (" + characterList.size() + ")"
        );

        listTitle.setFont(AppTheme.FONT_CARD_TITLE);
        listTitle.setForeground(AppTheme.TEXT_LIGHT);
        listTitle.setOpaque(false);

        listPanel.add(listTitle);
        listPanel.add(Box.createVerticalStrut(15));

        for (Character character : characterList) {

            listPanel.add(createCharacterCard(character));

            listPanel.add(
                    Box.createVerticalStrut(12)
            );
        }

        JScrollPane scrollPane = new JScrollPane(listPanel);

        scrollPane.setBorder(AppTheme.EMPTY_BORDER);
        scrollPane.setBackground(AppTheme.BG_MAIN);
        scrollPane.getViewport().setBackground(AppTheme.BG_MAIN);
        scrollPane.setOpaque(true);
        scrollPane.getViewport().setOpaque(true);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        // STATISTIK
        JPanel statisticsPanel = new JPanel(
                new BorderLayout()
        );

        statisticsPanel.setBackground(AppTheme.BG_CARD);
        statisticsPanel.setBorder(AppTheme.STAT_BORDER);
        statisticsPanel.setOpaque(true);

        JLabel statisticsLabel = new JLabel(
                "RATA-RATA LEVEL     "
                + String.format("%.2f", averageLevel)
        );

        statisticsLabel.setFont(AppTheme.FONT_STAT);
        statisticsLabel.setForeground(AppTheme.GOLD);
        statisticsLabel.setOpaque(false);

        JLabel footerLabel = new JLabel(
                "Statistik dihitung dari seluruh karakter"
        );

        footerLabel.setFont(AppTheme.FONT_BODY);
        footerLabel.setForeground(AppTheme.TEXT_MAIN);
        footerLabel.setOpaque(false);

        JPanel statisticsContent = new JPanel();

        statisticsContent.setLayout(
                new BoxLayout(
                        statisticsContent,
                        BoxLayout.Y_AXIS
                )
        );

        statisticsContent.setOpaque(false);

        statisticsContent.add(statisticsLabel);
        statisticsContent.add(Box.createVerticalStrut(6));
        statisticsContent.add(footerLabel);

        statisticsPanel.add(
                statisticsContent,
                BorderLayout.CENTER
        );

        // SUSUNAN UTAMA
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(statisticsPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }

    private JPanel createCharacterCard(Character character) {

        JPanel card = new JPanel(
                new BorderLayout(12, 5)
        );

        card.setBackground(AppTheme.BG_CARD);
        card.setBorder(
                AppTheme.cardBorder(character.getType())
        );
        card.setOpaque(true);

        card.setPreferredSize(
                new Dimension(650, 85)
        );

        card.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 90)
        );

        // NAMA KARAKTER
        JLabel nameLabel = new JLabel(
                character.getName()
        );

        nameLabel.setFont(AppTheme.FONT_BODY);
        nameLabel.setForeground(AppTheme.TEXT_LIGHT);
        nameLabel.setOpaque(false);

        // MINI-CHALLENGE: LEVEL 5 KE ATAS
        if (character.getLevel() >= HIGH_LEVEL_THRESHOLD) {

            nameLabel.setForeground(AppTheme.GOLD);

            nameLabel.setFont(
                    nameLabel.getFont().deriveFont(Font.BOLD)
            );
        }

        // TIPE KARAKTER
        JLabel typeLabel = new JLabel(
                "Tipe: " + character.getType()
        );

        typeLabel.setFont(AppTheme.FONT_BODY);
        typeLabel.setForeground(
                AppTheme.colorFor(character.getType())
        );
        typeLabel.setOpaque(false);

        JPanel leftPanel = new JPanel();

        leftPanel.setLayout(
                new BoxLayout(leftPanel, BoxLayout.Y_AXIS)
        );

        leftPanel.setOpaque(false);

        leftPanel.add(nameLabel);
        leftPanel.add(Box.createVerticalStrut(5));
        leftPanel.add(typeLabel);

        // DETAIL KARAKTER
        JLabel detailLabel = new JLabel(
                "<html><div style='text-align:right;'>"
                + "LEVEL " + character.getLevel()
                + "<br>HP: " + character.getHitPoints()
                + " &nbsp; | &nbsp; ATK: "
                + character.getAttackPower()
                + "</div></html>"
        );

        detailLabel.setFont(AppTheme.FONT_MONO);
        detailLabel.setForeground(AppTheme.TEXT_MAIN);
        detailLabel.setHorizontalAlignment(
                SwingConstants.RIGHT
        );
        detailLabel.setOpaque(false);

        // PROPERTI TAMBAHAN 1: TOOLTIP
        String detailTooltip =
                character.getName()
                + " | Level: " + character.getLevel()
                + " | HP: " + character.getHitPoints()
                + " | ATK: " + character.getAttackPower();

        card.setToolTipText(detailTooltip);
        nameLabel.setToolTipText(detailTooltip);
        typeLabel.setToolTipText(
                AppTheme.describe(character.getType())
        );

        // PROPERTI TAMBAHAN 2: AKSESIBILITAS
        card.getAccessibleContext().setAccessibleDescription(
                "Karakter " + character.getName()
                + ", role " + character.getType()
                + ", level " + character.getLevel()
        );

        card.add(leftPanel, BorderLayout.CENTER);
        card.add(detailLabel, BorderLayout.EAST);

        return card;
    }
}
