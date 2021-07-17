import mls.Address;
import mls.property.*;
import mls.property.structure.Building;
import mls.*;

public class SampleTest {
    public static void main(String[] args) {
        MobileHome p = MobileHome.builder()
                /*.address(new Address())*/
                .annualTax(23.0)
                /*.building(new Building())*/
                .lease(new LeaseInformation("HOA", 325.0))
                /*.landSize(new Size())*/
                /*.addExterior(new Lawn())*/
                /*.addNeighbourhood(Property.NeighbourhoodFeatures.Hospital)*/
                .underConstruction()
                .build();

        System.out.println(p);
    }
}
