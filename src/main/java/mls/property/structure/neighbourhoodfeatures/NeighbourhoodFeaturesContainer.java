package mls.property.structure.neighbourhoodfeatures;
import mls.property.structure.Room;
import java.util.ArrayList;
import java.util.List;

/**
 * Stores list of neighbourhood features
 */
public class NeighbourhoodFeaturesContainer {
    private List<NeighbourhoodFeatures> neighbourhoodFeaturesList = new ArrayList();

    public NeighbourhoodFeaturesContainer(){
        this.neighbourhoodFeaturesList = new ArrayList<>();
    }

    public NeighbourhoodFeaturesContainer(List<NeighbourhoodFeatures> list){
        // list deep copy
        this.neighbourhoodFeaturesList = new ArrayList<>();
        for(int i = 0 ; i < list.size(); i++){
            this.neighbourhoodFeaturesList.add(list.get(i).makeCopy());
        }
    }

    public void add(NeighbourhoodFeatures feature){
        // deep copy
        this.neighbourhoodFeaturesList.add(feature.makeCopy());
    }

    /**
     * loops through list and adds copy of each feature
     */
    public void setNeighbourhood(NeighbourhoodFeaturesContainer container){
        List<NeighbourhoodFeatures> list = container.neighbourhoodFeaturesList;
        // list deep copy
        this.neighbourhoodFeaturesList = new ArrayList();
        for(int i = 0 ; i < list.size(); i++){
            this.neighbourhoodFeaturesList.add(list.get(i).makeCopy());
        }
    }
}
