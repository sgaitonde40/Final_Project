import java.awt.*;

public class Bishop extends Piece{
    private boolean starterSquare;
    public Bishop(Color c, Square position){
        super(c, position);
        this.starterSquare = true;
    }

    @Override
    public boolean move(Square to) {
        return true;
    }
}
