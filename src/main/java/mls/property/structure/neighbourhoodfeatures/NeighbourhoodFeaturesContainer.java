package mls.property.structure.neighbourhoodfeatures;
import mls.property.DetachedHome;
import mls.property.structure.Room;

import java.util.*;

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


    /**
     * Compares every element in the lists of two NeighbourhoodFeaturesContainers. Order does not matter.
     * @param other
     * @return boolean
     */
    @Override
    public boolean equals(Object other){
        // check that other is the correct type
        if (other == null || !other.getClass().equals(this.getClass()))
            return false;

        // cast
        NeighbourhoodFeaturesContainer p = (NeighbourhoodFeaturesContainer) other;

        // shorthand
        List<NeighbourhoodFeatures> thisList = this.getNeighbourhood();
        List<NeighbourhoodFeatures> otherList = p.getNeighbourhood();

        // if containers have the same addresses
        if(this == p){
            return true;
        }

        // if lists inside containers have the same addresses
        if(thisList == otherList){
            return true;
        }

        // if lists have different lengths
        if(thisList.size() != otherList.size()){
            return false;
        }
        // iteratively check if all the objects have the same attributes
        // each row must have at least one match, result accumulated in totalFlag
        // time complexity is O(n^2), pretty bad. Need ability to sort neighbourhood features to improve speed.
        boolean totalFlag = true;
        for(int i = 0; i < thisList.size(); i++){
            boolean rowFlag = false;
            for(int j = 0; j < otherList.size(); j++){
                rowFlag = rowFlag || thisList.get(i).equals(otherList.get(j));
            }
            totalFlag = totalFlag && rowFlag;
        }
        return totalFlag;
    }

//    /**
//     * Returns true if obj is identical to this instance.
//     */
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null || !obj.getClass().equals(this.getClass()))
//            return false;
//
//        NeighbourhoodFeaturesContainer p = (NeighbourhoodFeaturesContainer) obj;
//        return this.neighbourhoodFeaturesList.equals(p.neighbourhoodFeaturesList);
//    }
}
