package Interface;

import chess.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseListener;

public class Game extends JPanel{

	private static final long serialVersionUID = 1L;
	private Board board;
    private Player player1;
    private Player player2;


    public Game(){

    }

    private boolean verifyVictory(){
        if(true){ //Victory condition
            return true;
        }
        else return false;
    }

    public void paint(Graphics g){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if((i+j)%2 == 0){
                    g.setColor(Color.WHITE);
                    g.fillRect (i*60, j*60, 60, 60);
                }
                else{
                    g.setColor(Color.DARK_GRAY);
                    g.fillRect (i*60, j*60, 60, 60);
                }
            }
        }
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setTitle("Chess");
        window.setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        JTextArea gameinfos = new JTextArea("");
        northPanel.add(gameinfos);

        JPanel southPanel = new JPanel();
        JTextArea developpers = new JTextArea("Hello, this interface is made by The Queen\'s Gambit Team");
        southPanel.add(developpers);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBorder(new TitledBorder("Let's Play!"));

        GridBagConstraints constraints = new GridBagConstraints();

        JPanel westPanel = new JPanel();
        JTextArea p1jtext = new JTextArea("Player 1 panel info");
        westPanel.add(p1jtext);

        JPanel eastPanel = new JPanel();
        JTextArea p2jtext = new JTextArea("Player 2 panel info");
        eastPanel.add(p2jtext);

        Game game = new Game();
        game.setPreferredSize(new Dimension(504, 504));
        constraints.gridheight = 5;

        constraints.weightx = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        centerPanel.add(westPanel, constraints);
        constraints.weightx = 3;
        constraints.gridx = 1;
        constraints.gridy = 0;
        centerPanel.add(game, constraints);
        constraints.weightx = 1;
        constraints.gridx = 4;
        constraints.gridy = 0;
        centerPanel.add(eastPanel, constraints);

        window.add("North", northPanel);
        window.add("South", southPanel);
        window.add("Center", centerPanel);

        window.setSize(1200, 720);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        Player[] players = new Player[2];
        //Add the players
        int currentPlayer = 0;
        gameinfos.setText("It's player 1 turn !");
        Turn currentTurn = new Turn();

        while(!game.verifyVictory()) //While the game is not completed
        {
            //while (!currentTurn.isValid()) { //While the current player didn't made a valid move, he have to play
                gameinfos.setText("Player " + (currentPlayer+1) + ", move invalid, try again");
            //}
            currentPlayer += 1%2;
            gameinfos.setText("It's player " +  (currentPlayer+1) + " turn !"); //When currentplayer is set to 0, it's player 1 turn, when it's set to 1, it's player 2 turn
        }
    }
}


