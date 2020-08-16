package flashcards;

import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private ActionManager manager;
    private Saver saver;
    private StatsManager statsManager;

    public Menu() {
        scanner = new Scanner(System.in);
        manager = new ActionManager(scanner);
        saver = new Saver(scanner);
        statsManager = new StatsManager(scanner);
    }

    public void runProgram() {
        while (true) {
            Saver.println("Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):");
            String action = Saver.nextLine(scanner);

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
                    Saver.println("Bye bye!");
                    return;
                case "log":
                    saver.log();
                    break;
                case "hardest card":
                    statsManager.hardestCard();
                    break;
                case "reset stats":
                    statsManager.resetStats();
                    break;
                default:
            }
        }
    }
}
