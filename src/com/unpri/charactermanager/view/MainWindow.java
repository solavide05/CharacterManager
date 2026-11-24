
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class MainWindow extends JFrame {

    private final CharacterManager manager;

    private final JPanel characterList;
    private final JLabel lblStatus;

    public MainWindow(CharacterManager manager) {

        this.manager = manager;

        setTitle("Character Manager - AP19 Sprint #6");
        setSize(1100, 750);
        setMinimumSize(new Dimension(850, 600));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(AppTheme.BACKGROUND);

        setLayout(new BorderLayout(15, 15));

        // HEADER
        JPanel header = createHeader();

        // FORM INPUT
        CharacterFormPanel formPanel =
                new CharacterFormPanel(
                        manager,
                        this::refreshList
                );

        // DAFTAR KARAKTER
        characterList = new JPanel(
                new GridLayout(0, 2, 15, 15)
        );

        characterList.setBackground(AppTheme.BACKGROUND);

        characterList.setBorder(
                BorderFactory.createEmptyBorder(
                        15, 15, 15, 15
                )
        );

        JScrollPane scroll = new JScrollPane(characterList);

        scroll.setBorder(null);

        scroll.getViewport().setBackground(
                AppTheme.BACKGROUND
        );

        scroll.setPreferredSize(
                new Dimension(650, 350)
        );

        // PANEL DAFTAR
        JPanel listPanel = new JPanel(new BorderLayout());

        listPanel.setBackground(AppTheme.BACKGROUND);

        JLabel listTitle = new JLabel("Daftar Karakter");

        listTitle.setFont(AppTheme.font(19, true));
        listTitle.setForeground(AppTheme.TEXT);

        listTitle.setBorder(
                BorderFactory.createEmptyBorder(
                        5, 15, 5, 15
                )
        );

        listPanel.add(listTitle, BorderLayout.NORTH);
        listPanel.add(scroll, BorderLayout.CENTER);

        // STATUS
        lblStatus = new JLabel();

        lblStatus.setFont(AppTheme.font(12, true));
        lblStatus.setForeground(AppTheme.MUTED);

        lblStatus.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 15, 10, 15
                )
        );

        // PANEL UTAMA
        JPanel center = new JPanel(new BorderLayout(15, 15));

        center.setBackground(AppTheme.BACKGROUND);

        center.setBorder(
                BorderFactory.createEmptyBorder(
                        0, 15, 0, 15
                )
        );

        center.add(formPanel, BorderLayout.NORTH);
        center.add(listPanel, BorderLayout.CENTER);

        add(header, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(lblStatus, BorderLayout.SOUTH);
    }

    // HEADER APLIKASI
    private JPanel createHeader() {

        JPanel header = new JPanel(new BorderLayout());

        header.setBackground(AppTheme.PANEL);

        header.setBorder(
                BorderFactory.createEmptyBorder(
                        20, 25, 20, 25
                )
        );

        JLabel title = new JLabel("CHARACTER MANAGER");

        title.setFont(AppTheme.font(25, true));
        title.setForeground(AppTheme.TEXT);

        JLabel subtitle = new JLabel(
                "AP19 - Form Input, Validasi & Analisis MVC"
        );

        subtitle.setFont(AppTheme.font(12, false));
        subtitle.setForeground(AppTheme.MUTED);

        JPanel textPanel = new JPanel(
                new GridLayout(2, 1, 0, 5)
        );

        textPanel.setBackground(AppTheme.PANEL);

        textPanel.add(title);
        textPanel.add(subtitle);

        JLabel version = new JLabel("VERSION 0.6");

        version.setFont(AppTheme.font(12, true));
        version.setForeground(AppTheme.SUCCESS);

        version.setHorizontalAlignment(
                SwingConstants.RIGHT
        );

        header.add(textPanel, BorderLayout.WEST);
        header.add(version, BorderLayout.EAST);

        return header;
    }

    // MEMPERBARUI DAFTAR KARAKTER
    public void refreshList() {

        characterList.removeAll();

        for (Character character : manager.getCharacters()) {

            characterList.add(
                    createCharacterCard(character)
            );
        }

        characterList.revalidate();
        characterList.repaint();

        lblStatus.setText(
                "Total karakter: "
                + manager.getTotalCharacters()
                + " / 20"
                + "     |     Rata-rata level: "
                + String.format(
                        "%.2f",
                        manager.getAverageLevel()
                )
        );
    }

    // MEMBUAT KARTU KARAKTER
    private JPanel createCharacterCard(Character character) {

        JPanel card = new JPanel(new BorderLayout(8, 8));

        card.setBackground(AppTheme.CARD);

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                AppTheme.PANEL
                        ),
                        BorderFactory.createEmptyBorder(
                                15, 15, 15, 15
                        )
                )
        );

        JLabel name = new JLabel(character.getName());

        name.setFont(AppTheme.font(18, true));
        name.setForeground(AppTheme.TEXT);

        JLabel role = new JLabel(
                character.getType().toString()
        );

        role.setFont(AppTheme.font(12, true));
        role.setForeground(AppTheme.SUCCESS);

        JLabel level = new JLabel(
                "Level: " + character.getLevel()
        );

        level.setFont(AppTheme.font(13, false));
        level.setForeground(AppTheme.MUTED);

        JLabel hp = new JLabel(
                "HP: " + character.getHitPoints()
        );

        hp.setFont(AppTheme.font(12, false));
        hp.setForeground(AppTheme.TEXT);

        JLabel attack = new JLabel(
                "Attack: " + character.getAttackPower()
        );

        attack.setFont(AppTheme.font(12, false));
        attack.setForeground(AppTheme.TEXT);

        JPanel info = new JPanel(
                new GridLayout(3, 1, 0, 5)
        );

        info.setBackground(AppTheme.CARD);

        info.add(role);
        info.add(level);
        info.add(hp);

        JPanel bottom = new JPanel(
                new FlowLayout(FlowLayout.LEFT, 0, 0)
        );

        bottom.setBackground(AppTheme.CARD);
        bottom.add(attack);

        card.add(name, BorderLayout.NORTH);
        card.add(info, BorderLayout.CENTER);
        card.add(bottom, BorderLayout.SOUTH);

        return card;
    }
}
