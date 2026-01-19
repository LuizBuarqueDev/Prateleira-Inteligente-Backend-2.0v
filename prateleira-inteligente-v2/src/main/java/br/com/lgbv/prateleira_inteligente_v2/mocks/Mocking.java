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

        /* ================= USER ================= */
        AppUser user = new AppUser();
        user.setUsername("luiz");
        user.setPassword("123456");
        user.setRole(UserRole.USER);
        userRepository.save(user);

        /* ================= CATEGORIES ================= */
        Categories category = new Categories();
        category.setName("Tecnologia");
        categoriesRepository.save(category);

        /* ================= AUTHOR ================= */
        Author author = new Author();
        author.setName("Luiz Gabriel");
        authorRepository.save(author);

        /* ================= BOOK ================= */
        Book book = new Book();
        book.setTitle("Spring Boot Profissional");
        book.setDescription("Livro sobre arquitetura com Spring Boot");
        book.setPublisher("Tech Books");
        book.setPublicationDate(LocalDate.of(2024, 1, 1));
        book.setScore(4.8);
        book.setAssessmentQuantity(120L);

        // relacionamentos ManyToMany
        book.setAuthors(Set.of(author));
        book.setCategories(Set.of(category));

        bookRepository.save(book);

        // sincroniza lado inverso (boa prática)
        author.getBooks().add(book);
        category.getBooks().add(book);

        authorRepository.save(author);
        categoriesRepository.save(category);

        /* ================= USER_BOOK ================= */
        UserBook userBook = new UserBook();
        userBook.setUser(user);
        userBook.setBook(book);
        userBook.setRating(5);
        userBook.setOnShelf(true);
        userBookRepository.save(userBook);

        /* ================= COMMENT ================= */
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setBook(book);
        comment.setText("Excelente livro, bem completo!");
        comment.setCreatedAt(Instant.now());
        commentRepository.save(comment);
    }
}