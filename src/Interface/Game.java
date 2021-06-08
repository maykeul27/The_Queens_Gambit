package Interface;

import chess.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class Game extends JPanel{ //Still need to Add Exception TRY CATCH everywhere

	private static final long serialVersionUID = 1L;
    private JButton[][] graphicBoard = new JButton[8][8];
	private Board board;

	private int numberOfClicks;
	private Piece pieceMove;
	private Case caseFrom;
	private Case caseTo;
	private int activePlayer;

    private Player player1;
    private Player player2;


    public Game(){
        board = new Board();
    }

    private boolean verifyVictory(){
        if(true){ //Victory condition
            return true;
        }
        else return false;
    }

    /*public void paint(Graphics g){
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
    }*/

    public void refreshGraphicBoard(){


        for (int i = 0; i < graphicBoard.length; i++) {
            for (int j = 0; j < graphicBoard[i].length; j++) {
                JButton button = graphicBoard[i][j];

                ImageIcon icon = new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                //Search pieces and display them
                Piece piece = board.getCase(i, j).getPieceInPlace();
                if (piece != null) {
                    if (piece.getClass().toString().contains("King")) {
                        if (piece.getColor().equals("white")) {
                            icon = new ImageIcon("img/wking.png");
                        } else {
                            icon = new ImageIcon("img/bking.png");
                        }
                    } else if (piece.getClass().toString().contains("Queen")) {
                        if (piece.getColor().equals("white")) {
                            icon = new ImageIcon("img/wqueen.png");
                        } else {
                            icon = new ImageIcon("img/bqueen.png");
                        }
                    } else if (piece.getClass().toString().contains("Rook")) {
                        if (piece.getColor().equals("white")) {
                            icon = new ImageIcon("img/wrook.png");
                        } else {
                            icon = new ImageIcon("img/brook.png");
                        }
                    } else if (piece.getClass().toString().contains("Bishop")) {
                        if (piece.getColor().equals("white")) {
                            icon = new ImageIcon("img/wbishop.png");
                        } else {
                            icon = new ImageIcon("img/bbishop.png");
                        }
                    } else if (piece.getClass().toString().contains("Knight")) {
                        if (piece.getColor().equals("white")) {
                            icon = new ImageIcon("img/wknight.png");
                        } else {
                            icon = new ImageIcon("img/bknight.png");
                        }
                    } else {
                        if (piece.getColor().equals("white")) {
                            icon = new ImageIcon("img/wpawn.png");
                        } else {
                            icon = new ImageIcon("img/bpawn.png");
                        }
                    }
                }
                button.setIcon(icon);
                if ((i + j) % 2 == 0) {
                    button.setBackground(Color.WHITE);
                } else {
                    button.setBackground(Color.DARK_GRAY);
                }
            }
        }
    }

    public void graphicBoard(){

        //In a gridlayout, any added item will fill at the same size than every other objects and objects scale depending on the number of lines and columns
        this.setLayout(new GridLayout(0, 9));
        //Insets buttonMargin = new Insets(0,0,0,0);

        //Instanciate the JButton array with colored tiles
        for (int i = 0; i < graphicBoard.length; i++) {
            for (int j = 0; j < graphicBoard[i].length; j++) {
                JButton button = new JButton();

                ImageIcon icon = new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                //Search pieces and display them
                Piece piece = board.getCase(i,j).getPieceInPlace();
                if(piece != null) {
                    if (piece.getClass().toString().contains("King")) {
                        if (piece.getColor().equals("white")) {
                            icon = new ImageIcon("img/wking.png");
                        } else {
                            icon = new ImageIcon("img/bking.png");
                        }
                    } else if (piece.getClass().toString().contains("Queen")) {
                        if (piece.getColor().equals("white")) {
                            icon = new ImageIcon("img/wqueen.png");
                        } else {
                            icon = new ImageIcon("img/bqueen.png");
                        }
                    } else if (piece.getClass().toString().contains("Rook")) {
                        if (piece.getColor().equals("white")) {
                            icon = new ImageIcon("img/wrook.png");
                        } else {
                            icon = new ImageIcon("img/brook.png");
                        }
                    } else if (piece.getClass().toString().contains("Bishop")) {
                        if (piece.getColor().equals("white")) {
                            icon = new ImageIcon("img/wbishop.png");
                        } else {
                            icon = new ImageIcon("img/bbishop.png");
                        }
                    } else if (piece.getClass().toString().contains("Knight")) {
                        if (piece.getColor().equals("white")) {
                            icon = new ImageIcon("img/wknight.png");
                        } else {
                            icon = new ImageIcon("img/bknight.png");
                        }
                    } else {
                        if (piece.getColor().equals("white")) {
                            icon = new ImageIcon("img/wpawn.png");
                        } else {
                            icon = new ImageIcon("img/bpawn.png");
                        }
                    }
                }
                button.setIcon(icon);
                //}
                if ((i+j)%2 == 0)
                {
                    button.setBackground(Color.WHITE);
                }
                else{
                    button.setBackground(Color.DARK_GRAY);
                }
                graphicBoard[i][j] = button;
                //Add event listener
                int finalI = i;
                int finalJ = j;
                ActionListener buttonListener = new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        numberOfClicks++;
                        if(numberOfClicks == 1){
                            Piece piece = board.getCase(finalI, finalJ).getPieceInPlace();
                            if (piece != null) {
                                pieceMove = piece;
                                System.out.println(piece);
                                System.out.println(piece.getColor());
                            }
                            else {
                                numberOfClicks=0;
                                pieceMove = null;
                            }
                        }
                        else if(numberOfClicks == 2){
                            System.out.println("Is it valid? " + pieceMove.isValid(finalI, finalJ));
                            if(pieceMove.isValid(finalI, finalJ).equals("Eat")){
                                activePlayer++;
                                numberOfClicks=0;
                                board.getCase(pieceMove.getX(), pieceMove.getY()).getPieceInPlace().toMove(finalI, finalJ);
                                refreshGraphicBoard();
                            }
                            else if(pieceMove.isValid(finalI, finalJ).equals("Clear")){
                                activePlayer++;
                                numberOfClicks=0;
                                board.getCase(pieceMove.getX(), pieceMove.getY()).getPieceInPlace().toMove(finalI, finalJ);
                                refreshGraphicBoard();
                            }
                            else{
                                numberOfClicks=0;
                                pieceMove = null;
                            }
                        }
                        System.out.println("Button clicked is (" + finalI + ", " + finalJ + ") and numberOfClicks is " + numberOfClicks);
                    }
                };
                graphicBoard[i][j].addActionListener(buttonListener);
            }
        }
        String[] columns = {"A", "B", "C", "D", "E", "F", "G", "H"};

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j <= 8; j++) {
                if (j==0){
                    this.add(new JLabel("" + (8-i), SwingConstants.CENTER));
                }
                else{
                    this.add(graphicBoard[i][j-1]);
                }
            }
        }
        //Display the letters line (A to H) at the line 9 (i = 8)
        this.add(new JLabel("", SwingConstants.CENTER));
        for (int i = 1; i <= 8; i++) {
            this.add(new JLabel(columns[i-1], SwingConstants.CENTER));
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
        game.graphicBoard();

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
        int activePlayer = 1;
        gameinfos.setText("It's player 1 turn !");
        Turn currentTurn = new Turn();

        while(!game.verifyVictory()) //While the game is not completed
        {
            gameinfos.setText("It's player " +  (activePlayer%2)+1 + " turn !"); //When currentplayer is set to 0, it's player 1 turn, when it's set to 1, it's player 2 turn
        }
    }
}


