import java.awt.*;

public class Rook extends Piece{
    private boolean starterSquare;
    public Rook(Color c, Square position){
        super(c, position);
        this.starterSquare = true;
    }

    @Override
    public boolean move(Square to) {
        return true;
    }
}
