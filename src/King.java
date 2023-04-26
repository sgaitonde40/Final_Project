import javax.swing.*;
import java.awt.*;

public class King extends Piece{
    private boolean starterSquare;
    private Image image;
    public King(Color c, Square position){
        super(c, position);
        this.starterSquare = true;
        if(c == Color.BLACK) {
            image = new ImageIcon("Images/blackking.png").getImage();
        }
        else if(c == Color.WHITE) {
            image = new ImageIcon("Images/whiteking.png").getImage();
        }
    }
    @Override
    public void draw(Graphics g, int x, int y, GameViewer G) {
        g.drawImage(image, x, y, 90, 90, G);
    }

    @Override
    public boolean move(Square to) {
        return true;
    }
}
