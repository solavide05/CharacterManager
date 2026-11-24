
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.EnumSet;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class MainWindow extends JFrame {

    private static final String APP_VERSION = "v0.6";
    private static final int HIGH_LEVEL_THRESHOLD = 5;

    private final CharacterManager manager;

    private JPanel cardsPanel;
    private JPanel statisticsPanel;

    private JLabel countLabel;
    private JLabel statusLabel;

    public MainWindow(CharacterManager manager) {
        super("Character Manager " + APP_VERSION);

        this.manager = manager;

        initComponents();

        pack();
        setMinimumSize(new Dimension(900, 560));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // INISIALISASI KOMPONEN
    private void initComponents() {
        getContentPane().setBackground(AppTheme.BG_MAIN);
        setLayout(new BorderLayout());

        // NORTH: HEADER DAN STATISTIK
        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.setBackground(AppTheme.BG_MAIN);

        northPanel.add(createHeaderPanel(), BorderLayout.NORTH);

        statisticsPanel = createStatisticsPanel();
        northPanel.add(statisticsPanel, BorderLayout.CENTER);

        add(northPanel, BorderLayout.NORTH);

        // WEST: FORM INPUT KARAKTER
        CharacterFormPanel formPanel =
                new CharacterFormPanel(manager, this::refreshList);

        add(formPanel, BorderLayout.WEST);

        // CENTER: DAFTAR KARAKTER
        add(createListArea(), BorderLayout.CENTER);

        // EAST: LEGENDA ROLE
        add(createLegendPanel(), BorderLayout.EAST);

        // SOUTH: STATUS BAR
        add(createStatusPanel(), BorderLayout.SOUTH);
    }

    // HEADER
    private JPanel createHeaderPanel() {
        JPanel header = new JPanel(new BorderLayout());

        header.setBackground(AppTheme.BG_MAIN);
        header.setBorder(
                BorderFactory.createEmptyBorder(16, 16, 8, 16)
        );

        JLabel title = new JLabel("CHARACTER MANAGER");
        title.setFont(AppTheme.FONT_TITLE);
        title.setForeground(AppTheme.GOLD);

        countLabel = new JLabel(
                manager.getTotalCharacters() + " karakter"
        );
        countLabel.setFont(AppTheme.FONT_BODY);
        countLabel.setForeground(AppTheme.GOLD);

        header.add(title, BorderLayout.WEST);
        header.add(countLabel, BorderLayout.EAST);

        return header;
    }

    // PANEL STATISTIK
    private JPanel createStatisticsPanel() {
        JPanel statistics = new JPanel(
                new GridLayout(2, 2, 8, 8)
        );

        statistics.setBackground(AppTheme.BG_MAIN);
        statistics.setBorder(
                BorderFactory.createEmptyBorder(4, 16, 8, 16)
        );

        updateStatisticsPanel(statistics);

        return statistics;
    }

    // MEMPERBARUI ISI STATISTIK
    private void updateStatisticsPanel(JPanel statistics) {
        statistics.removeAll();

        var characterList = manager.getAllCharacters();

        int total = characterList.size();
        int totalLevel = 0;
        int highestLevel = 0;

        Set<CharacterType> usedRoles =
                EnumSet.noneOf(CharacterType.class);

        for (Character character : characterList) {
            totalLevel += character.getLevel();

            if (character.getLevel() > highestLevel) {
                highestLevel = character.getLevel();
            }

            usedRoles.add(character.getType());
        }

        double averageLevel = total == 0
                ? 0
                : (double) totalLevel / total;

        statistics.add(
                createStatCard(
                        "TOTAL KARAKTER",
                        String.valueOf(total)
                )
        );

        statistics.add(
                createStatCard(
                        "RATA-RATA LEVEL",
                        String.format("%.2f", averageLevel)
                )
        );

        statistics.add(
                createStatCard(
                        "LEVEL TERTINGGI",
                        String.valueOf(highestLevel)
                )
        );

        statistics.add(
                createStatCard(
                        "ROLE DIGUNAKAN",
                        String.valueOf(usedRoles.size())
                )
        );
    }

    // KARTU STATISTIK
    private JPanel createStatCard(String title, String value) {
        JPanel card = new JPanel(new BorderLayout(4, 4));

        card.setBackground(AppTheme.BG_CARD);
        card.setBorder(AppTheme.CARD_BORDER);

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(AppTheme.FONT_MONO);
        titleLabel.setForeground(AppTheme.TEXT_MUTED);

        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(AppTheme.FONT_STAT);
        valueLabel.setForeground(AppTheme.GOLD);

        card.add(titleLabel, BorderLayout.NORTH);
        card.add(valueLabel, BorderLayout.CENTER);

        return card;
    }

    // DAFTAR KARAKTER
    private JScrollPane createListArea() {
        cardsPanel = new JPanel(
                new GridLayout(0, 1, 0, 8)
        );

        cardsPanel.setBackground(AppTheme.BG_MAIN);

        refreshCards();

        JPanel holder = new JPanel(new BorderLayout());
        holder.setBackground(AppTheme.BG_MAIN);
        holder.setBorder(
                BorderFactory.createEmptyBorder(8, 16, 8, 8)
        );

        holder.add(cardsPanel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(holder);
        scrollPane.setBorder(AppTheme.EMPTY_BORDER);
        scrollPane.getViewport().setBackground(AppTheme.BG_MAIN);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setPreferredSize(new Dimension(460, 280));

        return scrollPane;
    }

    // MEMBUAT ULANG KARTU KARAKTER
    private void refreshCards() {
        cardsPanel.removeAll();

        for (Character character : manager.getAllCharacters()) {
            cardsPanel.add(createCharacterCard(character));
        }
    }

    // MEMPERBARUI SELURUH TAMPILAN SETELAH INPUT
    private void refreshList() {
        refreshCards();

        updateStatisticsPanel(statisticsPanel);

        countLabel.setText(
                manager.getTotalCharacters() + " karakter"
        );

        statusLabel.setText(
                "Total: " + manager.getTotalCharacters()
                + " karakter | Daftar diperbarui"
        );

        cardsPanel.revalidate();
        cardsPanel.repaint();

        statisticsPanel.revalidate();
        statisticsPanel.repaint();
    }

    // KARTU KARAKTER
    private JPanel createCharacterCard(Character character) {
        JPanel card = new JPanel(new BorderLayout(12, 5));

        card.setBackground(AppTheme.BG_CARD);
        card.setBorder(
                AppTheme.cardBorder(character.getType())
        );

        card.setPreferredSize(new Dimension(650, 85));
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 90));

        JLabel nameLabel = new JLabel(character.getName());
        nameLabel.setFont(AppTheme.FONT_BODY);
        nameLabel.setForeground(AppTheme.TEXT_LIGHT);

        if (character.getLevel() >= HIGH_LEVEL_THRESHOLD) {
            nameLabel.setForeground(AppTheme.GOLD);
            nameLabel.setFont(
                    nameLabel.getFont().deriveFont(Font.BOLD)
            );
        }

        JLabel typeLabel = new JLabel(
                "Tipe: " + character.getType()
        );
        typeLabel.setFont(AppTheme.FONT_BODY);
        typeLabel.setForeground(
                AppTheme.colorFor(character.getType())
        );

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(
                new BoxLayout(leftPanel, BoxLayout.Y_AXIS)
        );
        leftPanel.setOpaque(false);

        leftPanel.add(nameLabel);
        leftPanel.add(Box.createVerticalStrut(5));
        leftPanel.add(typeLabel);

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
        detailLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        String tooltip =
                character.getName()
                + " | Level: " + character.getLevel()
                + " | HP: " + character.getHitPoints()
                + " | ATK: " + character.getAttackPower();

        card.setToolTipText(tooltip);
        nameLabel.setToolTipText(tooltip);

        typeLabel.setToolTipText(
                AppTheme.describe(character.getType())
        );

        card.getAccessibleContext().setAccessibleDescription(
                "Karakter " + character.getName()
                + ", role " + character.getType()
                + ", level " + character.getLevel()
        );

        card.add(leftPanel, BorderLayout.CENTER);
        card.add(detailLabel, BorderLayout.EAST);

        return card;
    }

    // LEGENDA ROLE
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

    // STATUS BAR
    private JPanel createStatusPanel() {
        JPanel status = new JPanel(new BorderLayout());

        status.setBackground(AppTheme.BG_STATUS);
        status.setBorder(
                BorderFactory.createEmptyBorder(6, 16, 6, 16)
        );

        statusLabel = new JLabel(
                "Total: " + manager.getTotalCharacters()
                + " karakter | Siap"
        );
        statusLabel.setFont(AppTheme.FONT_MONO);
        statusLabel.setForeground(AppTheme.TEXT_MUTED);

        JLabel versionLabel = new JLabel(APP_VERSION);
        versionLabel.setFont(AppTheme.FONT_MONO);
        versionLabel.setForeground(AppTheme.TEXT_MUTED);

        status.add(statusLabel, BorderLayout.WEST);
        status.add(versionLabel, BorderLayout.EAST);

        return status;
    }
}
