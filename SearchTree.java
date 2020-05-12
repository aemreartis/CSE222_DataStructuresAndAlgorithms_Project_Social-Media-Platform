public interface SearchTree<E> {
    E find(E target);
    E delete(E target);
    boolean add(E item);
    boolean contains(E target);
    boolean remove(E target);
}