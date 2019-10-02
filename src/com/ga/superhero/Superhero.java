package com.ga.superhero;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Superhero {

    public Superhero() throws FileNotFoundException {
        int correct = 0;
        int incorrect = 0;

        System.out.println("Hello Superheroes");
        // https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
        File input = new File("./input.txt");
        Scanner sc = new Scanner(input);

//        while (sc.hasNextLine()) System.out.println(sc.nextLine());

        // https://git.generalassemb.ly/nyc-s1-1/foundational-java/blob/master/java-basics/debugging-lesson/starter-code/simple-calculator/src/com/ga/Main.java
        System.out.println("Choose a superhero: \n1. superman \n2. batman \n3. spiderman \n4. wonder woman\n");

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

        outputResults(correct, incorrect);
    }

    // https://git.generalassemb.ly/nyc-s1-1/foundational-java/blob/master/java-basics/debugging-lesson/starter-code/simple-calculator/src/com/ga/Main.java
    public static String getInput(String context){
        System.out.print(context+": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void superman() {
        String response = "superman";
        System.out.println(response);
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

    public static void outputResults(int right, int wrong) throws FileNotFoundException {
        String result = (right >= wrong) ? "You won! =) Play again!" : "You lost! =( Play again!";
        // https://www.geeksforgeeks.org/redirecting-system-out-println-output-to-a-file-in-java/
        File output = new File("./output.txt");
        PrintStream out = new PrintStream(output);
        System.setOut(out);
        System.out.println(result);
    }
}
