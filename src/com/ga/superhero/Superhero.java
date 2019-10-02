package com.ga.superhero;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Superhero {
    private static int correct = 0;
    private static int incorrect = 0;
    private static File input = new File("./input.txt");
    private Scanner sc = new Scanner(input);
    private static ArrayList<String> trivia = new ArrayList<>();

    public Superhero() throws FileNotFoundException {
        String username = "";


        // https://www.geeksforgeeks.org/different-ways-reading-text-file-java/

        while (sc.hasNextLine()) {
            trivia.add(sc.nextLine());
        }

        System.out.println(trivia);

        username = getInput("Enter your name");

        // https://git.generalassemb.ly/nyc-s1-1/foundational-java/blob/master/java-basics/debugging-lesson/starter-code/simple-calculator/src/com/ga/Main.java
        System.out.println("Choose a superhero: \n1. superman \n2. batman \n3. spiderman \n4. wonder woman");

        Scanner scanner = new Scanner(System.in);

        String answer = scanner.nextLine();

        String firstQuestion = "What city does this superhero canonically defend?";

        if(answer.equals("1") || answer.equals("superman")){
            superman(firstQuestion, 1);
        } else if(answer.equals("2") || answer.equals("batman")){
            batman(firstQuestion, 1);
        } else if(answer.equals("3") || answer.equals("spiderman")){
            spiderman(firstQuestion, 1);
        } else if(answer.equals("4") || answer.equals("wonder woman")){
            wonderWoman(firstQuestion, 1);
        } else {
            System.out.println("Invalid input!");
        }

        outputResults(username, correct, incorrect);
    }

    // https://git.generalassemb.ly/nyc-s1-1/foundational-java/blob/master/java-basics/debugging-lesson/starter-code/simple-calculator/src/com/ga/Main.java
    public static String getInput(String context){
        System.out.print(context + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    // Refactor for DRYer Code
    public static void superman(String q, int tracker) {
        String a = getInput(q);
        System.out.println(tracker);

        if (a.equalsIgnoreCase(trivia.get(trivia.indexOf("Superman") + tracker))) {
            System.out.println("Correct!");
            correct += 1;
        } else {
            System.out.println("Incorrect...");
            incorrect += 1;
        }

        // Refactor for dynamic index searching
        if (trivia.get(trivia.indexOf("Superman") + tracker + 1).equals("Batman")) {
            return;
        } else {
            tracker += 1;
            // Refactor this for dynamic questioning
            q = "What is the superhero's hidden identity?";
            // Refactor this
            superman(q, tracker);
        }
    }

    public static void batman(String q, int tracker) {
        String a = getInput(q);
        System.out.println(tracker);

        if (a.equalsIgnoreCase(trivia.get(trivia.indexOf("Batman") + tracker))) {
            System.out.println("Correct!");
            correct += 1;
        } else {
            System.out.println("Incorrect...");
            incorrect += 1;
        }

        if (trivia.get(trivia.indexOf("Batman") + tracker + 1).equals("Spiderman")) {
            return;
        } else {
            tracker += 1;
            // Refactor this for dynamic questioning
            q = "What is the superhero's hidden identity?";
            batman(q, tracker);
        }
    }

    public static void spiderman(String q, int tracker) {
        String a = getInput(q);
        System.out.println(tracker);

        if (a.equalsIgnoreCase(trivia.get(trivia.indexOf("Spiderman") + tracker))) {
            System.out.println("Correct!");
            correct += 1;
        } else {
            System.out.println("Incorrect...");
            incorrect += 1;
        }

        if (trivia.get(trivia.indexOf("Spiderman") + tracker + 1).equals("Wonder Woman")) {
            return;
        } else {
            tracker += 1;
            // Refactor this for dynamic questioning
            q = "What is the superhero's hidden identity?";
            spiderman(q, tracker);
        }
    }

    public static void wonderWoman(String q, int tracker) {
        String a = getInput(q);
        System.out.println(tracker);

        if (a.equalsIgnoreCase(trivia.get(trivia.indexOf("Wonder Woman") + tracker))) {
            System.out.println("Correct!");
            correct += 1;
        } else {
            System.out.println("Incorrect...");
            incorrect += 1;
        }

        // Refactor this. Figure out how to check if the next element doesn't exist
        if (trivia.get(trivia.indexOf("Wonder Woman") + tracker + 1) == null) {
            return;
        } else {
            tracker += 1;
            // Refactor this for dynamic questioning
            q = "What is the superhero's hidden identity?";
            wonderWoman(q, tracker);
        }
    }

    public static void outputResults(String name, int right, int wrong) throws FileNotFoundException {
        String result = (right >= wrong) ? "You won! =) Play again!" : "You lost! =( Play again!";
        // https://www.geeksforgeeks.org/redirecting-system-out-println-output-to-a-file-in-java/
        File output = new File("./output.txt");
        PrintStream out = new PrintStream(output);
        System.setOut(out);
        System.out.println("Hey, " + name + "! \n\n" + result + "\n\nYou got this many answers right: " + right + "\nYou got this many answers wrong: " + wrong);
    }
}
