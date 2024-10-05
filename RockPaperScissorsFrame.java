import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame {
    private final JTextField playerWinsField, computerWinsField, tiesField;
    private final JTextArea gameLogArea;
    private int playerWins = 0, computerWins = 0, ties = 0;
    private final Strategy[] strategies = {new LeastUsedStrategy(), new MostUsedStrategy(), new LastUsedStrategy(), new RandomStrategy(), new CheatStrategy()};
    private String lastPlayerMove = "";
    private int[] playerMovesCount = new int[3]; // Rock, Paper, Scissors

    public RockPaperScissorsFrame() {
        setTitle("Rock Paper Scissors Game");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Choose Your Move"));
        buttonPanel.setLayout(new GridLayout(1, 4));

        JButton rockButton = new JButton(new ImageIcon("src/rock.png"));
        JButton paperButton = new JButton(new ImageIcon("src/paper.png"));
        JButton scissorsButton = new JButton(new ImageIcon("src/scissors.png"));
        JButton quitButton = new JButton("Quit");

        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);
        buttonPanel.add(quitButton);

        JPanel statsPanel = new JPanel();
        statsPanel.setBorder(BorderFactory.createTitledBorder("Statistics"));
        statsPanel.setLayout(new GridLayout(3, 2));

        statsPanel.add(new JLabel("Player Wins: "));
        playerWinsField = new JTextField("0");
        playerWinsField.setEditable(false);
        statsPanel.add(playerWinsField);

        statsPanel.add(new JLabel("Computer Wins: "));
        computerWinsField = new JTextField("0");
        computerWinsField.setEditable(false);
        statsPanel.add(computerWinsField);

        statsPanel.add(new JLabel("Ties: "));
        tiesField = new JTextField("0");
        tiesField.setEditable(false);
        statsPanel.add(tiesField);

        gameLogArea = new JTextArea(10, 50);
        JScrollPane scrollPane = new JScrollPane(gameLogArea);

        add(buttonPanel, BorderLayout.NORTH);
        add(statsPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        rockButton.addActionListener(e -> playGame("Rock"));
        paperButton.addActionListener(e -> playGame("Paper"));
        scissorsButton.addActionListener(e -> playGame("Scissors"));
        quitButton.addActionListener(e -> System.exit(0));
    }

    private void playGame(String playerMove) {
        Random random = new Random();
        Strategy strategy = strategies[random.nextInt(strategies.length)];
        String computerMove = strategy.determineMove(playerMovesCount, lastPlayerMove);

        String result = determineWinner(playerMove, computerMove);
        updateStats(result);
        lastPlayerMove = playerMove;
        updateMoveCount(playerMove);
        gameLogArea.append(result + " (" + strategy.getClass().getSimpleName() + ")\n");
    }

    private String determineWinner(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "It's a tie!";
        } else if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
                (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
                (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            playerWins++;
            return "Player wins! " + playerMove + " beats " + computerMove;
        } else {
            computerWins++;
            return "Computer wins! " + computerMove + " beats " + playerMove;
        }
    }

    private void updateStats(String result) {
        if (result.contains("Player wins")) {
            playerWinsField.setText(String.valueOf(playerWins));
        } else if (result.contains("Computer wins")) {
            computerWinsField.setText(String.valueOf(computerWins));
        } else {
            ties++;
            tiesField.setText(String.valueOf(ties));
        }
    }

    private void updateMoveCount(String playerMove) {
        switch (playerMove) {
            case "Rock":
                playerMovesCount[0]++;
                break;
            case "Paper":
                playerMovesCount[1]++;
                break;
            case "Scissors":
                playerMovesCount[2]++;
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RockPaperScissorsFrame().setVisible(true));
    }
}
