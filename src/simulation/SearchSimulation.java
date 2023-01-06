package simulation;

import Interface.RawSearchable;
import exceptions.ValidYearException;
import models.Movie;
import utilities.FileService;

import java.util.*;

public class SearchSimulation implements RawSearchable {
    private final Map<String, List<Movie>> MOVIES = FileService.readFile();
    private final List<Movie> MOVIELIST = MOVIES.get("movies");
    private List<Movie> myNewList = new ArrayList<Movie>(MOVIELIST);
    private final String HEADLINETAB = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";

    @Override
    public void showAll() {
        try {
            print(HEADLINETAB + "Вы выбрали показать коллекцию фильмов:\n");
            String frm = "Название фильма: %41s | Год выпуска: %4s | Описание: %9s | Режиссер: %17s.%n";
            for (Movie movie : MOVIELIST) {
                print(String.format(frm, movie.getName(), movie.getYear(), movie.getDescription(), movie.getDirector()));
            }
        } catch (NullPointerException | ValidYearException | IllegalArgumentException e) {
            print(e.getMessage());
        }
    }

    @Override
    public void searchShowPartly(String name) {
        String nameFull = name.toLowerCase();
        try {
            if (nameFull.isBlank()) {
                throw new IllegalArgumentException("Ввод названия фильма содержит ничего.\n");
            }
            print("Вы выбрали искать и отображать фильм по полному совпадению в названии фильма:\n");
            String frm = "УСПЕШНО! Название фильма: %10s%n";
            int count = 0;
            for (var v : MOVIELIST) {
                if (v.getName().contains(nameFull)) {
                    print(String.format(frm, v.getName()));
                    count++;
                    break;
                } else if (v.getName().equals(nameFull)) {
                    print(String.format(frm, v.getName()));
                    count++;
                    break;
                }
            }
            if (count == 0) {
                throw new NullPointerException("Поиск не нашел по вашему запросу: " + nameFull + "\n");
            }
        } catch (NullPointerException | IllegalArgumentException e) {
            print(e.getMessage());
        }
    }

    public void searchShowAll(String nameFull) {
        try {
            if (nameFull.isBlank()) {
                throw new IllegalArgumentException("Ввод названия фильма содержит ничего.\n");
            }
            print("Вы выбрали искать и отображать фильм по полному совпадению в названии фильма:\n");
            String frm = "УСПЕШНО! Название фильма: %10s%n";
            int count = 0;
            for (var v : MOVIELIST) {
                if (v.getName().equals(nameFull)) {
                    print(String.format(frm, v.getName()));
                    count++;
                    break;
                }
            }
            if (count == 0) {
                throw new NullPointerException("Поиск не нашел по вашему запросу: " + nameFull + "\n");
            }
        } catch (NullPointerException | IllegalArgumentException e) {
            print(e.getMessage());
        }
    }

    private void printList(List<Movie> listMovies) {
        System.out.println(listMovies);
    }

    public void incrimentByNameSort() {
        print("Сортировка фильмов по возрастанию по названию фильма\n");
        try {
            Collections.sort(myNewList, Comparator.naturalOrder());
        } catch (NullPointerException | ValidYearException | IllegalArgumentException e) {
            print(e.getMessage());
        }
        printList(myNewList);
    }

    @Override
    public void decrimentByNameSort() {
        print("Сортировка фильмов по убыванию и по названию фильма\n");
        try {
            Collections.sort(myNewList, Comparator.reverseOrder());
        } catch (NullPointerException | ValidYearException | IllegalArgumentException e) {
            print(e.getMessage());
        }
        printList(myNewList);
    }

    public void decrimentByYearSort() {
        print("Сортировка фильмов по убыванию по году выпуска фильма\n");
        try {
            Comparator movieByYear = Comparator.comparingInt(Movie::getYear);
            myNewList.sort(movieByYear.reversed());
        } catch (NullPointerException | ValidYearException | IllegalArgumentException e) {
            print(e.getMessage());
        }
        printList(myNewList);
    }

    public void incrimentByYearSort() {
        print("Сортировка фильмов по возрастанию по году выпуска фильма\n");
        try {
            Comparator movieByYear = Comparator.comparingInt(Movie::getYear);
            myNewList.sort(movieByYear);
        } catch (NullPointerException | ValidYearException | IllegalArgumentException e) {
            print(e.getMessage());
        }
        printList(myNewList);
    }

    public void incrimentByDirectorSort() {
        print("Сортировка фильмов по возрастанию по ДИРЕКТОРУ фильма\n");
        try {
            myNewList.sort(Comparator.comparing(Movie::getDirector));
        } catch (NullPointerException | ValidYearException | IllegalArgumentException e) {
            print(e.getMessage());
        }
        printList(myNewList);
    }

    public void decrimentByDirectorSort() {
        print("Сортировка фильмов по убыванию по ДИРЕКТОРУ фильма\n");
        try {
            myNewList.sort(Comparator.comparing(Movie::getDirector).reversed());

        } catch (NullPointerException | ValidYearException | IllegalArgumentException e) {
            print(e.getMessage());
        }
        printList(myNewList);
    }

    @Override
    public void byYear() {

    }

    @Override
    public void byName() {

    }

    @Override
    public void byCast() {

    }

    private void print(String message) {
        System.out.print(message);
    }
}
