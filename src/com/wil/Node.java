package com.wil;

import javafx.util.Pair;

public class Node {
        private int letter;
        private int count;
        private Node left;
        private Node right;
        public Node(Pair<Character,Integer> pair) {
                this.letter = pair.getKey();
                this.count = pair.getValue();
        }
        public Node(int value){
                this.count = value;
        }
        public Node getLeft() {
                return this.left;
        }

        public Node getRight() {
                return this.right;
        }

        public void setLeft(Node left) {
                this.left = left;
        }

        public void setRight(Node right) {
                this.right = right;
        }

        public int getLetter() {
                return this.letter;
        }
        public int getCount() {
                return this.count;
        }

        public void insert(Node node) {
                if (node.getCount() < this.getCount()) {
                        if (this.left == null) {
                                this.left = node;
                        } else {
                                this.left.insert(node);
                        }
                } else if (node.getCount() > this.getCount()) {
                        if (this.right == null) {
                                this.right = node;
                        } else {
                                this.right.insert(node);
                        }
                }
        }
        public void insert(Node node, boolean first) {
                if (first == true) {
                        if (this.left == null) {
                                this.left = node;
                        } else {
                                this.left.insert(node, true);
                        }
                } else {
                        if (this.right == null) {
                                this.right = node;
                        } else {
                                this.right.insert(node, false);
                        }
                }
        }

        public Node search(int key) {
                if (key == this.getCount()) {
                        return this;
                }

                if (key < this.getCount()) {
                        if (this.left != null) {
                                return this.left.search(key);
                        }
                }

                if (key > this.getCount()) {
                        if (this.right != null) {
                                return this.right.search(key);
                        }
                }

                return null;
        }
//
//        public Node remove(Node node) {
//                /* melhor caso: nó folha*/
//                if (node.getCount() == this.getCount()) {
//                        if (this.right == null && this.left == null) {
//                                return null;
//                        } else {
//                                if (this.left != null && this.right == null) {
//                                        return this.left;
//                                } else if (this.right != null && this.left == null) {
//                                        return this.right;
//                                } else {//filho no left e no right
//                                        Node aux = this.left;
//                                        while (aux.right != null) {//vai ate o ultimo filho da subarvore da esquerda
//                                                aux = aux.right;
//                                        }
//                                        //inversão dos valores do valor que queremos remover e do maior valor da subarvore esquerda
//                                        Node temp = this;
//                                        this.getCount() = aux.getCount();
//                                        aux.getCount() = temp;
//
//                                        this.left = left.remove(node);
//                                }
//                        }
//                } else if (node.getCount() < this.getCount()) {
//                        this.left = this.left.remove(node);
//                } else if (node.getCount() > this.getCount()) {
//                        this.right = this.right.remove(node);
//                }
//                return this;//retorna a arvore/subarvore
//        }
public void showtree() {
        System.out.println("FOLHA : ");
        System.out.print(this.getCount() + "  ");
        if (this.left != null) {
                this.left.showtree();
        }
        if (this.right != null) {
                this.right.showtree();
        }

}
}
