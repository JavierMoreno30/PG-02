package model;

public class NqueenProblem {

    public String solveNqueens(int n) {
        String result = "";
        int[][] board = new int[n][n];

        if (placeFirstQueen(board)) {
            result += printBoard(board);
        } else {
            result += "No existe solución para un tablero de " + n + "*" + n;
        }

        return result;
    }

    //busca la primera reina en cualquier fila y cualquier columna
    private boolean placeFirstQueen(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (isSafe(board, row, col)) {
                    board[row][col] = 1;

                    if (placeQueens(board, row, col)) return true;

                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    //coloca las demás reinas a partir de la posición inicial
    private boolean placeQueens(int[][] board, int startRow, int startCol) {
        if (countQueens(board) == board.length) return true;

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] == 0 && isSafe(board, row, col)) {
                    board[row][col] = 1;

                    if (placeQueens(board, row, col)) return true;

                    board[row][col] = 0;
                }
            }
        }

        return countQueens(board) == board.length;
    }

    private int countQueens(int[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) count++;
            }
        }
        return count;
    }

    private boolean isSafe(int[][] board, int row, int col) {
        //revisar fila
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == 1) return false;
        }

        //revisar columna
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 1) return false;
        }

        //diagonal superior izquierda
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }

        //diagonal superior derecha
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 1) return false;
        }

        //diagonal inferior izquierda
        for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 1) return false;
        }

        //diagonal inferior derecha
        for (int i = row, j = col; i < board.length && j < board.length; i++, j++) {
            if (board[i][j] == 1) return false;
        }

        return true;
    }

    private String printBoard(int[][] board) {
        String result = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                result += board[i][j] == 1 ? " Q " : " . ";
            }
            result += "\n";
        }
        return result;
    }
}