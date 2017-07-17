public class Matrix {
    private int[][] matrix;
    private int rows;
    private int columns;

    public Matrix(String matrixAsString) {
        createMatrix(matrixAsString);
    }

    private void createMatrix(String matrixAsString) {
        String[] rowsAsStrings = matrixAsString.split("\\n");
        String[] numbersInColumnAsStrings = rowsAsStrings[0].split(" ");

        rows = rowsAsStrings.length;
        columns = numbersInColumnAsStrings.length;

        matrix = new int[rows][columns];
        fillMatrix(rowsAsStrings);
    }

    private void fillMatrix(String[] stringRows) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                String[] rowAsStrings = stringRows[row].split(" ");
                matrix[row][col] = Integer.valueOf(rowAsStrings[col]);
            }
        }
    }

    public int getRowsCount() {
        return rows;
    }

    public int getColumnsCount() {
        return columns;
    }

    public int[] getRow(int row) {
        return matrix[row];
    }

    public int[] getColumn(int col) {
        int[] column = new int[rows];
        for (int row = 0; row < rows; row++) {
            column[row] = matrix[row][col];
        }
        return column;
    }
}
