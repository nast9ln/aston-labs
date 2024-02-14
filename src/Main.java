import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myFirstArrayList = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            myFirstArrayList.add(i);
        }

        System.out.print("Первый список целочисленных значений: ");
        for (Integer i : myFirstArrayList) {
            System.out.print(i + " ");
        }

        MyArrayList<Integer> mySecondArrayList = new MyArrayList<>(2);
        for (int i = 7; i > 0; i--) {
            mySecondArrayList.add(i);
        }
        System.out.print("\nВторой список целочисленных значений: ");
        for (Integer i : mySecondArrayList) {
            System.out.print(i + " ");
        }

        myFirstArrayList.addAll(mySecondArrayList);
        System.out.print("\nПервый список, после добавления всех элементов второго списка: ");
        for (Integer i : myFirstArrayList) {
            System.out.print(i + " ");
        }

        // проверка работы метода remove
        mySecondArrayList.remove(1);
        System.out.print("\nПервый список, после удаления элемента с индексом 1: ");
        for (Integer i : mySecondArrayList) {
            System.out.print(i + " ");
        }

        List<String> list = List.of("ast", "o", "nn!");
        MyArrayList<String> myArrayListFromCollection = new MyArrayList<>(list);
        System.out.print("\nСписок, созданный элементами коллекции: ");
        for (String str : myArrayListFromCollection) {
            System.out.print(str + " ");
        }

        System.out.println("\nПолучение элемента списка, созданного элементами коллекции, по индексу: " + myArrayListFromCollection.get(0));

        System.out.println("Получение размера первого списка: " + myFirstArrayList.size());
        System.out.println("Получение размера списка, созданного элементами коллекции, по индексу: " + myArrayListFromCollection.size());

        System.out.println("пустой ли только что созданный список?: " + new MyArrayList<>().isEmpty());
        System.out.println("пустой ли первый список?: " + new MyArrayList<>(myFirstArrayList).isEmpty());

        myArrayListFromCollection.add("mur mur");
        System.out.print("Вид списка, созданного элементами коллекции, после добавления нового элемента: ");
        for(String str : myArrayListFromCollection){
            System.out.print(str + " ");
        }

        System.out.println("\nПервый список (неотсортированный): " + myFirstArrayList);
        MyArrayList.bubbleSort(myFirstArrayList);
        System.out.println("Отсортированный список: " + myFirstArrayList);

    }
    }


