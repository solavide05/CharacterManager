
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

        manager.addCharacter(
                new Character("Arjuna", CharacterType.WARRIOR, 5)
        );

        manager.addCharacter(
                new Character("Merlin", CharacterType.MAGE, 3)
        );

        manager.addCharacter(
                new Character("Athena", CharacterType.ARCHER, 4)
        );

        manager.addCharacter(
                new Character("Bragi", CharacterType.HEALER, 6)
        );

        manager.addCharacter(
                new Character("Leonidas", CharacterType.WARRIOR, 8)
        );

        // Karakter tambahan untuk pengujian statistik
        manager.addCharacter(
                new Character("Kirana", CharacterType.MAGE, 10)
        );

        double averageLevel = manager.getAverageLevel();

        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow(
                    manager.getAllCharacters(),
                    averageLevel
            );

            window.setVisible(true);
        });
    }
}
