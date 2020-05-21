//Author Name: David Munoz
//Date: 4/12/2020
//Program Name: Munoz_Text_Analyzer
//Purpose: Analyze the words in given text file

package MunozTextAnalyzer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 * @author King David
 */
public class Munoz_Text_Analyzer extends javax.swing.JFrame {

    Connection conn = null;
    
    /**
     * Creates new form 
     */
    public Munoz_Text_Analyzer() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnStart = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnExit = new javax.swing.JButton();
        radSpellCheck = new javax.swing.JRadioButton();
        radWordCount = new javax.swing.JRadioButton();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Text Analyzer");

        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        jLabel1.setText("Choose an option, then press Start to run the selected procedure");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);
        jTextArea1.getAccessibleContext().setAccessibleName("txtResult");

        btnExit.setLabel("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        buttonGroup1.add(radSpellCheck);
        radSpellCheck.setLabel("Database Spell Check");

        buttonGroup1.add(radWordCount);
        radWordCount.setLabel("Word Count");

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radWordCount)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radSpellCheck))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radSpellCheck)
                    .addComponent(radWordCount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit)
                    .addComponent(btnClear)
                    .addComponent(btnStart))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnStart.getAccessibleContext().setAccessibleName("btnStart");
        jScrollPane1.getAccessibleContext().setAccessibleName("txtResults");
        btnExit.getAccessibleContext().setAccessibleName("btnExit");
        radSpellCheck.getAccessibleContext().setAccessibleName("radSpellCheck");
        radWordCount.getAccessibleContext().setAccessibleName("radWordCount");
        btnClear.getAccessibleContext().setAccessibleName("btnClear");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Method run when exit button is pressed
     * 
     * @param evt 
     */
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    /**
     * Method run when start button is pressed
     * Calls methods necessary to complete processing of text analyzer application depending upon user selected radio button
     * 
     * @param evt 
     */
    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        clear();
        InputStream file = null;  
        
        if(radWordCount.isSelected()){              

            file = getClass().getResourceAsStream("macbeth.txt");
   
            Map<String, Integer> wordMap = runAnalyzer(file);
            Map<String, Integer> result = createFinalWordList(wordMap);
            writeToTextArea(result);
        }
        else if(radSpellCheck.isSelected()){

            file = getClass().getResourceAsStream("testStates.txt");

            spellCheck(file);
        }
        
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    /**
     * Main method creates and displays form
     * 
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Munoz_Text_Analyzer().setVisible(true);
            }
        });
    }
    
    /**
     * This method performs processing on file and places formatted words and counts into Map to be returned
     * 
     * @param file file to be analyzed
     * @return wordMap with all formatted words from file and the integer count of how many times they were used
     */
    public static Map runAnalyzer(InputStream file){
      
        ArrayList<String> stringArrayList = new ArrayList(); // ArrayList to hold formatted words
        String currentWord = ""; // current word being scanned
        String nonWord = ""; // to hold non words
        String[] delimitedWord = new String[2]; // string array to separate words with punctuation attached
        Map<String, Integer> wordMap = new HashMap(); // map to hold word and count combination
      
        Scanner sc = new Scanner(file); //scan given file name
        while(sc.hasNext()){
            currentWord = sc.next();

            if (currentWord.endsWith("!")||currentWord.endsWith(".")||currentWord.endsWith("?")||currentWord.endsWith(";")||currentWord.endsWith(",")||currentWord.endsWith(":")||currentWord.endsWith("-")){ // if there is punctuation attached to word
                delimitedWord = currentWord.split("[!.?;:,-]"); // split the word from punctuation
                currentWord = delimitedWord[0]; //place word without punctuation into currentWord variable
            }
            if (currentWord.endsWith("|")) //this if statement prevents | from being placed into the list
                currentWord = nonWord;
            stringArrayList.add(currentWord.toLowerCase()); // add formatted word to arraylist
        }
        
        
        for(int i = 0; i < stringArrayList.size();i++){ // for loop iterates through each item in stringArrayList
            String testWord = stringArrayList.get(i); // word at index i is placed into string variable testWord
            
            if(!(wordMap.containsKey(testWord))){ // if wordMap does not contain testWord
                int incrementer = 0; // set incrementer to 0
                    
                for(int j = 0; j < stringArrayList.size();j++){ // second for loop iterates through stringArrayList
                    if(testWord.equalsIgnoreCase(stringArrayList.get(j))){ // if testWord is equivalent to word at index j in stringArrayList
                    incrementer++; // increment the incrementer
                    } 
                }
                wordMap.put(testWord, incrementer); // place current word and count of word usage into wordMap
            }  
        }
        return wordMap;
    }
    /**
     * This method performs final processing on wordMap
     * opens stream on wordMap and sorts keys by values, places these entries into reverse order and keeps top 20 results 
     * 
     * @param wordMap formatted words placed into this Map along with count of each word
     * @return LinkedHashMap result which keep the order of the entries in it
     */
    public static LinkedHashMap createFinalWordList(Map<String, Integer> wordMap){
        
        LinkedHashMap<String, Integer> result = new LinkedHashMap(); // new LinkedHashMap to keep order of items
        
        wordMap.entrySet() // access each entry in map
                .stream() // open stream
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) //sort by value and reverse order
                .limit(20) // limit 20 entries
                .forEachOrdered(x -> result.put(x.getKey(), x.getValue())); // put each key and value pair into result LinkedHashMap
        
        return result;
    }
   
    /**
     * This method accesses each entry in wordMap and appends it to the jTextArea on the form to be displayed to the user
     * 
     * @param result finalized and formatted wordMap
     */
    private void writeToTextArea(Map<String,Integer> result){
        for(Map.Entry<String, Integer> entry : result.entrySet()){
            jTextArea1.append(entry.toString() + '\n');
        }   
    }
    
    /**
     * This method takes a file and compares the words in it, to the words in the database. Words that don't match with those in the database are displayed to the user
     *
     * @param file file to check against database
     */
    private void spellCheck(InputStream file){
        ArrayList<String> stringArrayList = new ArrayList(); // ArrayList to hold words from test file
        ArrayList<String> dictionaryWordArrayList = new ArrayList(); // ArrayList to hold words from database
        Scanner sc = new Scanner(file);

        while(sc.hasNext()){
            stringArrayList.add(sc.nextLine());
        }

        // get all words from database and place into dictionaryWordArrayList
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/wordoccurrences", "root", "password");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM WORDS");
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                dictionaryWordArrayList.add(rs.getString(1));
            }                                
        }
        catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex, "Login Error", JOptionPane.ERROR_MESSAGE);
        }
        
        for(String word : stringArrayList){
            if(!(dictionaryWordArrayList.contains(word))){
                jTextArea1.append(word + '\n');
            }
        }
    }
    
    private void clear(){
        jTextArea1.selectAll();
        jTextArea1.replaceSelection("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnStart;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JRadioButton radSpellCheck;
    private javax.swing.JRadioButton radWordCount;
    // End of variables declaration//GEN-END:variables
}
