//Hussein H ex12
class QueueFullException extends Exception {
    public QueueFullException(String message) {
        super(message);
    }
}

class QueueEmptyException extends Exception {
    public QueueEmptyException(String message) {
        super(message);
    }
}

class Queue<E> {
    private E[] elements;
    private int index = 0;
    private int size;

    Queue(int size) {
        elements = (E[]) new Object[size];
        this.size = size;
    }

    void enqueue(E element) throws QueueFullException {
        if (index >= size) {
            throw new QueueFullException("");
        }

        elements[index] = element;
        index++;
    }

    E dequeue() throws QueueEmptyException {
        if (index == 0) {
            throw new QueueEmptyException("");
        }

        E returnElement = elements[0];
        // Shift elements to the left after dequeue
        for (int i = 0; i < index - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[index - 1] = null; // Remove the last element
        index--;
        return returnElement;
    }
}

public class Main {
    public static void main(String[] args) {
        Queue<String> strings = new Queue<>(2);
        try {
            strings.enqueue("Hello");
            strings.enqueue("World");
            System.out.println(strings.dequeue());
            System.out.println(strings.dequeue());
        } catch (QueueFullException | QueueEmptyException e) {
            e.printStackTrace();
        }
    }
}
