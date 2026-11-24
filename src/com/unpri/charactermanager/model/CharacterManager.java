package com.unpri.charactermanager.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CharacterManager {

    private final List<Character> characters;

    private static final int MAX_CHARACTERS = 20;

    public CharacterManager() {
        characters = new ArrayList<>();
    }

    // MENAMBAHKAN KARAKTER
    public boolean addCharacter(Character character) {

        if (character == null) {
            throw new IllegalArgumentException(
                    "Karakter tidak boleh kosong."
            );
        }

        if (isNameTaken(character.getName())) {
            return false;
        }

        if (characters.size() >= MAX_CHARACTERS) {
            throw new IllegalArgumentException(
                    "Daftar karakter sudah mencapai batas maksimal 20."
            );
        }

        characters.add(character);

        return true;
    }

    // MEMERIKSA NAMA DUPLIKAT
    public boolean isNameTaken(String name) {

        if (name == null) {
            return false;
        }

        for (Character character : characters) {

            if (character.getName().equalsIgnoreCase(name.trim())) {
                return true;
            }
        }

        return false;
    }

    // MENCARI KARAKTER BERDASARKAN NAMA
    public Character findByName(String name) {

        if (name == null) {
            return null;
        }

        for (Character character : characters) {

            if (character.getName().equalsIgnoreCase(name.trim())) {
                return character;
            }
        }

        return null;
    }

    // MENGHAPUS KARAKTER
    public boolean removeCharacter(String name) {

        Character character = findByName(name);

        if (character != null) {
            characters.remove(character);
            return true;
        }

        return false;
    }

    // MENDAPATKAN SELURUH KARAKTER
    public List<Character> getCharacters() {

        return Collections.unmodifiableList(
                new ArrayList<>(characters)
        );
    }

    // MENGHITUNG JUMLAH KARAKTER
    public int getTotalCharacters() {
        return characters.size();
    }

    // MENGHITUNG RATA-RATA LEVEL
    public double getAverageLevel() {

        if (characters.isEmpty()) {
            return 0;
        }

        int total = 0;

        for (Character character : characters) {
            total += character.getLevel();
        }

        return (double) total / characters.size();
    }

    // MENDAPATKAN KARAKTER TERKUAT
    public Character getStrongestCharacter() {

        if (characters.isEmpty()) {
            return null;
        }

        Character strongest = characters.get(0);

        for (Character character : characters) {

            if (character.getAttackPower()
                    > strongest.getAttackPower()) {

                strongest = character;
            }
        }

        return strongest;
    }
}