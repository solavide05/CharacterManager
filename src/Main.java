
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

        System.out.println("====================================");
        System.out.println("       CHARACTER MANAGER AP6");
        System.out.println("====================================");

        // 1. Menambahkan karakter
        System.out.println("\n--- MENAMBAHKAN KARAKTER ---");

        manager.addCharacter(
                new Character("Arjuna", CharacterType.WARRIOR, 5));

        manager.addCharacter(
                new Character("Merlin", CharacterType.MAGE, 3));

        manager.addCharacter(
                new Character("Athena", CharacterType.ARCHER, 4));

        // 2. Menguji duplikat
        System.out.println("\n--- MENGUJI DUPLIKAT ---");

        manager.addCharacter(
                new Character("Arjuna", CharacterType.HEALER, 1));

        // 3. Menghitung jumlah karakter
        System.out.println("\nTotal karakter: "
                + manager.getTotalCharacters());

        // 4. Mencari karakter
        System.out.println("\n--- MENCARI KARAKTER ---");

        Character ditemukan = manager.findByName("Merlin");

        if (ditemukan != null) {
            System.out.println("Ditemukan: " + ditemukan);
        }

        Character tidakDitemukan = manager.findByName("Zeus");

        if (tidakDitemukan == null) {
            System.out.println("Zeus tidak ditemukan.");
        }

        // 5. Menghapus karakter
        System.out.println("\n--- MENGHAPUS KARAKTER ---");

        manager.removeCharacter("Athena");

        System.out.println("Total karakter sekarang: "
                + manager.getTotalCharacters());

        // 6. Menampilkan karakter yang tersisa
        System.out.println("\n--- DAFTAR KARAKTER ---");

        for (Character character : manager.getAllCharacters()) {
            System.out.println(character);
        }

        // 7. MINI CHALLENGE: Rata-rata level
        System.out.println("\n--- MINI CHALLENGE 1 ---");

        System.out.println("Rata-rata level: "
                + manager.getAverageLevel());

        // 8. MINI CHALLENGE: Mencari berdasarkan tipe
        System.out.println("\n--- MINI CHALLENGE 2 ---");

        ArrayList<Character> warriors =
                manager.findByType(CharacterType.WARRIOR);

        System.out.println("Daftar karakter WARRIOR:");

        for (Character character : warriors) {
            System.out.println(character);
        }

        // 9. Eksperimen object reference
        System.out.println("\n--- EKSPERIMEN OBJECT REFERENCE ---");

        Character asli = manager.findByName("Arjuna");
        Character duplikatReferensi = asli;

        duplikatReferensi.setLevel(99);

        System.out.println("Level Arjuna setelah perubahan: "
                + asli.getLevel());

        System.out.println("Apakah referensinya sama? "
                + (asli == duplikatReferensi));

        // 10. Eksperimen defensive copy
        System.out.println("\n--- EKSPERIMEN DEFENSIVE COPY ---");

        ArrayList<Character> salinan = manager.getAllCharacters();

        salinan.add(
                new Character("Hantu", CharacterType.HEALER, 2));

        System.out.println("Jumlah karakter asli: "
                + manager.getTotalCharacters());

        System.out.println("Jumlah karakter salinan: "
                + salinan.size());

        System.out.println("\n====================================");
        System.out.println("       PROGRAM SELESAI");
        System.out.println("====================================");
    }
}
