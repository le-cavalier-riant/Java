public class Piece {

    private String type;

    Piece(String type) {
        this.type = type;
    }

    public char caractere() {
        return 'c';
    }

    public String recupererType() {
        return this.type;
    }
}
