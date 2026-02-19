package ca.uqam.h2024.inf2120.grpe30.tp2.adt;

import java.util.Iterator;
import java.util.NoSuchElementException;

class EquipeIterateur<T> implements Iterator<T> {

   private Noeud<T> curseur;

   public EquipeIterateur(Noeud<T> curseur) {
      this.curseur = curseur;
   }

   @Override
   public boolean hasNext() {
      return curseur != null;
   }

   @Override
   public T next() {
      if (!this.hasNext()) {
         throw new NoSuchElementException();
      }

      T courant = curseur.getElement();
      curseur = curseur.getSuivant();
      return courant;
   }


}
