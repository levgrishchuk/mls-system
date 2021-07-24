package mls.property.structure.neighbourhoodfeatures;
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


    public boolean equalss(NeighbourhoodFeaturesContainer other){
//        // compare addresses
//        if(this == other){
//            return true;
//        }
//
//        // temp copy
//        List<NeighbourhoodFeatures> temp = new ArrayList<NeighbourhoodFeatures>(this.neighbourhoodFeaturesList);
//        for(NeighbourhoodFeatures feature: other.getNeighbourhood()){
//            // if no match, return not equal
//            if(!(temp.remove(feature))){
//                return false;
//            }
//        }
//        // true if complete match
//        return temp.isEmpty();

        List<NeighbourhoodFeatures> thisList = this.getNeighbourhood();
        List<NeighbourhoodFeatures> otherList = other.getNeighbourhood();


//        // if containers have the same addresses
//        if(this.neighbourhoodFeaturesList == other){
//            return true;
//        }
//        // if lists have different lengths
//        if(thisSorted.size() != otherSorted.size()){
//            return false;
//        }

        // result accumulated in flag, check if each individual object has different attributes
        boolean totalflag = true;
        for(int i = 0; i < thisList.size(); i++){
            boolean rowflag = false;
            for(int j = i; j < otherList.size(); j++){
                rowflag = rowflag || thisList.equals(otherList);
            }
            totalflag = totalflag && rowflag;
        }
        return totalflag;
    }
}
