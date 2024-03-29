package com.wil;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Set;

public class Extractor {
    heapQueue buffer;
    heapQueue dictionary;
    public Extractor(){

    }
    public void extract(String arrayFile, String dicFile, String extractedPath) throws IOException {
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
        BitSet bitset = new BitSet();
        bitset = BitSet.valueOf(bArray);
        StringBuilder aux = new StringBuilder("");
        StringBuilder SBtoSave = new StringBuilder("");
        String StringToSave;
        ///SÓ PRA CONFERIR
        for (int i=0; i< bitset.length(); i++) {
            if(bitset.get(i) == true) {
                aux.append("1");
//                System.out.println("o aux feito:" + aux);
                char temp =findInDictionary(readDictionary(dicFile), aux);
                System.out.println("caso 1:"+temp);
                if(temp != '`'){
                    if (temp == '¨') {
                        System.out.print(temp);
                        SBtoSave.append('\n');
                        aux.delete(0,aux.length());
                    }else{
                        System.out.print(temp);
                        SBtoSave.append(temp);
                        aux.delete(0,aux.length());

                    }



                }

            }else{
                aux.append("0");
                char temp =findInDictionary(readDictionary(dicFile), aux);
                System.out.println("caso 2"+ temp);
                 if(temp != '`'){
                     if (temp == '¨') {
                         System.out.print(temp);
                         SBtoSave.append('\n');
                         aux.delete(0,aux.length());
                     }else{
                         System.out.print(temp);
                         SBtoSave.append(temp);
                         aux.delete(0,aux.length());
                     }

                }
            }
        }
        StringToSave = SBtoSave.toString();
        saveFile(StringToSave,extractedPath);
        }

    private void saveFile(String stringToSave,String extractedPath) throws IOException {
        Path file = Paths.get(extractedPath);
//        Files.writeString(file, stringToSave,);
        try (BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
            writer.write(stringToSave);
        }

    }

    private char findInDictionary(HashMap<Character,String> dictionary,  StringBuilder aux) {
        char letter = '`';
//        System.out.println("aux recebido:" + aux);
        Set<Character> a = dictionary.keySet();
        String expected = aux.toString();
        for (char t : a) {
//            System.out.println(t + " letter " + dictionary.get(t) + " code");
            String letterCode = dictionary.get(t);
            if((letterCode.equals(expected))){
                letter = t;
                return letter;
            }

        }

        return letter;
    }

    public static HashMap<Character,String> readDictionary(String file){
        String dictionary = "";
        HashMap<Character,String> dict = new HashMap<Character, String>();
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(
                new FileInputStream(file), StandardCharsets.UTF_8));) {
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


