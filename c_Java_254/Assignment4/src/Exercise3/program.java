package Exercise3;

public class program {

		
	  public static void main(String[] args) {
		  LinkedQueue<Integer> testQueue = new LinkedQueue<>(); 
		  testQueue.enqueue(1);                         
		  testQueue.enqueue(2);    
		  testQueue.enqueue(3);
		  testQueue.enqueue(4);
		  testQueue.enqueue(5);
		  testQueue.enqueue(6);
		  testQueue.enqueue(7);
	  
		  LinkedQueue<Integer> testQueue2 = new LinkedQueue<>(); 
		  testQueue2.enqueue(11);                           
		  testQueue2.enqueue(12);    
		  testQueue2.enqueue(13);
		  testQueue2.enqueue(14);
		  testQueue2.enqueue(15);
		  testQueue2.enqueue(16);
		  testQueue2.enqueue(17);
		  
		  testQueue.concatenate(testQueue2);


	        System.out.println("testQueue after concatenate:");
	        testQueue.printQueue();

	        System.out.println("testQueue2 after concatenate:");
	        testQueue2.printQueue();
	  }

}
