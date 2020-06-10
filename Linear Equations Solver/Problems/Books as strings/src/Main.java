class Book {

    private String title;
    private int yearOfPublishing;
    private String[] authors;

    public Book(String title, int yearOfPublishing, String[] authors) {
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;
        this.authors = authors;
    }

    @Override
    public String toString() {
        StringBuilder book = new StringBuilder();

        book.append("title=" + title);
        book.append(",");
        book.append("yearOfPublishing=" + yearOfPublishing);
        book.append(",");
        book.append("authors=[");

        for (String author : authors) {
            book.append(author + ",");
        }

        book.replace(book.length() - 1, book.length(), "]");
        return book.toString();
    }
}