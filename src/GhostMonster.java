import java.util.Random;
import java.util.Scanner;

public class GhostMonster extends Monster {

    GhostMonster(int sizeBoard) {
        super(sizeBoard);
        setImage("\uD83D\uDC7B"); // Призрак
    }

    @Override
    public boolean taskMonster(int difficultGame) {
        System.out.println("Решите задачу:");

        Random random = new Random();

        // Подбираем коэффициенты так, чтобы уравнение имело целые корни
        // (x + p)(x + q) = 0 => x^2 + (p+q)x + pq = 0
        int p = random.nextInt(5) + 1; // от 1 до 5
        int q = random.nextInt(5) + 1; // от 1 до 5

        int b = p + q;
        int c = p * q;

        System.out.println("Реши квадратное уравнение: " + "x^2 + " + b + "x + " + c + " = 0");
        System.out.println("Введите первый корень:");
        Scanner scanner = new Scanner(System.in);
        int answer1 = scanner.nextInt();

        System.out.println("Введите второй корень:");
        int answer2 = scanner.nextInt();

        // Проверяем корни (порядок ввода не важен)
        if ((answer1 == -p && answer2 == -q) || (answer1 == -q && answer2 == -p)) {
            System.out.println("Верно! Ты победил монстра");
            return true;
        } else {
            System.out.println("Ты проиграл эту битву! Правильные корни: " + (-p) + " и " + (-q));
            return false;
        }
    }
}