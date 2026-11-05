package com.neurokore.bootcamp.elias.beer.dao;

/**
 * Excepción no verificada para errores de persistencia de cervezas.
 *
 * <p>Envuelve las {@link java.sql.SQLException} lanzadas por {@link BeerDAOImpl}.</p>
 *
 * @author NeuroKore
 */
public class BeerPersistenceException extends RuntimeException {

    /**
     * Construye la excepción con mensaje y causa.
     *
     * @param message descripción del error
     * @param cause causa original
     */
    public BeerPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

}
