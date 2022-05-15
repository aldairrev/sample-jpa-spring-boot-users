package pe.aldairrev.store.services;

import java.util.List;

public interface IService<T, ID> {
    public List<T> getAll();
    public T find(ID id);
    public T create(T t);
    public T update(T t);
    public T delete(ID id);
}
