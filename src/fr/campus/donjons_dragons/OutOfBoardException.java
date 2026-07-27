package fr.campus.donjons_dragons;

/**
 * Exception levée si le joueur dépasse la dernière case du plateau (64).
 * Utilisée pour gérer les erreurs de positionnement.
 */
public class OutOfBoardException extends Exception {

    /**
     * Constructeur avec un message personnalisé.
     * @param message Le message décrivant l'erreur de position.
     */
    public OutOfBoardException(String message) {
        super(message);
    }
}
