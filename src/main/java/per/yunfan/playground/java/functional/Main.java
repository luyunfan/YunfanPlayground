package per.yunfan.playground.java.functional;

import java.util.function.Consumer;

class List<T> {
    private T _head;

    private List<T> tail;

    public List(T head, List<T> tail) {
        _head = head;
        this.tail = tail;
    }

    private List() {
    }

    public boolean isEmpty() {
        return false;
    }

    public void foreach(Consumer<T> action) {
        if (tail == null) return;
        action.accept(_head);
        tail.foreach(action);
    }

    public static <T> List<T> of(T... values) {
        List<T> newList = new List<>();
        for (int i = values.length - 1; i >= 0; i--)
            newList = new List<>(values[i], newList);
        return newList;
    }
}

class Nil<T> extends List<T> {
    @Override
    public boolean isEmpty() {
        return true;
    }

    public Nil(T head, List<T> tail) {
        super(head, tail);
    }
}

public class Main {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.foreach(System.out::println);
    }
}