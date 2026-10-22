import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String castle = "\uD83C\uDFF0";

        int sizeBoard = 5;
        Person person = new Person(sizeBoard);




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
        Monster[] monsters = new Monster[countMonster];
        int count = 0;

        while (count < countMonster) {
            Monster monster;

            if (random.nextBoolean()) {
                monster = new Monster(sizeBoard);
            } else {
                monster = new BigMonster(sizeBoard);
            }

            int row = monster.getY() - 1;
            int column = monster.getX() - 1;

            if (board[row][column].equals("  ")) {
                board[row][column] = monster.getImage();
                monsters[count] = monster;
                count++;
            }
        }

        for (int i = 0; i < countMonster; i++) {
            Monster monster = new Monster(sizeBoard);
            monsters[i] = monster;
            board[monster.getY() - 1][monster.getX() - 1] = monster.getImage();
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
                    board[person.getY() - 1][person.getX() - 1] = person.getImage();
                    for (String[] row : board) {
                        System.out.println(wall);

                        for (String cell : row) {
                            System.out.print(leftBlock);
                            System.out.print(cell);
                        }
                        System.out.println(rightBlock);
                    }

                    System.out.println(wall);

                    System.out.println("Количество жизней:\t" + person.getLive() + "\n");

                    System.out.println("Введите куда будет ходить персонаж (ход возможен только по вертикали и горизонтали на одну клетку)" +
                            "\nКоординаты персонажа - (x: " + person.getX() + ", y: " + person.getY() + ")");

                    int x = scanner.nextInt();
                    int y = scanner.nextInt();

                    System.out.println(x + ", " + y);

                    if (x != person.getX() && y != person.getY()) {
                        System.out.println("Некорректный ход");
                    } else if (person.isMoveCorrect(x, y)) {
                        String next = board[y - 1][x - 1];
                        if (next.equals("  ")) {
                            board[person.getY() - 1][person.getX() - 1] = "  ";
                            person.move(x, y);
                            step++;
                            System.out.println("Ход корректный; Новые координаты: " + person.getX() + ", " + person.getY() + "\nХод номер: " + step);

                        } else if (next.equals(castle)) {
                            System.out.println("Вы прошли игру!Ура-Ура-Ура!!!!");
                            break;
                        } else {
                            for (Monster monster : monsters) {
                                if (monster.conflictPerson(x, y)) {
                                    if (monster.taskMonster(difficultGame)) {
                                        board[person.getY() - 1][person.getX() - 1] = "  ";
                                        person.move(x, y);
                                        step++;
                                    } else {
                                        person.downLive();
                                    }
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("Некорpектный ход");
                    }

                    if (person.getLive() <= 0) {
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
}




