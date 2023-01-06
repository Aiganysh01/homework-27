package Interface;

public interface RawSearchable {
    void showAll();

    void searchShowAll(String name);

    void searchShowPartly(String namepart);

    void incrimentByNameSort();

    void decrimentByNameSort();

    void incrimentByYearSort();

    void decrimentByYearSort();

    void incrimentByDirectorSort();

    void decrimentByDirectorSort();

    void byYear();

    void byName();

    void byCast();
}
