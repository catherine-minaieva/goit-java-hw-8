import java.util.Arrays;

public class MyLinkedList<T> {

    private Node<T> first;
    private Node<T> last;

    private int count;
    private int size = 0;

    private static class Node<T> {
        Node<T> prev;
        Node<T> next;
        T data;

        public Node(Node<T> prev, T data, Node<T> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    public boolean add(T o) {
        Node<T> l = last;
        Node<T> newNode = new Node<T>(l, o, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        count++;
        return true;
    }

    public T get(int i) {
        Node<T> x = getNode(i);
        return x == null ? null : x.data;
    }

    private Node getNode(int i) {
        if (i >= size) {
            return null;
        }
        if (i < (size >> 1)) {

            Node x = first;
            for (int j = 0; j < i; j++) {
                x = x.next;
            }
            return x;
        } else {
            Node x = last;
            for (int j = size - 1; j > i; j--) {
            x = x.prev;
            }
            return x;
        }
    }

    public T remove(int i) {
        Node<T> x = getNode(i);
        if (x == null) {
            return null;
        }
        return remove(x);
    }

    private T remove(Node<T> x) {
        T oldData = x.data;
        Node<T> prev = x.prev;
        Node<T> next = x.next;

        if (prev == null) {
            first = x.next;
        } else {
            prev.next = next;
            x.prev = null;
        }
        if (next == null) {
            last = x.prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        x.data = null;
        size--;
        count++;
        return oldData;
    }

    public int size() {
        return size;
    }

    public void clear() {
        last = null;
        first = null;
        size = 0;
    }

    public T[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (MyLinkedList.Node<T> x = first; x != null; x = x.next)
            result[i++] = x.data;
        return (T[]) result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

}


class LinkedTest {
    public static void main(String[] args) {
        MyLinkedList<String> months = new MyLinkedList<>();
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        System.out.println(months.toString());
        System.out.println(months.size());

        System.out.println(months.get(1));

        months.remove(0);
        System.out.println(months.size());
        System.out.println(months.toString());

        months.clear();
        System.out.println(months.size());
    }

}
