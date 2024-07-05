package project.saham_ku.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Role;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private Integer balance;

    @Enumerated(EnumType.STRING)
    private Role role;
}
