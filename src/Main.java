import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String monster = "\uD83E\uDDDF";
        String castle = "\uD83C\uDFF0";

        int sizeBoard = 5;
        Person person = new Person(sizeBoard);



        int personLive = 3;
        int step = 0;
        int castleY = 1;
        Random random = new Random();
        int castleX = 1 + random.nextInt(sizeBoard);

        String leftBlock = " | ";
        String rightBlock = " | ";
        String wall = " + —— + —— + —— + —— + —— + ";


        String[][] board = new String[sizeBoard][sizeBoard];
        for (int y = 1; y <= sizeBoard; y++) {
            for (int x = 1; x <= sizeBoard; x++) {
                board[y-1][x - 1] = "  ";
            }
        }

        int countMonster = sizeBoard * sizeBoard - sizeBoard - 1;
        for (int i = 0; i < countMonster; i++) {
            board[random.nextInt(sizeBoard - 1)][random.nextInt(sizeBoard)] = monster;
        }

        board[castleY - 1][castleX - 1] = castle;


        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");

        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        System.out.println("Ваш ответ:\t" + answer);

        switch (answer) {
            case "Да":
                System.out.println("Выбери сложность игры (от 1 до 5):");
                int difficultGame = scanner.nextInt();
                System.out.println("Выбранная сложность:\t" + difficultGame);

                while (true) {
                    board[person.getY()- 1][person.getX() - 1] = person.getImage();
                    for (String[] row : board) {
                        System.out.println(wall);

                        for (String cell : row) {
                            System.out.print(leftBlock);
                            System.out.print(cell);
                        }
                        System.out.println(rightBlock);
                    }

                    System.out.println(wall);

                    System.out.println("Количество жизней:\t" + personLive + "\n");

                    System.out.println("Введите куда будет ходить персонаж (ход возможен только по вертикали и горизонтали на одну клетку)" +
                            "\nКоординаты персонажа - (x: " + person.getX() + ", y: " + person.getY() + ")");

                    int x = scanner.nextInt();
                    int y = scanner.nextInt();

                    System.out.println(x + ", " + y);

                    if (x != person.getX()&& y != person.getY()) {
                        System.out.println("Некорректный ход");
                    } else if (person.isMoveCorrect(x,y)) {
                        String next = board[y-1][x-1];
                        if (next.equals("  ")) {
                            board[person.getY() - 1][person.getX() - 1] = "  ";
                            person.move(x,y);
                            step++;
                            System.out.println("Ход корректный; Новые координаты: " + person.getX() + ", " + person.getY() + "\nХод номер: " + step);

                        } else if (next.equals(castle)) {
                            System.out.println("Вы прошли игру!Ура-Ура-Ура!!!!");
                            break;
                        } else {
                            System.out.println("Решите задачу.");
                            //доп
                            if (taskMonster(difficultGame)) {
                                board[person.getY() - 1][person.getX() - 1] = "  ";
                                person.move(x,y);
                                step++;
                            } else {
                                personLive--;
                            }
                        }
                    } else {
                        System.out.println("Некорpектный ход");
                    }

                    if (personLive <= 0) {
                        break;
                    }

                }
                break;

            case "НЕТ":
                System.out.println("Жаль, приходи ещё!");
                break;
            default:
                System.out.println("Данные введены некорректно");
                break;
        }
    }


    static boolean taskMonster(int difficultGame){
        if (difficultGame == 1) {
            Random random = new Random();
            int a = random.nextInt(100);
            int b = random.nextInt(100);
            int trueAnswer = a + b;
            System.out.println("Реши пример: " + a + " + " + b + " = ?");
            Scanner scanner = new Scanner(System.in);
            int ans = scanner.nextInt();
            if (trueAnswer == ans) {
                System.out.println("Верно! Ты победил монстра");
                return true;
            } else {
                System.out.println("Ты проиграл эту битву!");
                return false;

            }
        } else {
            //kod
            return true;
        }
    }
}




