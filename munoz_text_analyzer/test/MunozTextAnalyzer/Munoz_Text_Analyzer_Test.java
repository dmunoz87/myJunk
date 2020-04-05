//Author Name: David Munoz
//Date: 3/15/2020
//Program Name: Munoz_Text_Analyzer_Test
//Purpose: Test text analyzer

package MunozTextAnalyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author King David
 */
public class Munoz_Text_Analyzer_Test {
    
    public Munoz_Text_Analyzer_Test() {
    }

    /**
     * Test of runAnalyzer method, of class Munoz_Text_Analyzer.
     * @throws java.lang.Exception
     */
    @Test
    public void testRunAnalyzer() throws Exception {
        
        Map<String, Integer> wordMap = new HashMap<>(); // create new wordMap and put 5 entries
        wordMap.put("test", 3);
        wordMap.put("this", 1);
        wordMap.put("is", 1);
        wordMap.put("a", 1);
        wordMap.put("testing", 2);
        
        File test = new File("test.txt"); // grab test file
        Map<String, Integer> secondWordMap = Munoz_Text_Analyzer.runAnalyzer(test); //test given file and place into secondWordMap
        
        assertTrue(wordMap.equals(secondWordMap)); // if both maps are equal, test = true
    }
    
    /**
     * Test of createFinalWordList method, of class Munoz_Text_Analyzer.
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testCreateFinalWordList() throws FileNotFoundException{
        
        LinkedHashMap<String, Integer> wordMap = new LinkedHashMap<>(); // create new wordMap and put 5 entries
        wordMap.put("potato", 9);
        wordMap.put("tomato", 7);
        wordMap.put("apple", 5);
        wordMap.put("beef", 3);
        wordMap.put("cheese", 2);
        
        File test = new File("test2.txt"); // grab test file
        Map<String, Integer> secondWordMap = Munoz_Text_Analyzer.runAnalyzer(test); // use runAnalyzer method 

        LinkedHashMap<String, Integer> thirdWordMap = Munoz_Text_Analyzer.createFinalWordList(secondWordMap); // use createFinalWordList method and return organized LinkedHashMap
        
        assertTrue(wordMap.equals(thirdWordMap)); // if both maps are equal, test = true
    }
    
}
