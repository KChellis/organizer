package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Book.clearAllBooks();
    }

    public Book setupNewBook(){
        return new Book("The Jungle Book", "Rudyard Kipling", 1894, "images/Jungle-Book.jpg" );
    }

    @Test
    public void newBookObjectIsCreatedCorrectly_true() {
        Book newBook = setupNewBook();
        assertTrue(newBook instanceof Book);
    }

    @Test
    public void bookInstantiatesWithAuthor_true() {
        Book newBook = setupNewBook();
        assertEquals("Rudyard Kipling", newBook.getAuthor());
    }
    @Test
    public void bookInstantiatesWithYear_true() {
        Book newBook = setupNewBook();
        assertEquals(1894, newBook.getYear());
    }
    @Test
    public void bookInstantiatesWithImageURL_true() {
        Book newBook = setupNewBook();
        assertEquals("images/Jungle-Book.jpg", newBook.getImageURL());
    }
    @Test
    public void bookInstantiatesWithTitle_true() {
        Book newBook = setupNewBook();
        assertEquals("The Jungle Book", newBook.getTitle());
    }

    @Test
    public void allBooksAreCorrectlyReturned() {
        Book newBook = setupNewBook();
        Book otherBook = new Book ("Fahrenheit 451", "Ray Bradbury", 1953, "images/451");
        assertEquals(2, Book.getAll().size());
    }

    @Test
    public void AllBooksContainsAllPosts_true() {
        Book newBook = setupNewBook();
        Book otherBook = new Book ("Fahrenheit 451", "Ray Bradbury", 1953, "images/451");
        assertTrue(Book.getAll().contains(newBook));
        assertTrue(Book.getAll().contains(otherBook));
    }

    @Test
    public void getId_booksInstantiateWithAnID_1() throws Exception{
        Book newBook = setupNewBook();
        assertEquals(1, newBook.getId());
    }

    @Test
    public void findReturnsCorrectPost() throws Exception {
        Book newBook = setupNewBook();
        assertEquals(1, Book.findById(newBook.getId()).getId());
    }

    @Test
    public void findReturnsCorrectPostWhenMoreThanOnePostExists() throws Exception {
        Book newBook = setupNewBook();
        Book otherBook = new Book ("Fahrenheit 451", "Ray Bradbury", 1953, "images/451");
        assertEquals(2, Book.findById(otherBook.getId()).getId());
    }
}