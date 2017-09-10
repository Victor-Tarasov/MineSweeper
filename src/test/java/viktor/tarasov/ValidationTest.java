package viktor.tarasov;

import org.junit.Test;

public class ValidationTest {

    @Test(expected = IllegalArgumentException.class)
    public void emptyField() {
        new MineSweeperImpl().setMineField("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullField() {
        new MineSweeperImpl().setMineField("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nonRectangularField() {
        new MineSweeperImpl().setMineField("...*\n...");
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongSymbolsInField() {
        new MineSweeperImpl().setMineField(".k.\n...");
    }
}
