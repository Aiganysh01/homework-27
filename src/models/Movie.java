package models;
import exceptions.ValidYearException;

import java.time.LocalDate;
import java.util.ArrayList;

public class Movie implements Comparable <Movie> {
    private String name;
    private int year;
    private String description;
    private Director director;
    private ArrayList<Cast> cast;

    public String getName() {
        try {
            if (name.isBlank()) {
                throw new IllegalArgumentException("Наименование " + description + ", которого снял " + director + " является пустым полем.\n");
            }
            return name;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getYear() {
        try {
            int currentYear = LocalDate.now().getYear();
            if (currentYear <= this.year) {
                throw new ValidYearException("Год выпуска из будущего  для фильма '" + this.name + "'.");
            } else if (this.year == 0) {
                throw new NullPointerException("Год не может быть НОЛЬ для фильма '" + this.name + ".");
            }
            return year;
        } catch (ValidYearException | NullPointerException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public String getDescription() {
        try {
            if (description.isBlank()) {
                throw new IllegalArgumentException("Описание содержит ничего для фильма '" + this.name + ".");
            }
            return description;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Director getDirector() {
        try {
            if (director.toString().isBlank()) {
                throw new IllegalArgumentException("Нет директора для фильма '" + this.name + ".");
            }
            return director;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Cast> getCast() {
        return cast;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public void setCast(ArrayList<Cast> cast) {
        this.cast = cast;
    }
    @Override
    public String toString() {
        String frm = "Название фильма: %41s | Год выпуска: %4s | Описание: %9s | Режиссер: %17s%n";
        return String.format(frm, name, year, description, director);
    }
    @Override
    public int compareTo(Movie o) {
        return 0;
    }
}
