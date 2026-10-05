//Переработка класса BankAccount из задания 4.1 с применением принципов инкапсуляции.

package base;

//Объявляем класс с private полями: номер счёта (String), владелец (String), баланс (double).
public class BankAccount {
    //Нестатические поля (у каждого объекта свои).
    private final String accountNumber; //номер счета изменить нельзя (сеттера нет);
    private String owner; //имя владельца изменить можно (сеттер есть);
    private double balance; //баланс меняется только через методы программы (сеттера нет);
    //Статическое поле (одно для всех объектов).
    private static int totalAccounts = 0;
    //История транзакций (массив на 100 записей)
    private final String[] transactionHistory = new String[100];
    private int transactionCount = 0; //сколько записей уже добавлено

    public BankAccount(String accountNumber, String owner, double balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
        totalAccounts++;
    }

    //Добавляем геттеры для всех полей.

    //Метод getAccountNumber: возвращает номер счета.
    public String getAccountNumber() {
        return accountNumber;
    }

    //Метод getOwner: возвращает имя владельца.
    public String getOwner() {
        return owner;
    }

    //Метод getBalance: возвращает текущий баланс.
    public double getBalance() {
        return balance;
    }

    //Метод getTotalAccounts: количество созданных счетов.
    public static int getTotalAccounts() {
        return totalAccounts;
    }

    //Добавляем сеттер только для owner.

    //Метод setOwner: меняет имя владельца.
    public void setOwner(String owner) {
        if (owner == null || owner.isEmpty()) {
            throw new IllegalArgumentException("Имя владельца не может быть пустым");
        }
        this.owner = owner;
    }

    //Создаем 3 счета и проверяем все операции (методы) ниже.
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("333", "Иван Иванов", 300);
        BankAccount account2 = new BankAccount("555", "Аня Анина", 500);
        BankAccount account3 = new BankAccount("999", "Максим Максимов", 900);

        account1.deposit(100);
        account1.withdraw(350);
        account1.printStatement();

        account2.deposit(200);
        account2.withdraw(200);
        account2.printStatement();

        account3.deposit(300);
        account3.withdraw(300);
        account3.printStatement();

        printTotalAccounts();

        account1.printCheckMistake();
        account2.printCheckMistake();
        account3.printCheckMistake();
    }

    //Метод deposit: принимает сумму и увеличивает баланс.
    public void deposit(double depositSum) {
        System.out.println("====Операция пополнения===");
        //Добавляем валидацию, что сумма должна быть положительной
        if (depositSum <= 0) {
            throw new IllegalArgumentException("Сумма пополнения должна быть положительной: " + depositSum);
        }
        balance += depositSum;
        System.out.printf("Счет %s пополнен на %.2f руб. Текущий баланс: %.2f руб. %n",
                accountNumber, depositSum, balance);
        // Добавляем запись в историю
        addTransaction(String.format("Пополнение: +%.2f руб. Баланс: %.2f руб.", depositSum, balance));
        System.out.println("==========================");
    }

    //Метод withdraw: принимает сумму и уменьшает баланс (если средств достаточно, иначе выводит сообщение об ошибке).
    public void withdraw(double withdrawSum) {
        System.out.println("=====Операция списания====");
        //Добавляем валидацию, что сумма положительная и не превышает баланс
        if (withdrawSum <= 0) {
            throw new IllegalArgumentException("Сумма списания должна быть положительной: " + withdrawSum);
        }
        if (balance < withdrawSum) {
            throw new IllegalArgumentException(
                    "Недостаточно средств: запрошено " + withdrawSum + ", доступно " + balance);
        }
        balance -= withdrawSum;
        System.out.printf("Со счета %s списано %.2f руб. Текущий баланс: %.2f руб. %n",
                accountNumber, withdrawSum, balance);
        // Добавляем запись в историю
        addTransaction(String.format("Снятие: -%.2f руб. Баланс: %.2f руб.", withdrawSum, balance));
        System.out.println("==========================");
    }

    //Метод addTransaction: при каждом пополнении и снятии добавляет запись в историю.
    private void addTransaction(String record) {
        if (transactionCount < transactionHistory.length) {
            transactionHistory[transactionCount] = record;
            transactionCount++;
        } else {
            System.out.println("История транзакций заполнена!");
        }
    }

    //Метод getTransactionHistory: возвращает копию заполненной части массива.
    public String[] getTransactionHistory() {
        String[] copy = new String[transactionCount];
        for (int i = 0; i < transactionCount; i++) {
            copy[i] = transactionHistory[i];
        }
        return copy;
    }

    //Метод printStatement: выводит информацию о счёте.
    public void printStatement() {
        System.out.println("====Информация о счёте====");
        System.out.println("Номер счёта: " + getAccountNumber());
        System.out.println("Владелец: " + getOwner());
        System.out.printf("Баланс: %.2f руб. %n",
                getBalance());
        System.out.println("====История транзакций====");
        for (String record : getTransactionHistory()) {
            System.out.println(record);
            System.out.println("==========================");
        }
    }

    //Статический метод totalAccounts: считает, сколько счетов было создано.
    public static void printTotalAccounts() {
        System.out.println("Всего создано счетов: " + getTotalAccounts());
    }

    //Метод printCheckMistake: проверяет ошибки
    public void printCheckMistake() {
        System.out.println("====Проверка ошибок====");
        try {
            this.deposit(-100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: (счет " + accountNumber + "): " + e.getMessage());
        }
        try {
            this.withdraw(100000);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: (счет " + accountNumber + "): " + e.getMessage());
        }
    }
}