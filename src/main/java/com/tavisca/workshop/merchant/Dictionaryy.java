package com.tavisca.workshop.merchant;

import javax.naming.directory.Attribute;
import java.util.HashMap;

public class Dictionaryy {
    public  HashMap<String, String> wordRoman= new HashMap<String, String>();
    public  HashMap<String, Float> itemAmount= new HashMap<String, Float>();
    public float convert(String input)
    {
        String[][] answer= WordsToCreditsParser.parse(input);
        int  number= Integer.parseInt(answer[1][0]);
        String roman=wordRoman.get(answer[0][0]) +wordRoman.get(answer[0][1]);
        this.itemAmount.put(answer[0][2],(float)number/(float)RomanToNumeral.convertToDecimal(roman));
        return (float)number/(float)RomanToNumeral.convertToDecimal(roman);
    }

    public float questionParser(String input) {
            float number = 0;
            String splits[] = QuestionsParser.parse(input);
            if (splits[0].equals("much")) {
                String roman = "";
                String furtherSplits[] = splits[1].split(" ");
                for (String word : furtherSplits) {
                    roman = roman + this.wordRoman.get(word);
                }
                System.out.println(roman);
                number = RomanToNumeral.convertToDecimal(roman);
            } else if (splits[0].equals("many")) {
                String roman = "";
                String furtherSplits[] = splits[1].split(" ");
                roman = roman + this.wordRoman.get(furtherSplits[0]) + this.wordRoman.get(furtherSplits[1]);
                number = RomanToNumeral.convertToDecimal(roman);
                System.out.println(number);
                number = number * this.itemAmount.get(furtherSplits[2]);
            }
            return number;
    }
}
