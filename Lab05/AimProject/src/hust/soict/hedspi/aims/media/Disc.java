package hust.soict.hedspi.aims.media;

public class Disc extends Media {
    protected int length;
    protected String director;
    protected float cost;
    protected String category;
    protected String title;
    protected int id;

    public Disc(String title, String category, float cost) {
        super(title, category, cost); // Gọi lên Media
    }

    public Disc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public Disc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }


    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setLength(int length) {
        this.length = length;
    }
}