package pl.szlify.exchangeapi.exception;


public class ExchangeApiException extends RuntimeException {
    public ExchangeApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
