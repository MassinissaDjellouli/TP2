package Models.Documents.Enums;

public enum Genres {
    roman,
    manuel,
    magazine,
    etude;

    public static Genres stringToGenres(String string){
        switch (string){
            case "etude" -> {return Genres.etude;}
            case "magazine" -> {return Genres.magazine;}
            case "roman" -> {return Genres.roman;}
            case "manuel" -> {return Genres.manuel;}
            default -> {return null;}
        }
    }
}

