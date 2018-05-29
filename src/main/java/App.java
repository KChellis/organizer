import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import models.Book;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        //get: show new post form
        get("/books/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "newbook-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/books/new", (request, response) -> { //URL to make new post on POST route
            Map<String, Object> model = new HashMap<String, Object>();
            String title = request.queryParams("title");
            String author = request.queryParams("author");
            Integer year = Integer.parseInt(request.queryParams("year"));
            String imageURL = request.queryParams("imageURL");
            Book newBook = new Book(title, author, year, imageURL);
            model.put("book", newBook);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Book> books = Book.getAll();
            model.put("books", books);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show an individual post
        get("/books/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfBookToFind = Integer.parseInt(req.params("id")); //pull id - must match route segment
            Book foundBook = Book.findById(idOfBookToFind); //use it to find post
            model.put("book", foundBook); //add it to model for template to display
            return new ModelAndView(model, "book-detail.hbs"); //individual book page.
        }, new HandlebarsTemplateEngine());

    }
}
