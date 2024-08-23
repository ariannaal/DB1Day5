package exceptions;

public class NotFoundEx extends RuntimeException {

    public NotFoundEx(int id) {
        super("Elemento con ID " + id + " non trovato.");
    }

    public NotFoundEx(String id) {
        super("Elemento con ID " + id + " non trovato.");
    }

}
