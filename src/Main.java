/**
 * Класс Main является основным классом программы, в котором реализуется работа с
 * потоками и банковским счетом.
 *
 * <p>
 * В методе {@code main} создается объект класса {@link Account}, который использует
 * экземпляр класса {@link Threads} для выполнения операций снятия и пополнения средств банковского аккаунта.
 * </p>
 */

public class Main {

    /**
     * <p>
     * В методе выполняются следующие действия:
     * <ol>
     * <li> Создается объект класса {@link Account} с начальными данными.</li>
     * <li> Создается объект класса {@link Threads}, отвечающий за поток и через него
     * пополняем баланс.</li>
     * <li> Потом из основного потока выполняется операция снятия денег со счета.</li>
     * <li> Создается исключение для ожидания завершения потока (threads.join())</li>
     * <li> Выводятся итоговые значения баланса.</li>
     * </ol>
     * </p>
     *
     * @param args массив строк (не используется).
     *
     */

    public static void main(String[] args) {
       Account account = new Account();
       Threads threads = new Threads(account);

       threads.start();
       account.withdraw(550);

       System.out.println("Баланс (после снятия): " + account.getBalance());

        try {
            threads.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Баланс (после пополнения): " + account.getBalance());

    }
}