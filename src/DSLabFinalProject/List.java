package DSLabFinalProject;

public interface List<T> extends Collection<T> {
    T get(int index);
    void set(int index, T data);
    void add(int index, T data);
    T remove(int index);
    int indexOf(T data);
    int lastIndexOf(T data);
}