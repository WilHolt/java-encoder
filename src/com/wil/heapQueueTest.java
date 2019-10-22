package com.wil;
import javafx.util.Pair;
import org.junit.Test;


import static org.junit.Assert.*;

public class heapQueueTest {

    @Test
    public void isPopulating() {
      //arrange
        heapQueue fila = new heapQueue(10);
        Pair item1 =new  Pair<>('l',2);
        Pair item2 =new  Pair<>('l',5);
        Pair item3 =new  Pair<>('0',13);
        Pair item4 =new  Pair<>('0',12);
        Pair item5 =new  Pair<>('0',9);


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


        //Assert
        assertSame(t1,fila.peek());
    }
    @Test
    public  void removeLast(){
        //arrange
        heapQueue fila = new heapQueue(10);
        Pair item1 =new  Pair<>('l',2);
        Pair item2 =new  Pair<>('l',1);
        Pair item3 =new  Pair<>('o',13);
        Pair item4 =new  Pair<>('i',12);
        Pair item5 =new  Pair<>('g',9);


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
        System.out.println(fila.remove());
        System.out.println(fila.remove());

        //Assert
        assertSame(t5,fila.peek());
    }
    @Test
    public void itMustUpdateWhenAgeChanges() {
//        //Arrange
//        FilaBanco  fila = new FilaBanco();
//        Pessoa p1 = new Pessoa("Fulano", 10);
//        Pessoa p2 = new Pessoa("Beltrano", 20);
//        fila.insert(p1);
//        fila.insert(p2);
//
//        //Act
//        p1.setIdade(21);
//
//        //Assert
//        assertSame(p1, fila.peek());
    }

    @Test
    public void itMustInsertElements() {
//        //Arrange
//        FilaBanco fila = new FilaBanco();
//
//        //Act
//        int size = fila.getSize();
//        fila.insert("Fulano", 10);
//
//        //Assert
//        assertEquals(size + 1, fila.getSize());
    }

    @Test
    public void itMustRemoveElements() {
//        //Arrange
//        FilaBanco fila = new FilaBanco();
//
//        //Act
//        fila.insert("Fulano", 10);
//        int size = fila.getSize();
//        fila.remove();
//
//        //Assert
//        assertEquals(size - 1, fila.getSize());
    }

    @Test
    public void itMustReturnElement() {
//        //Arrange
//        FilaBanco fila = new FilaBanco();
//        Pessoa fulano = new Pessoa("Fulano", 20);
//
//        //Act
//        fila.insert(fulano);
//
//        //Assert
//        assertSame(fulano, fila.peek());
    }



}
