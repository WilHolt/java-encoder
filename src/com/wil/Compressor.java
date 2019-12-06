package com.wil;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Compressor implements Utilities {

    public Compressor(){
//        dictionary = new HashMap<>();
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
    public void showDictionary(HashMap<Integer, String> dict){
        Set<Integer> a = dict.keySet();
        for (int t : a) {
            System.out.println(t + " letter " + dict.get(t) + " code");
        }
    }
    public void compress(Node node, List<String> textLines, String dicPath, String compressedPath) throws IOException {
        Path file = Paths.get(compressedPath);

        HashMap<Integer, String> dictionary = getDictionary(node);
        int count = 0;
        BitSet newLine = new BitSet();

        System.out.println(textLines);
       for(String line : textLines){
           for ( int lineReader =  0; lineReader < line.length(); lineReader++){
//               System.out.println(line.charAt(lineReader));
               char aux = line.charAt(lineReader);
//               System.out.println( aux);
               String letterCode =  dictionary.get((int) aux);
               for(int k = 0 ; k < letterCode.length(); k++){
                   if(letterCode.charAt(k) == '0'){
                       count++;
                   }else{
//                       System.out.println("escreve 1");
                       newLine.set(count);
                       count++;
//                       System.out.println(newLine);
                       StringBuilder s = new StringBuilder();
//                       for( int i = 0; i < newLine.length();  i++ )
//                       {
//                           s.append( newLine.get( i ) == true ? 1: 0 );
//                       }
//                       System.out.println(s);
                   };
               }
           }

           System.out.println("to string bitset: "+ newLine.toString());
           String letterCode =  dictionary.get((int) '¨');
           for(int k = 0 ; k < letterCode.length(); k++){
               if(letterCode.charAt(k) == '0'){
                   count++;
               }else{
//                       System.out.println("escreve 1");
                   newLine.set(count);
                   count++;
//                       System.out.println(newLine);
                   StringBuilder s = new StringBuilder();
//                       for( int i = 0; i < newLine.length();  i++ )
//                       {
//                           s.append( newLine.get( i ) == true ? 1: 0 );
//                       }
//                       System.out.println(s);
               };
           }
           saveFile(newLine,file);

       }

        saveDictionary(getDictionary(node),dicPath);

    }

    private void saveDictionary(HashMap<Integer, String> dict, String dicPath) throws IOException {

        Path path  = Paths.get(dicPath);
        BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
        Set<Integer> a = dict.keySet();
        StringBuilder temp = new StringBuilder("");
        for (int t : a) {
            //System.out.println(t + " letter " + dict.get(t) + " code");
            temp.append(((char) t));
            temp.append(dict.get(t));
            //System.out.println("Linha: "+ temp);
            save(writer,temp.toString());
            temp.delete(0, temp.length());
        }
        writer.close();
    }

    public void saveFile(BitSet line, Path file) throws IOException {
        Files.write(file, line.toByteArray());
    }

    @Override
    public void save(BufferedWriter writer,String lineToSave) throws IOException {
        writer.write(lineToSave+'\n');
    }
}
