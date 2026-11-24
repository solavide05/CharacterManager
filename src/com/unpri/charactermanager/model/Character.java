package com.unpri.charactermanager.model;

import java.util.Locale;
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

        validateName(name);
        validateType(type);
        validateLevel(level);
        validateMageLevel(type, level);

        this.id = ++totalCharacterCreated;
        this.name = name.trim();
        this.type = type;
        this.level = level;

        updateStats();
    }

    // KONSTRUKTOR DENGAN DATA LENGKAP
    public Character(
            int id,
            String name,
            CharacterType type,
            int level,
            int hitPoints,
            int attackPower
    ) {

        validateName(name);
        validateType(type);
        validateLevel(level);
        validateMageLevel(type, level);

        this.id = id;
        this.name = name.trim();
        this.type = type;
        this.level = level;
        this.hitPoints = hitPoints;
        this.attackPower = attackPower;
        this.mana = level * 10;

        if (id > totalCharacterCreated) {
            totalCharacterCreated = id;
        }
    }

    // VALIDASI NAMA
    private void validateName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Nama karakter tidak boleh kosong."
            );
        }
    }

    // VALIDASI ROLE
    private void validateType(CharacterType type) {

        if (type == null) {
            throw new IllegalArgumentException(
                    "Role karakter harus dipilih."
            );
        }
    }

    // VALIDASI LEVEL
    private void validateLevel(int level) {

        if (level < 1 || level > 99) {
            throw new IllegalArgumentException(
                    "Level karakter harus berada di antara 1 sampai 99."
            );
        }
    }

    // MINI-CHALLENGE: MAGE MAKSIMAL LEVEL 60
    private void validateMageLevel(CharacterType type, int level) {

        if (type == CharacterType.MAGE && level > 60) {
            throw new IllegalArgumentException(
                    "Karakter dengan role MAGE maksimal memiliki level 60."
            );
        }
    }

    // UPDATE STATUS KARAKTER
    private void updateStats() {

        this.hitPoints = 100 + (level * 10);
        this.attackPower = 10 + (level * 5);
        this.mana = level * 10;
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

        validateName(name);
        this.name = name.trim();
    }

    // GETTER DAN SETTER ROLE
    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {

        validateType(type);
        validateMageLevel(type, this.level);

        this.type = type;
    }

    // GETTER DAN SETTER LEVEL
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {

        validateLevel(level);
        validateMageLevel(this.type, level);

        this.level = level;
        updateStats();
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    // CEK KARAKTER MASIH HIDUP
    public boolean isAlive() {
        return hitPoints > 0;
    }

    // JUMLAH KARAKTER YANG PERNAH DIBUAT
    public static int getTotalCharacterCreated() {
        return totalCharacterCreated;
    }

    // EQUALS BERDASARKAN NAMA
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Character)) {
            return false;
        }

        Character other = (Character) obj;

        return name.equalsIgnoreCase(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase(Locale.ROOT));
    }

    @Override
    public String toString() {

        return name
                + " | "
                + type
                + " | Level "
                + level;
    }
}