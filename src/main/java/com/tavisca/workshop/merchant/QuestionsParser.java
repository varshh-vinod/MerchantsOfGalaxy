package com.tavisca.workshop.merchant;

public class QuestionsParser {
    public static String[] parse(String input) {
        String[] answer={"",""};
        if(input.contains("much"))
        {
            answer[0]="much";
            String temporarySplit[]=input.split("how much is ");
            String temporarySplit2[]=temporarySplit[1].split(" \\?");
            System.out.println(temporarySplit2[0]);
            answer[1]=temporarySplit2[0];
        }
        if(input.contains("many"))
        {
            answer[0]="many";
            String temporarySplit[]=input.split("how many Credits is ");
            String temporarySplit2[]=temporarySplit[1].split(" \\?");
            System.out.println(temporarySplit2[0]);
            answer[1]=temporarySplit2[0];
        }
        return answer;
    }
}
