package no.hvl.dat102.treInt;

public class Main {

    public static void main(String[] args) {

        Tree Tree = new Tree();
        Tree.insert(25);
        Tree.insert(20);
        Tree.insert(15);
        Tree.insert(27);
        Tree.insert(17);
        Tree.insert(30);
        Tree.insert(29);
        Tree.insert(26);
        Tree.insert(22);
        Tree.insert(32);

        Tree.traverseInOrder();
        System.out.println();

        System.out.println(Tree.get(27));
        System.out.println(Tree.get(17));
        System.out.println(Tree.get(8888));

        System.out.println(Tree.min());
        System.out.println(Tree.max());

        Tree.delete(8888);
        Tree.traverseInOrder();
        System.out.println();

    }
}