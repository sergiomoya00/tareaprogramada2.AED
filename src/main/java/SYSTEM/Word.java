/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SYSTEM;

/**
 *
 * @author Fanny Brenes
 */
public class Word implements Comparable<Word> {
    String word;
    
    public Word(String word) {
        this.word = word;
    }
    public Word() {
        
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
     

    @Override
    public int compareTo(Word o) {
        if (SystemManager.getInstance().getUnique().size() > SystemManager.getInstance().getUnique(0).nodecounter()) {
            return -1;
        } else if (SystemManager.getInstance().getUnique().size() < SystemManager.getInstance().getUnique(0).nodecounter()) {
            return 1;
        } else {
            return 0;
        }
    }
}
