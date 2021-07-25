import app.DBController;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;
import mls.*;
import mls.property.Farmhouse;
import mls.property.LeaseInformation;
import mls.property.structure.Building;
import mls.property.structure.Room;
import mls.property.structure.neighbourhoodfeatures.Hospital;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class DBControllerUnitTest {
    DBController db = DBController.getInstance();

    @Test
    public void TestSingleton() {

    }

    @Test
    public void TestUpdateNew() throws IOException {
        Listing listing = TestHelper.getSample();
        boolean found = false;
        db.update(listing);
        List<Listing> arr = db.readAll();

        for (Listing l: arr) {
            if (l.getMlsNumber().equals(listing.getMlsNumber()))
                found = true;
        }

        assertEquals(true, found);
    }

    @Test
    public void TestUpdateReplace() throws IOException {
        db.clear();

        Listing listing = TestHelper.getSample();
        db.update(listing);
        listing.setListingPrice(23f);
        db.update(listing);

        assertEquals(1, db.readAll().size());
    }

    @Test
    public void TestRead() throws IOException {
        Listing listing = TestHelper.getSample();
        db.update(listing);
        Listing readListing = db.read(listing.getMlsNumber());
        assertEquals(true, listing.equals(readListing));

        readListing = db.read(UUID.randomUUID());
        assertEquals(null, readListing);
    }


}
