package Exercise1;


public class LinkedPositionalList<E> implements PositionalList<E> { 
	// 内部链表节点 
	private static class Node<E> implements Position<E> { 
		private E element; 
		private Node<E> prev, next; 
		
		public Node(E e, Node<E> p, Node<E> n) { 
			element = e; 
			prev = p; 
			next = n; 
			} 
		public E getElement() { 
			return element; 
			} 
		} 
	// 维护头尾哨兵 
	private Node<E> header, trailer; 
	private int size = 0; 
	public LinkedPositionalList() { 
		header = new Node<>(null, null, null); 
		trailer = new Node<>(null, header, null); 
		header.next = trailer; 
		} 
	public int size() {
		return size; 
		} 
	public boolean isEmpty() { 
		return size == 0; 
		} 
	public Position<E> first() { 
		return header.next == trailer ? null : header.next; 
		}
	public Position<E> last() { 
		return trailer.prev == header ? null : trailer.prev; 
		} 
	public Position<E> after(Position<E> p) { 
		return ((Node<E>) p).next == trailer ? null : ((Node<E>) p).next; 
		} 
	
	public Position<E> before(Position<E> p) { 
		return ((Node<E>) p).prev == header ? null : ((Node<E>) p).prev; 
		} 
	public Position<E> addFirst(E e) { 
		return addBetween(e, header, header.next); 
		} 
	
	public Position<E> addLast(E e) { 
		return addBetween(e, trailer.prev, trailer); 
		} 
	private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) { 
		Node<E> newest = new Node<>(e, pred, succ); 
		pred.next = newest; 
		succ.prev = newest; 
		size++; return newest; 
		}
	
	
	
	public Position<E> findPosition(E e) { 
		Position<E> p = first(); // get first place 
		while (p != null) { // loop list 
			if ((e == null && p.getElement() == null) || (e != null && e.equals(p.getElement()))) { 
				System.out.println(p.getElement() + ", prev:" + ((Node<E>) p).prev.getElement()+ ", next: " + ((Node<E>) p).next.getElement()); //
				
				return p; // find equal element 
				} 
			p = after(p); // go to next place 
				
		} 
		return null; // do not find, return null
		
	}
	

public static void main(String[] args) { 
	
	LinkedPositionalList<String> list = new LinkedPositionalList<>(); 
	Position<String> p1 = list.addLast("A"); 
	Position<String> p2 = list.addLast("B"); 
	Position<String> p3 = list.addLast("C"); 
	
	// Test for normal
	System.out.println(((list).findPosition("B") == p2) + "\n"); // true 
	System.out.println(((list).findPosition("C") == p3) + "\n"); // true 
	
	// Test: can not find 
	System.out.println("D position is: "+ list.findPosition("D") ); // true 
	
	// Test: empty list 
	LinkedPositionalList<Integer> emptyList = new LinkedPositionalList<>(); 
	System.out.println("5 position is: "+ emptyList.findPosition(5)); 
	
	// Test： null  
	list.addLast(null); 
	System.out.println(list.findPosition(null) != null); // true
	}

}
