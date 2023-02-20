import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


public class Task01 {

    public static Random random = new Random();
    public static boolean flag = true;

    public static void main(String[] args) {
        Dot size = new Dot(10, 10);
//        Dot start = new Dot(4,2);
        Dot start = new Dot(random.nextInt(1, size.x - 1),
                random.nextInt(1, size.y - 1));
        int[][] maze = new int[size.x][size.y];
//        int[][] maze =
//                {{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
//                        {-1, 0, 0, 0, 0, 0, 0, 0, 0, -1},
//                        {-1, 0, -1, -1, -1, -1, 0, 0, 0, -1},
//                        {-1, 0, 0, 0, -1, 0, 0, 0, 0, -1},
//                        {-1, 0, 0, 0, -1, 0, 0, 0, 0, -1},
//                        {-1, 0, 0, 0, -1, 0, 0, 0, 0, -1},
//                        {-1, 0, -1, -1, -1, -1, -1, -1, 0, -1},
//                        {-1, 0, 0, 0, -1, 0, 0, 0, 0, -1},
//                        {-1, 0, 0, 0, 0, 0, 0, 0, 0, -1},
//                        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}};

        Dot finish1 = new Dot(1, 8);
        Dot finish2 = new Dot(6, 8);
        fillArray(size, maze, start, finish1, finish2);
        print(maze, finish1, finish2);
        li(start, maze);
        System.out.println();
        print(maze, finish1, finish2);
        int way1 = finish(finish1, maze);
        int way2 = finish(finish2, maze);
        System.out.println();
        if (shortWay(way1, way2)) {
            System.out.println("Way1 is short way = " + way1);
            System.out.println(printWay(maze, finish1));
        } else {
            System.out.println("Way2 is short way = " + way2);
            System.out.println(printWay(maze, finish2));
        }
    }

    static String printWay(int[][] maze, Dot finish) {
        int step = maze[finish.x][finish.y];
        return backWay(maze, finish, step);
    }

    static String backWay(int[][] maze, Dot finish, int step) {
        StringBuilder sb = new StringBuilder();
        if (step == 1) {
            flag = false;
            sb.append("{").append(finish.x).append(";").append(finish.y).append("}; ");
            return sb.toString();
        } else if (flag) {
            if (maze[finish.x][finish.y - 1] == step - 1) {
                return sb.append(backWay(maze, new Dot(finish.x, finish.y - 1), step - 1)).append("{")
                        .append(finish.x).append(";").append(finish.y).append("}; ").toString();
            }
            if (maze[finish.x + 1][finish.y] == step - 1) {
                return sb.append(backWay(maze, new Dot(finish.x + 1, finish.y), step - 1)).append("{")
                        .append(finish.x).append(";").append(finish.y).append("}; ").toString();
            }
            if (maze[finish.x][finish.y + 1]  == step - 1) {
                return sb.append(backWay(maze, new Dot(finish.x, finish.y + 1), step - 1)).append("{")
                        .append(finish.x).append(";").append(finish.y).append("}; ").toString();
            }
            if (maze[finish.x - 1][finish.y]  == step - 1) {
                return sb.append(backWay(maze, new Dot(finish.x - 1, finish.y), step - 1)).append("{")
                        .append(finish.x).append(";").append(finish.y).append("}; ").toString();
            }
        }
        return null;
    }

    static void fillArray(Dot size, int[][] maze, Dot start, Dot finish1, Dot finish2) {
        for (int i = 0; i < size.y; i++) {
            maze[0][i] = -1;
            maze[size.x - 1][i] = -1;
        }
        for (int i = 1; i < size.x - 1; i++) {
            maze[i][0] = -1;
            maze[i][size.y - 1] = -1;
        }
        for (int i = 1; i < size.y - 1; i++)
            for (int j = 0; j < size.x - 1; j++) {
                int r = random.nextInt(4);
                if (r == 0)
                    maze[i][j] = -1;
            }
        maze[start.x][start.y] = -5;
        maze[finish1.x][finish1.y] = -2;
        maze[finish2.x][finish2.y] = -2;
    }

    static boolean shortWay(int w1, int w2) {
        if (w1 == -2) w1 = 99;
        if (w2 == -2) w2 = 99;
        return !(w1 >= w2);
    }

    static void li(Dot start, int[][] maze) {
        maze[start.x][start.y] = 1;
        Queue<Dot> queue = new LinkedList<>();
        queue.add(new Dot(start.x, start.y));
        while (!queue.isEmpty()) {
            Dot s = queue.poll();
            queue = addDot(maze, queue, s);
        }
    }

    static Queue<Dot> addDot(int[][] maze, Queue<Dot> queue, Dot s) {
        if (maze[s.x - 1][s.y] == 0 || maze[s.x - 1][s.y] == -2) {
            maze[s.x - 1][s.y] = maze[s.x][s.y] + 1;
            queue.add(new Dot(s.x - 1, s.y));
        }
        if (maze[s.x][s.y + 1] == 0 || maze[s.x][s.y + 1] == -2) {
            maze[s.x][s.y + 1] = maze[s.x][s.y] + 1;
            queue.add(new Dot(s.x, s.y + 1));
        }
        if (maze[s.x + 1][s.y] == 0 || maze[s.x + 1][s.y] == -2) {
            maze[s.x + 1][s.y] = maze[s.x][s.y] + 1;
            queue.add(new Dot(s.x + 1, s.y));
        }
        if (maze[s.x][s.y - 1] == 0 || maze[s.x][s.y - 1] == -2) {
            maze[s.x][s.y - 1] = maze[s.x][s.y] + 1;
            queue.add(new Dot(s.x, s.y - 1));
        }
        return queue;
    }

    static int finish(Dot f, int[][] maze) {
        return maze[f.x][f.y];
    }

    static void print(int[][] maze, Dot finish1, Dot finish2) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (maze[i][j] == 0)
                    System.out.print("   ");
                else if (maze[i][j] == -1)
                    System.out.print("  H");
                else if (maze[i][j] == -5)
                    System.out.print("  S");
                else if (maze[i][j] == -2)
                    System.out.print("  F");
                else {
                    if ((i == finish1.x && j == finish1.y) || (i == finish2.x && j == finish2.y)){
                        if (maze[i][j] < 10)
                            System.out.print(" " + maze[i][j] + "F");
                        else
                            System.out.print(maze[i][j] + "F");
                    }
                    else {
                        if (maze[i][j] < 10)
                            System.out.print("  " + maze[i][j]);
                        else
                            System.out.print(" " + maze[i][j]);
                    }
                }
            }
            System.out.println();
        }
    }
}

class Dot {
    int x, y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
