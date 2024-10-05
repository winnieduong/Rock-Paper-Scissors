public class MostUsedStrategy implements Strategy {
    @Override
    public String determineMove(int[] playerMovesCount, String lastPlayerMove) {
        int max = Integer.MIN_VALUE;
        String move = "Rock";
        if (playerMovesCount[0] > max) {
            max = playerMovesCount[0];
            move = "Paper"; // Choose Paper to counter Rock
        }
        if (playerMovesCount[1] > max) {
            max = playerMovesCount[1];
            move = "Scissors"; // Choose Scissors to counter Paper
        }
        if (playerMovesCount[2] > max) {
            move = "Rock"; // Choose Rock to counter Scissors
        }
        return move;
    }
}
