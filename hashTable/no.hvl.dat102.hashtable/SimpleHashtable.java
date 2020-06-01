package no.hvl.dat102.hashtable;

public class SimpleHashtable {

    private Employee[] hashtable;

    public SimpleHashtable() {
        hashtable = new Employee[10];
    }

    public void put (String key, Employee employee) {
        int hashedKey = hashKey(key);
        if (hashtable[hashedKey] != null)
            System.out.println("Sorry, det er allerede en 'Employee' i posisjon " + hashedKey);
        else
            hashtable[hashedKey] = employee;
    }

    public Employee get(String key) {
        int hashedKey = hashKey(key);
        return hashtable[hashedKey];
    }

    public int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++)
            System.out.println(hashtable[i]);
    }


}
