package ca.georgiancollege.assignment1.model;

public class Movie {
    private String imdbID;
    private String title;
    private String year;
    private String poster;
    private String rating;
    private String director;
    private String language;
    private String country;
    private String plot;

    public Movie(String imdbID, String title, String year, String poster, String rating, String director, String language, String country, String plot) {
        this.imdbID = imdbID;
        this.title = title;
        this.year = year;
        this.poster = poster;
        this.rating = rating;
        this.director = director;
        this.language = language;
        this.country = country;
        this.plot = plot;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }
}
