import java.time.LocalDate;
import java.util.List;
import org.springframework.cglib.core.Local;

public class ShoppingMall {
  private String name;
  private int area;
  private Cinema cinema;
  private List<String> shopcate;
}


static class Cinema{
  String name;
  LocalDate openedDate;
  List<ReleasedFilm> releasedFilms;

  static class ReleasedFilm{
    String name;
    LocalDate releasDate;
  }
}