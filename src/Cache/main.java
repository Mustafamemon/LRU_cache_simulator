/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cache;

import java.util.Random;
import ReplacementAlgorithms.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author DELL
 */
public class main {
    public static void main(String[] args){
      UICache cache = new UICache();
      cache.setVisible(true);
    }
    void checkAlgo(){
        int[] query1 = new int[]{1,2,3,4,2,1,5,6,2,1,2,3,7,6,3,2,1,2,3,6};
        FIFO lru = new FIFO(4);
        lru.set(4, 5);
        lru.set(4, 0);
        lru.set(3, 1);
        lru.set(2, 2);
        lru.set(3, 1);
        lru.set(2, 2);
        lru.set(1, 4);
        lru.set(1, 5);
        lru.set(4, 0);
        
        lru.set(5, 90);
       //lru.set(3,90);
        
        
        for(int i=1; i<=5; i++)
        System.out.println(lru.get(i));
        
        System.out.println("Query1");
        Random fifo = new Random(3); int misses = 0; int hits = 0;
        for (int i=0; i<query1.length; i++){
            if(fifo.get(query1[i])==-1)
                misses++;
            else
                hits++;
            fifo.set(query1[i], i);
            if(fifo.get(query1[i]) == 0)
            System.out.println(query1[i]);
            if(fifo.get(query1[i]) == 1)
            System.out.println("\t"+query1[i]);
            if(fifo.get(query1[i]) == 2)
            System.out.println("\t\t"+query1[i]);
            
            
        }
        System.out.println("hits= "+hits+ " misses= "+ misses);
        
        System.out.println(ThreadLocalRandom.current().nextInt(0, 19 + 1));
        
    }
    
}
