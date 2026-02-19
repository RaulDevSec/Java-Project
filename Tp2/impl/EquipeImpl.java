package ca.uqam.h2024.inf2120.grpe30.tp2.adt.impl;

import ca.uqam.h2024.inf2120.grpe30.tp2.adt.EquipeTda;
import ca.uqam.h2024.inf2120.grpe30.tp2.adt.Noeud;
import ca.uqam.h2024.inf2120.grpe30.tp2.adt.PositionException;

import java.util.*;
import java.util.function.Consumer;

public class EquipeImpl<T> implements EquipeTda<T> {

    private Noeud<T> uneEquipe = null;
    private short nbMembres = 0;

    public EquipeImpl(Noeud<T> uneEquipe, short nbMembres) {

    }

    @Override
    public boolean ajouter(T membre) {

        Noeud<T> nouveauNoeud = new Noeud<>(membre);

        if (membre != null && !membre.equals(this.uneEquipe.getElement())) {

            if (this.uneEquipe == null) {

                this.uneEquipe = nouveauNoeud;

            } else {

                Noeud<T> courant = this.uneEquipe;
                while (courant.getSuivant() != null) {

                    courant = courant.getSuivant();

                }
                courant.setSuivant(nouveauNoeud);

            }
            this.nbMembres++;
            return true;
        }
        return false;
    }

    @Override
    public boolean ajouter(int position, T membre) throws PositionException {

        Noeud<T> nouveauNoeud = new Noeud<>(membre);
        Noeud<T> precedent = this.uneEquipe;
        if (position < 0 && position > this.nbMembres){

            throw new PositionException("La position n'est pas dans le bon intervalle");

        }

        if (membre == null){

            return false;
        }
        if (position == 0){

            nouveauNoeud.setSuivant(this.uneEquipe);
            this.uneEquipe = nouveauNoeud;
        } else {

            for (int i = 0; i < position - 1; i++){

                precedent = precedent.getSuivant();

            }
            nouveauNoeud.setSuivant(precedent.getSuivant());
            precedent.setSuivant(nouveauNoeud);

        }
        this.nbMembres++;
        return true;

    }

    @Override
    public List<T> ajouter(EquipeTda<T> equipe) {

        ArrayList<T> membres = new ArrayList<>();
        ArrayList<T> membresNA = new ArrayList<>(); // membres non ajoutés

        if (equipe == null || equipe.estVide()) {

            return null;

        }

        for (T membre : equipe){

            if(!membres.contains(membre)){

                membres.add(membre);

            } else {

                membresNA.add(membre);

            }
        }

        return membresNA.isEmpty() ? null : membresNA;
    }

    @Override
    public List<T> comparer(EquipeTda<T> equipe) {

        Noeud<T> equipeCourante = this.uneEquipe;
        List<T> membresInexistantsEquipeCourante = new ArrayList<>();
        while (equipeCourante != null){

            T membre = equipeCourante.getElement();
            if(equipeCourante.getElement().equals(membre)){
                membresInexistantsEquipeCourante.add(membre);


            }
            equipeCourante = equipeCourante.getSuivant();


        }
        return membresInexistantsEquipeCourante.isEmpty() ? null : membresInexistantsEquipeCourante;

    }

    @Override
    public boolean estMembre(T membre) {

        if(membre == null){

            return false;

        }

        return this.uneEquipe.getElement().equals(membre);
    }

    @Override
    public int obtenirNbMembres() {

        return this.nbMembres;

    }

    @Override
    public boolean retirer(T membre) {

        if (membre != null){

            if(membre == this.uneEquipe.getElement()){

                this.uneEquipe.setElement(null);
                this.nbMembres--;

            }

            return true;

        }

        return false;
    }

    @Override
    public List<T> retirer(EquipeTda<T> equipe) {

        List<T> membresNR = new ArrayList<>();

        if (equipe == null || equipe.estVide()){

            return null;

        }
        for (T membre : equipe){

            if (this.uneEquipe.getElement().equals(membre)){

                this.uneEquipe.setElement(null);

            }else{

                membresNR.add(membre);

            }

        }

        return membresNR.isEmpty() ? null : membresNR;
    }

    @Override
    public boolean remplacer(T membreARemplacer, T nouveauMembre) {

        if(this.uneEquipe.getElement().equals(nouveauMembre)){

            return false;
        }
        if(this.uneEquipe.getElement().equals(membreARemplacer) && nouveauMembre != null){

            this.uneEquipe.setElement(nouveauMembre);
            return true;
        }

        return false;
    }

    @Override
    public Map<Integer, T> obtenirLesMembres() {

        Map<Integer, T> membresEtPositions = new HashMap<>();
        int position = 0;
        if(estVide()){

            return null;

        }
        for (T membre: this.uneEquipe){

            

        }

    }

    @Override
    public boolean estVide() {

        return this.uneEquipe == null;

    }

    @Override
    public void vider() {

        this.uneEquipe = null;

        nbMembres = 0;

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        EquipeTda.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return EquipeTda.super.spliterator();
    }



}
