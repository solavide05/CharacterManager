
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        ArrayList<Character> characters = new ArrayList<>();

        // DATA KARAKTER
        characters.add(
                new Character("Arjuna", CharacterType.WARRIOR, 5)
        );

        characters.add(
                new Character("Merlin", CharacterType.MAGE, 3)
        );

        characters.add(
                new Character("Athena", CharacterType.ARCHER, 4)
        );

        characters.add(
                new Character("Gatotkaca", CharacterType.WARRIOR, 7)
        );

        characters.add(
                new Character("Morgana", CharacterType.MAGE, 1)
        );

        characters.add(
                new Character("Artemis", CharacterType.ARCHER, 6)
        );

        characters.add(
                new Character("Bima", CharacterType.WARRIOR, 8)
        );

        characters.add(
                new Character("Circe", CharacterType.MAGE, 2)
        );

        // MENAMPILKAN APLIKASI
        SwingUtilities.invokeLater(() -> {

            MainWindow window = new MainWindow(characters);

            window.setVisible(true);
        });
    }
}
