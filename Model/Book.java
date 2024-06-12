package CaseStudyModule2.Model;

public class Book {
    private String idImportBook;
    private String nameImportBook;
    private String authorImportBook;
    private Double priceImportBook;
    private int quantity;
    public Book(String idBook, String nameBook, String authorBook, Double priceBook,int quantity){
        this.idImportBook = idBook;
        this.nameImportBook = nameBook;
        this.authorImportBook = authorBook;
        this.priceImportBook = priceBook;
        this.quantity = quantity;
    }

    public String getIdImportBook() {
        return idImportBook;
    }

    public void setIdImportBook(String idImportBook) {
        this.idImportBook = idImportBook;
    }

    public String getNameImportBook() {
        return nameImportBook;
    }

    public void setNameImportBook(String nameImportBook) {
        this.nameImportBook = nameImportBook;
    }

    public String getAuthorImportBook() {
        return authorImportBook;
    }

    public void setAuthorImportBook(String authorImportBook) {
        this.authorImportBook = authorImportBook;
    }

    public Double getPriceImportBook() {
        return priceImportBook;
    }

    public void setPriceImportBook(Double priceImportBook) {
        this.priceImportBook = priceImportBook;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getBill(){
        return getPriceImportBook() * getQuantity();
    }
}
