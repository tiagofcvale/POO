// Nome: Tiago Francisco Crespo do Vale
// NMec: 125913

public class StandardConcertProfitCalculator implements IConcertProfitCalculator{

    @Override
    public double calculateConcertProfit(Concert c) {
        double total = 1500*(c.getDuracao()/60); // /60 porque é por hora
        String local = c.getLocal();
        String[] partes = local.trim().split(", ");
        String pais = partes[1];
        if(!pais.equals("Portugal")){
            total*=2;
        }
        if(!pais.equals("Portugal") || !pais.equals("Espanha")) {
            total+=800;
        }
        return total;
    }
    
}
