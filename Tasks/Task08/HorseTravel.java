import java.util.Random;

public class HorseTravel {
    public static int boardSize = 8;
    public static int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
    public static int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};
    public static int[][] accessibility = new int[boardSize][boardSize];

    public static void main(String[] args) {
        int[][] board = new int[boardSize][boardSize];
        Random random = new Random();
        int currentRow = random.nextInt(boardSize),
                currentColumn = random.nextInt(boardSize);

        theWay(board, currentRow, currentColumn);
    }


    static void theWay(int[][] board, int currentRow, int currentColumn) {
        int counter = 1;
        board[currentRow][currentColumn] = counter;

        for (int i = 0; i < boardSize; i++)
            for (int j = 0; j < boardSize; j++)
                for (int number = 0; number < boardSize; number++) {
                    int row = i + vertical[number],
                            column = j + horizontal[number];

                    if (row > -1 && row < boardSize)
                        if (column > -1 && column < boardSize)
                            if (board[i][j] == 0)
                                ++accessibility[row][column];
                }

        for (; counter <= boardSize * boardSize; counter++) {
            int min = boardSize + 1,
                    priority = 0;

            for (int moveNumber = 0; moveNumber < boardSize; moveNumber++) {
                int row = currentRow + vertical[moveNumber],
                        column = currentColumn + horizontal[moveNumber];

                if (row > -1 && row < boardSize)
                    if (column > -1 && column < boardSize)
                        if (board[row][column] == 0)
                            if (min == accessibility[row][column]) {
                                if (forecast(board, row, column, priority) > forecast(board, row, column, moveNumber))
                                    priority = moveNumber;
                            } else if (min > accessibility[row][column]) {
                                min = accessibility[row][column];
                                priority = moveNumber;
                            }
            }
            if (min < boardSize + 1) {
                currentRow += vertical[priority];
                currentColumn += horizontal[priority];
                board[currentRow][currentColumn] = counter + 1;
            }

            for (int number = 0; number < boardSize; number++) {
                int row = currentRow + vertical[number],
                        column = currentColumn + horizontal[number];

                if (row > -1 && row < boardSize)
                    if (column > -1 && column < boardSize)
                        --accessibility[row][column];
            }
        }

        System.out.println("\n\t\tThe way of the horse:");

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++)
                System.out.print("\t" + board[i][j]);
            System.out.println();
        }
        System.out.println("\n");
    }

    static int forecast(int[][] board, int currentRow, int currentColumn, int option) {
        int min = boardSize + 1, priority = 0;

        int[][] copyBoard = new int[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++)
            for (int j = 0; j < boardSize; j++)
                copyBoard[i][j] = board[i][j];

        copyBoard[currentRow][currentColumn] = 1;
        currentRow += vertical[option];
        currentColumn += horizontal[option];

        for (int move_number = 0; move_number < boardSize; move_number++) {
            int row = currentRow + vertical[move_number],
                    column = currentColumn + horizontal[move_number];

            if (row > -1 && row < boardSize)
                if (column > -1 && column < boardSize)
                    if (board[row][column] == 0)
                        if (min == accessibility[row][column]) {
                            if (forecast(copyBoard, row, column, priority) > forecast(copyBoard, row, column, move_number))
                                priority = move_number;
                        } else if (min > accessibility[row][column]) {
                            min = accessibility[row][column];
                            priority = move_number;
                        }
        }
        if (min < boardSize + 1)
            return min;
        else
            return boardSize + 1;

    }
}
