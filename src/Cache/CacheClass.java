/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cache;

import ReplacementAlgorithms.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class CacheClass {
    private final int cacheSize;
    private WriteHitPolicy writeHit;
    private ReplacementPolicy replacementPolicy;
    private WriteMissPolicy writeMiss;
    private int misses;
    private int hits;
    
    private ReplacementAlgo[] replacementAlgo;
    private final ArrayList<Integer> arrayOfLoads;
    private final ArrayList<Integer> arrayOfStores;
    private final ArrayList<String> sequence;
    
    CacheClass(int cacheSize, WriteHitPolicy writeHit, WriteMissPolicy writeMiss){
        this.cacheSize = cacheSize;
        this.writeHit = writeHit;
        this.writeMiss = writeMiss;
        misses = 0;
        hits = 0;
        arrayOfLoads  = new ArrayList();
        arrayOfStores = new ArrayList();
        sequence = new ArrayList();
        
    }
    public boolean setLoadsAndStores(String input){
        String splitedArray[] = input.split("[\n]");
      
        for (String splitedArray1 : splitedArray) {
            if (splitedArray1.contains("L") || splitedArray1.contains("l")) {
                int temp = this.grabIntegers(splitedArray1);
                arrayOfLoads.add(temp);
                sequence.add("l");
            } else if (splitedArray1.contains("S") || splitedArray1.contains("s")) {
                int temp = this.grabIntegers(splitedArray1);
                arrayOfStores.add(temp);
                sequence.add("s");
            } else {
                JOptionPane.showMessageDialog(null,"Incorrect Query Format!" , "Query", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
    
    private int grabIntegers(String input){
      return Integer.parseInt(input.replaceAll("[\\D]", ""));
    }
    
    public int[] setDirectMappedCache(JTable table){
        
        //Initializing JTable;
        DefaultTableModel model;
        if (writeHit==WriteHitPolicy.WriteBack){ //Write Back Cache
            model = new  DefaultTableModel(0,3);
            for (int i=0; i<cacheSize; i++){
                model.addRow(new String[]{String.valueOf(i),"-","0"});
            }
        }
        else{//Write Through Cache
            model = new  DefaultTableModel(0,2);
            for (int i=0; i<cacheSize; i++){
                model.addRow(new String[]{String.valueOf(i),"-"});
            }
        }
        table.setModel(model);
        //Setting Column Names....
        table.getColumnModel().getColumn(0).setHeaderValue("Block Number");
        table.getColumnModel().getColumn(1).setHeaderValue("Cache Contents");
        if (writeHit==WriteHitPolicy.WriteBack)
             table.getColumnModel().getColumn(2).setHeaderValue("Dirty Bit");
        table.getTableHeader().repaint();
        
        
        
        int l = 0, s = 0; 
        for(int i=0; i<sequence.size(); i++){
            
            if (sequence.get(i).equals("l")){ //Load
                if(model.getValueAt(arrayOfLoads.get(l)%cacheSize, 1).equals(arrayOfLoads.get(l))){ //hit
                    hits++;
                }
                else{ //miss
                    model.setValueAt(arrayOfLoads.get(l) , arrayOfLoads.get(l)%cacheSize , 1);
                    if(writeHit == WriteHitPolicy.WriteBack)
                        model.setValueAt(0 , arrayOfLoads.get(l)%cacheSize , 2);
                    misses++;
                }
                l++;
            }
            else if (sequence.get(i).equals("s")){ //Store
                if(writeHit == WriteHitPolicy.WriteBack){ //WriteBack
                    model.setValueAt(1 , arrayOfStores.get(s)%cacheSize , 2);
                    }
                if(model.getValueAt(arrayOfStores.get(s)%cacheSize, 1).equals(arrayOfStores.get(s))){ //hit
                    hits++;
                }
                else { //miss
                    misses++;
                    if(writeMiss == WriteMissPolicy.WriteAllocate)
                    model.setValueAt(arrayOfStores.get(s) , arrayOfStores.get(s)%cacheSize , 1); 
                }
                s++;
            }
            
        }
        System.out.println(hits);
        System.out.println(misses);
        
        //Implementing All changes to table..
        table.setModel(model);
         return new int[]{hits,misses,sequence.size()};
      
    }
    
    public int[] setSetAssociativeCache(JTable table,int setSize, int replacementPolicy){
        int numberOfSets = cacheSize/setSize;
        
        switch (replacementPolicy){
//            case 1:
//                this.replacementPolicy = ReplacementPolicy.FIFO;
//                replacementAlgo =  new FIFO[numberOfSets];
//                for (int i=0; i<replacementAlgo.length; i++){
//                    replacementAlgo[i] = new FIFO(setSize); 
//                }
//                break;
            case 0:
                this.replacementPolicy = ReplacementPolicy.LRU;
                replacementAlgo =  new LRU[numberOfSets];
                for (int i=0; i<replacementAlgo.length; i++){
                    replacementAlgo[i] = new LRU(setSize); 
                }
                
                break;
//            default:
//                this.replacementPolicy = ReplacementPolicy.Random;
//                replacementAlgo =  new Random[numberOfSets];
//                for (int i=0; i<replacementAlgo.length; i++){
//                    replacementAlgo[i] = new Random(setSize); 
//                }
        }

        //Initializing JTable;
        DefaultTableModel model;
        if (writeHit==WriteHitPolicy.WriteBack){ //Write Back Cache
            model = new  DefaultTableModel(0,4);
             for (int i=0; i<cacheSize/setSize; i++){
                for (int j=0; j<setSize; j++)
                model.addRow(new String[]{String.valueOf(i),String.valueOf(j),"-","0"});
            }
        }
        else{//Write Through Cache
            model = new  DefaultTableModel(0,3);
            for (int i=0; i<cacheSize/setSize; i++){
                for (int j=0; j<setSize; j++)
                model.addRow(new String[]{String.valueOf(i),String.valueOf(j),"-"});
            }
        }
        table.setModel(model);
        //Setting Column Names....
        table.getColumnModel().getColumn(0).setHeaderValue("Set Number");
        table.getColumnModel().getColumn(1).setHeaderValue("Block Number");
        table.getColumnModel().getColumn(2).setHeaderValue("Content");
        if (writeHit==WriteHitPolicy.WriteBack)
             table.getColumnModel().getColumn(3).setHeaderValue("Dirty Bit");
        table.getTableHeader().repaint();
        
        
        
        int l = 0, s = 0;
        for(int i=0; i<sequence.size(); i++){
           
          
        
            if (sequence.get(i).equals("l")){ //Load
                  int setNumber= arrayOfLoads.get(l)%numberOfSets;
                  int cacheContent = arrayOfLoads.get(l);
            
                if(replacementAlgo[setNumber].get(cacheContent)==-1){ //miss
                    misses++;
                    replacementAlgo[setNumber].set(cacheContent, 2);
                    System.out.println(replacementAlgo[setNumber].get(cacheContent));
                    model.setValueAt(cacheContent , setNumber*setSize+replacementAlgo[setNumber].get(cacheContent) , 2);
                    if(writeHit == WriteHitPolicy.WriteBack)
                        model.setValueAt(0 , setNumber*setSize+replacementAlgo[setNumber].get(cacheContent) , 3);
                }
                else{ //hit
                    replacementAlgo[setNumber].set(cacheContent, 2);
                    hits++;
                }
                l++;
            }
            
            else if (sequence.get(i).equals("s")){ //Store
                
                  int setNumber =    arrayOfStores.get(s)%numberOfSets;
                  int cacheContent = arrayOfStores.get(s);
                
                if(replacementAlgo[setNumber].get(cacheContent)==-1){ //miss
                    misses++;
                    
                    if(writeMiss == WriteMissPolicy.WriteAllocate){
                        replacementAlgo[setNumber].set(cacheContent, 2);
                        model.setValueAt(cacheContent , setNumber*setSize+replacementAlgo[setNumber].get(cacheContent) , 2);
                    }
                }
                else { //hit
                      replacementAlgo[setNumber].set(cacheContent, 2);
                      hits++;
                     
                }
                
                if(writeHit == WriteHitPolicy.WriteBack){ //WriteBack
                    model.setValueAt(1 , setNumber*setSize+replacementAlgo[setNumber].get(cacheContent)  , 3);
                    }
                s++;
            }
            
        }
        
        
        //Implementing All changes to table..
        table.setModel(model);
        return new int[]{hits,misses,sequence.size()};
    }
    
    public int[] setFullyAssociativeCache(JTable table, int replacementPolicy){
        int numberOfSets = 1;
        
        switch (replacementPolicy){
//            case 0:
//                this.replacementPolicy = ReplacementPolicy.FIFO;
//                replacementAlgo =  new FIFO[numberOfSets];
//                for (int i=0; i<replacementAlgo.length; i++){
//                    replacementAlgo[i] = new FIFO(cacheSize); 
//                }
//                break;
            case 0:
                this.replacementPolicy = ReplacementPolicy.LRU;
                replacementAlgo =  new LRU[numberOfSets];
                for (int i=0; i<replacementAlgo.length; i++){
                    replacementAlgo[i] = new LRU(cacheSize); 
                }
                break;
//            default:
//                this.replacementPolicy = ReplacementPolicy.Random;
//                 replacementAlgo =  new Random[numberOfSets];
//                for (int i=0; i<replacementAlgo.length; i++){
//                    replacementAlgo[i] = new Random(cacheSize); 
//                }
        }

        //Initializing JTable;
        DefaultTableModel model;
        if (writeHit==WriteHitPolicy.WriteBack){ //Write Back Cache
            model = new  DefaultTableModel(0,3);
            for (int i=0; i<cacheSize; i++){
                model.addRow(new String[]{String.valueOf(i),"-","0"});
            }
        }
        else{//Write Through Cache
            model = new  DefaultTableModel(0,2);
            for (int i=0; i<cacheSize; i++){
                model.addRow(new String[]{String.valueOf(i),"-"});
            }
        }
        table.setModel(model);
        //Setting Column Names....
        table.getColumnModel().getColumn(0).setHeaderValue("Block Number");
        table.getColumnModel().getColumn(1).setHeaderValue("Cache Contents");
        if (writeHit==WriteHitPolicy.WriteBack)
             table.getColumnModel().getColumn(2).setHeaderValue("Dirty Bit");
        table.getTableHeader().repaint();
        
        
        
        int l = 0, s = 0;
        for(int i=0; i<sequence.size(); i++){
           
          
        
            if (sequence.get(i).equals("l")){ //Load
                  int setNumber= 0;
                  int cacheContent = arrayOfLoads.get(l);
            
                if(replacementAlgo[setNumber].get(cacheContent)==-1){ //miss
                    misses++;
                    replacementAlgo[setNumber].set(cacheContent, 1);
                    
                    model.setValueAt(cacheContent , replacementAlgo[setNumber].get(cacheContent) , 1);
                    if(writeHit == WriteHitPolicy.WriteBack)
                        model.setValueAt(0 , replacementAlgo[setNumber].get(cacheContent) , 2);
                }
                else{ //hit
                    replacementAlgo[setNumber].set(cacheContent, 1);
                    hits++;
                }
                l++;
            }
            
            else if (sequence.get(i).equals("s")){ //Store
                
                  int setNumber =    0;
                  int cacheContent = arrayOfStores.get(s);
                
                if(replacementAlgo[setNumber].get(cacheContent)==-1){ //miss
                    misses++;
                    
                    if(writeMiss == WriteMissPolicy.WriteAllocate){
                        replacementAlgo[setNumber].set(cacheContent, 1);
                        model.setValueAt(cacheContent , replacementAlgo[setNumber].get(cacheContent) , 1);
                    }
                }
                else { //hit
                      replacementAlgo[setNumber].set(cacheContent, 1);
                      hits++;
                     
                }
                
                if(writeHit == WriteHitPolicy.WriteBack){ //WriteBack
                    model.setValueAt(1 , replacementAlgo[setNumber].get(cacheContent)  , 2);
                    }
                s++;
            }
            
        }
        
        
        //Implementing All changes to table..
        table.setModel(model);
        return new int[]{hits,misses,sequence.size()};
    }
    
    
}

