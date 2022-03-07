package Models.Enums;

public enum Genres {
    roman,
    manuel,
    magazine,
    etude;

    public static Genres stringToGenres(String string){
        switch (string){
            case "etude" -> {return etude;}
            case "magazine" -> {return magazine;}
            case "roman" -> {return roman;}
            case "manuel" -> {return manuel;}
            default -> {return null;}
        }
    }
}

