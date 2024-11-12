/**
 * Class: Software Implementation
 * Instructor: Maria Boyle
 * Description: Class Room - Developed for the Hotel System
 * Date: 15/10/2024
 * @author Dale Nesbitt
 * @version 1.0
 */

package ie.atu.hotel;
import java.text.DecimalFormat;

public class Room implements Reservable {
    private int roomNumber;
    private String roomType;
    private double pricePerNight;
    private boolean allocated;

    public Room(int roomNumber, String roomType, double pricePerNight, boolean allocated) {
        // Check pricePerNight
        if (pricePerNight < 100.00) {
            throw new IllegalArgumentException("Price per night can't be less than €100.00.");
        }
        
        // Check roomType
        if (!roomType.equalsIgnoreCase("Double") && 
            !roomType.equalsIgnoreCase("King") && 
            !roomType.equalsIgnoreCase("Family")) {
            throw new IllegalArgumentException("Invalid room type. Must be Double, King, or Family.");
        }

        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.allocated = allocated;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.00");
        return roomNumber + " " + roomType + " ROOM @ €" + df.format(pricePerNight) + " per night " + (allocated ? "BOOKED" : "FREE");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Room) {
            Room rObject = (Room) obj;
            return this.roomNumber == rObject.roomNumber;
        }
        return false;
    }

    // Implement Reservable interface
    @Override
    public void reserve() {
        if (!allocated) {
            allocated = true;
            System.out.println("Room " + roomNumber + " is reserved.");
        } else {
            System.out.println("Room " + roomNumber + " is already booked.");
        }
    }

    @Override
    public void cancel() {
        if (allocated) {
            allocated = false;
            System.out.println("Room " + roomNumber + " is available.");
        } else {
            System.out.println("Room " + roomNumber + " is not reserved.");
        }
    }

    // Getters and Setters
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setPricePerNight(double pricePerNight) {
        if (pricePerNight < 100.00) {
            throw new IllegalArgumentException("Price per night cannot be less than €100.00.");
        }
        this.pricePerNight = pricePerNight;
    }

    public void setAllocated(boolean allocated) {
        this.allocated = allocated;
    }

    public int getNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public boolean getAllocated() {
        return allocated;
    }
}
