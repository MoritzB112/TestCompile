package com.inergis.fguma.searchEnums;

public enum ActivitySearch {
    CURSO("Curso"),
    CODIGOFGUMA("Código FGUMA"),
    IDCAMOUSVIRTUAL("Id Campus Virtual");

    private String name;

    ActivitySearch(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static ActivitySearch fromString(String text) {
        for (ActivitySearch b : ActivitySearch.values()) {
            if (b.name.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
