package ca.uqam.h2024.inf2120.grpe30.tp2.adt;


@SuppressWarnings("serial")
public class PositionException extends Exception {
   
   /**
    * Constructeur sans argument
    */   
   public PositionException() {
        super();
    }
   
   /**
    * Ce constructeur permet d'initialiser le message.
    * 
    * @param message le message à afficher
    */
   public PositionException(String message) {
        super(message);
    }

}

