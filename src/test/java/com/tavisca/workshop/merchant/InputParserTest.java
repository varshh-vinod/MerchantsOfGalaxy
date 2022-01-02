package com.tavisca.workshop.merchant;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InputParserTest {
    @Test
    public void canParseWordToRomanNumeralStatement()
    {
        assertArrayEquals(new String[]{"glob","I"},WordToRomanParser.parse("glob is I"));
    }
    @Test
    public void canGetNumberFromWord()
    {
        assertEquals(70,WordToRomanParser.convert("glob is LXX"));
    }
    @Test
    public void canParseWordsToCreditsStatement()
    {
        assertArrayEquals(new String[][]{{"glob","glob","Silver"},{"34", "Credits"}},WordsToCreditsParser.parse("glob glob Silver is 34 Credits"));
    }
    @Test
    public void canParseQuestions()
    {
        assertArrayEquals(new String[]{"many","glob prok Silver"},QuestionsParser.parse("how many Credits is glob prok Silver ?"));
        assertArrayEquals(new String[]{"much","pish tegj glob glob"},QuestionsParser.parse("how much is pish tegj glob glob ?"));
    }
    @Test
    public void answersQuestionTypeMuch()
    {
        Dictionaryy command=new Dictionaryy();
        String command1= "glob is I";
        String command2="prok is V";
        String command3="pish is X";
        String command4="tegj is L";
        command.wordRoman.put(WordToRomanParser.parse(command1)[0],WordToRomanParser.parse(command1)[1]);
        command.wordRoman.put(WordToRomanParser.parse(command2)[0],WordToRomanParser.parse(command2)[1]);
        command.wordRoman.put(WordToRomanParser.parse(command3)[0],WordToRomanParser.parse(command3)[1]);
        command.wordRoman.put(WordToRomanParser.parse(command4)[0],WordToRomanParser.parse(command4)[1]);
        float number= command.questionParser("how much is pish tegj glob glob ?");
        assertEquals(42.0,number,0.0);
    }
    @Test
    public void answersQuestionTypeMany()
    {
        Dictionaryy command=new Dictionaryy();
        String command1= "glob is I";
        String command2="prok is V";
        String command3="pish is X";
        String command4="tegj is L";
        command.wordRoman.put(WordToRomanParser.parse(command1)[0],WordToRomanParser.parse(command1)[1]);
        command.wordRoman.put(WordToRomanParser.parse(command2)[0],WordToRomanParser.parse(command2)[1]);
        command.wordRoman.put(WordToRomanParser.parse(command3)[0],WordToRomanParser.parse(command3)[1]);
        command.wordRoman.put(WordToRomanParser.parse(command4)[0],WordToRomanParser.parse(command4)[1]);
        command.convert("glob glob Silver is 34 Credits");
        command.convert("glob prok Gold is 57800 Credits");
        command.convert("pish pish Iron is 3910 Credits");
        assertEquals(68.0,command.questionParser("how many Credits is glob prok Silver ?"),0.0);
        assertEquals(57800.0,command.questionParser("how many Credits is glob prok Gold ?"),0.0);
        assertEquals(782.0,command.questionParser("how many Credits is glob prok Iron ?"),0.0);
    }
    @Test
    public void iHaveNoIdea() {
        Dictionaryy command = new Dictionaryy() ;
        try {
            command.questionParser("how many Credits is glob prok Silver ?");
        }
        catch(Exception e)
        {
            assertEquals(1,1);
        }
    }
    @Test
    public void canGetNumberFromCommandTwoType()
    {
        Dictionaryy command=new Dictionaryy();
        String command1= "glob is I";
        String command2="prok is V";
        String command3="pish is X";
        command.wordRoman.put(WordToRomanParser.parse(command1)[0],WordToRomanParser.parse(command1)[1]);
        command.wordRoman.put(WordToRomanParser.parse(command2)[0],WordToRomanParser.parse(command2)[1]);
        command.wordRoman.put(WordToRomanParser.parse(command3)[0],WordToRomanParser.parse(command3)[1]);
        assertEquals(17.0,command.convert("glob glob Silver is 34 Credits"),0.0);
        assertEquals(14450.0,command.convert("glob prok Gold is 57800 Credits"),0.0);
        assertEquals(195.5,command.convert("pish pish Iron is 3910 Credits"),0.0);
    }
}