package com.wil;

import java.util.BitSet;

public class Compressor {
//    heapQueue buffer;
    heapQueue dictionary;
    public Compressor(){
        buffer = new heapQueue();
    }
    public void compress(Node node){
        BitSet array[];

        if(node.getLeft() != null){
            compress(node.getLeft());
        }
        if(node.getRight() != null){
            compress(node.getRight());
        }
    }

}
