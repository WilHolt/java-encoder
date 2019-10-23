package com.wil;

import javafx.util.Pair;

import java.util.*;

public class Compressor {
    StringBuilder aux;
    Map<Integer,String> dictionary;
    int count = 0;

    public Compressor(){
        dictionary = new HashMap<>();
        aux = new StringBuilder();
    }

    //99471-3399
    public HashMap<Integer, String> getDictionary(Node node){
        HashMap<Integer, String> dict = new HashMap<>();
        getDictionary(dict, node, "");

        return dict;
    }

    private HashMap<Integer, String> getDictionary(HashMap<Integer, String> dict, Node node, String path) {
        if (node.getRight() == null && node.getLeft() == null) {
            dict.put(node.getLetter(), path);
        }
        if (node.getRight() != null) {
            getDictionary(dict, node.getRight(), path + "1");
        }
        if (node.getLeft() != null) {
            getDictionary(dict, node.getLeft(), path + "0");
        }
        return dict;
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
