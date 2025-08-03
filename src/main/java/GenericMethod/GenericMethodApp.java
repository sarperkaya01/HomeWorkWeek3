package GenericMethod;

public class GenericMethodApp {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};

        String[] strArray = {"Java", "Generics", "Ödev"};
        printArray(intArray);
        printArray(strArray);

    }
    public static <T> void printArray(T[] arr) {
        for (T elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }


}
