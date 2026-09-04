package base;

//Объявляем класс с полями: номер счёта (String), владелец (String), баланс (double).
public class BankAccount {
    //Нестатические поля (у каждого объекта свои).
    String accountNumber;
    String owner;
    double balance;
    //Статическое поле (одно для всех объектов).
    static int totalAccounts = 0;

    public BankAccount(String accountNumber, String owner, double balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
        totalAccounts++;
    }

    //Создаем 3 счета и проверяем все операции (методы) ниже.
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("333", "Иван Иванов", 300);
        BankAccount account2 = new BankAccount("555", "Аня Анина", 500);
        BankAccount account3 = new BankAccount("999", "Максим Максимов", 900);

        account1.deposit(100);
        account1.withdraw(450);
        account1.getBalance();
        account1.printStatement();
        account2.deposit(200);
        account2.withdraw(200);
        account2.getBalance();
        account2.printStatement();
        account3.deposit(300);
        account3.withdraw(300);
        account3.getBalance();
        account3.printStatement();
        printTotalAccounts();
    }

    //Метод deposit: принимает сумму и увеличивает баланс.
    public void deposit(double depositSum) {
        System.out.println("====Операция пополнения===");
        if (depositSum > 0) {
            balance += depositSum;
            System.out.printf("Счет %s пополнен на %.2f руб. Текущий баланс: %.2f руб. %n",
                    accountNumber, depositSum, balance);
        } else {
            System.out.println("Сумма пополнения не может быть отрицательной!");
        }
        System.out.println("==========================");
    }

    //Метод withdraw: принимает сумму и уменьшает баланс (если средств достаточно, иначе выводит сообщение об ошибке).
    public void withdraw(double withdrawSum) {
        System.out.println("=====Операция списания====");
        if (withdrawSum > 0) {
            if (balance >= withdrawSum) {
                balance -= withdrawSum;
                System.out.printf("Со счета %s списано %.2f руб. Текущий баланс: %.2f руб. %n",
                        accountNumber, withdrawSum, balance);
            } else {
                System.out.printf("Ошибка! Сумма списания %.2f руб. превышает остаток %.2f руб. по счету %s! %n",
                        withdrawSum, balance, accountNumber);
            }
        } else {
            System.out.println("Сумма списания не может быть отрицательной!");
        }
        System.out.println("==========================");
    }

    //Метод getBalance: возвращает текущий баланс.
    public double getBalance() {
        System.out.println("Информация о текущем балансе");
        System.out.printf("Баланс: %.2f руб. %n",
                balance);
        System.out.println("==========================");
        return balance;
    }

    //Метод printStatement: выводит информацию о счёте.
    public void printStatement() {
        System.out.println("====Информация о счёте====");
        System.out.println("Номер счёта: " + accountNumber);
        System.out.println("Владелец: " + owner);
        System.out.printf("Баланс: %.2f руб. %n",
                balance);
        System.out.println("==========================");
    }

    //Статическое поле totalAccounts считает сколько счетов было создано.
    public static void printTotalAccounts() {
        System.out.println("Всего создано счетов: " + totalAccounts);
    }
}