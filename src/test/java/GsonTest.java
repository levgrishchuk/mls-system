import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import mls.property.LeaseInformation;
import mls.property.MobileHome;

public class GsonTest {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

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

        JsonObject e = (JsonObject) gson.toJsonTree(p);
        System.out.println(e);
    }
}
