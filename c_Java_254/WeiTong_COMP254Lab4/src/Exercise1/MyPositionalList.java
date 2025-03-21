package Exercise1;

public interface MyPositionalList<E> extends PositionalList<E> {
	public abstract Position<E> findPosition(E e);
}
