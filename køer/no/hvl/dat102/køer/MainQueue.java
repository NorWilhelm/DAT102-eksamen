package no.hvl.dat102.køer;

public class MainQueue {

    public static void main(String[] args) {

        ArrayQueue queue = new ArrayQueue(10);

        queue.add(new Employee("Asgeir", "Sjefesen", 123));
        queue.add(new Employee("Elton", "John", 4567));
        queue.add(new Employee("Harry", "Nilsson", 22));
        queue.add(new Employee("Tom", "Venster", 3242));
        queue.add(new Employee("Jens", "Jensen", 1337));

        queue.printQueue();

    }

}

