import app.DBController;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;
import mls.*;
import mls.property.DetachedHome;
import mls.property.Farmhouse;
import mls.property.LeaseInformation;
import mls.property.structure.Building;
import mls.property.structure.Room;
import mls.property.structure.neighbourhoodfeatures.Hospital;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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

    /**
     * Tests read, readByPostalCode readByPropertyType
     * @throws IOException
     */
    @Test
    public void TestRead() throws IOException {
        Listing l1 = TestHelper.getSample();
        Listing l2 = TestHelper.getSample();

        // change postal code for l2
        l2.getProperty().setAddress(
                new Address(3495,
                        "Lawrence Ave.",
                        "Toronto",
                        "Ontario",
                        "A1A 2B2")
        );

        // change postal code for l3
        Listing l3 = TestHelper.getSample();
        l3.getProperty().setAddress(
                new Address(3495,
                        "Lawrence Ave.",
                        "Toronto",
                        "Ontario",
                        "A1A 2B2")
        );

        // change property type for l4
        Listing l4 = TestHelper.getSample();
        l4.setProperty(new DetachedHome.Builder().build());

        // change property type for l5
        Listing l5 = TestHelper.getSample();
        l5.setProperty(new DetachedHome.Builder().build());

        db.update(l1);
        db.update(l2);
        db.update(l3);
        db.update(l4);
        db.update(l5);

        // target lists
        List<Listing> postalCodesTest = Arrays.asList(l2, l3);
        List<Listing> propertyTypeTest = Arrays.asList(l4, l5);

        // by mlsNumber
        Listing readListing = db.read(l1.getMlsNumber());
        assertEquals(true, l1.equals(readListing));

        // error check
        readListing = db.read(UUID.randomUUID());
        assertEquals(null, readListing);

        // byPostalCode
        List<Listing> readListingList = db.readByPostalCode("A1A 2B2");
        assertEquals(true, readListingList.containsAll(postalCodesTest));

        // byPropertyType
        readListingList = db.readByPropertyType("DetachedHome");
        assertEquals(true, readListingList.containsAll(propertyTypeTest));

        // cleanup
        db.delete(l1);
        db.delete(l2);
        db.delete(l3);
        db.delete(l4);
        db.delete(l5);
    }

    @Test
    public void TestDelete() throws IOException {
        Listing l1 = TestHelper.getSample();

        db.update(l1);

        List<Listing> dbList = db.readAll();
        assertEquals(true, dbList.contains(l1));

        // delete existing entry
        boolean resultOfDeletion = db.delete(l1);
        dbList = db.readAll();
        assertEquals(true, resultOfDeletion == true &&
                dbList.contains(l1) == false);

        // delete non-existing entry
        resultOfDeletion = db.delete(l1);
        assertEquals(false, resultOfDeletion);

    }


}
