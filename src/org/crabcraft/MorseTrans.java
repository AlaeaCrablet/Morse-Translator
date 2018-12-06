package org.crabcraft;

import java.util.HashMap;
import java.util.Scanner;

public class MorseTrans {
    // Initialise the HashMaps for storing morse/lang
    private static HashMap<String, String> morse = new HashMap<>();


    public static void main(String[] args) {
        makeTranslator();

        String userInput = getUserInput();

        if (isMorse(userInput)) { System.out.println(translateToEng(userInput)); }
        else { System.out.println(translateToMorse(userInput)); }
    }

    private static void makeTranslator() {

        // Populate the morse HashMap, for fetching Morse Code values
        morse.put("a", ".-");
        morse.put("b", "-...");
        morse.put("c", "-.-.");
        morse.put("d", "-..");
        morse.put("e", ".");
        morse.put("f", "..-.");
        morse.put("g", "--.");
        morse.put("h", "....");
        morse.put("i", "..");
        morse.put("j", ".---");
        morse.put("k", "-.-");
        morse.put("l", ".-..");
        morse.put("m", "--");
        morse.put("n", "-.");
        morse.put("o", "---");
        morse.put("p", ".--.");
        morse.put("q", "--.-");
        morse.put("r", ".-.");
        morse.put("s", "...");
        morse.put("t", "-");
        morse.put("u", "..-");
        morse.put("v", "...-");
        morse.put("w", ".--");
        morse.put("x", "-..-");
        morse.put("y", "-.--");
        morse.put("z", "--..");
    }

    private static String getUserInput() {
        System.out.println("Enter the sentence to be translated");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        return userInput;
    }

    private static boolean isMorse(String input) {
        if (input.startsWith(".") || input.startsWith("-")) { return true; }
        else { return false; }
    }

    private static String translateToEng(String morseStr) {
        // Build a string of translated morse code
        String[] s = morseStr.split("/");
        StringBuilder builder = new StringBuilder();
        for (String morseLetter : s) {
            if (morseLetter.equals("/")) { builder.append(" "); }
            else { builder.append(getKeyFromValue(morse, morseLetter)); }
        }

        return builder.toString();
    }

    private static String translateToMorse(String engStr) {
        // Build a string of translated english
        String withSlashes = engStr.replaceAll("", "/");
        String[] s = withSlashes.split("");
        StringBuilder builder = new StringBuilder();
        for (String letter : s) {
            if (letter.equals("/")) { builder.append("/"); }
            else if (letter.equals(" ")) { builder.append(" "); }
            else { builder.append(morse.get(letter)); }
        }

        return builder.toString();
    }

    private static String getKeyFromValue(HashMap map, String value) {
        String result = null;
        for (Object o : map.keySet()) {
            if (map.get(o).equals(value)) {
                result = o.toString();
                System.out.println(result);
            }
        }
        return result;
    }
}