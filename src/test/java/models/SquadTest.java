package models;

import org.junit.Test;

public class SquadTest {

    @Test
    public void newSquad() throws Exception{
        Squad squad =new Squad("Avengers");
        assertArrayEquals(true, squad instanceof Squad);
    }

    private void assertArrayEquals(boolean b, boolean b1) {
    }
}
