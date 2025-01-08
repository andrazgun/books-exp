package com.books.pages;

public class ProductDto {

    private String title;
    private double price;

    public ProductDto() {
    }

    public ProductDto(String title, double price){
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ProductDto {" +
                "title= '" + title + '\'' +
                ", price= " + price +
                '}';
    }
}
