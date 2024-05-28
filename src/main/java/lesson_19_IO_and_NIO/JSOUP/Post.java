package lesson_19_IO_and_NIO.JSOUP;

public class Post {
    private  String title;
    private  String detailsLink;
    private  String author;
    private  String authorDetailsLink;
    private  String dateOfCreate;

    public String getTitle() {
        return title;
    }

    public String getDetailsLink() {
        return detailsLink;
    }

    public String getAuthor() {
        return author;
    }

    public String getAuthorDetailsLink() {
        return authorDetailsLink;
    }

    public String getDateOfCreate() {
        return dateOfCreate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDetailsLink(String detailsLink) {
        this.detailsLink = detailsLink;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAuthorDetailsLink(String authorDetailsLink) {
        this.authorDetailsLink = authorDetailsLink;
    }

    public void setDateOfCreate(String dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", detailsLink='" + detailsLink + '\'' +
                ", author='" + author + '\'' +
                ", authorDetailsLink='" + authorDetailsLink + '\'' +
                ", dateOfCreate='" + dateOfCreate + '\'' +
                '}';
    }
}
