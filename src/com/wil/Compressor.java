package com.wil;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Map;
import java.util.Set;

public class Compressor {
    StringBuilder aux;
    Map<Integer,String> dictionary;
    public Compressor(){
        aux = new StringBuilder();
    }
    public void getDictionary(Node node){
        if(node.getLeft() != null){
            if(node.getLetter()==0){
                aux.append("0");
            }else{
                aux.deleteCharAt(0);
                dictionary.put(node.getLetter(), aux.toString());

            }
            getDictionary(node.getLeft());
        }
        if(node.getRight() != null){
            getDictionary(node.getRight());
        }
    }
    public void showDictionary(){
        Set<Integer> a = dictionary.keySet();
        for (int t : a) {
            System.out.println(t + " letter " + dictionary.get(t) + " code");
        }
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
