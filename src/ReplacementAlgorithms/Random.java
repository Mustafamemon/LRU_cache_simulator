///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package ReplacementAlgorithms;
//
//import java.util.concurrent.ThreadLocalRandom;
//
///**
// *
// * @author DELL
// */
//public class Random extends ReplacementAlgo{
//   
//    private int[] buffer;
//    public Random(int capacity) {
//          this.capacity = capacity;
//          buffer = new int [capacity];
//          this.counter = 0;
//    }
// 
//    public int get(int key) {
//        if(map.containsKey(key)){
//            Block n = map.get(key);
//            //remove(n);
//            //setHead(n);
//            
//            return n.value;
//        }
// 
//        return -1;
//    }
// 
//    public void set(int key, int value) {
//        
//        if(map.containsKey(key)){
//           // Block old = map.get(key);
//            //old.value = value;
//            //remove(old);
//            //setHead(old);
//        }else{
//            
//            Block created = new Block(key, counter);
//            if(counter<capacity)
//                buffer[counter] = key;
//            counter++;
//            Block blockToRemove= map.get(buffer[ThreadLocalRandom.current().nextInt(0, capacity + 1-1)]);
//            
//            if(map.size()>=capacity){
//                map.remove(blockToRemove.key);
//                created.value = blockToRemove.value;
//                buffer[created.value] = key;
//                remove(blockToRemove);
//                setHead(created);
//                
// 
//            }else{
//                setHead(created);
//            }    
// 
//            map.put(key, created);
//        }
//   
//    }
//}