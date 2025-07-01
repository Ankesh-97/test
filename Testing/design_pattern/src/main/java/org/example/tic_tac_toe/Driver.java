package src.design_patterns.tic_tac_toe;

import java.util.*;

public class Driver {
    public static void main(String[] args) {
        List<Player> playerList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of board");
        int size = scanner.nextInt();
        Board board = new Board(size);
        System.out.println("Enter the No. of Player");
        int numberOfPlayer = scanner.nextInt();

        for (int i = 0; i < numberOfPlayer; i++) {
            System.out.println("Enter the Player " + (i + 1) + " : ");
            String playerName = scanner.next();
            System.out.println("Enter the Player " + (i + 1) + " Symbol : ");
            String symbol = scanner.next();
            playerList.add(new Player(playerName, symbol));
        }

        System.out.println("Start the Game Y or N ?");
        String symbol = scanner.next();
        if (symbol.equals("Y")) {
            System.out.println("Starting the Game");
        } else {
            System.exit(1);
        }
        Game game = new Game(board, playerList);
        boolean isWinner = false;
        Queue<Player> queue = new LinkedList<>(playerList);
        while (!isWinner) {
            Player player = queue.peek();
            System.out.println(player.getName() + " turn.");
            System.out.println("Enter cell row :");
            int row = scanner.nextInt();
            System.out.println("Enter cell col :");
            int col = scanner.nextInt();

            boolean isAdded = game.play(row, col, player.getSymbol());
            if (isAdded) {
                player = queue.poll();
            }
            isWinner = board.checkWinner(row, col);
            if (isWinner) {
                System.out.println("Winner is " + player.getName());
            }
            board.printBoard();
            queue.add(player);
        }
    }
}
