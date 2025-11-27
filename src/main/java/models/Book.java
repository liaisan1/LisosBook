package models;


public class Book {
    private long id;
    private String title;
    private String author;
    private int publicationYear;
    private String genre;

    public Book(long id, String title, String author, int publicationYear, String genre) {}

    public Book(String title, String author, int publicationYear, String genre) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.genre = genre;
    }

    public long getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPublicationYear() { return publicationYear; }
    public String getGenre() { return genre; }

    public void setId(long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; }
    public void setGenre(String genre) { this.genre = genre; }
}