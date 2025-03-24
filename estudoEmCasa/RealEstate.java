package estudoEmCasa;

import java.util.ArrayList;
import aula05.DateYMD;

public class RealEstate {
    private static int idCounter = 1000;
    private ArrayList<Property> properties;

    public RealEstate() {
        properties = new ArrayList<>();
    }

    public void newProperty(String localidade, int roomsNum, int preço) {
        properties.add(new Property(idCounter++, localidade, roomsNum, preço));
    }

    public void sell(int id) {
        for (Property prop : properties) {
            if (prop.getId() == id) {
                if (prop.isAvailable()) {
                    prop.sell();
                    System.out.println("Imóvel " + id + " vendido.");
                } else {
                    System.out.println("Imóvel " + id + " não está disponível.");
                }
                return;
            }
        }
        System.out.println("Imóvel " + id + " não existe.");
    }

    public void setAuction(int id, DateYMD date, int duration) {
        for (Property prop : properties) {
            if (prop.getId() == id) {
                if (prop.isAvailable()) {
                    prop.setAuction(date, duration);
                } else {
                    System.out.println("Imóvel " + id + " não está disponível.");
                }
                return;
            }
        }
        System.out.println("Imóvel " + id + " não existe.");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Propriedades:\n");
        for (Property prop : properties) {
            sb.append(prop).append("\n");
        }
        return sb.toString();
    }

    public class Property {
        private int id;
        private String localidade;
        private int roomsNum;
        private int preço;
        private boolean available;
        private String auctionInfo;

        public Property(int id, String localidade, int roomsNum, int preço) {
            this.id = id;
            this.localidade = localidade;
            this.roomsNum = roomsNum;
            this.preço = preço;
            this.available = true;
            this.auctionInfo = "";
        }

        public int getId() {
            return id;
        }

        public boolean isAvailable() {
            return available;
        }

        public void sell() {
            this.available = false;
        }

        public void setAuction(DateYMD date, int duration) {
            auctionInfo = "; leilão " + date + " : " + date;
        }

        @Override
        public String toString() {
            return "Imóvel: " + id + "; quartos: " + roomsNum + "; localidade: " + localidade + "; preço: " + preço + "; disponível: " + (available ? "sim" : "não") + auctionInfo;
        }
    }
}
