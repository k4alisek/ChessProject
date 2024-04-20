import javax.swing.*;
import java.awt.*;
import java.util.Objects;
public class ChessGraphic extends JFrame {
    private static final int HEIGHT = 600;
    private static final int WIDTH = 600;
    String whitePawn = "♙";
    String blackPawn = "♟";
    String whiteRook = "♖";
    String blackRook = "♜";
    String whiteKnight = "♘";
    String blackKnight = "♞";
    String whiteBishop = "♗";
    String blackBishop = "♝";
    String whiteQueen = "♕";
    String blackQueen = "♛";
    String whiteKing = "♔";
    String blackKing = "♚";
    private JButton[][] tiles;
    private String currentFigure;
    private String currentPlayer;
    private final Chess chess;
    public ChessGraphic() {
        super("Chess");
        chess = new Chess();
        addComponents();
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void addComponents() {
        Container pane = getContentPane();
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(8, 8));
        tiles = new JButton[8][8];
        for (int index1 = 0; index1 < tiles.length; index1++) {
            for (int index2 = 0; index2 < tiles[index1].length; index2++) {
                tiles[index1][index2] = new JButton(" ");
                final int finalIndex1 = index1;
                final int finalIndex2 = index2;
                tiles[index1][index2].addActionListener(e -> tilePressed(finalIndex1, finalIndex2));
                tiles[index1][index2].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
                grid.add(tiles[index1][index2]);
            }
        }
        for (int index1 = 0; index1 < tiles.length; index1++) {
            if (index1 % 2 == 0) {
                for (int index2 = 0; index2 < tiles[index1].length; index2 = index2 + 2) {
                    tiles[index1][index2].setBackground(Color.white);
                }
            }
            else {
                for (int index2 = 1; index2 < tiles[index1].length; index2 = index2 + 2) {
                    tiles[index1][index2].setBackground(Color.white);
                }
            }
        }
        for (JButton[] tile : tiles) {
            for (JButton jButton : tile) {
                if (jButton.getBackground() != Color.white) {
                    jButton.setBackground(Color.lightGray);
                }
            }
        }
        pane.add(grid);
        tiles[0][0].setText(blackRook);
        tiles[0][1].setText(blackKnight);
        tiles[0][2].setText(blackBishop);
        tiles[0][3].setText(blackQueen);
        tiles[0][4].setText(blackKing);
        tiles[0][5].setText(blackBishop);
        tiles[0][6].setText(blackKnight);
        tiles[0][7].setText(blackRook);
        for (int index = 0; index < 8; index++) {
            tiles[1][index].setText(blackPawn);
        }
        tiles[7][0].setText(whiteRook);
        tiles[7][1].setText(whiteKnight);
        tiles[7][2].setText(whiteBishop);
        tiles[7][3].setText(whiteQueen);
        tiles[7][4].setText(whiteKing);
        tiles[7][5].setText(whiteBishop);
        tiles[7][6].setText(whiteKnight);
        tiles[7][7].setText(whiteRook);
        for (int index = 0; index < 8; index++) {
            tiles[6][index].setText(whitePawn);
        }
    }
    private void tilePressed(int digit1, int digit2) {
        setCurrentPlayer();
        if (chess.isAFigure(tiles[digit1][digit2].getText()) && currentFigure == null) {
            if (chess.whiteFigure(tiles[digit1][digit2].getText()) && Objects.equals(currentPlayer, "white")) {
                setCurrentFigure(digit1, digit2);
                tiles[digit1][digit2].setText(" ");
                setCurrentPlayer();
            }
            else if (chess.blackFigure(tiles[digit1][digit2].getText()) && Objects.equals(currentPlayer, "black")) {
                setCurrentFigure(digit1, digit2);
                tiles[digit1][digit2].setText(" ");
                setCurrentPlayer();
            }
        } else if (currentFigure != null) {
            if (chess.whiteFigure(currentFigure) && !chess.isAFigure(tiles[digit1][digit2].getText())) {
                tiles[digit1][digit2].setText(currentFigure);
                currentFigure = null;
            } else if (chess.whiteFigure(currentFigure) && chess.blackFigure(tiles[digit1][digit2].getText())) {
                tiles[digit1][digit2].setText(currentFigure);
                currentFigure = null;
            } else if (chess.blackFigure(currentFigure) && !chess.isAFigure(tiles[digit1][digit2].getText())) {
                tiles[digit1][digit2].setText(currentFigure);
                currentFigure = null;
            } else if (chess.blackFigure(currentFigure) && chess.whiteFigure(tiles[digit1][digit2].getText())) {
                tiles[digit1][digit2].setText(currentFigure);
                currentFigure = null;
            }
        }
    }
    public void setCurrentFigure(int digit1, int digit2) {
        currentFigure = tiles[digit1][digit2].getText();
    }
    public void setCurrentPlayer() {
        if (Objects.equals(currentPlayer, "white")) {
            currentPlayer = "black";
        }
        else {
            currentPlayer = "white";
        }
    }
    public static void main(String[] args) {
        new ChessGraphic();
    }
}
