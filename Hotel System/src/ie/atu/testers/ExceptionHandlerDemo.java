package ie.atu.testers;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import ie.atu.hotel.CreditCard;
import ie.atu.hotel.Date;
import ie.atu.hotel.Guest;
import ie.atu.hotel.Name;

public class ExceptionHandlerDemo {

    public static void main(String[] args) {
        ArrayList<Guest> hotelGuests = new ArrayList<Guest>();

        // Create Guest objects and add them to the list
        Name name = new Name("Mr", "Homer", "Simpson");
        CreditCard card = new CreditCard(1111222233334444L, new Date(31, 12, 2027), 111);
        Guest guest = new Guest(name, "087 1234567", "homer.simpson@atu.ie", card);
        hotelGuests.add(guest);

        name = new Name("Mrs", "Marge", "Simpson");
        card = new CreditCard(5555666677778888L, new Date(31, 12, 2026), 222);
        guest = new Guest(name, "086 1234567", "marge.simpson@atu.ie", card);
        hotelGuests.add(guest);

        name = new Name("Miss", "Lisa", "Simpson");
        card = new CreditCard(9999888877776666L, new Date(31, 3, 2025), 333);
        guest = new Guest(name, "087 9876543", "lisa.simpson@atu.ie", card);
        hotelGuests.add(guest);
        
        boolean goodInput = false;
        while (!goodInput) {
            String guestNumberToViewAsString = "";
            try {
                guestNumberToViewAsString = JOptionPane.showInputDialog(null,
                        "Enter Guest to View (" + 1 + " to " + hotelGuests.size() + ")");
                
                if (guestNumberToViewAsString == null) {
                    // Handle cancel action
                    JOptionPane.showMessageDialog(null, "Input was canceled.");
                    return; // Exit the program
                }

                int guestToView = Integer.parseInt(guestNumberToViewAsString);
                System.out.println(hotelGuests.get(guestToView - 1));
                goodInput = true; // Valid input received
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        guestNumberToViewAsString + " is not valid. Please enter a number and re-submit.");
            } catch (IndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null,
                        "You must choose a guest from (" + 1 + " to " + hotelGuests.size() + "). Please re-enter.");
            }
        }
    }
}
