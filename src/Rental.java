public class Rental {

    private Movie movie;
    private int _daysRented;

    public Movie getMovie() {
        return movie;
    }

    public int get_daysRented() {
        return _daysRented;
    }

    public Rental(Movie movie, int _daysRented) {

        this.movie = movie;
        this._daysRented = _daysRented;
    }

     double getCharge() {
        double result=0;
        switch(getMovie().get_priceCode()){
            case Movie.REGULAR:
                result+=2;
                if(get_daysRented() > 2)
                    result+= (get_daysRented() - 2) * 1.5;
                break;
            case Movie.NEW_REALEASE:
                result+=get_daysRented()*3;
                break;
            case Movie.CHILDRENS:
                result+=1.5;
                if(get_daysRented()>3)
                    result+=((get_daysRented()-3)*1.5);
                break;
        }
        return result;
    }

    int getFrequentRenterPoints(){
        int frequentRenterPoints = 0;

        frequentRenterPoints++;

        if((getMovie().get_priceCode()==Movie.NEW_REALEASE)
                && get_daysRented()>1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}
