package bioscoopCasus;

import java.util.ArrayList;

public class movie {
    private String title;
    private ArrayList<movieScreening> screenings;
    public movie(String title) {
        this.title = title;
        screenings = new ArrayList<>();
    }

    public void AddScreening(movieScreening screening) {
        screenings.add(screening);
    }

    public ArrayList<movieScreening> getScreenings() {
        return screenings;
    }
    
    public String toString() {
        return title;
    }
}
