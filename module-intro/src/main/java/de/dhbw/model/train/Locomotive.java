package de.dhbw.model.train;

public class Locomotive {

    public enum EngineType {
        SteamEngine, CombustionMotor, Electrical
    }

    private EngineType type;

    public EngineType getType() {
        return type;
    }

    public void setType(EngineType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Locomotive{" +
                "type=" + type +
                '}';
    }
}
