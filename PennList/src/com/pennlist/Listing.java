package com.pennlist;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table LISTING.
 */
public class Listing {

    private Long id;
    /** Not-null value. */
    private String title;
    /** Not-null value. */
    private String seller;
    private String imageLink;
    private String description;
    private java.util.Date date;
    /** Not-null value. */
    private String sellerEmail;
    private String sellerPhone;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public Listing() {
    }

    public Listing(Long id) {
        this.id = id;
    }

    public Listing(Long id, String title, String seller, String imageLink, String description, java.util.Date date, String sellerEmail, String sellerPhone) {
        this.id = id;
        this.title = title;
        this.seller = seller;
        this.imageLink = imageLink;
        this.description = description;
        this.date = date;
        this.sellerEmail = sellerEmail;
        this.sellerPhone = sellerPhone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getTitle() {
        return title;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setTitle(String title) {
        this.title = title;
    }

    /** Not-null value. */
    public String getSeller() {
        return seller;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    /** Not-null value. */
    public String getSellerEmail() {
        return sellerEmail;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public String getSellerPhone() {
        return sellerPhone;
    }

    public void setSellerPhone(String sellerPhone) {
        this.sellerPhone = sellerPhone;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
