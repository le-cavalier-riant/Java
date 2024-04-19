public class Echecs {

    public static void main(String[] args) {

        for (int j = 0; j < ; j++) {

            for (int i = 0; i < 8; i++) {

                System.out.print('■');
                System.out.print(' ');

            }

        }

        Piece piece = new Piece("Pion");
        System.out.println(piece.caractere());
        System.out.println(piece.recupererType());

    }

}
