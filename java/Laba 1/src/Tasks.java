import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Tasks
{
    /** Цей метод вийзачає вікову категорію людини
     * залежно від введеного віку
     * @param ageOfPerson вік людини (від 0 до 100)
     * @return повертає назву вікової категорії людини
     * @throws IllegalArgumentException якщо {@code ageOfPerson}
     * не входить в діапазон 1 - 100
     */
    public static String taskOne(int ageOfPerson) throws IllegalArgumentException {
        //Перевірка на коректність
        taskOneCheck(ageOfPerson);
        return switch (ageOfPerson) {
            case 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 -> "дитина";
            case 11, 12, 13, 14, 15 -> "підліток";
            case 16, 17, 18, 19, 20 -> "юнак";
            case 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 -> "молода людина";
            default -> "доросла людина";
        };
    }
    private static void taskOneCheck(int ageOfPerson) throws IllegalArgumentException {
    if(ageOfPerson < 1 || ageOfPerson > 100) throw new IllegalArgumentException("Не вірно вказанний вік людини!");
    }


    /** Цей метод виконує функцію на деякому проміжку
     * з деяким кроком.
     * @param startPoint початок проміжку функції, це може бути любим числом,
     *                   но не більшим за {@code endPoint}
     * @param endPoint кінець проміжку функції, це може бути любим числом,
     *                 но не меншим за {@code starPoint}
     * @param step крок проміжку функції, це може бути любим числом,
     *             но не меншим і не рівним 0
     * @throws IllegalArgumentException якщо {@code starPoint} > {@code endPoint},
     *         або якщо {@code step} <= 0
     */
    public static void taskTwo(double startPoint, double endPoint, double step) throws IllegalArgumentException {
        //Перевірка на коректність
        taskTwoCheck(startPoint, endPoint, step);
        double sum; // Сума рівняння
        for(double i = startPoint; i <= endPoint; i+= step) {
            //Перевірка знаменника дроба на нуль,
            //і якщо нуль, то цей крок лічильника пропускається
            if(i - 2 == 0) {
                System.out.println("Значення відсутнє , тому що на 0 діліти не можна");
                continue;
            }
            //виконання рівняння
            sum = (Math.pow(i, 4) - 12 * i) / (i - 2);
            //вивід в консоль значення
            System.out.println("X = " + String.format("%.2f", i) + "\tY = "+ String.format("%.2f", sum));
        }
    }
    private static void taskTwoCheck(double startPoint, double endPoint, double step) throws IllegalArgumentException  {
        if(startPoint > endPoint) throw new IllegalArgumentException("Початкове значення не може бути більшим за кінцеве!");
        if(step <= 0) throw new IllegalArgumentException("Крок не може бути меншим або рівним за 0!");
    }


    /** Цей метод повертає суму елементів
     * під не парним числом з масива,
     * масив вводиться з клавіатури
     * @param size розмір масива
     * @return повертає суму з не парних елементів масива
     * @throws IllegalArgumentException якщо {@code size} <= 0
     *
     * @see #createMass(int size) метод для генерації масива вручну
     */
    public static int taskThreeOne(int size) throws IllegalArgumentException {
        //Перевірка на коректність
        taskThreeOneCheck(size);
        int[] arr = createMass(size);
        int sum = 0;
        for (int i = 0; i < size; i++) {
            if(i % 2 == 1) sum += arr[i];
        }
        return sum;
    }
    public static void taskThreeOneCheck(int size) throws IllegalArgumentException {
        if(size <= 0) throw new IllegalArgumentException("Розмір мисива не може бути меншим або рівним 0!");
    }

    /** Цей метод повертає суму елементів
     * від першого додатнього елемента масиву
     * до другого, і повертає його суму, масив
     * генерується в рандомно на проміжку [-100;100]
     * @param size розмір масива
     * @return повертає суму від першого
     *         додатнього елемента до другого.
     * @throws IllegalArgumentException якщо {@code size} <= 0
     */
    public static int taskThreeTwo(int size) throws IllegalArgumentException {
        int[] arr = createMassRandom(size);
        int sum = 0;
        //Пойтер, щоб визначити суму між першим додатнім
        //і другим додатнім елементом
        int twoPointer = 0;
        for (int i = 0; i < size; i++) {
            if(arr[i] > 0) twoPointer++;
            if(twoPointer > 0) sum += arr[i];
            if(twoPointer == 2) break;
        }
        return sum;
    }
    public static void taskThreeTwoCheck(int size) throws IllegalArgumentException {
        if(size <= 0) throw new IllegalArgumentException("Розмір мисива не може бути меншим або рівним 0!");
    }

    /** Цей метод створює масив з заданим
     * розміром, цей масив вводиться вручну
     * @param size розмір масива
     * @return повертає масив цілих чисел
     */
    private static int[] createMass(int size) {
        int[] arr = new int[size];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < size; i++) {
            System.out.println("Елемент(" + (i + 1) + "):");
            String digit = scanner.nextLine();
            //Перевірка на можливість конвертації введених данних
            if(!digit.matches("\\d+")) {
                System.err.println("Введіть цифри, а не символи!");
                i--;
                continue;
            }
            arr[i] = Integer.parseInt(digit);
        }
        return arr;
    }
    /** Цей метод створює масив з заданим розміром
     * автоматично на проміжку [-100;100]
     * @param size розмір масива
     * @return повертає масив цілих чисел
     * @throws IllegalArgumentException якщо {@code size} <= 0
     */
    private static int[] createMassRandom(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(201) - 100;
            //System.out.println("Елемент(" + (i + 1) + "):" + arr[i]);
        }
        return arr;
    }

    /** Цей масив змінює елементи для двох різних
     * рядків в масиві, який або генерується
     * автоматично на діапазоні [-100;100], або
     * вводиться з клавіатури.
     * @param height к-сть рядків масива
     * @param width к-сть елементів в рядку масива.
     * @throws IllegalArgumentException якщо {@code height} < 1 або {@code width} < 1
     */
    public static void taskFour(int height, int width) throws IllegalArgumentException {
        //Перевірка на коректність
        taskFourCheck(height, width);
        Scanner scanner = new Scanner(System.in);
        int[][] arr;
        System.out.println("Вибиріть спосіб генерації масива:\n1)Вручну\n2)Автоматично");
        for(;;) {
            String digit = scanner.nextLine();
            if(digit.equals("1")) {
                arr = createMass(height, width);
                break;
            }
            if(digit.equals("2")) {
                arr = createMassRandom(height, width);
                break;
            }
        }
        taskFourPrint(arr);
        taskFourChangeLines(arr);
    }
    private static void taskFourCheck(int height, int width) throws IllegalArgumentException {
        if(height < 1) throw new IllegalArgumentException("Висота масива не може бути меншим за 1");
        if(width < 1) throw new IllegalArgumentException("Ширина масива не може бути меншим за 1");
    }
    private static void taskFourPrint(int[][] arr) {
        System.out.println("Масив:");

        for (int i = 0; i < arr.length; i++) {
            System.out.print("[" + (i + 1) + "]");
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print("\t" + arr[i][j]);
            }
            System.out.println();
        }
    }
    private static void taskFourChangeLines(int[][] arr){
        Scanner scanner = new Scanner(System.in);
        //Змінна для провірення можливість конвертації введених данних
        String digit;
        //Перший і другий рядок для обміну
        int firstLine, secondLine;
        for(;;){
            System.out.println("Введіть номер першого рядка:");
            digit = scanner.nextLine();
            if(digit.matches("\\d+")){
                firstLine = Integer.parseInt(digit);
                break;
            }
            System.err.println("Введіть цифри, а не символи!");
        }
        for(;;){
            System.out.println("Введіть номер другого рядка:");
            digit = scanner.nextLine();
            if(digit.matches("\\d+")){
                secondLine = Integer.parseInt(digit);
                break;
            }
            System.err.println("Введіть цифри, а не символи!");
        }
        int[][] newArr;
        if(firstLine - 1 < arr.length && secondLine - 1 < arr.length && firstLine != secondLine) {
            if(firstLine > 0 && secondLine > 0) {
                newArr= ChangeLines(arr, firstLine - 1, secondLine - 1);
                taskFourPrint(newArr);
            }
            else System.out.println("Номер рядків не може бути меншим за 1");
        }
        else {
            System.out.println("Вказаний невірний номер рядків");
        }
    }
    private static int[][] ChangeLines(int[][] arr, int firstLine, int secondLine) {
        int temp;
        for (int i = 0; i < arr[0].length; i++) {
            temp = arr[firstLine][i];
            arr[firstLine][i] = arr[secondLine][i];
            arr[secondLine][i] = temp;
        }
        return arr;
    }

    /** Цей метод створює двовимірний масив з заданим
     * розміром, цей масив вводиться вручну
     * @param height висота масива
     * @param width ширина масива
     * @return повертає масив цілих чисел
     */
    private static int[][] createMass(int height, int width) {
        int[][] arr = new int[height][width];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.println("Елемент(" + (i + 1) + ")(" + (j + 1) + ")" + ":");
                String digit = scanner.nextLine();
                //Перевірка на можливість конвертації введених данних
                if(!digit.matches("\\d+")) {
                    System.err.println("Введіть цифри, а не символи!");
                    j--;
                    continue;
                }
                arr[i][j] = Integer.parseInt(digit);
            }
        }
        return arr;
    }
    /** Цей метод створює двовимірний масив з заданим
     * розміром, цей масив вводиться рандомно на
     * проміжку [-100; 100]
     * @param height висота масива
     * @param width ширина масива
     * @return повертає масив цілих чисел
     */
    private static int[][] createMassRandom(int height, int width) {
        int[][] arr = new int[height][width];
        Random random = new Random();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                arr[i][j] = random.nextInt(201) - 100;
            }
        }
        return arr;
    }
}
