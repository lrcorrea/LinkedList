package ex;

public interface IConjunto<T>{
    public void add(T obj);
    public void remove(T obj);
    public boolean empty();
    public boolean contains(T obj);
    //public int size();
    //public IConjunto<T> intersection(IConjunto<T> b);
    //public IConjunto<T> union(IConjunto<T> b);
}
