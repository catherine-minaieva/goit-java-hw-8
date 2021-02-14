import java.util.Arrays;

public class MyQueue<E> {
    private static final int START_CAPACITY = 10;
    private Object[] queueArray = {};
    private final Object[] EMPTY = new Object[0];
    private int size = 0;

    public MyQueue() {
        this.queueArray = new Object[START_CAPACITY];
    }

    public MyQueue(int i) {
        this.queueArray = new Object[i];
    }

    public void add(E value) {
        if (size == queueArray.length) {
            resize();
        }
        this.queueArray[size] = value;
        this.size++;
    }

    private void resize() {
        queueArray = Arrays.copyOf(queueArray, size * 3 / 2);
    }

    public E remove(int index) {
        if (isIndexCorrect(index)) {
            E e = (E) queueArray[index];
            for (int i = index; i < size - 1; i++) {
                queueArray[i] = queueArray[i + 1];
            }
            size--;
            return e;
        } else {
            return null;
        }
    }

    private boolean isIndexCorrect(int index) {
        if (!(index >= 0 && index < size)) {
            System.out.println("Element[" + index + "] does not exist");
        }
        return index >= 0 && index < size;
    }

    public void clear() {
        queueArray = Arrays.copyOf(EMPTY, 0);
        size = 0;
    }

    public int size() {
        return size;
    }

    public E peek() {
        return (E) queueArray[0];
    }

    public E poll() {
        return remove(0);
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(queueArray, size));
    }
}

class MyQueueTest {
    public static void main(String[] args) {
        MyQueue<String> students = new MyQueue<>();
        students.add("Petrov");
        students.add("Ivanov");
        students.add("Sidorov");
        students.add("Galustyan");

        System.out.println(students.toString());
        System.out.println(students.size());

        System.out.println(students.peek());
        students.poll();
        System.out.println(students.toString());
        System.out.println(students.size());

        students.clear();
        System.out.println(students.toString());
        System.out.println(students.size());
    }
}

