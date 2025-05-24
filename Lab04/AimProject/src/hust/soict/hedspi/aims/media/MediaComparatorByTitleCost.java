package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    public int compare(Media media1, Media media2) {
        int titleCompare = media1.getTitle().compareToIgnoreCase(media2.getTitle());
        if (titleCompare == 0) {
            return Float.compare(media2.getCost(), media1.getCost()); // cost giảm dần
        }
        return titleCompare;
    }
}
