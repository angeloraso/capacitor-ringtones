package ar.com.anura.plugins.ringtones;

public class Ringtone {
    private String title;
    private String uri;

    public Ringtone(String title, String uri) {
        this.title = title;
        this.uri = uri;
    }

    public String getTitle() {
        return title;
    }

    public String getUri() {
        return uri;
    }
}