import app.DBController;
import mls.Address;
import mls.property.*;
import mls.property.structure.Building;
import mls.*;
import mls.property.structure.Room;
import mls.property.structure.neighbourhoodfeatures.Hospital;

import java.io.IOException;

public class SampleTest {
    public static void main(String[] args) throws IOException {

        DBController db = DBController.getInstance();
        //db.update(TestHelper.getSample());
        Building b = TestHelper.getSample().getProperty().getBuilding();
        String json = db.getGson().toJson(b);
        Building b1 = db.getGson().fromJson(json, Building.class);
        System.out.println(b.equals(b1));
    }
}
