package exercise;
import exercise.exampleClass.BankAccount;
public class Get_Set_BankAccount {
    public static void main(String[] args){
        BankAccount account1 = new BankAccount("1234-5678-9012-3456","John Doe",1000.00);
        account1.deposit();
        account1.withdraw();
        account1.getBalance();
    }
}