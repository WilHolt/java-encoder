package com.wil;

import javafx.util.Pair;

public class binaryTree {
    private Node raiz = null;

    public boolean isEmpty() {
        return raiz == null;
    }

    public void insert(Node node) {
        if (raiz == null) {//se a arvore estiver vazia, o primeiro nó vai ser a raiz
            raiz = node;
            return;
        }
        raiz.insert(node);//chama  a função se inserir que está na classe Node.
    }

    public void insert(Pair<Character,Integer> pair) {//caso so passe o valor do nó
        Node n = new Node(pair);
        insert(n);//chama a função de inserir, passando o node em questão
    }
    public void insert(int value) {//caso so passe o valor do nó
        Node n = new Node(value);
        insert(n);//chama a função de inserir, passando o node em questão
    }
//    public void remove(Pair<Character,Integer> pair){
//        Node n= new Node(pair);
//        raiz.remove(n);
//    }
    public void printTree(){
        if (!isEmpty()){
            raiz.showtree();

        }
    }
//    public void balanced(){
//
//        raiz.balanced(raiz);
//    }

    public Node search(int key) {
        if (raiz == null) {
            return null;
        }
        return raiz.search(key);
    }

}

