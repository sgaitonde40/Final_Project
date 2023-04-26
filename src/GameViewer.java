import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameViewer extends JFrame implements MouseListener {

    private static final int SQUARE_SIZE = 60;
    private static final Color LIGHT_SQUARE_COLOR = new Color(255, 206, 158);
    private static final Color DARK_SQUARE_COLOR = new Color(209, 139, 71);

    private Game game;
    private Square selectedSquare;
    private Square[] validMoves;

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

    @Override
    public void mouseClicked(MouseEvent e) {

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
