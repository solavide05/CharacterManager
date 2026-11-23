
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        // 1. Menyiapkan data karakter
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

        // 2. Mengambil statistik dari Model
        double averageLevel = manager.getAverageLevel();

        // 3. Menjalankan GUI di Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {

            MainWindow window = new MainWindow(
                manager.getAllCharacters(),
                averageLevel
            );

            window.setVisible(true);
        });
    }
}
