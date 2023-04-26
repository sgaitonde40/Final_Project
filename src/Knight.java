import java.awt.*;

public class Knight extends Piece{
    private boolean starterSquare;
    public Knight(Color c, Square position){
        super(c, position);
        this.starterSquare = true;
    }

    @Override
    public boolean move(Square to) {
        return true;
    }
}
