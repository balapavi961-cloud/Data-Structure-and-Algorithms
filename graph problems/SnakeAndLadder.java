import java.util.*;

class SnakeAndLadder {

    static class Cell {
        int position;
        int diceThrows;

        Cell(int position, int diceThrows) {
            this.position = position;
            this.diceThrows = diceThrows;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] board = new int[101];
        Arrays.fill(board, -1);

        System.out.print("Enter number of ladders: ");
        int ladders = sc.nextInt();

        for (int i = 0; i < ladders; i++) {
            System.out.print("Enter ladder start and end: ");
            int start = sc.nextInt();
            int end = sc.nextInt();
            board[start] = end;
        }

        System.out.print("Enter number of snakes: ");
        int snakes = sc.nextInt();

        for (int i = 0; i < snakes; i++) {
            System.out.print("Enter snake head and tail: ");
            int head = sc.nextInt();
            int tail = sc.nextInt();
            board[head] = tail;
        }

        boolean[] visited = new boolean[101];
        Queue<Cell> queue = new LinkedList<>();

        visited[1] = true;
        queue.add(new Cell(1, 0));

        while (!queue.isEmpty()) {
            Cell current = queue.poll();

            if (current.position == 100) {
                System.out.println("Minimum dice throws required: " + current.diceThrows);
                return;
            }

            for (int dice = 1; dice <= 6; dice++) {
                int nextPos = current.position + dice;

                if (nextPos <= 100 && !visited[nextPos]) {
                    visited[nextPos] = true;

                    int finalPos;
                    if (board[nextPos] != -1) {
                        finalPos = board[nextPos];
                    } else {
                        finalPos = nextPos;
                    }

                    queue.add(new Cell(finalPos, current.diceThrows + 1));
                }
            }
        }
    }
}
