package br.com.lgbv.prateleira_inteligente_v2.mocks;

import br.com.lgbv.prateleira_inteligente_v2.entities.*;
import br.com.lgbv.prateleira_inteligente_v2.enums.UserRole;
import br.com.lgbv.prateleira_inteligente_v2.repositories.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class Mocking {

    private final UserRepository userRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final CategoriesRepository categoriesRepository;
    private final UserBookRepository userBookRepository;
    private final CommentRepository commentRepository;

    @PostConstruct
    public void loadMock() {

        if (bookRepository.count() > 0) return;

        /* ================= USERS ================= */
        AppUser admin = new AppUser();
        admin.setUsername("admin_master");
        admin.setPassword("123456");
        admin.setRole(UserRole.ADMIN);
        userRepository.save(admin);

        AppUser maria = new AppUser();
        maria.setUsername("maria_dev");
        maria.setPassword("123456");
        maria.setRole(UserRole.USER);
        userRepository.save(maria);

        AppUser carlos = new AppUser();
        carlos.setUsername("carlos_reader");
        carlos.setPassword("123456");
        carlos.setRole(UserRole.USER);
        userRepository.save(carlos);

        /* ================= CATEGORIES ================= */
        Categories backend = new Categories();
        backend.setName("Backend");
        categoriesRepository.save(backend);

        Categories frontend = new Categories();
        frontend.setName("Frontend");
        categoriesRepository.save(frontend);

        Categories devops = new Categories();
        devops.setName("DevOps");
        categoriesRepository.save(devops);

        Categories arquitetura = new Categories();
        arquitetura.setName("Arquitetura de Software");
        categoriesRepository.save(arquitetura);

        /* ================= AUTHORS ================= */
        Author roberto = new Author();
        roberto.setName("Roberto Almeida");
        authorRepository.save(roberto);

        Author fernanda = new Author();
        fernanda.setName("Fernanda Lima");
        authorRepository.save(fernanda);

        Author thiago = new Author();
        thiago.setName("Thiago Martins");
        authorRepository.save(thiago);

        Author[] authors = {roberto, fernanda, thiago};
        Categories[] categories = {backend, frontend, devops, arquitetura};
        AppUser[] users = {admin, maria, carlos};

        /* ================= BOOKS ================= */
        for (int i = 1; i <= 20; i++) {

            Book book = new Book();
            book.setTitle("Livro Tech Volume " + i);
            book.setDescription("Explorando conceitos avançados de desenvolvimento - Volume " + i);
            book.setPublisher("Digital Tech Press");
            book.setPublicationDate(LocalDate.of(2023 + (i % 3), (i % 12) + 1, (i % 28) + 1));
            book.setScore(3.5 + (i % 5) * 0.3);
            book.setAssessmentQuantity(50L + i * 3);

            Author selectedAuthor = authors[i % authors.length];
            Categories selectedCategory = categories[i % categories.length];

            book.setAuthors(Set.of(selectedAuthor));
            book.setCategories(Set.of(selectedCategory));

            bookRepository.save(book);

            selectedAuthor.getBooks().add(book);
            selectedCategory.getBooks().add(book);

            /* ================= USER_BOOK ================= */
            AppUser selectedUser = users[i % users.length];

            UserBook userBook = new UserBook();
            userBook.setUser(selectedUser);
            userBook.setBook(book);
            userBook.setRating(3 + (i % 3));
            userBook.setOnShelf(i % 2 == 0);
            userBookRepository.save(userBook);

            /* ================= COMMENT ================= */
            Comment comment = new Comment();
            comment.setUser(selectedUser);
            comment.setBook(book);
            comment.setText("Excelente leitura! Volume " + i + " agregou muito conhecimento.");
            comment.setCreatedAt(Instant.now());
            commentRepository.save(comment);
        }

        authorRepository.save(roberto);
        authorRepository.save(fernanda);
        authorRepository.save(thiago);

        categoriesRepository.save(backend);
        categoriesRepository.save(frontend);
        categoriesRepository.save(devops);
        categoriesRepository.save(arquitetura);
    }
}