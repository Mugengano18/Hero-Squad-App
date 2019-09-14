package models;
import org.junit.Test;
import static org.junit.Assert.*;
public class HeroTest {
    @Test
    public void NewHeroObject() throws Exception{
        Hero hero=new Hero("Black widow",30,"Athletic abilities","normal situations");
        assertArrayEquals(true, hero instanceof Hero);
    }
    private void assertArrayEquals(boolean b, boolean b1) {
    }


}
