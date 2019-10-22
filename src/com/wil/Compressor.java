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
    }
    public void getDictionary(Node node){
        if(node.getLeft() != null){
            if(node.getLetter() - node.getLetter() != 0){// comparando apenas pra saber se existe
                aux.append("0");

            }else{
                System.out.println(aux);
                String aux2 = aux
                dictionary.put(node.getLetter(), aux);
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
