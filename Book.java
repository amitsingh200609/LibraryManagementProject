package LibraryManagement;

class Book {
    int id;
    String title;
    String author;
    int available;

    //jhaki mar book ka algo :)))))
    //constructor me pass
    Book(int id, String title, String author, int available) {
        this.id = id;
        this.title = title;
        //this bole toh current object ko point krna sir ne sekhaya tha
        this.author = author;
        this.available = available;
    }
}