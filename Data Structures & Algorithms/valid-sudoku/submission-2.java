class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rowCount = 0;
        boolean[][] columns = new boolean[9][9];
        boolean[][] boxes = new boolean[3][9];

        for (char[] row : board) {
            System.out.println("Row: " + rowCount);
            int col = 0;
            boolean[] rowCheck = new boolean[9];

            if (rowCount % 3 == 0) {
                boxes = new boolean[3][9];
            }

            for (char digit : row) {
                if (digit != '.') {
                    System.out.println("Digit: " + digit);

                    int digitIndex = digit - 1 - '0';

                    if (columns[col][digitIndex]) {
                        return false;
                    }

                    if (rowCheck[digitIndex]) {
                        return false;
                    }

                    columns[col][digitIndex] = true;
                    rowCheck[digitIndex] = true;
                    if (col < 3) {
                        if (boxes[0][digitIndex]) {
                            return false;
                        }
                        boxes[0][digitIndex] = true;
                    } else if (col < 6) {
                        if (boxes[1][digitIndex]) {
                            return false;
                        }
                        boxes[1][digitIndex] = true;
                    } else {
                        if (boxes[2][digitIndex]) {
                            return false;
                        }
                        boxes[2][digitIndex] = true;
                    }
                }
                col++;
            }
            rowCount++;
        }
        return true;
    }
}

