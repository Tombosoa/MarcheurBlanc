package com.marcheurblanc;

import java.util.List;

public record Carte(List<Lieu> lieux) {
    public Carte(List<Lieu> lieux) {
        this.lieux = lieux;
    }
}
