package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    public int compare(Media media1, Media media2) {
        int costCompare = Float.compare(media2.getCost(), media1.getCost()); // cost giảm dần
        if (costCompare == 0) {
            return media1.getTitle().compareToIgnoreCase(media2.getTitle());
        }
        return costCompare;
    }
}
