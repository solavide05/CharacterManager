import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Character Manager v0.1 ===");
        System.out.println();

        // Membuat karakter
        Character warrior = new Character(
                "Arjuna",
                CharacterType.WARRIOR,
                5
        );

        Character mage = new Character(
                "Merlin",
                CharacterType.MAGE,
                3
        );

        Character archer = new Character(
                "Athena",
                CharacterType.ARCHER,
                4
        );

        // Menampilkan karakter
        System.out.println(warrior);
        System.out.println(mage);
        System.out.println(archer);

        // Menaikkan level karakter
        System.out.println();
        System.out.println(">> Arjuna level up!");

        warrior.setLevel(6);

        System.out.println("After level up: " + warrior);

        // Menampilkan informasi karakter
        System.out.println();
        System.out.println(">> Nama karakter: " + warrior.getName());
        System.out.println(">> Jenis karakter: " + warrior.getType());
        System.out.println(">> HP saat ini: " + warrior.getHitPoints());

        // =====================================
        // MINI CHALLENGE TP03
        // =====================================

        System.out.println();
        System.out.println("=================================");
        System.out.println("       MINI CHALLENGE TP03");
        System.out.println("=================================");

        // Membuat karakter baru
        Character knight = new Character(
                "Leon",
                CharacterType.WARRIOR,
                7
        );

        // Mengatur mana
        knight.setMana(100);

        // Menampilkan data karakter
        System.out.println();
        System.out.println("Data Karakter Baru:");
        System.out.println(knight);

        // Memeriksa status hidup
        System.out.println();
        System.out.println(">> Status hidup: " + knight.isAlive());

        // Menampilkan mana
        System.out.println(">> Mana karakter: " + knight.getMana());

        // Menguji validasi mana
        System.out.println();
        System.out.println(">> Pengujian validasi mana:");

        try {
            knight.setMana(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("Validasi berhasil: " + e.getMessage());
        }

        // Menampilkan mana setelah pengujian
        System.out.println(">> Mana terakhir: " + knight.getMana());

        System.out.println();
        System.out.println("=== PROGRAM SELESAI ===");
    }
}