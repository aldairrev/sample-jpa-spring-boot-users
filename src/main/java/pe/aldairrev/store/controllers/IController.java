package pe.aldairrev.store.controllers;

import java.util.List;


public interface IController<T, ID> {
    public List<T> index();
    public T show(ID id);
    public T create(T t);
    public T update(ID id, T t);
    public T delete(ID id);
}
