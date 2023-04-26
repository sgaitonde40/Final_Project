import java.awt.*;

public class Piece {
    private boolean isAlive;
    private Color color;
    private Square position;
    public Piece(Color c, Square position) {
        isAlive = true;
        color = c;

    }

    public boolean isAlive() {
        return isAlive;
    }

    public Color getColor() {
        return color;
    }

    public void setPosition(Square position) {
        this.position = position;
    }

    public Square getPosition() {
        return position;
    }

    public boolean move(Square sq) {
        if (!isLegalMove(sq)) {
            return false;
        }
        Piece capturedPiece = sq.getP();
        if (capturedPiece != null) {
            capturedPiece.capture();
        }
        position.removeP();
        sq.setP(this);
        position = sq;
        return true;
    }

    public void capture() {
        this.isAlive = false;
        this.position.removeP();
    }

    public boolean isLegalMove(Square sq) {
        return true;
    }
}
