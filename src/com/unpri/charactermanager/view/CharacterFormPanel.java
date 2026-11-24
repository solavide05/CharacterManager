
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

public class CharacterFormPanel extends JPanel {

    private final CharacterManager manager;

    private final JTextField txtName;
    private final JComboBox<CharacterType> cmbRole;
    private final JSpinner spnLevel;

    private final JButton btnSave;
    private final JLabel lblMessage;

    private final Border originalNameBorder;
    private final Border originalRoleBorder;
    private final Border originalLevelBorder;

    private final Runnable onCharacterAdded;

    public CharacterFormPanel(
            CharacterManager manager,
            Runnable onCharacterAdded
    ) {

        this.manager = manager;
        this.onCharacterAdded = onCharacterAdded;

        setLayout(new BorderLayout(10, 10));
        setBackground(AppTheme.PANEL);

        setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(71, 85, 105)
                        ),
                        BorderFactory.createEmptyBorder(
                                18, 20, 18, 20
                        )
                )
        );

        // INPUT NAMA
        txtName = new JTextField(20);
        AppTheme.styleTextField(txtName);

        // INPUT ROLE
        cmbRole = new JComboBox<>(CharacterType.values());
        cmbRole.setFont(AppTheme.font(14, false));
        cmbRole.setBackground(AppTheme.CARD);
        cmbRole.setForeground(AppTheme.TEXT);

        // INPUT LEVEL
        spnLevel = new JSpinner(
                new SpinnerNumberModel(1, 1, 99, 1)
        );

        spnLevel.setFont(AppTheme.font(14, false));

        // SIMPAN BORDER ASLI
        originalNameBorder = txtName.getBorder();
        originalRoleBorder = cmbRole.getBorder();
        originalLevelBorder = spnLevel.getBorder();

        // TOMBOL SIMPAN
        btnSave = new JButton("Tambah Karakter");

        AppTheme.styleButton(
                btnSave,
                AppTheme.PRIMARY
        );

        // PESAN VALIDASI
        lblMessage = new JLabel(" ");
        lblMessage.setFont(AppTheme.font(12, true));
        lblMessage.setForeground(AppTheme.DANGER);

        buildForm();

        btnSave.addActionListener(e -> onSave());
    }

    // MEMBANGUN FORM
    private void buildForm() {

        JLabel title = new JLabel("Tambah Karakter Baru");

        title.setFont(AppTheme.font(19, true));
        title.setForeground(AppTheme.TEXT);

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(AppTheme.PANEL);
        header.add(title, BorderLayout.WEST);

        JPanel fields = new JPanel(new GridBagLayout());
        fields.setBackground(AppTheme.PANEL);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(8, 5, 8, 12);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // NAMA
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;

        fields.add(createLabel("Nama Karakter"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;

        fields.add(txtName, gbc);

        // ROLE
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;

        fields.add(createLabel("Role Karakter"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;

        fields.add(cmbRole, gbc);

        // LEVEL
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;

        fields.add(createLabel("Level"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;

        fields.add(spnLevel, gbc);

        // BAGIAN BAWAH
        JPanel bottom = new JPanel(new BorderLayout(10, 10));
        bottom.setBackground(AppTheme.PANEL);

        bottom.add(lblMessage, BorderLayout.CENTER);
        bottom.add(btnSave, BorderLayout.EAST);

        add(header, BorderLayout.NORTH);
        add(fields, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
    }

    // MEMBUAT LABEL
    private JLabel createLabel(String text) {

        JLabel label = new JLabel(text);

        label.setFont(AppTheme.font(13, true));
        label.setForeground(AppTheme.TEXT);

        return label;
    }

    // VALIDASI NAMA
    // URUTAN: KELENGKAPAN -> PANJANG -> FORMAT -> KEUNIKAN
    private String validateName(String name) {

        // 1. KELENGKAPAN
        if (name == null || name.isEmpty()) {
            return "Nama karakter wajib diisi.";
        }

        // 2. PANJANG
        if (name.length() < 2 || name.length() > 20) {
            return "Nama harus terdiri dari 2 sampai 20 karakter.";
        }

        // 3. FORMAT
        if (name.contains("  ")) {
            return "Nama tidak boleh mengandung spasi ganda.";
        }

        if (!name.matches("[\\p{L}]+(?: [\\p{L}]+)*")) {
            return "Nama hanya boleh berisi huruf dan satu spasi.";
        }

        // 4. KEUNIKAN
        if (manager.isNameTaken(name)) {
            return "Nama karakter tersebut sudah digunakan.";
        }

        return null;
    }

    // MENYIMPAN KARAKTER
    private void onSave() {

        resetValidation();

        // MEMBERSIHKAN INPUT
        String name = txtName.getText().trim();

        // VALIDASI NAMA
        String errorMessage = validateName(name);

        if (errorMessage != null) {

            showError(
                    errorMessage,
                    txtName,
                    AppTheme.ERROR_BORDER
            );

            return;
        }

        // COMMIT EDIT SPINNER
        try {

            spnLevel.commitEdit();

        } catch (ParseException ex) {

            showError(
                    "Masukkan level berupa angka yang valid.",
                    spnLevel,
                    AppTheme.ERROR_BORDER
            );

            return;
        }

        // MEMBACA ROLE
        CharacterType role;

        try {

            role = (CharacterType) cmbRole.getSelectedItem();

        } catch (ClassCastException ex) {

            showError(
                    "Pilihan role tidak valid.",
                    cmbRole,
                    AppTheme.ERROR_BORDER
            );

            return;
        }

        // MEMBACA LEVEL
        int level;

        try {

            level = ((Number) spnLevel.getValue()).intValue();

        } catch (ClassCastException ex) {

            showError(
                    "Level harus berupa angka.",
                    spnLevel,
                    AppTheme.ERROR_BORDER
            );

            return;
        }

        // MEMBUAT DAN MENYIMPAN KARAKTER
        try {

            Character character = new Character(
                    name,
                    role,
                    level
            );

            boolean added = manager.addCharacter(character);

            if (!added) {

                showError(
                        "Nama karakter tersebut sudah digunakan.",
                        txtName,
                        AppTheme.ERROR_BORDER
                );

                return;
            }

            lblMessage.setForeground(AppTheme.SUCCESS);

            lblMessage.setText(
                    "Karakter " + name + " berhasil ditambahkan!"
            );

            txtName.setText("");
            cmbRole.setSelectedIndex(0);
            spnLevel.setValue(1);

            resetBordersOnly();

            onCharacterAdded.run();

            txtName.requestFocusInWindow();

        } catch (IllegalArgumentException ex) {

            // PESAN ERROR BERASAL DARI MODEL
            showError(
                    ex.getMessage(),
                    spnLevel,
                    AppTheme.ERROR_BORDER
            );
        }
    }

    // MENAMPILKAN PESAN ERROR
    private void showError(
            String message,
            JComponent component,
            Border errorBorder
    ) {

        lblMessage.setForeground(AppTheme.DANGER);
        lblMessage.setText(message);

        component.setBorder(errorBorder);
        component.requestFocusInWindow();
    }

    // MEMULIHKAN BORDER
    private void resetBordersOnly() {

        txtName.setBorder(originalNameBorder);
        cmbRole.setBorder(originalRoleBorder);
        spnLevel.setBorder(originalLevelBorder);
    }

    private void resetValidation() {

        resetBordersOnly();

        lblMessage.setForeground(AppTheme.MUTED);
        lblMessage.setText(" ");
    }
}
