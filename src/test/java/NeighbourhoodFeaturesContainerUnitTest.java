import mls.property.structure.neighbourhoodfeatures.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class NeighbourhoodFeaturesContainerUnitTest {
    @Test
    public void neighbourhoodContainerEquals(){
        NeighbourhoodFeatures f1 = new Hospital("1", "2");
        NeighbourhoodFeatures f2 = new Hospital("1", "3");
        NeighbourhoodFeatures f3 = new Hospital("1", "4");
        NeighbourhoodFeatures f4 = new Hospital("1", "5");

        NeighbourhoodFeaturesContainer c1 = new NeighbourhoodFeaturesContainer();
        NeighbourhoodFeaturesContainer c2 = new NeighbourhoodFeaturesContainer();
        NeighbourhoodFeaturesContainer c3 = new NeighbourhoodFeaturesContainer();
        NeighbourhoodFeaturesContainer c4 = new NeighbourhoodFeaturesContainer();

        c1.add(f1);
        c1.add(f2);
        c1.add(f3);
        c1.add(f4);

        c2.add(f1);
        c2.add(f2);
        c2.add(f3);
        c2.add(f4);

        c3.add(f4);
        c3.add(f3);
        c3.add(f2);
        c3.add(f1);

        c4.add(f4);
        c4.add(f3);
        c4.add(f2);


        assertEquals(true, c1.equals(c1));
        assertEquals(true, c1.equals(c2));
        assertEquals(true, c1.equals(c3));
        assertEquals(false, c1.equals(c4));
    }

    @Test
    public void AddDeepCopyTest(){
        NeighbourhoodFeaturesContainer c1 = new NeighbourhoodFeaturesContainer();
        NeighbourhoodFeatures f1 = new Park("link1");

        c1.add(f1);

        assertEquals(false, c1.getNeighbourhood().get(0) == f1);
    }

    @Test
    public void SetDeepCopyTest(){
        NeighbourhoodFeaturesContainer c1 = new NeighbourhoodFeaturesContainer();

        List<NeighbourhoodFeatures> l1 = new ArrayList<NeighbourhoodFeatures>();
        l1.add(new Hospital("1", "2"));
        l1.add(new Park("1"));
        l1.add(new School("1", "4"));
        l1.add(new Subway("1"));

        NeighbourhoodFeaturesContainer c2 = new NeighbourhoodFeaturesContainer(l1);

        c1.setNeighbourhood(c2);

        boolean flag = false;

        // check that no element in the new list has the same address as the first one in l1
        for(int i = 0; i < l1.size(); i++){
            if(l1.get(0) == c1.getNeighbourhood().get(i)){
                flag = true;
            }
        }
        assertFalse(flag);
    }

    @Test
    public void MakeCopyTest(){
        NeighbourhoodFeatures f1 = new Park("1");
        NeighbourhoodFeatures copy = f1.makeCopy();

        assertEquals(false, f1 == copy);
    }
}
