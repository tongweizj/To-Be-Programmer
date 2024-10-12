//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        testBank();
    }
    public static void testBank(){
        Bank bank1= new Bank();
        Bank bank2= new Bank();
//        for(Account item:bank1.accountList){
//            System.out.println(item);
//            item.withdraw(3000);
//            item.deposit(100000);
//        }
//        for(Account item:bank2.accountList){
//            System.out.println(item);
//            item.withdraw(30000);
//            item.deposit(200000);
//        }
        // bank1
        bank1.accountList.get(0).deposit(1000.00);
        bank1.accountList.get(0).withdraw(1000.00);
        bank1.accountList.get(1).deposit(2000.98);
        bank1.accountList.get(1).withdraw(2000.78);
        bank1.accountList.get(2).deposit(20000.76);
        bank1.accountList.get(2).withdraw(20000.56);
        bank1.accountList.get(3).deposit(20000.87);
        bank1.accountList.get(3).withdraw(20000.56);
        bank1.accountList.get(4).deposit(20000.54);
        bank1.accountList.get(4).withdraw(20000.65);
        bank1.accountList.get(5).deposit(20000.77);
        bank1.accountList.get(5).withdraw(20000.88);

        for(Account item:bank1.accountList){
            System.out.println(item);
        }

    }
}