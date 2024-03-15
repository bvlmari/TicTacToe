import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        char[][] board = initializeBoard();
        char[] teams = chooseTeam();
        gaming(board, teams);

    }

    public static char[][] initializeBoard() {
        char[][] board = new char[3][3];
        for (char[] chars : board) {
            Arrays.fill(chars, '_');
        }
        return board;
    }
    public static void printBoard (char[][] board) {
        System.out.printf("""
                Current board:
                   0 1 2
                   _____
                0| %c %c %c
                1| %c %c %c
                2| %c %c %c
                """,board[0][0],board[0][1],board[0][2],board[1][0],board[1][1],board[1][2],board[2][0],board[2][1],board[2][2]);
    }
    public static char[] chooseTeam () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Tic tac toe
                Choose your team:
                X - input x
                O - input o""");
        char team = Character.toUpperCase(scanner.next().charAt(0));
        char rival;
        if (team == 'X') {
            rival = 'O';
        } else {
            rival = 'X';
        }
        return new char[]{team,rival};
    }
    public static void gaming (char[][] board, char[]teams) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int x, y, a, b;
        int turn = 0;
        while(turn<5) {
            System.out.println("TURN "+turn);
            printBoard(board);
            do {
                x = scanner.nextInt();
                y = scanner.nextInt();
                if (board[x][y]=='X'||board[x][y]=='O') {
                    System.out.println("Spot taken, try another spot.");
                }
            } while (board[x][y]!='_');
            board[x][y] = teams[0];//Teams 0 is the team of user
            if(turn<4){
                do {
                    a = random.nextInt(0, 3);
                    b = random.nextInt(0, 3);
                } while (board[a][b] != '_');
                board[a][b] = teams[1];//Teams 1 is the team of the rival
            }
            turn++;
        }
        printBoard(board);
    }
}