package mls.property.structure.neighbourhoodfeatures;

/**
 * Interface for all neighbourhood features
 * Link refers to a Google page result for the neighbourhood feature
 */
public interface NeighbourhoodFeatures {
    public void setLink(String link);
    public String getLink();
    public NeighbourhoodFeatures makeCopy();

}
