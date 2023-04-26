import java.awt.*;

public class King extends Piece{
    private boolean starterSquare;
    public King(Color c, Square position){
        super(c, position);
        this.starterSquare = true;
    }

    @Override
    public boolean move(Square to) {
        return true;
    }
}
