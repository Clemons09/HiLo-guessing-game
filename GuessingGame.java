import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
@SuppressWarnings("serial")
public class GuessingGame extends JFrame {
    private JTextField txtGuess;
    private JLabel lblOutput;
    private int numOfTries;
    JButton btnPlayAgain;
    private int theNumber;
    public void checkGuess(){
        String guessText = txtGuess.getText();
        String message = "";
        numOfTries++;
        try {
            int guess = Integer.parseInt(guessText);
            if (guess < theNumber)
                message = guess + " is too low. Try again.";
            else if (guess > theNumber)
                message = guess + " is too high. Try again.";
            else {
                message = guess + 
                        " is correct. You win after " + numOfTries + " tries. Let's play again!";
                //newGame();
                btnPlayAgain.setVisible(true);
                txtGuess.requestFocus();
                txtGuess.selectAll();
               
            }
        } catch (Exception e){
            message = "Enter a whole number between 1 and 100.";
        } finally {
            lblOutput.setText(message);
            txtGuess.requestFocus();
            txtGuess.selectAll();
        }
    }
    public void newGame() {
        theNumber = (int)(Math.random() * 100 + 1);
        numOfTries = 0;
        btnPlayAgain.setVisible(false);
    }
    public GuessingGame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Cody's Hi-Lo Guessing Game");
        getContentPane().setLayout(null);

        JLabel lblCodysHilo = new JLabel("Cody's Hi-Lo Guessing Game");
        lblCodysHilo.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblCodysHilo.setHorizontalAlignment(SwingConstants.CENTER);
        lblCodysHilo.setBounds(10, 37, 414, 24);
        getContentPane().add(lblCodysHilo);

        JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100:");
        lblGuessANumber.setHorizontalAlignment(SwingConstants.CENTER);
        lblGuessANumber.setBounds(10, 98, 272, 14);
        getContentPane().add(lblGuessANumber);

        txtGuess = new JTextField();
        txtGuess.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
        txtGuess.setBounds(292, 95, 43, 20);
        getContentPane().add(txtGuess);
        txtGuess.setColumns(10);

        JButton btnGuess = new JButton("Guess!");
        btnGuess.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
        btnGuess.setBounds(172, 149, 89, 23);
        getContentPane().add(btnGuess);

        lblOutput = new JLabel("Enter a number above, and click Guess!");
        lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
        lblOutput.setBounds(10, 209, 414, 14);
        getContentPane().add(lblOutput);
        
        btnPlayAgain = new JButton("New Game");
        btnPlayAgain.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		newGame();
        	}
        });
        btnPlayAgain.setBounds(261, 146, 117, 29);
        getContentPane().add(btnPlayAgain);
    }
    public static void main(String[] args) {
        GuessingGame theGame = new GuessingGame();
        theGame.newGame();
        theGame.setSize(new Dimension(450,300));
        theGame.setVisible(true);

    }
}