package no.hvl.dat102.stabelLinkedList;

import no.hvl.dat102.stabelArray.ArrayStack;
import no.hvl.dat102.stabelArray.Employee;

public class MainLinkedList {

    public static void main(String[] args) {

        LinkedStack stack = new LinkedStack();

        stack.push(new no.hvl.dat102.stabelArray.Employee("Asgeir", "Sjefesen", 123));
        stack.push(new no.hvl.dat102.stabelArray.Employee("Elton", "John", 4567));
        stack.push(new no.hvl.dat102.stabelArray.Employee("Harry", "Nilsson", 22));
        stack.push(new no.hvl.dat102.stabelArray.Employee("Tom", "Venster", 3242));
        stack.push(new Employee("Jens", "Jensen", 1337));

        stack.printStack();

        System.out.println("Popped: " + stack.pop());
    }
}
