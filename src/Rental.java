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
        return movie.getFrequentRenterPoints(get_daysRented());
    }
}
