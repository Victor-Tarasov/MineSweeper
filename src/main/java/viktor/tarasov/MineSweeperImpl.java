package viktor.tarasov;

import java.util.Arrays;

public class MineSweeperImpl implements MineSweeper {
    private String mineField;
    private Integer width;

    public void setMineField(String mineField) throws IllegalArgumentException {
        if (mineField == null || mineField.isEmpty()) {
            throw new IllegalArgumentException("Mine field can't be null or empty.");
        }

        String[] lines = mineField.split("\n");
        if (Arrays.stream(lines).map(String::length).distinct().count() > 1) {
            throw new IllegalArgumentException("Mine field must have rectangular form.");
        }

        if (!Arrays.stream(lines).allMatch(line -> line.matches("[.*]+"))) {
            throw new IllegalArgumentException("Mine field can contains only dots, stars, and new line symbols (.*\\n)");
        }

        this.mineField = mineField;
        this.width = lines[0].length();
    }

    public String getHintField() throws IllegalStateException {
        char[] hintField = mineField.toCharArray();

        for (int i = 0; i < hintField.length; i++) {
            char c = hintField[i];
            if (c == '\n' || c == '*') continue;

            hintField[i] = (char) (countMines(hintField, i) + 48);
        }

        return new String(hintField);
    }

    private int countMines(char[] hintField, int i) {
        int widthWithNewLine = width + 1;
        int[] surroundingCells = {i - widthWithNewLine - 1, i - widthWithNewLine, i - widthWithNewLine + 1,
        i -1, i, i + 1, i + widthWithNewLine - 1, i + widthWithNewLine, i + widthWithNewLine + 1};
        return (int) Arrays.stream(surroundingCells)
                .filter(checkCellIndex -> isMine(hintField, checkCellIndex))
                .count();
    }

    private boolean isMine(char[] hintField, int i) {
        return !(i < 0 || i >= hintField.length) && hintField[i] == '*';
    }
}
