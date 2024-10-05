public class LeastUsedStrategy implements Strategy {
    @Override
    public String determineMove(int[] playerMovesCount, String lastPlayerMove) {
        int min = Integer.MAX_VALUE;
        String move = "Rock";
        if (playerMovesCount[0] < min) {
            min = playerMovesCount[0];
            move = "Paper"; // Choose Paper to counter Rock
        }
        if (playerMovesCount[1] < min) {
            min = playerMovesCount[1];
            move = "Scissors"; // Choose Scissors to counter Paper
        }
        if (playerMovesCount[2] < min) {
            move = "Rock"; // Choose Rock to counter Scissors
        }
        return move;
    }
}
