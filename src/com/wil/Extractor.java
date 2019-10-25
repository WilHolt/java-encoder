package com.wil;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Extractor {
    heapQueue buffer;
    heapQueue dictionary;
    public Extractor(){

    }
    public void extract(String arrayFile, String dicFile) throws IOException {
        File file = new File(arrayFile);
        FileInputStream fis = null;
        // Creating a byte array using the length of the file
        // file.length returns long which is cast to int
        byte[] bArray = new byte[(int) file.length()];
        try{
            fis = new FileInputStream(file);
            fis.read(bArray);
            fis.close();

        }catch(IOException ioExp){
            ioExp.printStackTrace();
        }
        BitSet bitset;
        bitset = BitSet.valueOf(bArray);
        StringBuilder aux = new StringBuilder("");
        ///SÓ PRA CONFERIR
        for (int i=0; i< bitset.length(); i++) {
            if(bitset.get(i) == true) {
                System.out.print("1");
                aux.append("1");
                char temp =findInDictionary(readDictionary(dicFile), aux);
                if(temp != ' '){
                    System.out.print(temp);
                }
                if(temp == 'l'){
                    aux.delete(0,aux.length());
                }
            }else{
                System.out.print("0");
                aux.append("0");
                if(findInDictionary(readDictionary(dicFile), aux) !=  ' '){
                    System.out.print(findInDictionary(readDictionary(dicFile), aux));
                    aux.delete(0,aux.length());
                }
            }
        }

        }

    private char findInDictionary(HashMap<Character,String> dictionary,  StringBuilder aux) {
        char letter = ' ';
        Set<Character> a = dictionary.keySet();
        for (char t : a) {
//            System.out.println(t + " letter " + dictionary.get(t) + " code");
            String letterCode = dictionary.get(t);
            letter = t;
            if(letterCode == aux.toString()){
                return letter;
            }
        }

        for ( int mapReader =  0; mapReader < aux.length(); mapReader++){

            }
        return letter;
    }

    public static HashMap<Character,String> readDictionary(String file){
        String dictionary = "C:/Users/joswi/Documents/caminho.txt";
        HashMap<Character,String> dict = new HashMap<Character, String>();
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(
                new FileInputStream(dictionary), StandardCharsets.UTF_8));) {
            String line;
            while(buffer.ready()){
                line = buffer.readLine();
                for(int i =0; i< line.length(); i++){
                    char aux = line.charAt(0);
                    dict.put(aux, (line.substring(1)));
                }
            }
            Set<Character> a = dict.keySet();
            for (Character t : a) {
//                System.out.println(t + " letter " + dict.get(t) + " code");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dict;
    }
    }


