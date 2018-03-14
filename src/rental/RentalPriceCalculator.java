package rental;

public class RentalPriceCalculator {

    // age - age of driver
    // yearsLicenceHeld - number of full years person holds driving licence
    // carClass - class of the car from 1 (smallest) to 5 (largest) that person wishes to rent
    // isAccidentCaused - has s/he caused any accidents within last year
    // isAaccidentInvolved - has s/he participated (but not caused) in any accidents within last year
    // isSeasonHigh - if it is high season or not
    private static final int MIN_AGE = 18;
    private static final int MIDDLE_AGE = 21;

    public double CalculateRentalPrice(int age, int yearsLicenceHeld, int carClass, boolean isAccidentCaused, boolean isSeasonHigh) {

        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Driver too young - cannot quote the price");
        }
        if (age <= MIDDLE_AGE && carClass > 2) {
            throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
        }

        double rentalPrice = age;

        if (carClass >= 4 && age <= 25 && isSeasonHigh != false) {
            rentalPrice = rentalPrice * 2;
        }

        if (yearsLicenceHeld < 1) {
            throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
        }

        if (yearsLicenceHeld < 3) {
            rentalPrice = rentalPrice * 1.3;
        }

        if (isAccidentCaused == true && age < 30) {
            rentalPrice += 15;
        }

        if (rentalPrice > 1000) {
            return 1000.00;
        }
        return rentalPrice;
    }
}
