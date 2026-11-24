
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
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

    public MainWindow(ArrayList<Character> characterList) {

        super("Character Manager v0.5");

        this.characterList = characterList;

        initComponents();

        pack();
        setMinimumSize(new Dimension(560, 380));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        getContentPane().setBackground(AppTheme.BG_MAIN);

        setLayout(new BorderLayout());

        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createListArea(), BorderLayout.CENTER);
        add(createLegendPanel(), BorderLayout.EAST);
        add(createStatusPanel(), BorderLayout.SOUTH);
    }

    // NORTH: HEADER
    private JPanel createHeaderPanel() {

        JPanel header = new JPanel(new BorderLayout());

        header.setBackground(AppTheme.BG_MAIN);
        header.setBorder(
                BorderFactory.createEmptyBorder(16, 16, 8, 16)
        );

        JLabel title = new JLabel("CHARACTER MANAGER");

        title.setFont(AppTheme.FONT_TITLE);
        title.setForeground(AppTheme.GOLD);

        JLabel count = new JLabel(
                characterList.size() + " karakter"
        );

        count.setFont(AppTheme.FONT_BODY);
        count.setForeground(AppTheme.GOLD);

        header.add(title, BorderLayout.WEST);
        header.add(count, BorderLayout.EAST);

        return header;
    }

    // CENTER: DAFTAR KARAKTER DENGAN SCROLLPANE
    private JScrollPane createListArea() {

        JPanel cards = new JPanel(
                new GridLayout(0, 1, 0, 8)
        );

        cards.setBackground(AppTheme.BG_MAIN);

        for (Character character : characterList) {
            cards.add(createCharacterCard(character));
        }

        JPanel holder = new JPanel(new BorderLayout());

        holder.setBackground(AppTheme.BG_MAIN);
        holder.setBorder(
                BorderFactory.createEmptyBorder(8, 16, 8, 8)
        );

        holder.add(cards, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(holder);

        scrollPane.setBorder(AppTheme.EMPTY_BORDER);
        scrollPane.getViewport().setBackground(AppTheme.BG_MAIN);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setPreferredSize(new Dimension(460, 280));

        return scrollPane;
    }

    // KARTU KARAKTER
    private JPanel createCharacterCard(Character character) {

        JPanel card = new JPanel(
                new BorderLayout(12, 5)
        );

        card.setBackground(AppTheme.BG_CARD);
        card.setBorder(
                AppTheme.cardBorder(character.getType())
        );

        card.setPreferredSize(new Dimension(650, 85));
        card.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 90)
        );

        // NAMA KARAKTER
        JLabel nameLabel = new JLabel(character.getName());

        nameLabel.setFont(AppTheme.FONT_BODY);
        nameLabel.setForeground(AppTheme.TEXT_LIGHT);

        // LEVEL 5 KE ATAS BERWARNA EMAS DAN TEBAL
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

        // PANEL KIRI
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

        // TOOLTIP
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

        // AKSESIBILITAS
        card.getAccessibleContext().setAccessibleDescription(
                "Karakter " + character.getName()
                + ", role " + character.getType()
                + ", level " + character.getLevel()
        );

        card.add(leftPanel, BorderLayout.CENTER);
        card.add(detailLabel, BorderLayout.EAST);

        return card;
    }

    // EAST: LEGENDA ROLE
    private JPanel createLegendPanel() {

        JPanel legend = new JPanel();

        legend.setLayout(
                new BoxLayout(legend, BoxLayout.Y_AXIS)
        );

        legend.setBackground(AppTheme.BG_MAIN);
        legend.setBorder(
                BorderFactory.createEmptyBorder(8, 8, 8, 16)
        );

        JLabel heading = new JLabel("Legenda Role");

        heading.setFont(
                AppTheme.FONT_BODY.deriveFont(Font.BOLD)
        );

        heading.setForeground(AppTheme.TEXT_MAIN);
        heading.setAlignmentX(Component.LEFT_ALIGNMENT);

        legend.add(heading);
        legend.add(Box.createVerticalStrut(8));

        for (CharacterType type : CharacterType.values()) {

            JLabel chip = new JLabel(type.name());

            chip.setOpaque(true);
            chip.setBackground(AppTheme.colorFor(type));
            chip.setForeground(AppTheme.TEXT_LIGHT);
            chip.setFont(AppTheme.FONT_MONO);
            chip.setBorder(AppTheme.CARD_BORDER);
            chip.setToolTipText(AppTheme.describe(type));

            chip.setAlignmentX(Component.LEFT_ALIGNMENT);

            legend.add(chip);
            legend.add(Box.createVerticalStrut(6));
        }

        legend.add(Box.createVerticalGlue());

        return legend;
    }

    // SOUTH: STATUS BAR
    private JPanel createStatusPanel() {

        JPanel status = new JPanel(new BorderLayout());

        status.setBackground(AppTheme.BG_STATUS);
        status.setBorder(
                BorderFactory.createEmptyBorder(0, 0, 0, 16)
        );

        // STATUS DI KIRI
        JPanel leftPanel = new JPanel(
                new FlowLayout(FlowLayout.LEFT, 16, 6)
        );

        leftPanel.setBackground(AppTheme.BG_STATUS);

        JLabel statusLabel = new JLabel(
                "Total: " + characterList.size()
                + " karakter  |  Siap"
        );

        statusLabel.setFont(AppTheme.FONT_MONO);
        statusLabel.setForeground(AppTheme.TEXT_MUTED);

        leftPanel.add(statusLabel);

        // VERSI DI KANAN
        JLabel versionLabel = new JLabel(
                "Character Manager v0.5"
        );

        versionLabel.setFont(AppTheme.FONT_MONO);
        versionLabel.setForeground(AppTheme.TEXT_MUTED);

        status.add(leftPanel, BorderLayout.WEST);
        status.add(versionLabel, BorderLayout.EAST);

        return status;
    }
}
