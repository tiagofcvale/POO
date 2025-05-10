package aula09.Exercicio2;

import java.util.ArrayList;
import java.util.List;

public class PlaneManager {
    private List<Plane> planes;

    public PlaneManager() {
        this.planes = new ArrayList<>();
    }

    public void addPlane(Plane plane) {
        planes.add(plane);
    }

    public boolean removePlane(String id) {
        return planes.removeIf(plane -> plane.getNome().equals(id));
    }

    public Plane searchPlane(String id) {
        for (Plane plane : planes) {
            if (plane.getNome().equals(id)) {
                return plane;
            }
        }
        return null;
    }

    public List<Plane> getCommercialPlanes() {
        List<Plane> commercialPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof CommercialPlane) {
                commercialPlanes.add(plane);
            }
        }
        return commercialPlanes;
    }

    public List<Plane> getMilitaryPlanes() {
        List<Plane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add(plane);
            }
        }
        return militaryPlanes;
    }

    public void printAllPlanes() {
        for (Plane plane : planes) {
            System.out.println(plane);
        }
    }

    public Plane getFastestPlane() {
        if (planes.isEmpty()) {
            return null;
        }
        Plane fastest = planes.get(0);
        for (Plane plane : planes) {
            if (plane.getVelocidadeMax() > fastest.getVelocidadeMax()) {
                fastest = plane;
            }
        }
        return fastest;
    }
}