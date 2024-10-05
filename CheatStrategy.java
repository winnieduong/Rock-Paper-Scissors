import java.util.Random;

public class CheatStrategy implements Strategy {
    @Override
    public String determineMove(int[] playerMovesCount, String lastPlayerMove) {
        Random random = new Random();
        if (random.nextDouble() < 0.1) { // 10% chance to cheat
            switch (lastPlayerMove) {
                case "Rock":
                    return "Paper"; // Paper beats Rock
                case "Paper":
                    return "Scissors"; // Scissors beats Paper
                case "Scissors":
                    return "Rock"; // Rock beats Scissors
            }
        }
        // Fallback to random if not cheating
        String[] moves = {"Rock", "Paper", "Scissors"};
        return moves[random.nextInt(moves.length)];
    }
}
