import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GameViewer extends JFrame implements MouseListener {

    private static final int SQUARE_SIZE = 90;
    private static final Color LIGHT_SQUARE_COLOR = new Color(255, 206, 158);
    private static final Color DARK_SQUARE_COLOR = new Color(209, 139, 71);

    private Game game;
    private ArrayList<Square> validMoves;
    private Square currentSquare;

    private int windowWidth;
    private int windowHeight;

    public GameViewer(Game game, int width, int height) {
        this.game = game;
        addMouseListener(this);
        this.windowHeight = height;
        this.windowWidth = width;
        this.setTitle("Chess");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        for(int i = 0; i < game.getBoard().BOARD_SIZE; i++) {
            for(int j = 0; j < game.getBoard().BOARD_SIZE; j++) {
                if((i+j) % 2 == 0) {
                    g.setColor(DARK_SQUARE_COLOR);
                    g.drawRect(i*SQUARE_SIZE, j*SQUARE_SIZE + 25, SQUARE_SIZE, SQUARE_SIZE);
                    g.fillRect(i*SQUARE_SIZE, j*SQUARE_SIZE + 25, SQUARE_SIZE, SQUARE_SIZE);
                }
                else {
                    g.setColor(LIGHT_SQUARE_COLOR);
                    g.drawRect(i*SQUARE_SIZE, j*SQUARE_SIZE + 25, SQUARE_SIZE, SQUARE_SIZE);
                    g.fillRect(i*SQUARE_SIZE, j*SQUARE_SIZE + 25, SQUARE_SIZE, SQUARE_SIZE);
                }
            }
        }
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(game.getBoard().getPieceAt(i,j) != null) {
                    game.getBoard().getPieceAt(i,j).draw(g, game.getBoard().getPieceAt(i,j).getPosition().getY() * 90
                                    ,game.getBoard().getPieceAt(i,j).getPosition().getX() * 90 + 20, this);
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        int row = y / SQUARE_SIZE;
        int col = x / SQUARE_SIZE;
        Square sq = new Square(row, col);
        if(currentSquare == null) {
            Piece p = game.getBoard().getPieceAt(row, col);
            if(p != null && p.getColor() == game.getCurrentPlayer().getC()) {
                currentSquare = sq;
                validMoves = game.getValidMoves();
            }
        }
        else {
            
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
