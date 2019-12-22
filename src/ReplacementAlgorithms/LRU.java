/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReplacementAlgorithms;

import java.util.HashMap;

/**
 *
 * @author DELL
 */

class Block{
    protected int key;
    protected int value;
    protected Block pre;
    protected Block next;
    
 
    public Block(int key, int value){
        this.key = key;
        this.value = value;
      
    }
}
public class LRU extends ReplacementAlgo {
   
 
    public LRU(int capacity) {
          this.capacity = capacity;
          this.counter = 0;
    }
 
    public int get(int key) {
        if(map.containsKey(key)){
            Block n = map.get(key);
            remove(n);
            setHead(n);
            
            return n.value;
        }
 
        return -1;
    }
 
    public void set(int key, int value) {
        
        if(map.containsKey(key)){
            Block old = map.get(key);
            //old.value = value;
            remove(old);
            setHead(old);
        }else{
            
            Block created = new Block(key, counter);
            counter++;
            if(map.size()>=capacity){
                map.remove(end.key);
                created.value = end.value;
                remove(end);
                setHead(created);
                
 
            }else{
                setHead(created);
            }    
 
            map.put(key, created);
        }
   
    }

}
