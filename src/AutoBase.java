import java.util.Scanner;
/*
* Напишите программу, которая считывает с клавиатуры название автомобиля и его цену и помещает их в базу автомобилей.
 Внесите программу в version control и сделайте commit на GitHub.

* Внесите изменения в проект:
* Добавьте в параметр авто, год производства.
* Сделайте commit на Git.

Реализуйте распределение сортировку авто:
* от меньшей цены к большей
* Решите задачу разными методами в разных ветках, решите конфликт и сделайте commit итогового варианта на GitHub.
*/


public class AutoBase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Auto[] autoBase = new Auto[5];
        String n;
        String p;
        for (int i = 0; i < 5; i++) {
            System.out.println("Введите данные");
            System.out.println("Введите название:");
            n = scanner.nextLine();
            System.out.println("Введите цену:");
            p = scanner.nextLine();
            autoBase[i] = new Auto(n, p);
            System.out.println("Занесено в базу");
            System.out.println(" ");

            if (n.equals("s") || p.equals("s")) {
                System.out.println("Введите индекс:");
                int in = scanner.nextInt();
                System.out.println(autoBase[in - 1]);
            }
            if (n.equals("e") || p.equals("e")) {
                System.out.println("Выход из программы");
                break;
            }
            System.out.println(autoBase[i].name + " " + autoBase[i].price);
            System.out.println(" ");
        }
    }
}
class Auto {
    String name;
    String price;
    public Auto(String name, String price) {
        this.name = name;
        this.price = price;
    }
}
