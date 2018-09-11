package opgave5;

import java.util.ArrayList;

public class Series {
    private String title;
    private ArrayList<String> cast = new ArrayList<>();
    private ArrayList<Episode> episodes = new ArrayList<>();

    public Series(String title, ArrayList<String> cast) {
        this.title = title;
        this.cast = cast;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getCast() {
        return new ArrayList<>(cast);
    }

    public Episode createEpisode(int number, ArrayList<String> guestActors, int lengthMinutes) {
        Episode ep = new Episode(number, guestActors, lengthMinutes);
        episodes.add(ep);

        return ep;
    }

    public int totalLength() {
        int length = 0;
        for (Episode ep : episodes) {
            length += ep.getLength();
        }

        return length;
    }

    public ArrayList<String> getGuestActors() {
        ArrayList<String> allGuestActors = new ArrayList<>();
        for (Episode e : episodes) {
            allGuestActors.addAll(e.getGuestActors());
        }

        return allGuestActors;
    }
}
