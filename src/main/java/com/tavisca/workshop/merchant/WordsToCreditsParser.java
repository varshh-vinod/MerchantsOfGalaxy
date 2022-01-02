package com.tavisca.workshop.merchant;

public class WordsToCreditsParser {

    public static String[][] parse(String input) {
        String[][] answer= {{},{}};
        answer[0]=input.split(" is ")[0].split(" ");
        answer[1]=input.split(" is ")[1].split(" ");
        return answer;
    }
}
