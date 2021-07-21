package mls.property.structure.neighbourhoodfeatures;
import mls.property.structure.Room;
import java.util.ArrayList;
import java.util.List;

/**
 * Stores list of neighbourhood features
 */
public class NeighbourhoodFeaturesContainer {
    private List<NeighbourhoodFeatures> neighbourhoodFeaturesList;

    public NeighbourhoodFeaturesContainer(Builder builder){
        this.neighbourhoodFeaturesList = builder.neighbourhoodFeaturesList;
    }

    /**
     * builder class
     * @param <T>
     */
    public static class Builder<T extends Builder<T>>{
        private List<NeighbourhoodFeatures> neighbourhoodFeaturesList;

        /**
         * loops through list and adds copy of each feature
         * @param list
         */
        public void setNeighbourhoodFeaturesList(List<NeighbourhoodFeatures> list){
            // list deep copy
            this.neighbourhoodFeaturesList = new ArrayList();
            for(int i = 0 ; i < list.size(); i++){
                this.neighbourhoodFeaturesList.add(list.get(i).makeCopy());
            }
        }

        public void addNeighbourhoodFeature(NeighbourhoodFeatures feature){
            this.neighbourhoodFeaturesList.add(feature.makeCopy());
        }
    }

}
