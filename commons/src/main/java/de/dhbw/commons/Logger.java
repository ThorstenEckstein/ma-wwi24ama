package de.dhbw.commons;

@SuppressWarnings("unused")
public class Logger {

    private enum LogLevel { Debug, Warn, Error; }
    private LogLevel logLevel;
    private final Class<?> clazz;

    public Logger(LogLevel logLevel, Class<?> clazz) {
        this.logLevel = logLevel;
        if(clazz != null) {
            this.clazz = clazz;
        } else {
            throw new IllegalArgumentException("The argument 'clazz' must not be null!");
        }
    }

    public Logger(Class<?> clazz) {
        this(LogLevel.Debug,clazz);
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public void log(Object what) {
        switch (logLevel) {
            case Debug -> debug(what);
            case Warn -> warn(what);
            case Error -> error(what);
        }
    }

    public void debug(Object what) {
        if (LogLevel.Debug == logLevel) {
            out(what);
        }
    }

    public void warn(Object what) {
        if (LogLevel.Warn == logLevel) {
            out(what);
        }
    }

    public void error(Object what) {
        if (LogLevel.Error == logLevel) {
            err(what);
        }
    }

    private void out(Object what) {
        System.out.printf("\n[%s] %s", clazz.getSimpleName(), what);
    }

    private void err(Object what) {
        System.err.printf("\n[%s] %s", clazz.getSimpleName(), what);
    }
}
