package com.javarush.esin;

import com.javarush.esin.controllers.MainController;
import com.javarush.esin.entity.Result;

import java.util.Scanner;

public class ConsoleRun {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MainController controller = new MainController();

        System.out.println("Caesar Cipher. Commands:");
        System.out.println("encode <filename> <key>");
        System.out.println("decode <key>");
        System.out.println("exit");

        while (true) {
            System.out.print("> ");
            String line = scanner.nextLine();
            if ("exit".equalsIgnoreCase(line)) {
                System.out.println("Bye!");
                break;
            }

            String[] parts = line.split(" ");
            String actionName = parts[0];
            String[] parameters = new String[parts.length - 1];
            System.arraycopy(parts, 1, parameters, 0, parts.length - 1);

            try {
                Result result = controller.doAction(actionName, parameters);
                System.out.println(result);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}