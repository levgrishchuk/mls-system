import mls.Address;
import mls.property.*;
import mls.property.structure.Building;
import mls.*;
import mls.property.structure.Room;
import mls.property.structure.neighbourhoodfeatures.Hospital;

public class SampleTest {
    public static void main(String[] args) {

        DetachedHome f1 = DetachedHome.builder()
                /*.address(new Address(3495,
                        "Lawrence Ave.",
                        "Toronto",
                        "Ontario",
                        "M1H 1B3"))*/
                .annualTax(1200.00)
                .landSize(new Size(10.0, 10.0, "meter"))
                .lease(new LeaseInformation("Strata", 550.0))
                .build();

        DetachedHome f2 = DetachedHome.builder()
                /*.address(new Address(3495,
                        "Lawrence Ave.",
                        "Toronto",
                        "Ontario",
                        "M1H 1B3"))*/
                .annualTax(1200.00)
                .landSize(new Size(10.0, 10.0, "meter"))
                .lease(new LeaseInformation("Strata", 550.0))
                .build();

        System.out.println(f1.equals(f2));
    }
}
