package aula05;

import java.util.ArrayList;

public class RealEstate {
    private int id = 1000;
    public class Property {
        private int id;
        private String nome;
        private int roomsNum;
        private int price;
        private boolean available;
        private String auction;
        
        public Property(int id, String nome, int roomsNum, int price) {
            this.id = id;
            this.nome = nome;
            this.roomsNum = roomsNum;
            this.price = price;
            this.available = true;
            this.auction = "";
        }
        public String nome() {
            return nome;
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
            DateYMD lastDay = new DateYMD(date.getDay(), date.getMonth(), date.getYear()); 
        
            for (int i = 0; i <= duration; i++) { 
                lastDay.incrementDate(lastDay);
            }
            auction = "; leilão " + date + " : " + lastDay; // Store auction details
        }
        

        @Override
        public String toString() {
            return "Imóvel: " + id + "; quartos: " + roomsNum + "; localidade: " + nome + "; preço: " + price + "; disponível: " + (available ? "sim" : "não") + auction;
        }
    }
    private ArrayList<Property> properties;
    public RealEstate() {
        properties = new ArrayList<>();
    }
    public void newProperty(String nome,int roomsNum, int price) {
        properties.add(new Property(id++, nome, roomsNum, price));
    }
    public void sell(int id) {
        for (Property prop : properties) {
            if (prop.getId() == id) {
                if (prop.isAvailable()) {
                    prop.sell();
                    System.out.println("Imóvel " + id + " vendido.");
                } else {
                    System.out.println("Imóvel " + id + "não está disponível");
                }
            } else {
                System.out.println("Imóvel "+id+" não existe");
            }
        }
    }
    public void setAuction(int id, DateYMD date, int duration) {
        for (Property prop : properties) {
            if (prop.getId() == id) {
                if (prop.isAvailable()) {
                    System.out.println("Leilão criado para imóvel id " +id+ " para "+ date + "com duração de "+duration+ " dias");
                    prop.setAuction(date, duration);
                } else {
                    System.out.println("Imóvel "+id+" não disponível");
                }
            } else {
                System.out.println("Imóvel "+id+" não existe");
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Propriedades:\n");
        for (Property prop : properties) {
            sb.append(prop).append("\n");
        }
        return sb.toString();
    }
}

