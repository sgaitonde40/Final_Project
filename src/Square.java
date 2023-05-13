import java.awt.*;

public class Square {
    private int row, col;
    private boolean isUsed;
    private Piece p;

    public Square(int x, int y) {
        this.row = x;
        this.col = y;
        isUsed = false;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isUsed() {
        return isUsed;
    }

    // returns piece in this square
    public Piece getP() {
        return p;
    }

    // updates isused and sets the piece equal to the input
    public void setP(Piece p) {
        this.p = p;
        if(p != null) {
            isUsed = true;
        }
       else {
           isUsed = false;
        }
    }
    public void removeP() {
        this.p = null;
    }

    // if there is a piece in this square draw it
    public void draw(Graphics g, GameViewer G) {
        if(p != null) {
            p.draw(g, G);
        }
    }
}
