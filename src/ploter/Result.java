package ploter;


public class Result {
    public String URL;
    public String matchedPhrase;
    public String sentence;

    public Result(String URL, String matchedPhrase, String sentence) {
        this.URL = URL;
        this.matchedPhrase = matchedPhrase;
        this.sentence = sentence;
    }
}
