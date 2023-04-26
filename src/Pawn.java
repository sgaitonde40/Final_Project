import java.awt.*;

public class Pawn extends Piece {
    private boolean starterSquare;
    public Pawn(Color c, Square position){
        super(c, position);
        this.starterSquare = true;
    }

    @Override
    public boolean move(Square to) {
        return true;
    }
}
