package de.dhbw.exceptions.demo;

public interface ContextAware {

    ExceptionContext getContext();
    void setContext(ExceptionContext exceptionContext);

}
