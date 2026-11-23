
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private final ArrayList<Character> characterList;
    private final double averageLevel;

    public MainWindow(
            ArrayList<Character> characterList,
            double averageLevel) {

        super("Character Manager v0.3");

        this.characterList = characterList;
        this.averageLevel = averageLevel;

        initComponents();

        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        mainPanel = new JPanel();

        // Judul daftar karakter
        JLabel titleLabel = new JLabel(
            "=== Daftar Karakter (" + characterList.size() + ") ==="
        );

        mainPanel.add(titleLabel);

        // Menampilkan setiap karakter
        for (Character c : characterList) {

            String info = c.getName()
                    + " | " + c.getType()
                    + " | Lv." + c.getLevel()
                    + " | HP:" + c.getHitPoints()
                    + " | ATK:" + c.getAttackPower();

            JLabel characterLabel = new JLabel(info);

            mainPanel.add(characterLabel);
        }

        // Statistik rata-rata level
        JLabel averageLabel = new JLabel(
            "Rata-rata Level: "
            + String.format("%.1f", averageLevel)
        );

        mainPanel.add(averageLabel);

        // Memasukkan panel ke JFrame
        add(mainPanel);
    }
}
