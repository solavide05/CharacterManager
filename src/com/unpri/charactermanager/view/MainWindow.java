
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainWindow extends JFrame {

    private final ArrayList<Character> characterList;
    private final double averageLevel;

    private final Color backgroundColor = new Color(245, 247, 250);
    private final Color primaryColor = new Color(35, 55, 85);
    private final Color accentColor = new Color(52, 120, 190);

    public MainWindow(ArrayList<Character> characterList,
                      double averageLevel) {

        super("Character Manager | TP8 Sprint #3");

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
        mainPanel.setBackground(backgroundColor);
        mainPanel.setBorder(new EmptyBorder(22, 25, 22, 25));

        // HEADER
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(
                new BoxLayout(headerPanel, BoxLayout.Y_AXIS)
        );
        headerPanel.setBackground(primaryColor);
        headerPanel.setBorder(new EmptyBorder(20, 22, 20, 22));

        JLabel titleLabel = new JLabel("CHARACTER MANAGER");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);

        JLabel subtitleLabel = new JLabel(
                "Dashboard Data Karakter - TP8 Sprint #3"
        );
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        subtitleLabel.setForeground(new Color(220, 230, 245));

        headerPanel.add(titleLabel);
        headerPanel.add(Box.createVerticalStrut(7));
        headerPanel.add(subtitleLabel);

        // DAFTAR KARAKTER
        JPanel listPanel = new JPanel();
        listPanel.setLayout(
                new BoxLayout(listPanel, BoxLayout.Y_AXIS)
        );
        listPanel.setBackground(backgroundColor);

        JLabel listTitle = new JLabel(
                "DAFTAR KARAKTER (" + characterList.size() + ")"
        );
        listTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        listTitle.setForeground(primaryColor);

        listPanel.add(listTitle);
        listPanel.add(Box.createVerticalStrut(12));

        // Menampilkan karakter secara dinamis
        for (Character character : characterList) {
            listPanel.add(createCharacterCard(character));
            listPanel.add(Box.createVerticalStrut(10));
        }

        JScrollPane scrollPane = new JScrollPane(listPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setBackground(backgroundColor);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        // STATISTIK
        JPanel statisticsPanel = new JPanel(new BorderLayout());
        statisticsPanel.setBackground(new Color(225, 239, 252));
        statisticsPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(190, 215, 240)
                        ),
                        new EmptyBorder(16, 18, 16, 18)
                )
        );

        JLabel statisticsLabel = new JLabel(
                "RATA-RATA LEVEL     "
                + String.format("%.1f", averageLevel)
        );
        statisticsLabel.setFont(
                new Font("Segoe UI", Font.BOLD, 18)
        );
        statisticsLabel.setForeground(primaryColor);

        JLabel footerLabel = new JLabel(
                "Statistik dihitung dari seluruh karakter"
        );
        footerLabel.setFont(
                new Font("Segoe UI", Font.PLAIN, 12)
        );
        footerLabel.setForeground(new Color(90, 105, 125));

        JPanel statisticsContent = new JPanel();
        statisticsContent.setLayout(
                new BoxLayout(statisticsContent, BoxLayout.Y_AXIS)
        );
        statisticsContent.setOpaque(false);

        statisticsContent.add(statisticsLabel);
        statisticsContent.add(Box.createVerticalStrut(5));
        statisticsContent.add(footerLabel);

        statisticsPanel.add(statisticsContent, BorderLayout.CENTER);

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(statisticsPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }

    private JPanel createCharacterCard(Character character) {

        JPanel card = new JPanel(new BorderLayout(12, 5));
        card.setBackground(Color.WHITE);

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(220, 226, 235)
                        ),
                        new EmptyBorder(13, 16, 13, 16)
                )
        );

        card.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 90)
        );

        JLabel nameLabel = new JLabel(character.getName());
        nameLabel.setFont(
                new Font("Segoe UI", Font.BOLD, 16)
        );
        nameLabel.setForeground(primaryColor);

        JLabel typeLabel = new JLabel(
                "Tipe: " + character.getType()
        );
        typeLabel.setFont(
                new Font("Segoe UI", Font.PLAIN, 12)
        );
        typeLabel.setForeground(accentColor);

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

        detailLabel.setFont(
                new Font("Segoe UI", Font.PLAIN, 12)
        );
        detailLabel.setForeground(new Color(65, 75, 90));

        card.add(leftPanel, BorderLayout.CENTER);
        card.add(detailLabel, BorderLayout.EAST);

        return card;
    }
}
