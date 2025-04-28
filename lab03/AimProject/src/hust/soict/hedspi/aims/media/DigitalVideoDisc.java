package hust.soict.hedspi.aims.disc;

import hust.soict.hedspi.aims.media.Disc;
import hust.soict.hedspi.aims.media.Playable;

public class DigitalVideoDisc extends Disc implements Playable {
    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }

    @Override
    public void play() {
        if (getLength() <= 0) {
            System.out.println("DVD \"" + getTitle() + "\" cannot be played. Invalid length.");
        } else {
            System.out.println("Playing DVD: " + getTitle());
            System.out.println("DVD length: " + getLength());
        }
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() +
                " - " + getDirector() + " - " + getLength() +
                ": " + getCost() + "$";
    }
}
