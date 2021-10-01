package by.java_online.modul6.entity;

import java.util.Objects;

public class Book {

    private String name;
    private String author;
    private int year;
    private String type;

    public Book() {

    }

    public Book(String name, String author, int year, String type) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!Objects.equals(name, book.name)) return false;
        if (!Objects.equals(author, book.author)) return false;
        if (!Objects.equals(type, book.type)) return false;
        return year == book.year;

    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = name != null ? name.hashCode() : 0;
        result = prime * result + author != null ? author.hashCode() : 0;
        result = prime * result + type != null ? type.hashCode() : 0;
        result = prime * result + year;

        return result;
    }

    @Override
    public String toString (){
        return "Book { name = '" + name +"', author = '"+author+"', year = "+ year+", type = "+ type+"}";
    }
}
