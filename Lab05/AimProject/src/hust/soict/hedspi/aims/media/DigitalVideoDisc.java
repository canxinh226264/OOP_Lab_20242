package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

    // Constructor đầy đủ (6 args)
    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }

    // Constructor đơn giản (4 args)
    public DigitalVideoDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    // ✅ Constructor tối giản (3 args) — dùng trong test View
    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost); // gọi Media constructor, tự sinh id
    }

    @Override
    public void play() throws PlayerException {
        if (getLength() <= 0) {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }

        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength());
    }

    @Override
    public String toString() {
        return String.format("DVD - %s - %s - %s - %d: %.2f$",
                getTitle(), getCategory(), getDirector(), getLength(), getCost());
    }
}
