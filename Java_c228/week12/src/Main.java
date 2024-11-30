import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

// collection basic mathod
// loop
// add
// delete
//
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // testStack();
//        testQueue();
        testHashTable();
    }
    static void testStack(){
            System.out.println("Stack operations.....\n");
            // create a stack of integer number
            Stack<Integer> numberStack = new Stack<>();
            // add elements to stack using push() method
            numberStack.push(56);
            numberStack.push(562);
            numberStack.push(512);
            numberStack.push(262);
            numberStack.push(632);
            numberStack.push(560);
            System.out.println("Number: " + numberStack.size());
            System.out.println("Is empty:" + numberStack.isEmpty());

            // for loop: bottom to top
//            for(Integer num : numberStack){
//                System.out.println("num:" + num);
//            }


            // ListIterator(top to bottom)
            ListIterator<Integer> stackIterator = numberStack.listIterator(numberStack.size());
            while(stackIterator.hasPrevious()){
                System.out.println("num:" + stackIterator.previous());
            }

            // find the top item
            System.out.println("top most:" +numberStack.peek());

            // search()
            if(!numberStack.isEmpty()){
                int position = numberStack.search(56);
                // no, out -1
                // yes, out index
                if(position == -1){
                    System.out.println("sorry");

                }else{
                    System.out.println("index:" + position);
                }
            }else {
                System.out.println("Sorry");
            }

            // delete
            Integer deletedElement = numberStack.pop();
            System.out.println("pop:" + deletedElement);

            // get index item
            // bottom to top
            Integer indexItem = numberStack.elementAt(1);

            indexItem = numberStack.elementAt(numberStack.size()-2); // get top
            System.out.println("elementAt:" + indexItem);

        }
    static void testQueue(){
        System.out.println("Stack operations.....\n");
        Queue<String> peopleQueen = new LinkedList<String>();

        peopleQueen.add("AA");
        peopleQueen.add("BB");
        peopleQueen.add("CC");
        peopleQueen.add("DD");
        peopleQueen.add("EE");

        System.out.println("size:" + peopleQueen.size());
        System.out.println("peek:" + peopleQueen.peek());
        // all
        for(String person : peopleQueen){
            System.out.println("Attending" + person);
        }

        if(!peopleQueen.isEmpty()){
            // element() to access first element
            peopleQueen.remove();
            String ele = peopleQueen.element();
            System.out.println("ele: " + ele);

            // search
            String search = "BB";
            if(peopleQueen.contains(search)){
                System.out.println(search + "in the queue");
            }else {
                System.out.println("sorry");
            }
        }

    }
    static void testHashTable(){
        System.out.println("Stack operations.....\n");
/*
* <key, value> pair
* */
        Hashtable<Integer, String> errorCode = new Hashtable<>();
        // add
        errorCode.put(1,"AA");
        errorCode.put(2,"BB");
        errorCode.put(10,"CC");
        errorCode.put(51,"DD");
        errorCode.put(101,"EEW");
        errorCode.put(109,"WW");

        for(String msg : errorCode.values()){
            System.out.println(msg);
        }

        for(Integer key : errorCode.keySet()){
            System.out.println(key);
            System.out.println(errorCode.get(key));

        }
        Collection x = errorCode.values();
        System.out.println(errorCode.values());
        System.out.println(errorCode.keySet());

        if(errorCode.containsKey(109)){
            System.out.println("109 is exit");
        }


        // how to add
        // put

        // how to delete
        // remove

        // how to loop
        // key and value

        // how to search
        // containsValue
        String searchValue = "AA";
        if(errorCode.containsValue(searchValue)){
            System.out.println("find it");
        }else{
            System.out.println("can not find it");
        }

    }
//    static void testStack(){
//        System.out.println("Stack operations.....\n");
//    }
//    static void testStack(){
//        System.out.println("Stack operations.....\n");
//    }

}