// Interface for Strategy
interface OfferStrategy {
    String getName();
    double getDiscountPercentage();
}

// Concrete implementation of base Strategy
class NoDiscountStrategy implements OfferStrategy {
    @Override
    public String getName() {
        return "NoDiscountStrategy";
    }

    @Override
    public double getDiscountPercentage() {
        return 0;
    }
}

// Concrete implementation of base Strategy
class QuarterDiscountStrategy implements OfferStrategy {
    @Override
    public String getName() {
        return "QuarterDiscountStrategy";
    }

    @Override
    public double getDiscountPercentage() {
        return 0.25;
    }
}
