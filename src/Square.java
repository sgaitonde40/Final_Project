import java.awt.*;

public class Square {
    private int x, y;
    private boolean isUsed;
    private Piece p = new Piece(Color.BLACK, this);

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
        isUsed = false;
        p = null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public Piece getP() {
        return p;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void setUsed(boolean used) {
        isUsed = used;
    }

    public void setP(Piece p) {
        this.p = p;
    }
    public void removeP() {
        this.p = null;
    }
}
