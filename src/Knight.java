import javax.swing.*;
import java.awt.*;

public class Knight extends Piece{
    private boolean starterSquare;
    private Image image;
    public Knight(Color c, Square position){
        super(c, position);
        this.starterSquare = true;
        if(c == Color.BLACK) {
            image = new ImageIcon("Images/blackknight.png").getImage();
        }
        else if(c == Color.WHITE) {
            image = new ImageIcon("Images/whiteknight.png").getImage();
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
