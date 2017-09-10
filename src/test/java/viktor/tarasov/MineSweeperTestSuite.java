package viktor.tarasov;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        ValidationTest.class,
        HintFieldTest.class
})
public class MineSweeperTestSuite {
}
