package br.com.lgbv.prateleira_inteligente_v2.mocks;

import br.com.lgbv.prateleira_inteligente_v2.entities.AppUser;
import br.com.lgbv.prateleira_inteligente_v2.entities.Author;
import br.com.lgbv.prateleira_inteligente_v2.enums.UserRole;
import br.com.lgbv.prateleira_inteligente_v2.repositories.AuthorRepository;
import br.com.lgbv.prateleira_inteligente_v2.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Mocking {

    private final UserRepository userRepository;
    private final AuthorRepository authorRepository;

    @PostConstruct
    public void loadMock () {
        AppUser user = new AppUser();
        user.setRole(UserRole.USER);
        user.setUsername("Luiz");
        user.setPassword("1234578");

        userRepository.save(user);

        Author author = new Author();
        author.setName("Luiz");

        authorRepository.save(author);


    }
}
