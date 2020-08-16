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

    public void runProgram(String[] args) {
        startProgram(args);
        boolean exit = false;
        while (!exit) {
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
                    exit = true;
                    break;
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
        exitProgram(args);
    }

    private void startProgram(String[] args) {
        if (args.length == 0) {
            return;
        }

        // checks if either the first or second argument is import or export, but only the second if it exists
        if ("-import".equals(args[0]) || (args.length > 2 && "-import".equals(args[2]))) {
            Map<String, String> cards = saver.importData(args[1]);
            if (cards != null) {
                manager.setCards(cards);
            }
        }
    }

    private void exitProgram(String[] args) {
        if (args.length == 0) {
            return;
        }

        // checks if either the first or second argument is import or export, but only the second if it exists
        if ("-export".equals(args[0]) || (args.length > 2 && "-export".equals(args[2]))) {
            saver.exportData(manager.getCards(), args[1]);
        }
    }
}
