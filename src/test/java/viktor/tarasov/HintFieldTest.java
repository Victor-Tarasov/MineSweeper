package viktor.tarasov;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HintFieldTest {

    @Test
    public void center() {
        assertHintField("...\n.*.\n...", "111\n1*1\n111");
    }

    @Test
    public void leftUpperConner() {
        assertHintField("*..\n...\n...", "*10\n110\n000");
    }

    @Test
    public void rightUpperConner() {
        assertHintField("..*\n...\n...", "01*\n011\n000");
    }

    @Test
    public void endOfMiddleLine() {
        assertHintField("...\n..*\n...", "011\n01*\n011");
    }

    @Test
    public void towMines() {
        assertHintField("....\n.*..\n....\n*...\n....", "1110\n1*10\n2210\n*100\n1100");
    }

    @Test
    public void forOnThreeField() {
        assertHintField("*...\n..*.\n....", "*211\n12*1\n0111");
    }

    private void assertHintField(String mineField, String hintField) {
        MineSweeperImpl mineSweeper = new MineSweeperImpl();
        mineSweeper.setMineField(mineField);
        assertEquals(mineSweeper.getHintField(), hintField);
    }
}
