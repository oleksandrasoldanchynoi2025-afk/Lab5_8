package com.itproger;
import com.itproger.command.Command;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Map<Integer, Command> commands = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);


    public void setCommand(int key, Command command) {
        commands.put(key, command);
    }

    public void show() {
        while (true) {
            help();
            System.out.println("\nВаш вибір: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if(choice == 0)
                    break;
                if (commands.containsKey(choice)) {
                    commands.get(choice).execute();
                } else {
                    System.out.println("Такого пункту немає.");
                }
            } else {
                System.out.println("Введіть число!");
                scanner.next();
            }
        }
    }

    public void help(){
        System.out.println("\n=== Menu ===");
        for(Map.Entry<Integer, Command> entry : commands.entrySet()){
            System.out.print(entry.getKey() + ". " + entry.getValue().getDesc() + "\n");
        }
        System.out.println("0. Exit");
    }
}