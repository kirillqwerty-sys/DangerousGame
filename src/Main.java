import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String person = "\uD83E\uDDD9";
        String monster = "\uD83E\uDDDF";
        String castle = "\uD83C\uDFF0";

        int personLive = 3;
        int sizeBoard = 5;
        int personX;
        int personY;
        int step = 0;
        int castleY = 1;
        Random random = new Random();
        int castleX = 1 + random.nextInt(sizeBoard);



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

        switch (answer) {
            case "Да":
                System.out.println("Выбери сложность игры (от 1 до 5):");
                int difficultGame = scanner.nextInt();

                System.out.println("Выбранная сложность:\t" + difficultGame);

                while ((personLive > 0) && !(castleX == personX && castleY == personY)) {
                    /*****************************************/
                    String leftBlock = " | ";
                    String rightBlock = " | ";
                    String wall = " + —— + —— + —— + —— + —— + ";
                    for (int y = 1; y <= sizeBoard; y++) {
                        System.out.println(wall);

                        for (int x = 1; x <= sizeBoard; x++) {
                            System.out.print(leftBlock);

                            if (personY == y && personX == x) {
                                System.out.print(person);
                            } else if (castleX == x && castleY == y) {
                                System.out.print(castle);
                            } else {
                                System.out.print("  ");
                            }
                        }
                        System.out.println(rightBlock);
                    }
                    System.out.println(wall);

                    /*****************************************/
                    System.out.println(("Координаты персонажа - (х:" + personX + ", y: " + personY + ")"));
                    System.out.println("Сместите персонажа по горизонтали или вертикали на одну клетку");
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    System.out.println(x + "," + y);
                    if (x != personX && y != personY) {
                        System.out.println("Некорректный ход");
                    } else if (Math.abs(x - personX) == 1 || Math.abs(y - personY) == 1) {
                        personX = x;
                        personY = y;
                        step += 1;
                        System.out.println("Ход корректный; Новые координаты: " +
                                personX + ", " + personY + "\nХод номер: " + step);
                    } else {
                        System.out.println("Координаты не изменены");

                    }
                }

                break;
            case "Нет":
                System.out.println("Жаль, прихощди еще!");
                break;
            default:
                System.out.println("Данные введены некорректно");
        }
    }
}