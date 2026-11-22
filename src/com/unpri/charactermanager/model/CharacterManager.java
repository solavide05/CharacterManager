
package com.unpri.charactermanager.model;

import java.util.ArrayList;

public class CharacterManager {

    private final ArrayList<Character> characterList;

    public CharacterManager() {
        characterList = new ArrayList<>();
    }

    // Menambahkan karakter dan mencegah duplikat nama
    public boolean addCharacter(Character character) {
        if (character == null) {
            return false;
        }

        if (findByName(character.getName()) != null) {
            System.out.println("Karakter " + character.getName()
                    + " sudah ada. Tidak dapat ditambahkan.");
            return false;
        }

        characterList.add(character);
        System.out.println("Karakter " + character.getName()
                + " berhasil ditambahkan.");
        return true;
    }

    // Mencari karakter berdasarkan nama
    public Character findByName(String name) {
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
            System.out.println("Karakter " + name + " tidak ditemukan.");
            return false;
        }

        characterList.remove(character);
        System.out.println("Karakter " + name + " berhasil dihapus.");
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

    // MINI CHALLENGE 1: Menghitung rata-rata level
    public double getAverageLevel() {
        if (characterList.isEmpty()) {
            return 0;
        }

        int totalLevel = 0;

        for (Character character : characterList) {
            totalLevel += character.getLevel();
        }

        return (double) totalLevel / characterList.size();
    }

    // MINI CHALLENGE 2: Mencari karakter berdasarkan tipe
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
}
