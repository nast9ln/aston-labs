import java.util.*;
import java.util.stream.Collectors;

public class PuttingIntoPractice {
    private static List<Transaction> transactions;

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        System.out.println("Задание 1 :");
        printCollection(findTransactionsAt2011AndSortByValue(transactions));

        System.out.println("Задание 2 :");
        printCollection(getCitiesWithoutRepetition(transactions));

        System.out.println("Задание 3 :");
        printCollection(findTradersFromCambridgeAndSortByName(transactions));

        System.out.println("Задание 4 :");
        System.out.println(getNamesOfTraders(transactions) + "\n");

        System.out.println("Задание 5 :");
        System.out.println(checkThereIsTraderFromMilan(transactions) + "\n");

        System.out.println("Задание 6 :");
        System.out.println(getSumOfAllTradersFromCambridge(transactions) + "\n");

        System.out.println("Задание 7 :");
        System.out.println(findMaxValueOfTransactions(transactions) + "\n");

        System.out.println("Задание 8 :");
        System.out.println(findTransactionWithMinValue(transactions));
    }

    //1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей
//к большей).
    public static List<Transaction> findTransactionsAt2011AndSortByValue(Collection<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .toList();
    }

    //2. Вывести список неповторяющихся городов, в которых работают трейдеры.
    public static Set<String> getCitiesWithoutRepetition(Collection<Transaction> transactions) {
        return transactions.stream()
                .map(t -> t.getTrader().getCity())
                .collect(Collectors.toSet());
    }

    // 3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
    public static List<Trader> findTradersFromCambridgeAndSortByName(Collection<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> Objects.equals(trader.getCity(), "Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .toList();
    }

    //4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном
//порядке.
    public static String getNamesOfTraders(Collection<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .map(Trader::getName)
                .sorted()
                .collect(Collectors.joining(", "));
    }


    //5. Выяснить, существует ли хоть один трейдер из Милана.
    public static boolean checkThereIsTraderFromMilan(Collection<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .anyMatch(trader -> trader.getCity().equals("Milan"));
    }

    //6. Вывести суммы всех транзакций трейдеров из Кембриджа.
    public static int getSumOfAllTradersFromCambridge(Collection<Transaction> transactions) {
        return transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .mapToInt(Transaction::getValue)
                .sum();
    }

    //7. Какова максимальная сумма среди всех транзакций?
    public static int findMaxValueOfTransactions(Collection<Transaction> transactions) {
        return transactions.stream()
                .mapToInt(Transaction::getValue)
                .max()
                .orElse(0);
    }

    //8. Найти транзакцию с минимальной суммой.
    public static Transaction findTransactionWithMinValue(Collection<Transaction> transactions) {
        return transactions.stream()
                .min(Comparator.comparingInt(Transaction::getValue))
                .orElseThrow();
    }

    public static <T> void printCollection(Collection<T> list) {
        for (T element : list) {
            System.out.println(element);
        }
        System.out.println();
    }
}
