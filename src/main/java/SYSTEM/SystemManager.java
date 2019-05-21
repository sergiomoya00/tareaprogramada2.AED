/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SYSTEM;

import Collections.BST;

import Collections.SimpleLinkeList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static javax.management.Query.lt;

/**
 *
 * @author Fanny Brenes
 */
public class SystemManager {

    //BST<Partitions> part[];

    
    List< BST<Partitions>> tree = new SimpleLinkeList<>();
    BST<Word> bstree = new BST<>();
    List<Partitions> partitions = new SimpleLinkeList<>();
    List<String> txt = new SimpleLinkeList<>();
    List<HDD> hdd = new SimpleLinkeList<>();
    List<BST<Word>> la = new SimpleLinkeList<>();
    
    
    public static SystemManager instance;

    public static final SystemManager getInstance() {
        return instance;
    }

    static {
        instance = new SystemManager();
        instance.partitions.add(new Partitions() {
            {
                setRoot("hola");
                setQuantity(2);
            }
        });

        instance.partitions.clear();
        //instance.partitions.clear();
    }
    
       public boolean nodesequals(String index){
       for (int i=0;i<SystemManager.getInstance().getTreeString().nodecounter();i++) {
            
             
        if (SystemManager.getInstance().getTreeString().Gettreenod(i).equals(index)) {
                return true;
                }
        
       }
       return false;
       }
      
      public Word getTreeString(int index){
      Word e=bstree.Gettreenod(index);
      return e;
      }
      public  BST<Word> getTreeString(){
      return bstree;
      }

      public void addTree( BST<Partitions> hdd) {
        this.tree.add(hdd);
    }
       public void addStringTree( Word hdd) {
        this.bstree.insert(hdd);
    }
       public void addTree( int index,BST<Partitions> hdd) {
        this.tree.add(index,hdd);
    }
    public List<BST<Partitions>> getTree() {
        return tree;
    }

    public void removeTree(int index) {
        tree.remove(index);
    }
     
       public void addRealTree( int index,BST<Word> hdd) {
        this.la.add(index,hdd);
    }
        public void addUnique( BST<Word> hdd) {
        this.la.add(hdd);
    }
       public void addUnique( int index,BST<Word> hdd) {
        this.la.add(index,hdd);
    }
       public List<BST<Word>>  getUnique() {
        return la;
    }
         public BST<Word> getUnique(int index) {
        BST<Word> selectedtree= la.get(index);
        return selectedtree;
    }

    public void removeTreee(int index) {
        partitions.remove(index);
    }
    public void removeTree( BST<Partitions> partition) {
        this.tree.remove(partition);

    }

    public BST<Partitions> getTree(int index) {
        BST<Partitions> selectedtree= tree.get(index);
        return selectedtree;
    }
    
    //Métodos para añadir y eliminar un elemento de tipo Order. 
   

    public void addPartition(Partitions partition) {
        this.partitions.add(partition);

    }

    

    public void removePartition(Partitions partition) {
        this.partitions.remove(partition);

    }

    public List<Partitions> getPartition() {
        return partitions;
    }

    public void addHDD(HDD hdd) {
        this.hdd.add(hdd);
    }

    public void removeHDD(int index) {
        hdd.remove(index);
    }
      public void addWord(String hdd) {
        this.txt.add(hdd);
    }

    public void removeWord(int index) {
        txt.remove(index);
    }
    public List<String> getWord() {
        return txt;
    }

    public String getWord(int index) {
        String hdds = txt.get(index);
        return hdds;
    }
    

    public void removeTextEdition(int index) {
        txt.remove(index);
    }

  

    public void removePartition(int index) {
        partitions.remove(index);
    }

    public List<HDD> getHDD() {
        return hdd;
    }

    public HDD getHDD(int index) {
        HDD hdds = hdd.get(index);
        return hdds;
    }

    public Partitions getPartition(int index) {
        Partitions partition = partitions.get(index);
        return partition;
    }

    public Collection<Partitions> searchRaffle(Partitions newPartition) {

        List<Partitions> results = new ArrayList<>();

        boolean byName = newPartition.getRoot() != null && newPartition.getRoot().length() > 0;

        for (Partitions part : partitions) {
            boolean add = !(byName);
            if (!add && byName && part.getRoot().contains(newPartition.getRoot())) {
                add = true;
            }
            if (add) {
                results.add(part);
            }
        }
        return results;

    }

}
