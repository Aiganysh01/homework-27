package user;

import models.Movie;
import simulation.FullSearchSimulation;
import simulation.SearchSimulation;
import utilities.FileService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class User {
    private final Scanner sc = new Scanner(System.in);
    private SearchSimulation sm = new SearchSimulation();
    private FullSearchSimulation dss = new FullSearchSimulation();

    public void run() {
        apply();
    }

    private void apply() {
        print("Для начала необходимо получить файл со списком фильмов\n");
        Map<String, List<Movie>> MOVIES = FileService.readFile();
        print("Вводи номер для выбора действия\n");
        print("0. Выводить коллекцию фильмов на экран\n" +
                "1. Искать и отображать фильмы по частичному совпадению в названии\n" +
                "2. Сортировать фильмов по возрастанию и по году выпуска фильма\n" +
                "3. Сортировать фильмов по убыванию по году выпуска фильма\n" +
                "4. Сортировать фильмов по возрастанию и по по названию\n" +
                "5. Сортировать фильмов по убыванию по по названию\n" +
                "6. Сортировать фильмов по возрастанию и по по режиссеру" +
                "7. Сортировать фильмов по убыванию по по режиссеру\n" +
                "8. Всех фильмов, в которых снимался тот или иной актёр. Критерий поиска 'имя актера'\n" +
                "9 Всех фильмов, которые режиссировал тот или иной режиссер. Критерий поиска 'имя режиссера'\n" +
                "10. Всех фильмов, которые были выпущены в определенном году. Критерий поиска 'год выпуска фильма'\n" +
                "11. Списка фильмов и роль того или иного актера в этом фильме. Критерий поиска 'имя актера'\n" +
                "12. Искать и отображать фильмы по полному  совпадению в названии");
        int choice = getRightInt(12);
        switch (choice) {
            case 0:
                sm.showAll();
                exitOr();
            case 1:
                print("Ввeдите имя фильма:");
                String toSend = getRightString();
                sm.searchShowPartly(toSend);
                exitOr();
            case 2:
                sm.incrimentByYearSort();
                exitOr();
            case 3:
                sm.decrimentByYearSort();
                exitOr();
            case 4:
                sm.incrimentByNameSort();
                exitOr();
            case 5:
                sm.decrimentByNameSort();
                exitOr();
            case 6:
                sm.incrimentByYearSort();
                exitOr();
            case 7:
                sm.decrimentByYearSort();
                //exitOr();
            case 8:
                print("Всех фильмов, в которых снимался тот или иной актёр. Критерий поиска 'имя актера'\n");
                print("Ввeдите имя фильма актера:");
                String toSendCast = getRightString();
                dss.allMovieWithCast(toSendCast);
                exitOr();
            case 9:
                print("9 Всех фильмов, которые режиссировал тот или иной режиссер. Критерий поиска 'имя режиссера'\n");
                print("Ввeдите имя фильма директора:");
                String toSendDir = getRightString();
                dss.allMovieWithDirector(toSendDir);
                exitOr();
            case 10:
                print("10. Всех фильмов, которые были выпущены в определенном году. Критерий поиска 'год выпуска фильма'\n");
                print("Ввeдите год выпуска:");
                int year = sc.nextInt();
                dss.allMovieWithYear(year);
                exitOr();
            case 11:
                print("11. Списка фильмов и роль того или иного актера в этом фильме. Критерий поиска 'имя актера'\n");
                print("Введите что-то:");
                String some = getRightString();
                dss.allActorWithRoleOfMovies();
                exitOr();
            case 12:
                print("Ввeдите имя фильма:");
                String toSendFull = getRightString();
                sm.searchShowAll(toSendFull);
                exitOr();
        }
    }

    private String getRightString() {
        String name = sc.nextLine().trim().toLowerCase();
        String apply = name.substring(0, 1).toUpperCase() + name.substring(1);
        return apply;
    }

    private void exitOr() {
        print("Продолжить: вводи - 'Y'\nЗакрыть программу: вводи -'N' !\n");
        String askMore = sc.nextLine().trim().toLowerCase();
        if (askMore.charAt(0) == 'y') {
            apply();
        } else if (askMore.charAt(0) != 'n') {
            print("Enter 'y' or 'n'");
            exitOr();
        }
    }

    private int getRightInt(int num) {
        print("Enter a number between 0 to " + (num) + " (включительно): ");
        String choiceString = sc.nextLine();
        int choiceInt = 0;
        try {
            choiceInt = Integer.parseInt(choiceString);
            if (choiceInt > num || choiceInt < 0) {
                throw new Exception();
            }
        } catch (NumberFormatException e) {
            print("Choice is not a digit. ");
            choiceInt = getRightInt(num);
        } catch (Exception e) {
            print("Choice is not in the diapason. ");
            choiceInt = getRightInt(num);
        }
        return choiceInt;
    }

    private void print(String message) {
        System.out.print(message);
    }
}
