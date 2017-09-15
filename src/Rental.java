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
        return movie.getCharge(get_daysRented());
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
