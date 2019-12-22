/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cache;

/**
 *
 * @author DELL
 */
enum WriteHitPolicy{WriteThrough, WriteBack};
enum WriteMissPolicy{WriteAllocate, NoWriteAllocate};
enum ReplacementPolicy{FIFO, LRU, Random}
