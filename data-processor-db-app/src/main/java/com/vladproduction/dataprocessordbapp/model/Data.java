package com.vladproduction.dataprocessordbapp.model;

import java.util.Objects;

public class Data {

    private String name;
    private int type;
    private boolean isTrue;

    public Data(String name, int type, boolean isTrue) {
        this.name = name;
        this.type = type;
        this.isTrue = isTrue;
    }

    public Data() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return type == data.type && isTrue == data.isTrue && Objects.equals(name, data.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, isTrue);
    }

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", isTrue=" + isTrue +
                '}';
    }
}
