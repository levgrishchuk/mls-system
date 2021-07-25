import mls.Size;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SizeUnitTest {
    @Test
    public void AreaTest(){

        Size s1 = new Size(4.0, 5.0, "meter");
        assertEquals(true, s1.getArea() == 20);
    }
    @Test
    public void EqualsTest(){

        Size s1 = new Size(4.0, 5.0, "meter");
        Size s2 = new Size(s1);
        Size s3 = new Size(4.0, 5.0, "meter");
        Size s4 = new Size(7.0, 8.0, "meter");

        assertEquals(true, s1.equals(s2));
        assertEquals(true, s1.equals(s3));
        assertEquals(false, s1.equals(s4));
    }
}
