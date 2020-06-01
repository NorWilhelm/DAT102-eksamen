package no.hvl.dat102.stabelLinkedList;

import no.hvl.dat102.stabelArray.Employee;

import java.util.LinkedList;
import java.util.ListIterator;
/*

LinkedList har mange funksjoner som add, og indexOf, som vi ikke ønsker å kunne bruke i en stack (stabel)
Lager en egen LinkedStack klasse fordi vi kun ønsker å bruke push, pop, peek, isEmpty.

Dersom vi hadde brukt stack direkte, ville vi fått tilgang til mange fler metoder som f.eks. add og indexOf.
        Vi ønsker en klasse som oppfører seg som en stack.
*/

public class LinkedStack {

    private LinkedList<Employee> stack;

    public LinkedStack() { stack = new LinkedList<Employee>(); }

    public void push(Employee employee) { stack.push(employee); }

    public Employee pop() { return stack.pop(); }

    public Employee peek() { return stack.peek(); }

    public boolean isEmpty() { return stack.isEmpty(); }

    public void printStack() {
        ListIterator<Employee> iterator = stack.listIterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }

}
