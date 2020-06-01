package no.hvl.dat102.stabelArray;

public class MainStabel {

    public static void main(String[] args) {

        ArrayStack stack = new ArrayStack(10);

        stack.push(new Employee("Asgeir", "Sjefesen", 123));
        stack.push(new Employee("Elton", "John", 4567));
        stack.push(new Employee("Harry", "Nilsson", 22));
        stack.push(new Employee("Tom", "Venster", 3242));
        stack.push(new Employee("Jens", "Jensen", 1337));

        // stack.printStack();

        System.out.println(stack.peek());

        System.out.println("Poppet " + stack.pop());
        System.out.println(stack.peek());

    }

}
