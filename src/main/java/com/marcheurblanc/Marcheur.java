package com.marcheurblanc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Marcheur {
    private String nom;
    private Lieu positionActuelle;
    private Lieu destination;
    private final HashSet<Lieu> lieuVisite = new HashSet<>();
    private final List<Lieu> lieuxVisitesList = new ArrayList<>();

    protected void setPositionActuelle(Lieu positionActuelle) {
        this.positionActuelle = positionActuelle;
    }

    public Marcheur(String nom, Lieu positionActuelle, Lieu destination) {
        this.nom = nom;
        this.positionActuelle = positionActuelle;
        this.destination = destination;
    }

    public String marcher(Carte carte) {
        Random random = new Random();
        lieuVisite.add(positionActuelle);
        lieuxVisitesList.add(positionActuelle);

        while (!positionActuelle.equals(destination)) {
            int index;
            Lieu nouvellePosition;

            do {
                index = random.nextInt(positionActuelle.getRuesAdjacentes().size());
                Rue nouvelleTrajectoire = positionActuelle.getRuesAdjacentes().get(index);
                nouvellePosition = nouvelleTrajectoire.obtenirAutreExtremite(positionActuelle, carte);
            } while (nouvellePosition.equals(positionActuelle));

            setPositionActuelle(nouvellePosition);

            lieuVisite.add(positionActuelle);
            lieuxVisitesList.add(positionActuelle);
        }

        StringBuilder phrase = new StringBuilder();
        for (int i = 0; i < lieuxVisitesList.size(); i++) {
            if (i == 0) {
                phrase.append(lieuxVisitesList.get(i).getNomDuLieu()).append(" d'abord");
            } else if (i == lieuxVisitesList.size() - 1) {
                phrase.append(" et enfin ").append(lieuxVisitesList.get(i).getNomDuLieu());
            } else {
                phrase.append(", après ").append(lieuxVisitesList.get(i).getNomDuLieu());
            }
        }
        System.out.println("Voici la trajectoire pour arriver à "+ destination.getNomDuLieu() + ": "+ phrase.toString());
        return positionActuelle.getNomDuLieu();
    }

}
