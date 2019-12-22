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
public abstract class ReplacementAlgo {
    protected int capacity;
    protected HashMap<Integer, Block> map = new HashMap<Integer, Block>();
    protected Block head=null;
    protected Block end=null;
    protected int counter;
    
    public abstract void set(int key, int value);
    public abstract int get(int key);
    
    protected void setHead(Block n){
        n.next = head;
        n.pre = null;
 
        if(head!=null)
            head.pre = n;
 
        head = n;
 
        if(end ==null)
            end = head;
    }
    
    protected void remove(Block n){
        if(n.pre!=null){
            n.pre.next = n.next;
        }else{
            head = n.next;
        }
 
        if(n.next!=null){
            n.next.pre = n.pre;
        }else{
            end = n.pre;
        }
 
    }
}
