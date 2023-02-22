import java.util.Random;

public class EightQueens {

    static public int boardSize = 8;
    static public int[][] board = new int[boardSize][boardSize];
    static public int[][] heuristics = new int[boardSize][boardSize];

    public static void main(String[] args) {
        eureka();
//        print(heuristics);
        arrange();
        print(board);
    }

    static void arrange (){
        for (int queen = 1; queen < 9; queen++)
        {
            int min = 99,
                    x = 0, y = 0, future_step = 0;

            for (int i = 0; i < boardSize; i++)
                for (int j = 0; j < boardSize; j++)
                    if (board[i][j] == 0)
                        if (min > heuristics[i][j])
                        {
                            min = heuristics[i][j];
                            x = i;
                            y = j;
                            future_step = forecast(board, heuristics, x, y, queen);
                        }
                        else
                        if (min == heuristics[i][j])
                            if (future_step != 9)
                                if (future_step < forecast(board, heuristics, i, j, queen))
                                {
                                    min = heuristics[i][j];
                                    x = i;
                                    y = j;
                                    future_step = forecast(board, heuristics, x, y, queen);
                                }

            if (min > 30)
            {
                System.out.println("\t" + (queen - 1) + " queens on the board\n");
                queen = 9;
            }
            else
            {
                board[x][y] = queen;

                hueurika(heuristics, x, y);
            }
        }
    }

    static void print(int[][] board)
    {
        for (int i = 0; i < boardSize; i++)
        {
            for (int j = 0; j < boardSize; j++)
                System.out.print("\t" + board[i][j]);
            System.out.println();
        }
        System.out.println("\n");
    }

    static void eureka()
    {
        for (int i = 0; i < boardSize; i++)
        {
            for (int j = 0; j < boardSize; j++)
            {
                ++heuristics[i][j];

                for (int n = 1; n < boardSize; n++)
                {
                    if ((i - n) > -1)
                    {
                        ++heuristics[i][j];
                        if ((j - n) > -1)
                            ++heuristics[i][j];
                        if ((j + n) < boardSize)
                            ++heuristics[i][j];
                    }
                    if ((i + n) < boardSize)
                    {
                        ++heuristics[i][j];
                        if ((j - n) > -1)
                            ++heuristics[i][j];
                        if ((j + n) < boardSize)
                            ++heuristics[i][j];
                    }
                    if ((j - n) > -1)
                        ++heuristics[i][j];
                    if ((j + n) < boardSize)
                        ++heuristics[i][j];
                }
            }
        }
    }
    static void hueurika(int[][] heuristics, int i, int j)
    {
        heuristics[i][j] = 99;

        for (int n = 1; n < boardSize; n++)
        {
            if ((i - n) > -1)
            {
                heuristics[i - n][j] = 98;
                if ((j - n) > -1)
                    heuristics[i - n][j - n] = 98;
                if ((j + n) < boardSize)
                    heuristics[i - n][j + n] = 98;
            }
            if ((i + n) < boardSize)
            {
                heuristics[i + n][j] = 98;
                if ((j - n) > -1)
                    heuristics[i + n][j - n] = 98;
                if ((j + n) < boardSize)
                    heuristics[i + n][j + n] = 98;
            }
            if ((j - n) > -1)
                heuristics[i][j - n] = 98;
            if ((j + n) < boardSize)
                heuristics[i][j + n] = 98;
        }
    }

    static int forecast(int[][] board, int[][] heuristics, int x, int y, int queen)
    {
        int[][] copyBoard = new int[boardSize][boardSize];
        int[][] copyHeuristics = new int[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++)
            for (int j = 0; j < boardSize; j++)
            {
                copyBoard[i][j] = board[i][j];
                copyHeuristics[i][j] = heuristics[i][j];
            }

        copyBoard[x][y] = queen;
        queen++;
        hueurika(copyHeuristics, x, y);

        while (queen < 9)
        {
            int min = 99,
                    a = 0, b = 0, future = 0;

            for (int i = 0; i < boardSize; i++)
                for (int j = 0; j < boardSize; j++)
                    if (copyBoard[i][j] == 0)
                        if (min > copyHeuristics[i][j])
                        {
                            min = copyHeuristics[i][j];
                            a = i;
                            b = j;
                            future = forecast(copyBoard, copyHeuristics, a, b, queen);
                        }
                        else
                        if (min == copyHeuristics[i][j])
                            if (future != 9)
                                if (future < forecast(copyBoard, copyHeuristics, i, j, queen))
                                {
                                    min = copyHeuristics[i][j];
                                    a = i;
                                    b = j;
                                    future = forecast(copyBoard, copyHeuristics, a, b, queen);
                                }
            if (min > 30)
            {
                return queen;
            }
            else
            {
                copyBoard[a][b] = queen;
                queen++;
                hueurika(copyHeuristics, a, b);
            }
        }


        return queen;
    }
}
