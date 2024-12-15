package by.clevertec.starter.performancemonitorspringbootstarter.exception;

public class PerformanceMonitorInitException extends RuntimeException {

    public PerformanceMonitorInitException(String message) {
        super(message);
    }

    public PerformanceMonitorInitException(String message, Throwable cause) {
        super(message, cause);
    }

    public PerformanceMonitorInitException(Throwable cause) {
        super(cause);
    }

    public PerformanceMonitorInitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public PerformanceMonitorInitException() {
    }
}
