package com.marcheurblanc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public record Rue(
                  String nom      ) {
    public Rue(String nom) {
        if (nom.isEmpty()){
            this.nom = String.valueOf(Math.random());
        }else{
            this.nom = nom;
        }
    }

    public Lieu obtenirAutreExtremite(Lieu extremiteActuelle, Carte carte) {
        Random random = new Random();
        List<Lieu> possibilité = new ArrayList<>();
        for (Lieu lieu : carte.lieux()) {
            List<Rue> ruesAdjacentes = new ArrayList<>(lieu.getRuesAdjacentes());
            ruesAdjacentes.retainAll(extremiteActuelle.getRuesAdjacentes());
            if (!ruesAdjacentes.isEmpty()) {
                possibilité.add(lieu);
            }
        }
        if (!possibilité.isEmpty()) {
            int index = random.nextInt(possibilité.size());
            return possibilité.get(index);
        } else {
            throw new IllegalStateException("Aucun lieu avec des rues adjacentes communes trouvé.");
        }
    }
}
