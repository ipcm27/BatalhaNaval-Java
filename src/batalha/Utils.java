package batalha;

public class Utils {
    public static char rowToLetter(int row) {
        int ascii = row + 65;
        char rowChar = (char) row;
        return rowChar;
    }

    public static int letterToRow(char row) {
        char rowChar = Character.toUpperCase(row); // Converte para letra maiúscula
        int ascii = rowChar; // Converte para código ASCII
        return ascii - 65;
    }
}
