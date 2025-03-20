package Exercise1;

import Exercise1.LinkedPositionalList.Node;

public interface PositionalList<E> {

	    int size();                      // 返回列表大小
	    boolean isEmpty();               // 判断列表是否为空
	    Position<E> first();             // 获取第一个位置
	    Position<E> last();              // 获取最后一个位置
	    Position<E> before(Position<E> p);  // 获取 p 之前的位置
	    Position<E> after(Position<E> p);   // 获取 p 之后的位置
	    Position<E> addFirst(E e);       // 在开头插入元素，返回新位置
	    Position<E> addLast(E e);        // 在末尾插入元素，返回新位置
	    
		default // 修饰词，可以直接在已有interface里面扩展出一个带body 的mathod
		public Position<E> findPosition(E e) { 
			Position<E> p = first(); // get first place 
			while (p != null) { // loop list 
				if ((e == null && p.getElement() == null) || (e != null && e.equals(p.getElement()))) { 
						
					return p; // find equal element 
					} 
				p = after(p); // go to next place 
					
			} 
			return null; // do not find, return null
			
		}
	}

