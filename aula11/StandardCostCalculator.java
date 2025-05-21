package aula11;

public class StandardCostCalculator implements IContactCostCalculator{
    public StandardCostCalculator() {
    }

    @Override
    public double calculateCost(double units, ContactType type) {
        if (type == ContactType.EMAIL) {
            return 0.0;
        } else if (type == ContactType.CELLNUMBER) {
            return units * 0.10;
        }
        return -1;
    }

}
