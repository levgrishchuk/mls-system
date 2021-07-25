import mls.Size;
import mls.property.structure.exterior.Backyard;
import mls.property.structure.exterior.Exterior;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExteriorUnitTest {
    @Test
    public void exteriorEquals(){
        Exterior e1 = new Backyard(new Size(1.0,2.0,"metric"));
        Exterior e2 = new Backyard(new Size(1.0,2.0,"metric"));
        Exterior e3 = new Backyard(new Size(99.0,99.0,"metric"));

        assertEquals(true, e1.equals(e1));
        assertEquals(true, e1.equals(e2));
        assertEquals(false, e1.equals(e3));
    }
}
