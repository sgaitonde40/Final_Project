import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class GameViewer extends JFrame implements MouseListener {

    private static final int SQUARE_SIZE = 90;
    private static final Color LIGHT_SQUARE_COLOR = new Color(255, 206, 158);
    private static final Color DARK_SQUARE_COLOR = new Color(209, 139, 71);

    private Game game;
    private boolean isCheck;
    private Piece p;
    private int windowWidth;
    private int windowHeight;

    public GameViewer(Game game, int width, int height) {
        // sets up mouse listener and window
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
        // paints all the squares
        for(int row = 0; row < Board.BOARD_SIZE; row++) {
            for(int col = 0; col < Board.BOARD_SIZE; col++) {
                if((row+col) % 2 == 0) {
                    g.setColor(DARK_SQUARE_COLOR);
                }
                else {
                    g.setColor(LIGHT_SQUARE_COLOR);
                }
                g.drawRect(row*SQUARE_SIZE, col*SQUARE_SIZE + 25, SQUARE_SIZE, SQUARE_SIZE);
                g.fillRect(row*SQUARE_SIZE, col*SQUARE_SIZE + 25, SQUARE_SIZE, SQUARE_SIZE);
            }
        }
        // paints all the pieces
        for(int row = 0; row < 8; row++) {
            for(int col = 0; col < 8; col++) {
                game.getBoard().getSquare(row,col).draw(g, this);
            }
        }
        // if a king is in check prints out check
        g.setColor(Color.BLACK);
        g.drawRect(720,0,50,740);
        g.fillRect(720,0,50,740);
        if(isCheck) {
            g.setColor(Color.RED);
            g.setFont(new Font("Serif", Font.TRUETYPE_FONT, 50));
            g.drawString("C", 720, 200);
            g.drawString("H", 720, 250);
            g.drawString("E", 720, 300);
            g.drawString("C", 720, 350);
            g.drawString("K", 720, 400);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // sets the piece equal to the location of the mouse press
        int col = e.getX() / SQUARE_SIZE;
        int row = e.getY() / SQUARE_SIZE;
        p = game.getBoard().getPieceAt(row, col);
        game.getBoard().getSquare(row, col).setP(p);
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        // finds the location of the mouse and calls the move method on the piece
        int col = e.getX() / SQUARE_SIZE;
        int row = e.getY() / SQUARE_SIZE;
        p.move(row, col, game.getBoard());
        // checks if it is a promotion piece
        game.getBoard().isPromotion();
        // goes through each piece and checks if its attacking the king
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(game.getBoard().getSquare(i, j).getP() != null) {
                    if(game.getBoard().isCheck(game.getBoard().getSquare(i, j).getP())) {
                        isCheck = true;
                        i = 8;
                        j = 8;
                    }
                    else {
                        isCheck = false;
                    }
                }
            }
        }
        // repaints the window
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }
}
