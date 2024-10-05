public class LastUsedStrategy implements Strategy {
    @Override
    public String determineMove(int[] playerMovesCount, String lastPlayerMove) {
        switch (lastPlayerMove) {
            case "Rock":
                return "Paper"; // Paper beats Rock
            case "Paper":
                return "Scissors"; // Scissors beats Paper
            case "Scissors":
                return "Rock"; // Rock beats Scissors
            default:
                return "Random"; // Random fallback
        }
    }
}
