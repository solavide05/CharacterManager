
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainWindow extends JFrame {

    private final ArrayList<Character> characterList;
    private final double averageLevel;

    public MainWindow(ArrayList<Character> characterList,
                      double averageLevel) {

        super("Character Manager v0.4");

        this.characterList = characterList;
        this.averageLevel = averageLevel;

        initComponents();

        setSize(760, 620);
        setMinimumSize(new Dimension(600, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        JPanel mainPanel = new JPanel(new BorderLayout(0, 18));
        mainPanel.setBackground(AppTheme.BG_MAIN);
        mainPanel.setBorder(new EmptyBorder(22, 25, 22, 25));

        // HEADER
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(
                new BoxLayout(headerPanel, BoxLayout.Y_AXIS)
        );
        headerPanel.setBackground(AppTheme.BG_MAIN);
        headerPanel.setBorder(new EmptyBorder(10, 5, 12, 5));

        JLabel titleLabel = new JLabel("CHARACTER MANAGER");
        titleLabel.setFont(AppTheme.FONT_TITLE);
        titleLabel.setForeground(AppTheme.GOLD);

        JLabel subtitleLabel = new JLabel(
                "Dashboard Data Karakter - Sprint #4"
        );
        subtitleLabel.setFont(AppTheme.FONT_BODY);
        subtitleLabel.setForeground(AppTheme.TEXT_MAIN);

        headerPanel.add(titleLabel);
        headerPanel.add(Box.createVerticalStrut(7));
        headerPanel.add(subtitleLabel);

        // DAFTAR KARAKTER
        JPanel listPanel = new JPanel();
        listPanel.setLayout(
                new BoxLayout(listPanel, BoxLayout.Y_AXIS)
        );
        listPanel.setBackground(AppTheme.BG_MAIN);

        JLabel listTitle = new JLabel(
                "DAFTAR KARAKTER (" + characterList.size() + ")"
        );
        listTitle.setFont(new Font("SansSerif", Font.BOLD, 17));
        listTitle.setForeground(AppTheme.TEXT_LIGHT);

        listPanel.add(listTitle);
        listPanel.add(Box.createVerticalStrut(15));

        for (Character character : characterList) {
            listPanel.add(createCharacterCard(character));
            listPanel.add(Box.createVerticalStrut(12));
        }

        JScrollPane scrollPane = new JScrollPane(listPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setBackground(AppTheme.BG_MAIN);
        scrollPane.getViewport().setBackground(AppTheme.BG_MAIN);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        // STATISTIK
        JPanel statisticsPanel = new JPanel(new BorderLayout());
        statisticsPanel.setBackground(new Color(32, 32, 51));
        statisticsPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(65, 65, 85)
                        ),
                        new EmptyBorder(16, 18, 16, 18)
                )
        );

        JLabel statisticsLabel = new JLabel(
                "RATA-RATA LEVEL     "
                + String.format("%.2f", averageLevel)
        );
        statisticsLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        statisticsLabel.setForeground(AppTheme.GOLD);

        JLabel footerLabel = new JLabel(
                "Statistik dihitung dari seluruh karakter"
        );
        footerLabel.setFont(AppTheme.FONT_BODY);
        footerLabel.setForeground(AppTheme.TEXT_MAIN);

        JPanel statisticsContent = new JPanel();
        statisticsContent.setLayout(
                new BoxLayout(statisticsContent, BoxLayout.Y_AXIS)
        );
        statisticsContent.setOpaque(false);

        statisticsContent.add(statisticsLabel);
        statisticsContent.add(Box.createVerticalStrut(6));
        statisticsContent.add(footerLabel);

        statisticsPanel.add(statisticsContent, BorderLayout.CENTER);

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(statisticsPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }

    private JPanel createCharacterCard(Character character) {

        JPanel card = new JPanel(new BorderLayout(12, 5));
        card.setBackground(new Color(32, 32, 51));

        Color roleColor = AppTheme.colorFor(character.getType());

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(
                                0, 4, 0, 0, roleColor
                        ),
                        AppTheme.CARD_BORDER
                )
        );

        card.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 90)
        );
        card.setPreferredSize(new Dimension(650, 80));

        // NAMA KARAKTER
        JLabel nameLabel = new JLabel(character.getName());
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 17));
        nameLabel.setForeground(AppTheme.TEXT_LIGHT);

        // TIPE KARAKTER
        JLabel typeLabel = new JLabel(
                "Tipe: " + character.getType()
        );
        typeLabel.setFont(AppTheme.FONT_BODY);
        typeLabel.setForeground(roleColor);

        typeLabel.setToolTipText(
                AppTheme.describe(character.getType())
        );

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

        // MINI CHALLENGE: LEVEL 7 KE ATAS
        if (character.getLevel() >= 7) {
            nameLabel.setForeground(AppTheme.GOLD);
            nameLabel.setFont(
                    new Font("SansSerif", Font.BOLD, 19)
            );
            nameLabel.setToolTipText("Karakter level tinggi!");
        }

        card.setToolTipText(
                AppTheme.describe(character.getType())
        );

        card.add(leftPanel, BorderLayout.CENTER);
        card.add(detailLabel, BorderLayout.EAST);

        return card;
    }
}
