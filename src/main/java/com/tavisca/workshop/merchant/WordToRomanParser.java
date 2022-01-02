package com.tavisca.workshop.merchant;

public class WordToRomanParser {
    public static String[] parse(String input)
    {
        return new String[]{input.split(" ")[0],input.split(" ")[2]};
    }
    public static int convert (String input) {
        String[]answer= WordToRomanParser.parse(input);
        int number=RomanToNumeral.convertToDecimal(answer[1]);
        return number;
    }
}