package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;
    private static int nbMedia = 0;

    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Media)) return false;

        Media other = (Media) obj;
        String otherTitle = other.getTitle();

        // Null-safe title comparison
        if ((this.title == null && otherTitle != null) || (this.title != null && !this.title.equals(otherTitle))) {
            return false;
        }

        // Compare costs
        return Double.compare(this.cost, other.getCost()) == 0;
    }


    public int compareTo(Media other) {
        if (other == null) {
            throw new NullPointerException("Cannot compare with null");
        }

        if (!(other instanceof Media)) {
            throw new ClassCastException("Invalid type for comparison");
        }

        // Null-safe title comparison
        if (this.title == null && other.getTitle() == null) return 0;
        if (this.title == null) return -1;
        if (other.getTitle() == null) return 1;

        int titleCompare = this.title.compareTo(other.getTitle());
        if (titleCompare != 0) return titleCompare;

        // If titles are equal, compare costs
        return Double.compare(this.cost, other.getCost());
    }

    //constructor
    public Media(String title){
        this.id = ++nbMedia;
        this.title = title;
    }

    public Media(String title, String category, float cost) {
        this.id = ++nbMedia;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }


    public int getId() {

        return id;
    }

    public String getTitle() {

        return title;
    }

    public float getCost() {

        return cost;
    }

    public String getCategory() {

        return category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void setCategory(String category) {

        this.category = category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

 /*   @Override
    public boolean equals(Object obj) {
        Media media = (Media) obj;
        try {
            String title = media.getTitle();
            return this.title.equals(title);
        } catch (NullPointerException e) {
            return false;
        }
    }
    */


    public void displayDetails() {
        System.out.println("----------------MEDIA's DETAILs----------------");
        System.out.println("Title: " + title);
        System.out.println("Category: " + category);
        System.out.println("Cost: " + cost);
        System.out.println("---------------END-----------------");
    }


    @Override
    public String toString() {
        return "Media [id=" + '\'' + id + '\'' + ", title=" + '\'' + title  + '\''
                + ", category=" + category+ ", cost=" + cost + "]";
    }





}