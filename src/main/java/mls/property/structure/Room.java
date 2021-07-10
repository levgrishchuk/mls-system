package mls.property.structure;

import mls.Size;

public class Room {
    private RoomType type;
    private Size size;


    // enum type
    enum RoomType {
        Living, Dining, Bed, Bath, Laundry, Recreational
    }
}
