/**
 * Class: Software Implementation
 * Instructor: Maria Boyle
 * Description: Class Room - Developed for the Hotel System
 * Date: 15/10/2024
 * @author Dale Nesbitt
 * @version 1.0
 */

package ie.atu.testers;
import java.util.ArrayList;
import ie.atu.hotel.Room;

public class RoomTester {
    public static void main(String[] args) {
    	
        //Create an ArrayList of Rooms
        ArrayList<Room> rooms = new ArrayList<>();

        try {

            // Add 5 Doubles
        	for (int i = 1; i <= 5; i++) {
                rooms.add(new Room(i, "Double", 160.00, false));
            }
        	
        	// Add 5 Kings
            for (int i = 6; i <= 10; i++) {
                rooms.add(new Room(i, "King", 185.00, false));
            }
            
            // Add 3 Families
            for (int i = 11; i <= 13; i++) {
                rooms.add(new Room(i, "Family", 210.00, false));
            }
        } catch (IllegalArgumentException error) {
            System.err.println("Error adding rooms: " + error.getMessage());
            return;
        }

        // Display all rooms
        System.out.println("ROOMS IN HOTEL:");
        for (Room room : rooms) {
            System.out.println(room);
        }

        // Display family rooms and count how many there are
        System.out.println("\nFAMILY ROOM LIST:");
        int count = 0;
        for (Room room : rooms) {
            if (room.getRoomType().equalsIgnoreCase("Family")) {
                System.out.println(room);
                count++;
            }
        }
        System.out.println(count + " FAMILY ROOM(S)\n");

        for (Room room : rooms) {
            if (room.getRoomType().equalsIgnoreCase("Family") && !room.getAllocated()) {
                room.reserve();
                break;
            }
        }

        // Display family rooms from arraylist again
        System.out.println("\nUPDATED FAMILY ROOM LIST: ");
        for (Room room : rooms) {
            if (room.getRoomType().equalsIgnoreCase("Family")) {
                System.out.println(room);
            }
        }

        // Create a Object/Person ArrayList for objects like Employee and Guest
        ArrayList<Object> peopleInHotel = new ArrayList<>();

    }
}
