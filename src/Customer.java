import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String _name) {
        this._name = _name;
    }

    public void addRental(Rental arg){
        _rentals.addElement(arg);
        //System.out.println("Added");
    }

    public String get_name() {
        return _name;
    }

    public String statement(){
        double totalAmount=0;
        int frequentRenterPoints=0;
        Enumeration rentals = _rentals.elements();
        String result="Rental Record for " + get_name();

        while(rentals.hasMoreElements()){
            //System.out.println("There are rentals");
            double thisAmount=0;
            Rental each = (Rental) rentals.nextElement();

            switch(each.getMovie().get_priceCode()){
                case Movie.REGULAR:
                    thisAmount+=2;
                    if(each.get_daysRented() > 2)
                        thisAmount+= (each.get_daysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_REALEASE:
                    thisAmount+=each.get_daysRented()*3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount+=1.5;
                    if(each.get_daysRented()>3)
                        thisAmount+=((each.get_daysRented()-3)*1.5);
                    break;
            }

            frequentRenterPoints++;

            if((each.getMovie().get_priceCode()==Movie.NEW_REALEASE)
                && each.get_daysRented()>1)
                frequentRenterPoints++;

            result += "\t" + each.getMovie().get_title() + "\t" +
                    String.valueOf(thisAmount) + "\n";
            totalAmount+=thisAmount;

        }

        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) +
                " frequent renter points";

        return result;
    }

    public static void main(String[] args) {
        Movie movie = new Movie("ET",1);
        Customer customer = new Customer("Pepe");
        Rental rental = new Rental(movie, 7);
        customer.addRental(rental);
        System.out.println(customer.statement());
    }
}
