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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
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
