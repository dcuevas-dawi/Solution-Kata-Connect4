public class Connect4 {

    public static void main(String[] args) {

        Connect4 instancia = new Connect4();
        int[] moves = new int[]{1, 2, 2, 3, 4, 3, 1, 4, 3, 4, 4, 5, 4};
        for (int i = 0; i < moves.length; i++) {

            System.out.println(instancia.play(moves[i]));

        }
    }

    int[][] board = new int[6][7]; //Declaramos el tablero
    int currentPlayer = 2; //Inicializamos con el jugador 2 porque se cambia justo al empezar el método play, empezará con el 1
    boolean gameWon = false; //Condición de victoria conseguida
    int currentColumn = 0;
    int currentRow = 0;

    public String play(int column) {

        if (gameWon) {
            return "Game has finished!"; //Una vez acabado el juego, todos los movimientos obtendrán esta respuesta
        }

        currentPlayer = currentPlayer == 1 ? 2 : 1; //Cambiamos de jugador

        for (int i = 5; i >= 0; i--) { // Comprobamos de abajo a arriba si podemos colocar la ficha
            if (board[i][column] == 0) {
                board[i][column] = currentPlayer;
                currentColumn = column;
                currentRow = i;
                break;
            }
            if (i == 0) { //Si no se puede colocar la ficha, devolvemos  columna llena y pasamos de jugador, para que al ejecutar de nuevo play, aparezca de nuevo el mismo
                currentPlayer = currentPlayer == 1 ? 2 : 1;
                return "Column full!";
            }
        }
        if (checkWin(currentColumn, currentRow)) { //Llamamos a los métodos de abajo para comprobar las condiciones de victoria
            gameWon = true;
            return "Player " + currentPlayer + " wins!";
        }

        return "Player " + currentPlayer + " has a turn"; //Si no ocurre nada, pasamos de turno

    }

    private boolean checkWin(int column, int row) { //Recibimos columna y fila actuales y llamamos a los métodos de comprobar la victoria

        if (checkVertical(column) || checkHorizontal(row) || checkDiagonalRight() || checkDiagonalLeft()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkVertical(int column) { //Comprobamos combinación vertical

        for (int i = 2; i >= 0; i--) {
            if ((board[i][column] != 0)
                    && (board[i][column] == board[i + 1][column])
                    && (board[i + 1][column] == board[i + 2][column])
                    && (board[i + 2][column] == board[i + 3][column])) {
                return true;
            }
        }

        return false;
    }

    private boolean checkHorizontal(int row) { //Comprobamos combinación horizontal

        for (int i = 0; i <= 3; i++) {
            if ((board[row][i] != 0)
                    && (board[row][i] == board[row][i + 1])
                    && (board[row][i + 1] == board[row][i + 2])
                    && (board[row][i + 2] == board[row][i + 3])) {
                return true;
            }
        }

        return false;
    }

    private boolean checkDiagonalRight() { //Comprobamos combinación diagonal /

        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j <= 3; j++) {
                if ((board[i][j] != 0)
                        && (board[i][j] == board[i + 1][j + 1])
                        && (board[i + 1][j + 1] == board[i + 2][j + 2])
                        && (board[i + 2][j + 2] == board[i + 3][j + 3])) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkDiagonalLeft() { //Comprobamos la otra combinación diagonal \

        for (int i = 5; i >= 3; i--) {
            for (int j = 0; j <= 3; j++) {
                if ((board[i][j] != 0)
                        && (board[i][j] == board[i - 1][j + 1])
                        && (board[i - 1][j + 1] == board[i - 2][j + 2])
                        && (board[i - 2][j + 2] == board[i - 3][j + 3])) {
                    return true;
                }
            }
        }

        return false;
    }

}
