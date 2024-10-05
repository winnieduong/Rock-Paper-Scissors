import java.util.Random;

public class RandomStrategy implements Strategy {
    @Override
    public String determineMove(int[] playerMovesCount, String lastPlayerMove) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        return moves[random.nextInt(moves.length)];
    }
}
