
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;

public class Main {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("   CHARACTER MANAGER v0.2 - AP6");
        System.out.println("========================================");

        CharacterManager manager = new CharacterManager();

        // 1. Menambahkan karakter
        System.out.println("\n--- TAMBAH KARAKTER ---");

        manager.addCharacter(
                new Character("Arjuna", CharacterType.WARRIOR, 5)
        );

        manager.addCharacter(
                new Character("Merlin", CharacterType.MAGE, 3)
        );

        manager.addCharacter(
                new Character("Athena", CharacterType.ARCHER, 4)
        );

        // 2. Menguji karakter duplikat
        System.out.println("\n--- UJI DUPLIKAT ---");

        manager.addCharacter(
                new Character("Arjuna", CharacterType.HEALER, 1)
        );

        // 3. Menampilkan total karakter
        System.out.println("\nTotal karakter: "
                + manager.getTotalCharacters());

        // 4. Mencari karakter
        System.out.println("\n--- PENCARIAN ---");

        Character hasil = manager.findByName("Merlin");

        System.out.println(
                hasil != null ? "Ditemukan: " + hasil
                        : "Karakter tidak ditemukan"
        );

        Character tidakAda = manager.findByName("Zeus");

        System.out.println(
                tidakAda != null ? "Ditemukan: " + tidakAda
                        : "Zeus tidak ditemukan (sesuai harapan)"
        );

        // 5. Menghapus karakter
        System.out.println("\n--- PENGHAPUSAN ---");

        manager.removeCharacter("Athena");

        System.out.println("Total setelah hapus: "
                + manager.getTotalCharacters());

        // 6. Menampilkan karakter tersisa
        System.out.println("\n--- DAFTAR KARAKTER ---");

        for (Character c : manager.getAllCharacters()) {
            System.out.println(c);
        }

        // 7. Mini Challenge: rata-rata level
        System.out.println("\n--- MINI CHALLENGE ---");

        System.out.println("Rata-rata level: "
                + manager.getAverageLevel());

        // 8. Mini Challenge: pencarian berdasarkan tipe
        System.out.println("\nKarakter dengan tipe WARRIOR:");

        for (Character c : manager.findByType(CharacterType.WARRIOR)) {
            System.out.println(c);
        }

        // 9. Eksperimen Object Reference
        System.out.println("\n--- EKSPERIMEN OBJECT REFERENCE ---");

        Character asli = manager.findByName("Arjuna");

        Character duplikatReferensi = asli;

        System.out.println("Level Arjuna sebelum: "
                + asli.getLevel());

        duplikatReferensi.setLevel(99);

        System.out.println("Level Arjuna sesudah: "
                + asli.getLevel());

        System.out.println("asli == duplikatReferensi? "
                + (asli == duplikatReferensi));

        // 10. Menguji defensive copy
        System.out.println("\n--- EKSPERIMEN DEFENSIVE COPY ---");

        java.util.ArrayList<Character> salinanList =
                manager.getAllCharacters();

        salinanList.add(
                new Character("Hantu", CharacterType.MAGE, 1)
        );

        System.out.println("Total di manager asli: "
                + manager.getTotalCharacters());

        System.out.println("Total di salinan list: "
                + salinanList.size());

        System.out.println("\n========================================");
        System.out.println("       PROGRAM SELESAI");
        System.out.println("========================================");
    }
}
