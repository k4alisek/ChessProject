import java.util.Objects;
public class Chess {
    String whitePawn = "♙";
    String blackPawn = "♟";
    String whiteRook = "♖";
    String blackRook = "♜";
    String whiteKnight = "♘";
    String blackKnight = "♞";
    String whiteBishop = "♗";
    String blackBishop = "♝";
    String whiteQueen = "♕";
    String blackQueen = "♛";
    String whiteKing = "♔";
    String blackKing = "♚";
    String[] whiteFigures = {whitePawn, whiteRook, whiteKnight, whiteBishop, whiteQueen, whiteKing};
    String[] blackFigures = {blackPawn, blackRook, blackKnight, blackBishop, blackQueen, blackKing};
    public boolean isAFigure(String figure) {
        return !Objects.equals(figure, " ");
    }
    public boolean whiteFigure(String figure) {
        for (String whiteFigure : whiteFigures) {
            if (Objects.equals(figure, whiteFigure)) {
                return true;
            }
        }
        return false;
    }
    public boolean blackFigure(String figure) {
        for (String blackFigure : blackFigures) {
            if (Objects.equals(figure, blackFigure)) {
                return true;
            }
        }
        return false;
    }
}