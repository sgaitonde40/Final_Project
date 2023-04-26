import javax.swing.*;
import java.awt.*;

public class Bishop extends Piece{
    private boolean starterSquare;
    private Image image;
    public Bishop(Color c, Square position){
        super(c, position);
        this.starterSquare = true;
        if(c == Color.BLACK) {
            image = new ImageIcon("Images/blackbishop.png").getImage();
        }
        else if(c == Color.WHITE) {
            image = new ImageIcon("Images/whitebishop.png").getImage();
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
