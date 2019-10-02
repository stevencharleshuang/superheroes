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

        if(answer.equals("1") || answer.equals("superman")){
            superman();
        } else if(answer.equals("2") || answer.equals("batman")){
            batman();
        } else if(answer.equals("3") || answer.equals("spiderman")){
            spiderman();
        } else if(answer.equals("4") || answer.equals("wonder woman")){
            wonderWoman();
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

    public static void superman() {
        String a1 = getInput("What city does this superhero defend?");

        if (a1.equalsIgnoreCase(trivia.get(trivia.indexOf("Superman") + 1))) {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect...");
        }
    }

    public static void batman() {
        String response = "batman";
        System.out.println(response);
    }

    public static void spiderman() {
        String response = "spiderman";
        System.out.println(response);
    }

    public static void wonderWoman() {
        String response = "wonder woman";
        System.out.println(response);
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
