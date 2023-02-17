import com.fasterxml.jackson.annotation.JsonProperty;

public class Information {
//
//    "id": "5b4910ae0508220014ccfe90",
//            "text": "Кошки могут слышать ультразвук и коммуницировать с дельфинами.",
//            "type": "cat",
//            "user": "Alex Petrov",
//            "upvotes": 12

    private final String id;
    private final String text;
    private final String type;
    private final String user;
    private final int upvotes;

    public Information(

            @JsonProperty("id") String id,
            @JsonProperty("text") String text,
            @JsonProperty("type") String type,
            @JsonProperty("user") String user,
            @JsonProperty("upvotes") int upvotes
    ) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upvotes = upvotes;
    }

    public int getUpvotes() {
        return upvotes;
    }

    @Override
    public String toString() {
        return "Information{" +
                "id='" + id + '\'' +
                ", test='" + text + '\'' +
                ", type='" + type + '\'' +
                ", user='" + user + '\'' +
                ", upvotes=" + upvotes +
                '}';
    }
}
