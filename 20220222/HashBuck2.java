import java.util.HashMap;
import java.util.Objects;

/**
 * Date: 2022/2/22
 * Hash map/table
 */
class Person {
    public String ID;

    public Person(String ID) {
        this.ID = ID;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(ID, person.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID='" + ID + '\'' +
                '}';
    }
}
public class HashBuck2<K,V> {

    static class Node<K,V> {
        public K key;
        public V val;
        public Node<K,V> next;

        public Node(K key,V val) {
            this.val = val;
            this.key = key;
        }
    }

    public Node<K,V>[] array = (Node<K,V>[])new Node[10];
    public int usedSize;

    public void put(K key,V val) {
        int hash = key.hashCode();
        int index = hash % array.length;
        Node<K,V> cur = array[index];
        while (cur != null) {
            if(cur.key.equals(key)) {
                cur.val = val;//更新val值
                return;
            }
            cur = cur.next;
        }
        Node<K,V> node = new Node<>(key, val);
        node.next = array[index];
        array[index] = node;
        this.usedSize++;
    }

    public V get(K key) {
        int hash = key.hashCode();
        int index = hash % array.length;
        Node<K,V> cur = array[index];
        while (cur != null) {
            if(cur.key.equals(key)) {
                //更新val值
                return cur.val;
            }
            cur = cur.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Person person1 = new Person("123");
        Person person2 = new Person("123");

        HashBuck2<Person,String> hashBuck2 = new HashBuck2<>();
        hashBuck2.put(person1,"bit");

        System.out.println(hashBuck2.get(person2));
    }

    public static void main1(String[] args) {
        //hashcode
        Person person1 = new Person("123");

        Person person2 = new Person("123");

        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());

        HashMap<Person,String> map = new HashMap<>();
    }
}