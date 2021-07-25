package mls.property.structure;
import mls.Size;

/**
 * Represents a room
 * Mutable class
 */
public class Room {
    private RoomType type;
    private Size size;

    /**
     * enum type
     */
    public enum RoomType {
        Living, Dining, Bed, Bath, Laundry, Recreational
    }

    /**
     * A constructor performing Deep Copy
     * No need to make new object for Size b/c it is immutable
     * @param type
     * @param size
     */
    public Room(RoomType type, Size size) {
        this.type = type;
        this.size = size;
    }

    /**
     * Copy constructor
     */
    public Room(Room room) {
        this(room.getType(),
                room.getSize());
    }

    public RoomType getType() {
        return type;
    }

    public Size getSize() {
        return size;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object other){
        if(other == null || other.getClass() != Room.class){
            return false;
        }
        return (this.getType() == ((Room) other).getType() &&
                this.getSize().equals(((Room) other).getSize()));
    }


}
