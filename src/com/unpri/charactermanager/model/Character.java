
package com.unpri.charactermanager.model;

import java.util.Objects;

/**
 * Class Character untuk menyimpan data karakter.
 */
public class Character {

    private int id;
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    private int mana;

    public Character(String name, CharacterType type, int level) {
        if (level < 1) {
            throw new IllegalArgumentException("Level minimal 1");
        }

        this.id = 0;
        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = calculateBaseHP();
        this.attackPower = calculateBaseAttack();
        this.mana = 0;
    }

    public Character(
            int id,
            String name,
            CharacterType type,
            int level,
            int hitPoints,
            int attackPower
    ) {
        if (level < 1) {
            throw new IllegalArgumentException("Level minimal 1");
        }

        this.id = id;
        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = hitPoints;
        this.attackPower = attackPower;
        this.mana = 0;
    }

    private int calculateBaseHP() {
        return 100 + (level * 10);
    }

    private int calculateBaseAttack() {
        return 10 + (level * 5);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CharacterType getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getMana() {
        return mana;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException("Level minimal 1");
        }

        this.level = level;
        this.hitPoints = calculateBaseHP();
        this.attackPower = calculateBaseAttack();
    }

    public void setHitPoints(int hitPoints) {
        if (hitPoints < 0) {
            throw new IllegalArgumentException(
                    "Hit Points tidak boleh negatif"
            );
        }

        this.hitPoints = hitPoints;
    }

    public void setAttackPower(int attackPower) {
        if (attackPower < 0) {
            throw new IllegalArgumentException(
                    "Attack Power tidak boleh negatif"
            );
        }

        this.attackPower = attackPower;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException(
                    "Mana tidak boleh negatif"
            );
        }

        this.mana = mana;
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

    /**
     * Membandingkan dua karakter berdasarkan nama.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Character)) {
            return false;
        }

        Character other = (Character) obj;

        return Objects.equals(this.name, other.name);
    }

    /**
     * hashCode dibuat konsisten dengan equals.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Character{id=" + id
                + ", name='" + name + '\''
                + ", type=" + type
                + ", level=" + level
                + ", hp=" + hitPoints
                + ", atk=" + attackPower
                + ", mana=" + mana
                + '}';
    }
}
