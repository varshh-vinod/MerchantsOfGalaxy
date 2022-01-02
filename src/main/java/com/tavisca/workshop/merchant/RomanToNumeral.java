package com.tavisca.workshop.merchant;

import java.util.HashMap;

public class RomanToNumeral {
    public static final HashMap<Character, Integer> romanDecimal= new HashMap<Character, Integer>() {
        {
            put('I',1);
            put('V',5);
            put('X',10);
            put('L',50);
            put('C',100);
            put('D',500);
            put('M',1000);
        }
    };
    public static int ValidateRoman(String romanNumeral)
    {
        return 1;
    }

    public static int convertToDecimal (String romanNumeral) {
        if(ValidateRoman(romanNumeral)==1) {
            romanNumeral = romanNumeral.toUpperCase();
            int decimalNum = 0;
            int num = 0;
            int previousnum = 0;
            for (int i=romanNumeral.length()-1;i>=0;i--) {
                char x = romanNumeral.charAt(i);
                previousnum = num;
                num = romanDecimal.get(x);
                if (num < previousnum) {
                    decimalNum = decimalNum - num;
                } else
                    decimalNum = decimalNum + num;
            }
            return decimalNum;
        }
        System.out.println("Invalid Roman number");
        System.exit(0);
        return 0;
    }
}

