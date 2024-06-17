package com.marcheurBlanc;

import com.marcheurblanc.Carte;
import com.marcheurblanc.Lieu;
import com.marcheurblanc.Marcheur;
import com.marcheurblanc.Rue;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarcheurTest {
    @Test
    public void marcheur_arrive_toujours_a_destination(){
        Rue rue1 = new Rue("heisekl");
        Rue rue2 = new Rue("heipull");
        Rue rue3 = new Rue("ballpull");
        Rue rue4 = new Rue("ballboulevard");
        Rue rue5 = new Rue("ballesti");
        Rue rue6 = new Rue("seklmarais");

        Lieu hei = new Lieu("hei", Arrays.asList(rue1, rue2));
        Lieu Pullman = new Lieu("Pullman", Arrays.asList(rue2, rue3));
        Lieu Balancoire = new Lieu("Balançoire", Arrays.asList(rue3, rue4, rue5));
        Lieu Boulevard = new Lieu("Boulevard", Arrays.asList(rue4));
        Lieu esti = new Lieu("Esti", Arrays.asList(rue5));
        Lieu sekl = new Lieu("Sekolintsika", Arrays.asList(rue6, rue1));
        Lieu marais = new Lieu("Marais", Arrays.asList(rue6));

        Carte carte = new Carte(List.of(hei,Pullman,Balancoire, Boulevard, esti, sekl, marais));

        Marcheur Bjarni = new Marcheur("Bjarni", hei, esti);

        assertEquals(esti, Bjarni.marcher(carte).getLast());
    }

    @Test
    public void marcheur_arrive_toujours_a_destination_meme_sans_nom_de_rue(){
        Rue rue1 = new Rue("");
        Rue rue2 = new Rue("");
        Rue rue3 = new Rue("");
        Rue rue4 = new Rue("");
        Rue rue5 = new Rue("");
        Rue rue6 = new Rue("");

        Lieu hei = new Lieu("hei", Arrays.asList(rue1, rue2));
        Lieu Pullman = new Lieu("Pullman", Arrays.asList(rue2, rue3));
        Lieu Balancoire = new Lieu("Balançoire", Arrays.asList(rue3, rue4, rue5));
        Lieu Boulevard = new Lieu("Boulevard", Arrays.asList(rue4));
        Lieu esti = new Lieu("Esti", Arrays.asList(rue5));
        Lieu sekl = new Lieu("Sekolintsika", Arrays.asList(rue6, rue1));
        Lieu marais = new Lieu("Marais", Arrays.asList(rue6));

        Carte carte = new Carte(List.of(hei,Pullman,Balancoire, Boulevard, esti, sekl, marais));

        Marcheur Bjarni = new Marcheur("Bjarni", hei, esti);

        assertEquals(esti, Bjarni.marcher(carte).getLast());
    }

    @Test
    public void point_de_depart_inchangé(){
        Rue rue1 = new Rue("");
        Rue rue2 = new Rue("");
        Rue rue3 = new Rue("");
        Rue rue4 = new Rue("");
        Rue rue5 = new Rue("");
        Rue rue6 = new Rue("");

        Lieu hei = new Lieu("hei", Arrays.asList(rue1, rue2));
        Lieu Pullman = new Lieu("Pullman", Arrays.asList(rue2, rue3));
        Lieu Balancoire = new Lieu("Balançoire", Arrays.asList(rue3, rue4, rue5));
        Lieu Boulevard = new Lieu("Boulevard", Arrays.asList(rue4));
        Lieu esti = new Lieu("Esti", Arrays.asList(rue5));
        Lieu sekl = new Lieu("Sekolintsika", Arrays.asList(rue6, rue1));
        Lieu marais = new Lieu("Marais", Arrays.asList(rue6));

        Carte carte = new Carte(List.of(hei,Pullman,Balancoire, Boulevard, esti, sekl, marais));

        Marcheur Bjarni = new Marcheur("Bjarni", hei, esti);

        assertEquals(hei, Bjarni.marcher(carte).getFirst());
    }
}
