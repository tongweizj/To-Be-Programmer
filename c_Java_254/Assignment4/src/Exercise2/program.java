package Exercise2;

public class program {
	public static <E> ArrayStack<E> cleanStack(ArrayStack<E> stack){
		if(stack.isEmpty()) {
			return new ArrayStack<>();
		}else {
			 System.out.println(stack.pop());
			 cleanStack(stack);
		}
		return stack;
	}
	
	
	  public static void main(String[] args) {
		ArrayStack<Integer> testStack = new ArrayStack<>();  // contents: ()
	    testStack.push(5);                              // contents: (5)
	    testStack.push(3);                              // contents: (5, 3)
	    testStack.push(7);                              // contents: (7)
	    testStack.push(9);                              // contents: (7, 9) 9
	    testStack.push(4);                              // contents: (7, 9, 4)
	    testStack.push(6);                              // contents: (7, 9, 6)
	    testStack.push(8);                              // contents: (7, 9, 6, 8)
	    ArrayStack<Integer> clearedStack = cleanStack(testStack);
	    System.out.println("Stack after cleanStack:");
        System.out.println("Is the stack empty? " + clearedStack.isEmpty());
	  }

}
