
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

        System.out.println("======================================");
        System.out.println("     CHARACTER MANAGER - TP5");
        System.out.println("======================================");

        // BAGIAN A: IMPLEMENTASI CORE
        System.out.println("\n--- BAGIAN A: IMPLEMENTASI CORE ---");

        Character arjuna =
                new Character("Arjuna", CharacterType.WARRIOR, 5);

        Character merlin =
                new Character("Merlin", CharacterType.MAGE, 8);

        Character athena =
                new Character("Athena", CharacterType.ARCHER, 4);

        manager.addCharacter(arjuna);
        manager.addCharacter(merlin);
        manager.addCharacter(athena);

        // Menguji equals
        System.out.println("\n--- PENGUJIAN EQUALS ---");

        Character arjunaLain =
                new Character("Arjuna", CharacterType.HEALER, 2);

        System.out.println("Arjuna.equals(ArjunaLain): "
                + arjuna.equals(arjunaLain));

        // Menguji duplikat
        System.out.println("\n--- PENGUJIAN DUPLIKAT ---");

        manager.addCharacter(arjunaLain);

        System.out.println("Total karakter: "
                + manager.getTotalCharacters());

        // Mencari karakter
        System.out.println("\n--- PENCARIAN KARAKTER ---");

        Character hasil = manager.findByName("Merlin");

        if (hasil != null) {
            System.out.println("Karakter ditemukan: " + hasil);
        }

        // Menghapus karakter
        System.out.println("\n--- PENGHAPUSAN KARAKTER ---");

        manager.removeCharacter("Athena");

        System.out.println("Total setelah penghapusan: "
                + manager.getTotalCharacters());

        // Menampilkan daftar karakter
        System.out.println("\n--- DAFTAR KARAKTER ---");

        for (Character character : manager.getAllCharacters()) {
            System.out.println(character);
        }

        // BAGIAN B: MINI CHALLENGE
        System.out.println("\n--- BAGIAN B: MINI CHALLENGE ---");

        System.out.println("Rata-rata level: "
                + manager.getAverageLevel());

        ArrayList<Character> warriors =
                manager.findByType(CharacterType.WARRIOR);

        System.out.println("\nDaftar WARRIOR:");

        for (Character character : warriors) {
            System.out.println(character);
        }

        // BAGIAN C: FITUR ANALITIK
        System.out.println("\n--- BAGIAN C: FITUR ANALITIK ---");

        Character strongest = manager.findStrongest();

        if (strongest != null) {
            System.out.println("Karakter terkuat: "
                    + strongest.getName());

            System.out.println("Attack Power: "
                    + strongest.getAttackPower());
        }

        // BAGIAN D: EKSPERIMEN REFERENCE
        System.out.println("\n--- EKSPERIMEN REFERENCE ---");

        Character a = new Character(
                "Percobaan", CharacterType.WARRIOR, 5);

        Character b = a;

        b.setLevel(8);

        System.out.println("Level a: " + a.getLevel());
        System.out.println("Level b: " + b.getLevel());

        System.out.println("Apakah a == b? " + (a == b));

        // Menguji defensive copy
        System.out.println("\n--- DEFENSIVE COPY ---");

        ArrayList<Character> salinan =
                manager.getAllCharacters();

        salinan.add(
                new Character("Hantu", CharacterType.HEALER, 2));

        System.out.println("Jumlah karakter asli: "
                + manager.getTotalCharacters());

        System.out.println("Jumlah karakter salinan: "
                + salinan.size());

        // Menguji static counter
        System.out.println("\n--- STATIC COUNTER ---");

        System.out.println("Total objek Character dibuat: "
                + Character.getTotalCharacterCreated());

        System.out.println("\n======================================");
        System.out.println("          PROGRAM SELESAI");
        System.out.println("======================================");
    }
}
