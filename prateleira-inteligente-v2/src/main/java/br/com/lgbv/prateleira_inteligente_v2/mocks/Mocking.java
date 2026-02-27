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

        /* ================= USER ================= */
        AppUser user = new AppUser();
        user.setUsername("luiz");
        user.setPassword("123456");
        user.setRole(UserRole.USER);
        userRepository.save(user);

        /* ================= CATEGORY ================= */
        Categories category = new Categories();
        category.setName("Tecnologia");
        categoriesRepository.save(category);

        /* ================= AUTHOR ================= */
        Author author = new Author();
        author.setName("Luiz Gabriel");
        authorRepository.save(author);

        for (int i = 1; i <= 10; i++) {

            /* ================= BOOK ================= */
            Book book = new Book();
            book.setTitle("Spring Boot Avançado " + i);
            book.setDescription("Livro focado em arquitetura backend com Spring Boot - Volume " + i);
            book.setPublisher("Tech Books");
            book.setPublicationDate(LocalDate.of(2024, 1, i));
            book.setScore(4.0 + (i * 0.1));
            book.setAssessmentQuantity(100L + i);

            book.setAuthors(Set.of(author));
            book.setCategories(Set.of(category));

            bookRepository.save(book);

            author.getBooks().add(book);
            category.getBooks().add(book);

            /* ================= USER_BOOK ================= */
            UserBook userBook = new UserBook();
            userBook.setUser(user);
            userBook.setBook(book);
            userBook.setRating(4 + (i % 2));
            userBook.setOnShelf(true);
            userBookRepository.save(userBook);

            /* ================= COMMENT ================= */
            Comment comment = new Comment();
            comment.setUser(user);
            comment.setBook(book);
            comment.setText("Comentário sobre o livro volume " + i);
            comment.setCreatedAt(Instant.now());
            commentRepository.save(comment);
        }

        authorRepository.save(author);
        categoriesRepository.save(category);
    }
}