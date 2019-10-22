package com.wil;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;


public class heapQueue {

    private Node[] nodes;
    private int size;//quantos elementos tem
    private int capacity;//quantos elementos cabem

    public heapQueue() {
        this(10);
    }

    public heapQueue(int capacity) {
        nodes = new Node[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public void insert(Pair<Character,Integer> node) {
        insert(new Node(node));
    }

    public void insert(Node node) {
        ensureCapacity();
        nodes[getSize()] = node;
        heapifyUp(getSize());
        size++;
    }

    private void heapifyUp(int index) {
        int parentIndex = getParentIndex(index);

        if (parentIndex < 0) {
            return;
        }

        Node root    = nodes[parentIndex];
        Node node = nodes[index];
        if (node.getCount() < root.getCount()) {
            nodes[index]   = root;
            nodes[parentIndex] = node;
            heapifyUp(parentIndex);
        }
    }

    public int getParentIndex(int index) {
        return (int) Math.floor((index - 1) / 2);
    }

    private void ensureCapacity() {
        if (size == capacity) {
            nodes = Arrays.copyOf(nodes, capacity * 2);
            capacity = capacity * 2;
        }
    }

    public int getSize() {
        return size;
    }

    public Node peek() {
        if (getSize() == 0) {
            return null;
        }
        return nodes[0];
    }

    public Node remove() {
        Node temp = nodes[0];
        nodes[0] = nodes[getSize() - 1];
        nodes[getSize() - 1] = null;
        size--;
        heapifyDown(0);
//        heapify(getSize());
        return temp;
    }

    private void heapifyDown(int index) {
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;

        int childIndex = -1;
        if (leftChild < getSize()) {
            childIndex = leftChild;
        }

        if (childIndex == -1) {
            return;
        }

        if (rightChild > getSize()) {
            if (nodes[rightChild].getCount() < nodes[leftChild].getCount()) {
                childIndex = rightChild;
            }
        }

        if (nodes[index].getCount() > nodes[childIndex].getCount()) {
            Node tmp          = nodes[index];
            nodes[index]      = nodes[childIndex];
            nodes[childIndex] = tmp;
            heapifyDown(childIndex);
        }
    }
    public void print(){
        for (int i = 0; i < getSize(); i++){
            nodes[i].showtree();
        }
    }
}