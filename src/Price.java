public abstract class Price {
    abstract int getPriceCode();
}
class ChildrensPrice extends Price{

    @Override
    int getPriceCode() {
        return Movie.CHILDRENS;
    }
}

class NewReleasePrice extends Price{

    @Override
    int getPriceCode() {
        return Movie.NEW_REALEASE;
    }
}

class RegularPrice extends Price{


    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }
}