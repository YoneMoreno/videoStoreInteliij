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

        Enumeration rentals = _rentals.elements();
        String result="Rental Record for " + get_name();

        while(rentals.hasMoreElements()){
            //System.out.println("There are rentals");

            Rental each = (Rental) rentals.nextElement();





            result += "\t" + each.getMovie().get_title() + "\t" +
                    String.valueOf(each.getCharge()) + "\n";
        }

        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) +
                " frequent renter points";

        return result;
    }

    public String htmlStatement(){
        Enumeration rentals = _rentals.elements();
        String result = "<H1>Rentals for<EM>" +get_name()+ "</EM></H1><P>\n";
        while(rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();

            result += each.getMovie().get_title() + ": " +
                    String.valueOf(each.getCharge()) + "<BR>\n";
        }

        result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) +
                "</EM><P>\n";
        result += "On this rental you earned <EM>" +
                String.valueOf(getTotalFrequentRenterPoints()) +
                "</EM> frequent renter points<P>";
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int frequentRenterPoints=0;
        Enumeration rentals = _rentals.elements();

        while(rentals.hasMoreElements()){
            Rental each = (Rental)rentals.nextElement();
            frequentRenterPoints+=each.getFrequentRenterPoints();
        }
        return frequentRenterPoints;

    }

    private double getTotalCharge() {
        double totalCharge = 0;
        Enumeration rentals = _rentals.elements();

        while(rentals.hasMoreElements()){
            Rental each = (Rental)rentals.nextElement();
            totalCharge+=each.getCharge();
        }
        return totalCharge;
    }

    private double amountFor(Rental aRental){
        return aRental.getCharge();
    }



    public static void main(String[] args) {
        Movie movie = new Movie("ET",1);
        Movie up = new Movie("UP!",2);
        Customer customer = new Customer("Pepe");
        Rental rental = new Rental(movie, 7);
        Rental rentUp = new Rental(up, 9);
        customer.addRental(rental); customer.addRental(rentUp);;
        System.out.println(customer.statement());
        //System.out.println(customer.htmlStatement());
    }
}
