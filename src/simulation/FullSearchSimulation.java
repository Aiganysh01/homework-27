package simulation;

import Interface.FullSearchable;
import models.Movie;
import utilities.FileService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FullSearchSimulation implements FullSearchable {
    private final Map<String, List<Movie>> MOVIES = FileService.readFile();
    private final List<Movie> MOVIELIST = MOVIES.get("movies");

    @Override
    public void allMovieWithCast(String actorName) {
        String actorLowerCase = actorName.toLowerCase();
        Map<Movie, String> movByActor = new HashMap<>();
        for (Movie eachMovie : MOVIELIST) {
            for (int i = 0; i < eachMovie.getCast().size(); i++) {
                if (eachMovie.getCast().get(i).getName().contains(actorLowerCase)) {
                    movByActor.put(eachMovie, eachMovie.getName());
                }
            }
        }
        printMap(movByActor);
    }

    private void printMap(Map<Movie, String> mapMovies) {
        for (Map.Entry<Movie, String> kv : mapMovies.entrySet()) {
            System.out.println(kv.getKey().getName());
        }
    }

    @Override
    public void allMovieWithDirector(String directorName) {
        String dirLowerCase = directorName.toLowerCase();
        Map<Movie, String> movByDir = new HashMap<>();
        for (Movie eachMovie : MOVIELIST) {
            for (int i = 0; i < eachMovie.getCast().size(); i++) {
                if (eachMovie.getDirector().getFullName().contains(dirLowerCase)) {
                    movByDir.put(eachMovie, eachMovie.getName());
                }
            }
        }
        printMap(movByDir);
    }

    @Override
    public void allMovieWithYear(int year) {
        Map<Movie, String> movByYear = new HashMap<>();
        for (Movie eachMovie : MOVIELIST) {
            for (int i = 0; i < eachMovie.getCast().size(); i++) {
                if (eachMovie.getYear() == year) {
                    movByYear.put(eachMovie, eachMovie.getName());
                }
            }
        }
        printMap(movByYear);
    }

    @Override
    public void allMovieWithRole(String actorName) {
        Map<Movie, String> movByNameRole = new HashMap<>();
        for (Movie eachMovie : MOVIELIST) {
            for (int i = 0; i < eachMovie.getCast().size(); i++) {
                if (eachMovie.getCast().get(i).getName().contains(actorName)) {
                    movByNameRole.put(eachMovie, eachMovie.getCast().get(i).getRoleName());
                }
            }
        }
        for (Map.Entry<Movie, String> kv : movByNameRole.entrySet()) {
            System.out.println(kv.getKey().getName() + " - " + kv.getValue());
        }
    }

    @Override
    public void allActorWithRoleOfMovies() {
        System.out.println("Task is failed! (((");
    }
}
