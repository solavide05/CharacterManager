
package com.unpri.charactermanager.model;

import java.util.ArrayList;

public class CharacterManager {

    private final ArrayList<Character> characterList;

    public CharacterManager() {
        characterList = new ArrayList<>();
    }

    // Menambahkan karakter dan menolak nama duplikat
    public boolean addCharacter(Character character) {

        if (character == null) {
            return false;
        }

        if (findByName(character.getName()) != null) {
            System.out.println(
                    "Karakter " + character.getName()
                    + " sudah ada. Penambahan ditolak."
            );
            return false;
        }

        characterList.add(character);

        System.out.println(
                "Karakter " + character.getName()
                + " berhasil ditambahkan."
        );

        return true;
    }

    // Mencari karakter berdasarkan nama
    public Character findByName(String name) {

        if (name == null) {
            return null;
        }

        for (Character character : characterList) {
            if (character.getName().equals(name)) {
                return character;
            }
        }

        return null;
    }

    // Menghapus karakter berdasarkan nama
    public boolean removeCharacter(String name) {

        Character character = findByName(name);

        if (character == null) {
            System.out.println(
                    "Karakter " + name + " tidak ditemukan."
            );
            return false;
        }

        characterList.remove(character);

        System.out.println(
                "Karakter " + name + " berhasil dihapus."
        );

        return true;
    }

    // Menghitung jumlah karakter
    public int getTotalCharacters() {
        return characterList.size();
    }

    // Mengembalikan salinan daftar karakter
    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characterList);
    }

    // Menghitung rata-rata level karakter
    public double getAverageLevel() {

        if (characterList.isEmpty()) {
            return 0.0;
        }

        int totalLevel = 0;

        for (Character character : characterList) {
            totalLevel += character.getLevel();
        }

        return (double) totalLevel / characterList.size();
    }

    // Mencari karakter berdasarkan tipe
    public ArrayList<Character> findByType(CharacterType type) {

        ArrayList<Character> result = new ArrayList<>();

        if (type == null) {
            return result;
        }

        for (Character character : characterList) {
            if (character.getType() == type) {
                result.add(character);
            }
        }

        return result;
    }

    // Mencari karakter dengan attack power tertinggi
    public Character findStrongest() {

        if (characterList.isEmpty()) {
            return null;
        }

        Character strongest = characterList.get(0);

        for (Character character : characterList) {

            if (character.getAttackPower()
                    > strongest.getAttackPower()) {
                strongest = character;
            }
        }

        return strongest;
    }
}
