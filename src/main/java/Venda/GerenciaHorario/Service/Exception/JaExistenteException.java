package Venda.GerenciaHorario.Service.Exception;

public class JaExistenteException extends RuntimeException {
    public JaExistenteException(String message) {
        super(message);
    }
}

