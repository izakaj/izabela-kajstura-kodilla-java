package com.kodilla.patterns.builder.bigmac;

public enum Bun {
    WITH_SESAME("with sesame"),
    WITHOUT_SESAME("without sesame");

    private String version;

    Bun(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return version;
    }
}
