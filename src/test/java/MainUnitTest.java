import com.google.gson.Gson;
import com.google.gson.JsonParser;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import mls.*;
import app.*;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

public class MainUnitTest {
    @Test
    public void TestAddListing() throws IOException {
        Listing sampleListing = TestHelper.getSample();

        // Add the sample listing manually
        Main m = new Main();
        String response = m.addListing(
                120000f,
                "{\"typeName\":\"mls.property.Farmhouse\",\"data\":{\"barn\":false,\"courtyard\":false,\"address\":{\"streetNumber\":3495,\"streetName\":\"Lawrence Ave.\",\"city\":\"Toronto\",\"province\":\"Ontario\",\"postalCode\":\"M1H 1B3\"},\"annualTax\":1200,\"isUnderConstruction\":true,\"landSize\":{\"length\":10,\"width\":10,\"unit\":\"meter\"},\"exteriors\":[],\"building\":{\"category\":\"MultiGenerational\",\"unitCount\":1,\"storyCount\":1,\"rooms\":[{\"type\":\"Bed\",\"size\":{\"length\":10,\"width\":10,\"unit\":\"meter\"}}],\"exteriorDesign\":\"Brick\",\"hasBasement\":false,\"appliances\":[\"Waching machine\"]},\"neighbourhood\":{\"neighbourhoodFeaturesList\":[{\"typeName\":\"mls.property.structure.neighbourhoodfeatures.Hospital\",\"data\":{\"link\":\"1\",\"phoneNumber\":\"1\"}}]},\"leaseInformation\":{\"landlord\":\"Strata\",\"monthlyFee\":550}}}",
                "Nice farmhouse.",
                "{\"name\":\"John\",\"address\":{\"streetNumber\":3495,\"streetName\":\"Lawrence Ave.\",\"city\":\"Toronto\",\"province\":\"Ontario\",\"postalCode\":\"M1H 1B3\"},\"email\":\"john@gmail.com\",\"phone\":\"123-456-7890\"}",
                "{\"brokerage\":{\"corporateName\":\"MyBrokerage\",\"address\":{\"streetNumber\":3495,\"streetName\":\"Lawrence Ave.\",\"city\":\"Toronto\",\"province\":\"Ontario\",\"postalCode\":\"M1H 1B3\"}},\"name\":\"Mary\",\"address\":{\"streetNumber\":3495,\"streetName\":\"Lawrence Ave.\",\"city\":\"Toronto\",\"province\":\"Ontario\",\"postalCode\":\"M1H 1B3\"},\"email\":\"mary@gmail.com\",\"phone\":\"987-654-3210\"}\n"
        );

        // Gets the uuid of the listing that is just created.
        UUID mlsNumber = UUID.fromString(
                new JsonParser().parse(response).getAsJsonObject().get("mlsNumber").getAsString()
        );

        Listing readListing = DBController.getInstance().read(mlsNumber);
        assertEquals(sampleListing.getListingPrice(), readListing.getListingPrice(), 0.00001);
        assertEquals(sampleListing.getProperty(), readListing.getProperty());
        assertEquals(sampleListing.getDescription(), readListing.getDescription());
        assertEquals(sampleListing.getPropertyOwner(), readListing.getPropertyOwner());
        assertEquals(sampleListing.getBroker(), readListing.getBroker());
    }

    @Test
    public void TestSold() throws IOException {
        Listing sampleListing = TestHelper.getSample();

        // Add the sample listing manually; the provided string information must match with the sampleListing.
        Main m = new Main();
        String response = m.addListing(
                120000f,
                "{\"typeName\":\"mls.property.Farmhouse\",\"data\":{\"barn\":false,\"courtyard\":false,\"address\":{\"streetNumber\":3495,\"streetName\":\"Lawrence Ave.\",\"city\":\"Toronto\",\"province\":\"Ontario\",\"postalCode\":\"M1H 1B3\"},\"annualTax\":1200,\"isUnderConstruction\":true,\"landSize\":{\"length\":10,\"width\":10,\"unit\":\"meter\"},\"exteriors\":[],\"building\":{\"category\":\"MultiGenerational\",\"unitCount\":1,\"storyCount\":1,\"rooms\":[{\"type\":\"Bed\",\"size\":{\"length\":10,\"width\":10,\"unit\":\"meter\"}}],\"exteriorDesign\":\"Brick\",\"hasBasement\":false,\"appliances\":[\"Waching machine\"]},\"neighbourhood\":{\"neighbourhoodFeaturesList\":[{\"typeName\":\"mls.property.structure.neighbourhoodfeatures.Hospital\",\"data\":{\"link\":\"1\",\"phoneNumber\":\"1\"}}]},\"leaseInformation\":{\"landlord\":\"Strata\",\"monthlyFee\":550}}}",
                "Nice farmhouse.",
                "{\"name\":\"John\",\"address\":{\"streetNumber\":3495,\"streetName\":\"Lawrence Ave.\",\"city\":\"Toronto\",\"province\":\"Ontario\",\"postalCode\":\"M1H 1B3\"},\"email\":\"john@gmail.com\",\"phone\":\"123-456-7890\"}",
                "{\"brokerage\":{\"corporateName\":\"MyBrokerage\",\"address\":{\"streetNumber\":3495,\"streetName\":\"Lawrence Ave.\",\"city\":\"Toronto\",\"province\":\"Ontario\",\"postalCode\":\"M1H 1B3\"}},\"name\":\"Mary\",\"address\":{\"streetNumber\":3495,\"streetName\":\"Lawrence Ave.\",\"city\":\"Toronto\",\"province\":\"Ontario\",\"postalCode\":\"M1H 1B3\"},\"email\":\"mary@gmail.com\",\"phone\":\"987-654-3210\"}\n"
        );

        // Gets the uuid of the listing that is just created.
        UUID mlsNumber = UUID.fromString(
                new JsonParser().parse(response).getAsJsonObject().get("mlsNumber").getAsString()
        );

        Listing readListing = DBController.getInstance().read(mlsNumber);
        assertEquals(null, readListing.getBuyer());
        assertEquals(null, readListing.getDateSold());
        assertEquals(Listing.Status.Active, readListing.getStatus());

        String buyerJson = "{\"name\":\"Michael\",\"address\":{\"streetNumber\":3495,\"streetName\":\"Lawrence Ave.\",\"city\":\"Toronto\",\"province\":\"Ontario\",\"postalCode\":\"M1H 1B3\"},\"email\":\"mike@gmail.com\",\"phone\":\"abc-456-7890\"}";
        Participant buyer = DBController.getInstance().getGson().fromJson(buyerJson, Participant.class);
        m.setSold(
                mlsNumber.toString(),
                buyerJson
        );

        // Read after setting sold.
        readListing = DBController.getInstance().read(mlsNumber);
        assertEquals(buyer, readListing.getBuyer());
        assertEquals(true, readListing.getDateSold() instanceof Date);
        assertEquals(Listing.Status.Sold, readListing.getStatus());
    }

    @Test
    public void TestUpdatePrice() throws IOException {
        Listing l = Listing.builder().setListingPrice(20f).build();
        DBController.getInstance().update(l);

        Listing l1 = DBController.getInstance().read(l.getMlsNumber());
        assertEquals(20f, l1.getListingPrice(), 0.00001);

        l.setListingPrice(40f);
        DBController.getInstance().update(l);
        l1 = DBController.getInstance().read(l.getMlsNumber());
        assertEquals(40f, l1.getListingPrice(), 0.00001);
    }
}
