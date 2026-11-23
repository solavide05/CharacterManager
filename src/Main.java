
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        ArrayList<Character> characters = new ArrayList<>();

        characters.add(
                new Character("Arjuna", CharacterType.WARRIOR, 5)
        );

        characters.add(
                new Character("Merlin", CharacterType.MAGE, 6)
        );

        characters.add(
                new Character("Athena", CharacterType.ARCHER, 4)
        );

        characters.add(
                new Character("Gatotkaca", CharacterType.WARRIOR, 8)
        );

        characters.add(
                new Character("Morgana", CharacterType.MAGE, 5)
        );

        characters.add(
                new Character("Robin", CharacterType.ARCHER, 8)
        );

        // Menghitung rata-rata level
        double totalLevel = 0;

        for (Character character : characters) {
            totalLevel += character.getLevel();
        }

        double averageLevel =
                totalLevel / characters.size();

        // Menampilkan aplikasi
        SwingUtilities.invokeLater(() -> {

            MainWindow window = new MainWindow(
                    characters,
                    averageLevel
            );

            window.setVisible(true);
        });
    }
}
