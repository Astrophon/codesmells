package codesmells;

import java.util.*;

class Customer {
    private String name;
    private Vector<Rental> rentals = new Vector<Rental>();
    private static double RentedDaysMultiplier = 1.5;
    
    public Customer (String newname){
        name = newname;
    };
    
    public void addRental(Rental arg) {
        rentals.addElement(arg);
    };
    
    public String getName (){
        return name;
    };
    
    public String get_all_infos() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> enum_rentals = rentals.elements();
        
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) enum_rentals.nextElement();
            //determine amounts for each line
            thisAmount = calculate_costs(each);
            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            assert(((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) || (each.getMovie().getPriceCode() == Movie.REGULAR) || ( each.getMovie().getPriceCode() == Movie.CHILDRENS)) && each.getDaysRented() > 0 );
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) 
                frequentRenterPoints ++;
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" + "\t" + each.getDaysRented() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        //add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }

    private double calculate_costs(Rental each) {
        double thisAmount = 0;
        switch (each.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                assert(each.getDaysRented() > 0);
                if (each.getDaysRented() > 2)
                    thisAmount += (each.getDaysRented() - 2) * RentedDaysMultiplier;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += each.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                assert(each.getDaysRented() > 0);
                if (each.getDaysRented() > 3)
                    thisAmount += (each.getDaysRented() - 3) * RentedDaysMultiplier;
                break;
            default: break;
        }
        return thisAmount;
    }

}
    