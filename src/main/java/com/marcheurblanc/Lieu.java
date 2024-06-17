package com.marcheurblanc;

import java.util.List;
import java.util.Objects;

public class Lieu {
    private String nomDuLieu;
    private  List<Rue> ruesAdjacentes;

    public Lieu(String nomDuLieu, List<Rue> ruesAdjacentes) {
        this.nomDuLieu = nomDuLieu;
        this.ruesAdjacentes = ruesAdjacentes;
    }

    public List<Rue> getRuesAdjacentes() {
        return ruesAdjacentes;
    }

    public String getNomDuLieu() {
        return nomDuLieu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lieu lieu)) return false;
        return Objects.equals(getNomDuLieu(), lieu.getNomDuLieu()) && Objects.equals(getRuesAdjacentes(), lieu.getRuesAdjacentes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNomDuLieu(), getRuesAdjacentes());
    }
}
