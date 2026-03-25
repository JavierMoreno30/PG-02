package model;

public class SudokuProblem {

    public String solveSudoku(int[][] board) {
        String result = "";

        if (solve(board)) {
            result += printBoard(board);
        } else {
            result += "No existe solución para el sudoku dado.";
        }

        return result;
    }

    private boolean solve(int[][] board) {
        int[] emptyCell = findEmptyCell(board);

        if (emptyCell == null) {
            return true;
        }

        int row = emptyCell[0];
        int col = emptyCell[1];

        for (int num = 1; num <= 9; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;

                if (solve(board)) {
                    return true;
                }

                board[row][col] = 0;
            }
        }

        return false;
    }

    private int[] findEmptyCell(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    return new int[]{row, col};
                }
            }
        }
        return null;
    }

    private boolean isSafe(int[][] board, int row, int col, int num) {
        // revisar fila y columna
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) return false;
            if (board[i][col] == num) return false;
        }

        // revisar subcuadro 3x3
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }

    private String printBoard(int[][] board) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                result.append(board[i][j]).append(" ");
                if ((j + 1) % 3 == 0 && j != 8) {
                    result.append("| ");
                }
            }
            result.append("\n");

            if ((i + 1) % 3 == 0 && i != 8) {
                result.append("---------------------\n");
            }
        }

        return result.toString();
    }
}