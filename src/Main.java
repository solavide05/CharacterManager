import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

/**
 * Main class untuk menjalankan Character Manager.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("       CHARACTER MANAGER v0.1");
        System.out.println("====================================");
        System.out.println();

        // Membuat tiga karakter
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

        // Menampilkan tiga karakter
        System.out.println("DAFTAR KARAKTER");
        System.out.println("------------------------------------");
        System.out.println(warrior);
        System.out.println(mage);
        System.out.println(archer);

        // Demonstrasi level up
        System.out.println();
        System.out.println("DEMO LEVEL UP");
        System.out.println("------------------------------------");

        System.out.println("Sebelum level up:");
        System.out.println(warrior);

        warrior.setLevel(6);

        System.out.println("Sesudah level up:");
        System.out.println(warrior);

        // Menampilkan informasi karakter
        System.out.println();
        System.out.println("INFORMASI KARAKTER");
        System.out.println("------------------------------------");
        System.out.println("Nama       : " + warrior.getName());
        System.out.println("Jenis      : " + warrior.getType());
        System.out.println("Level      : " + warrior.getLevel());
        System.out.println("Hit Points : " + warrior.getHitPoints());
        System.out.println("Attack     : " + warrior.getAttackPower());

        // ====================================
        // MINI CHALLENGE TP03
        // ====================================

        System.out.println();
        System.out.println("====================================");
        System.out.println("          MINI CHALLENGE TP03");
        System.out.println("====================================");

        // Membuat satu karakter baru
        Character knight = new Character(
                "Leon",
                CharacterType.WARRIOR,
                7
        );

        // Mengatur mana karakter
        knight.setMana(100);

        // Menampilkan data karakter
        System.out.println();
        System.out.println("DATA KARAKTER BARU");
        System.out.println("------------------------------------");
        System.out.println(knight);

        // Memeriksa apakah karakter masih hidup
        System.out.println();
        System.out.println("Status hidup : " + knight.isAlive());

        // Menampilkan mana
        System.out.println("Mana         : " + knight.getMana());

        // Menguji validasi mana negatif
        System.out.println();
        System.out.println("PENGUJIAN VALIDASI MANA");
        System.out.println("------------------------------------");

        try {
            knight.setMana(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("Validasi berhasil: " + e.getMessage());
        }

        // Memastikan mana tidak berubah
        System.out.println("Mana terakhir: " + knight.getMana());

        // Menguji status karakter ketika HP nol
        knight.setHitPoints(0);

        System.out.println();
        System.out.println("PENGUJIAN STATUS KARAKTER");
        System.out.println("------------------------------------");
        System.out.println("Status hidup setelah HP 0: " + knight.isAlive());

        System.out.println();
        System.out.println("====================================");
        System.out.println("          PROGRAM SELESAI");
        System.out.println("====================================");
    }
}