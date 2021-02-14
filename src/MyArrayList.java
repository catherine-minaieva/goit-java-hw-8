import java.util.Arrays;

public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private E[] elements = (E[]) new Object[DEFAULT_CAPACITY];

    public E get(int index) {
        return (E) elements[index];
    }


    public int size() {
        return size;
    }

    public void clear() {
        elements = Arrays.copyOf(elements, 0);
        size = 0;
    }

    public void remove(int index) {
        E value = (E) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        --size;
    }

    public void add(Object value) {

        if (size >= elements.length) {
            resizeMyArray();
        }
        elements[size] = (E) value;
        size++;
    }


    @Override
    public String toString() {
        return Arrays.toString(elements);
    }


    private void resizeMyArray() {
        size = (size * 3) / 2 + 1;
        elements = Arrays.copyOf(this.elements, size);
    }
}

class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<String> subjects = new MyArrayList<>();
        subjects.add("Уголовное право");
        subjects.add("Гражданское право");
        subjects.add("Конституционное право");
        subjects.add("Трудовое право");
        subjects.add("Административное право");
        subjects.add("Налоговое право");
        subjects.add("Финансовое право");
        subjects.add("Трудовое право");
        subjects.add("Административное право");

        System.out.println(subjects);
        System.out.println(subjects.size());

        System.out.println(subjects.get(1));

        subjects.remove(2);
        System.out.println(subjects);
        System.out.println(subjects.size());


        subjects.clear();
        System.out.println(subjects);
        System.out.println(subjects.size());
    }
}
