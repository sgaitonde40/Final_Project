import java.awt.*;
import java.util.ArrayList;

public class Player {
    private Color c;
    private ArrayList<Piece> pieces = new ArrayList<>();
    public Player(Color c) {
        this.c = c;
    }

    public Color getC() {
        return c;
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void addPiece(Piece piece) {
         pieces.add(piece);
    }

    public void removePiece(Piece piece) {
        pieces.remove(piece);
    }
}
