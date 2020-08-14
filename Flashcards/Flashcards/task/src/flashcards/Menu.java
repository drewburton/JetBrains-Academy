package flashcards;

import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private ActionManager manager;
    private Saver saver;

    public Menu() {
        scanner = new Scanner(System.in);
        manager = new ActionManager(scanner);
        saver = new Saver(scanner);
    }

    public void runProgram() {
        while (true) {
            System.out.println("Input the action (add, remove, import, export, ask, exit):");
            String action = scanner.nextLine();

            switch (action) {
                case "add":
                    manager.add();
                    break;
                case "remove":
                    manager.remove();
                    break;
                case "import":
                    Map<String, String> cards = saver.importData();
                    if (cards != null) {
                        manager.setCards(cards);
                    }
                    break;
                case "export":
                    saver.exportData(manager.getCards());
                    break;
                case "ask":
                    manager.ask();
                    break;
                case "exit":
                    System.out.println("Bye bye!");
                    return;
                default:
            }
        }
    }
}
