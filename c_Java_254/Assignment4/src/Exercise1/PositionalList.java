package Exercise1;

public interface PositionalList<E> {

	    int size();                      // 返回列表大小
	    boolean isEmpty();               // 判断列表是否为空
	    Position<E> first();             // 获取第一个位置
	    Position<E> last();              // 获取最后一个位置
	    Position<E> before(Position<E> p);  // 获取 p 之前的位置
	    Position<E> after(Position<E> p);   // 获取 p 之后的位置
	    Position<E> addFirst(E e);       // 在开头插入元素，返回新位置
	    Position<E> addLast(E e);        // 在末尾插入元素，返回新位置
	}

