public abstract class Price {
    abstract int getPriceCode();

    abstract double getCharge(int daysRented);

    int getFrequentRenterPoints(int daysRented){
        return 1;
    }
}
class ChildrensPrice extends Price{

    @Override
    public double getCharge(int daysRented) {
        double result = 1.5;
        if(daysRented>3)
            result+=((daysRented-3)*1.5);
        return result;
    }

    @Override
    int getPriceCode() {
        return Movie.CHILDRENS;
    }
}

class NewReleasePrice extends Price{

    @Override
    int getFrequentRenterPoints(int daysRented) {
        return getPriceCode() == Movie.NEW_REALEASE &&
                daysRented > 1 ? 2 : 1;
    }

    @Override
    public double getCharge(int daysRented) {
        return daysRented*3;
    }

    @Override
    int getPriceCode() {
        return Movie.NEW_REALEASE;
    }
}

class RegularPrice extends Price{

    @Override
    public double getCharge(int daysRented) {
        double result = 2;
        if(daysRented > 2)
            result+= (daysRented - 2) * 1.5;
        return result;
    }

    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }
}
