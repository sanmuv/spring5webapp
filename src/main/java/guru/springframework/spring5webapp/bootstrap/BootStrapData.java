package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) {
        Author louliana = new Author("Louliana", "Cosamina");
        Book pivotal_spring_professional = new Book("Pivotal Spring Professional", UUID.randomUUID().toString());
        Publisher apress = new Publisher("Apress");

        louliana.getBooks().add(pivotal_spring_professional);
        pivotal_spring_professional.getAuthors().add(louliana);

        authorRepository.save(louliana);
        bookRepository.save(pivotal_spring_professional);
        publisherRepository.save(apress);

        Author santhosh = new Author("Santhosh", "Muvva");
        Book patienceProgramming = new Book("Patience Programming", UUID.randomUUID().toString());

        santhosh.getBooks().add(patienceProgramming);
        patienceProgramming.getAuthors().add(santhosh);

        authorRepository.save(santhosh);
        bookRepository.save(patienceProgramming);

        System.out.println("Started in Bootstrap");
        System.out.println("Books count " + bookRepository.count());
        System.out.println("Authors count " + authorRepository.count());
        System.out.println("Publisher count " + publisherRepository.count());
    }
}
