public interface Strategy {
    String determineMove(int[] playerMovesCount, String lastPlayerMove);
}
