import java.util.Arrays;

public class MyStack<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private E[] elements = (E[]) new Object[DEFAULT_CAPACITY];

    public E get(int index) {
        return (E) elements[index];
    }

    public void push(E e) {
        if (size == elements.length) {
            resize();
        }
        this.elements[size] = e;
        this.size++;
    }

    private void resize() {
        elements = Arrays.copyOf(elements, size * 3 / 2);
    }

    public E remove(int index) {
        E value = (E) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        --size;
        return value;
    }

    public void clear() {
        elements = Arrays.copyOf(elements, 0);
        size = 0;
    }

    public int size() {
        return size;
    }

    public E peek() {
        return elements[size - 1];
    }

    public E pop() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements, size));
    }
}


class MyStackTest {
    public static void main(String[] args) {
        MyStack<String> letters = new MyStack<>();
        letters.push("Oldest");
        letters.push("Old");
        letters.push("Mew");
        letters.push("Newest");
        System.out.println(letters.toString());
        System.out.println(letters.size());

        System.out.println(letters.peek());
        letters.pop();
        System.out.println(letters.toString());
        System.out.println(letters.size());

        letters.remove(1);
        System.out.println(letters.toString());

        letters.clear();
        System.out.println(letters.toString());

    }
}
