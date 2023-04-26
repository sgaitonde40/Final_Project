import java.awt.*;

public class Queen extends Piece{
    private boolean starterSquare;
    public Queen(Color c, Square position){
        super(c, position);
        this.starterSquare = true;
    }

    @Override
    public boolean move(Square to) {
        return true;
    }
}

