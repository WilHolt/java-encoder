
package com.wil;
import javafx.util.Pair;

import java.util.Map; // import the MAP class
import java.util.HashMap; // import the HashMap class

import java.io.BufferedReader; // import buffer reader
import java.io.InputStreamReader; // import stream reader
import java.nio.charset.StandardCharsets;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import static org.junit.Assert.assertSame;

public class Main {

    public static void readDictionary(String file){
        String dictionary = "C:/Users/joswi/Documents/caminho.txt";

        Map<Character,String> repetitions = new HashMap<Character, String>();
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(
                new FileInputStream(dictionary), StandardCharsets.UTF_8));) {
            String line;
            while(buffer.ready()){
                line = buffer.readLine();
                for(int i =0; i< line.length(); i++){
                    char aux = line.charAt(0);
                    repetitions.put(aux, (line.substring(1)));
                }
            }
            Set<Character> a = repetitions.keySet();
            for (Character t : a) {
                System.out.println(t + " letter " + repetitions.get(t) + " code");
            }
//            while((line = br.readLine()) != null){
//
//
//            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)  throws FileNotFoundException, IOException {

	// write your code here
        //TODO
        //count frequency of caracters -- read the document
        //create a encode three
        //create a encode table - to know how the code from each caracter
        heapQueue fila = new heapQueue(10);
        Pair item1 =new  Pair<>('l',4);
        Pair item2 =new  Pair<>('o',3);
        Pair item3 =new  Pair<>('p',1);
        Pair item4 =new  Pair<>('z',1);
        Pair item5 =new  Pair<>('a',3);


        Node t1 = new Node(item1);
        Node t2 = new Node(item2);
        Node t3 = new Node(item3);
        Node t4 = new Node(item4);
        Node t5 = new Node(item5);

        //act
        fila.insert(t5);
        fila.insert(t2);
        fila.insert(t3);
        fila.insert(t4);
        fila.insert(t1);

        while(fila.getSize() > 1){
            Node temp1 = fila.remove();
            Node temp2 = fila.remove();
            Node pai = new Node(temp1.getCount()+temp2.getCount());
            pai.setLeft(temp1);
            pai.setRight(temp2);
//            System.out.println(pai.getLeft());
//            System.out.println(pai.getRight());
            pai.setLeft(temp1);
            pai.setRight(temp2);
            fila.insert(pai);
            System.out.println("rodou");
        }

        fila.print();

        //////////////////////////////////////////////////////////////////////////////////


        /////////////////////////////////////////////////////////////////////////////////






        String filename = "C:/Users/joswi/Documents/lola.txt";
        Map<Character,Integer> repetitions = new HashMap<Character, Integer>();
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(
             new FileInputStream(filename), StandardCharsets.UTF_8));) {
           String line;
           line = buffer.readLine();
                       for(int i =0; i< line.length(); i++){
                           char aux = line.charAt(i);
                           Integer count = repetitions.get(aux);
                           if (count == null) {
                               repetitions.put(aux,0);

                           }
                           repetitions.put(aux, repetitions.get(aux) + 1);
        }
            Set<Character> a = repetitions.keySet();
            for (Character t : a) {
                System.out.println(t + " Ocurred " + repetitions.get(t) + " times");
            }
//            while((line = br.readLine()) != null){
//
//
//            }

        }
        String dictionary = "C:/Users/joswi/Documents/teste1.txt";

        readDictionary(dictionary);
    }

}


