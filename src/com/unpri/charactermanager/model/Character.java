
package com.unpri.charactermanager.model;

import java.util.Objects;

public class Character {

    private int id;
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    private int mana;

    private static int totalCharacterCreated = 0;

    // KONSTRUKTOR UTAMA
    public Character(String name, CharacterType type, int level) {
        this(0, name, type, level,
                100 + level * 10,
                10 + level * 5);
    }

    // KONSTRUKTOR DENGAN DATA LENGKAP
    public Character(
            int id,
            String name,
            CharacterType type,
            int level,
            int hitPoints,
            int attackPower) {

        // VALIDASI NAMA
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Nama tidak boleh kosong."
            );
        }

        // VALIDASI ROLE
        if (type == null) {
            throw new IllegalArgumentException(
                    "Role wajib dipilih."
            );
        }

        // VALIDASI LEVEL
        if (level < 1 || level > 99) {
            throw new IllegalArgumentException(
                    "Level harus antara 1 sampai 99."
            );
        }

        // MINI-CHALLENGE: BATAS LEVEL MAGE
        validateMageLevel(type, level);

        this.id = id;
        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = hitPoints;
        this.attackPower = attackPower;
        this.mana = 0;

        totalCharacterCreated++;
    }

    // VALIDASI KHUSUS MAGE
    private void validateMageLevel(CharacterType type, int level) {
        if (type == CharacterType.MAGE && level > 60) {
            throw new IllegalArgumentException(
                    "Karakter dengan role MAGE maksimal memiliki level 60."
            );
        }
    }

    // GETTER DAN SETTER ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // GETTER DAN SETTER NAMA
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Nama tidak boleh kosong."
            );
        }

        this.name = name;
    }

    // GETTER DAN SETTER ROLE
    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        if (type == null) {
            throw new IllegalArgumentException(
                    "Role wajib dipilih."
            );
        }

        validateMageLevel(type, this.level);

        this.type = type;
    }

    // GETTER DAN SETTER LEVEL
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level < 1 || level > 99) {
            throw new IllegalArgumentException(
                    "Level harus antara 1 sampai 99."
            );
        }

        validateMageLevel(this.type, level);

        this.level = level;
        this.hitPoints = 100 + level * 10;
        this.attackPower = 10 + level * 5;
    }

    // GETTER DAN SETTER HP
    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    // GETTER DAN SETTER ATTACK POWER
    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    // GETTER DAN SETTER MANA
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    // STATUS KARAKTER
    public boolean isAlive() {
        return hitPoints > 0;
    }

    // TOTAL KARAKTER YANG DIBUAT
    public static int getTotalCharacterCreated() {
        return totalCharacterCreated;
    }

    // EQUALS BERDASARKAN NAMA
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Character other = (Character) obj;

        return name.equalsIgnoreCase(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase());
    }

    // TOSTRING
    @Override
    public String toString() {
        return "Character{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", type=" + type
                + ", level=" + level
                + ", hitPoints=" + hitPoints
                + ", attackPower=" + attackPower
                + ", mana=" + mana
                + '}';
    }
}
