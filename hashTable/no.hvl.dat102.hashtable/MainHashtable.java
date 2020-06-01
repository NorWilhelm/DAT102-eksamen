package no.hvl.dat102.hashtable;

public class MainHashtable {

    public static void main(String[] args) {

        SimpleHashtable ht = new SimpleHashtable();

        ht.put("Asgeir", new Employee("Asgeir", "Sjefesen", 123));
        ht.put("Elton", new Employee("Elton", "John", 4567));
        ht.put("Harry", new Employee("Harry", "Nilsson", 22));
        ht.put("Tom", new Employee("Tom", "Venster", 3242));
        ht.put("Jens", new Employee("Jens", "Jensen", 1337));

        // Her skaper vi en kolisjon med å bruke samme nøkkel for to forskjellige verdier
        ht.put("Jens", new Employee("Jens", "Monsen",  9001));

        ht.printHashtable();

        System.out.println("Henter nøkkel Tom " + ht.get("Tom"));

        // ht.printStack();



    }

}

