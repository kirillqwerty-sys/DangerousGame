import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String person = "\uD83E\uDDD9";
        String monster = "\uD83E\uDDDF";

        int personLive = 3;
        int sizeBoard = 5;
        int personX;
        int personY;
        int step = 0;

        personX = 1 + sizeBoard / 2;
        personY = 1 + sizeBoard / 2;
        // \n, \t - спец символ
        String gamingField = "+ —— + —— + —— + —— + —— +\n"
                + "|    |    |    |    |    |\n"
                + "+ —— + —— + —— + —— + —— +\n"
                + "|    |    |    |    |    |\n"
                + "+ —— + —— + —— + —— + —— +\n"
                + "|    |    | " + monster + " |    |    |\n"
                + "+ —— + —— + —— + —— + —— +\n"
                + "|    |    |    |    |    |\n"
                + "+ —— + —— + —— + —— + —— +\n"
                + "| " + person + " |    |    |    |    |\n"
                + "+ —— + —— + —— + —— + —— +";

        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");

        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        System.out.println("Ваш ответ:\t" + answer);
        if (answer.equals("ДА") || answer.equals("Да")){
           System.out.println("Начинаем играть");
           System.out.println("Введите куда будет ходить персонаж(ход возможен по вертикали и горизонтали на одну клетку)");
           System.out.println(("Координаты персонажа - (х:" + personX +", y: " + personY + ")"));

           int x = scanner.nextInt();
           int y = scanner.nextInt();
            if (x != personX && y != personY) {
                System.out.println("Некорректный ход");
            }

        }else  if (answer.equals("НЕТ") || answer.equals("Нет")){
            System.out.println("Почему ты не захотел со мной играть :(");
            System.out.println("Приходи ещё!");
        }else {
            System.out.println("Недопустимая команда!Повторите ввод");
        }

    }
}