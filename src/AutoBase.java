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
        String a;
        for (int i = 0; i < 5; i++) {
            System.out.println("Введите данные");
            System.out.println("Введите название:");
            n = scanner.nextLine();
            if (n.equals("s")) {
                System.out.println("Введите индекс:");
                int in = scanner.nextInt();
                StringBuilder sb1 = new StringBuilder(autoBase[in - 1].name);
                sb1.append(" ");
                sb1.append(autoBase[in - 1].price);
                sb1.append(" р. ");
                sb1.append(autoBase[in - 1].age);
                sb1.append(" года.");
                System.out.println(sb1);
                continue;
            }
            System.out.println("Введите цену:");
            p = scanner.nextLine();
            System.out.println("Введите год производсва:");
            a = scanner.nextLine();
            autoBase[i] = new Auto(n, p, a);
            System.out.println("Занесено в базу");
            System.out.println(" ");
            if (n.equals("e") || p.equals("e") || a.equals("e")) {
                System.out.println("Выход из программы");
                break;
            }
            StringBuilder sb = new StringBuilder(n);
            sb.append(" ");
            sb.append(p);
            sb.append(" р. ");
            sb.append(a);
            sb.append(" года.");
            System.out.println(sb);
            System.out.println(" ");
            if (i == 4){
                AutoCategorization ac = new AutoCategorization();
                ac.autoCategorisation(autoBase);
                break;
            }
        }
    }
}
class Auto {
    String name;
    int price;
    String age;
    public Auto(String name, String price, String age) {
        this.name = name;
        this.price = Integer.parseInt(price);
        this.age = age;
    }
}
class AutoCategorization {
    public void autoCategorisation(Auto[] autoBase) {
        // первый метод сортировка
        for (int i = 0; i < autoBase.length; i++) {
            Auto min = autoBase[i];
            int min_i = i;
            for (int j = i+1; j < autoBase.length; j++) {
                if (autoBase[j].price < min.price) {
                    min = autoBase[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                Auto tmp = autoBase[i];
                autoBase[i] = autoBase[min_i];
                autoBase[min_i] = tmp;
            }
        }

        for(int i = 0 ; i<autoBase.length; i++) {
            StringBuilder sb1 = new StringBuilder(autoBase[i].name);
            sb1.append(" ");
            sb1.append(autoBase[i].price);
            sb1.append(" р. ");
            sb1.append(autoBase[i].age);
            sb1.append(" года.");
            System.out.println(sb1);
        }
    }
}
