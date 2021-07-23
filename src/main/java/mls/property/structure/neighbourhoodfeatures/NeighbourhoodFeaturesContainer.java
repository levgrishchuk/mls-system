package mls.property.structure.neighbourhoodfeatures;
import mls.property.structure.Room;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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

    public List<NeighbourhoodFeatures> getNeighbourhood(){
        return this.neighbourhoodFeaturesList;
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

    public boolean equals(NeighbourhoodFeaturesContainer other){
        // compare addresses
        if(this == other){
            return true;
        }

        // temp copy
        List<NeighbourhoodFeatures> temp = new ArrayList<NeighbourhoodFeatures>(this.neighbourhoodFeaturesList);
        for(NeighbourhoodFeatures feature: other.getNeighbourhood()){
            // if no match, return not equal
            if(!(temp.remove(feature))){
                return false;
            }
        }
        // true if complete match
        return temp.isEmpty();
    }
}
