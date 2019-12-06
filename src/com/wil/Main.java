
package com.wil;

import javafx.util.Pair;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {


    public static void main(String[] args)  throws FileNotFoundException, IOException {
        String dicPath = args[3];
        String compressedPath = args[2];
        heapQueue fila = new heapQueue(10);
        String filename = args[1];
        Map<Character,Integer> repetitions = new HashMap<Character, Integer>();
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(
                new FileInputStream(filename), StandardCharsets.UTF_8));) {
            String line;
            while((line = buffer.readLine()) != null){
                for(int i =0; i< line.length(); i++){
                    char aux = line.charAt(i);
                    Integer count = repetitions.get(aux);
                    if (count == null) {
                        repetitions.put(aux,0);

                    }
                    repetitions.put(aux, repetitions.get(aux) + 1);
                    if(i == line.length()-1){
                        repetitions.put('¨', repetitions.get(aux) + 1);

                    }
                }

            }

        }
        Set<Character> a = repetitions.keySet();
        for (Character t : a) {
            Pair item =new  Pair<>(t,repetitions.get(t));
            Node node= new Node(item);
            fila.insert(node);

                System.out.println(t + " Ocurred " + repetitions.get(t) + " times");
        }

        List<String> textLines = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(
                new FileInputStream(filename), StandardCharsets.UTF_8));) {
            String line;
            while((line = buffer.readLine() )!= null ){
                textLines.add(line);
            }

        }

        if(args[0].equals("compress")) {
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
                System.out.println(pai.getCount());
            }
            Compressor comp = new Compressor();
            comp.compress(fila.peek(), textLines, dicPath, compressedPath);
        }
        if(args[0].equals("extract")){
            Extractor winrar = new Extractor();
            winrar.extract(args[1], args[2],args[3]);

        }
    }
}



