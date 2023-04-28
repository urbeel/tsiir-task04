package by.urbel.task04.entity;

import by.urbel.task04.entity.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Serial
    private static final long serialVersionUID = 5961203649427194472L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 60)
    private String email;
    @Column(nullable = false, length = 60)
    private String password;
    @Column(nullable = false, length = 45)
    private String firstname;
    @Column(nullable = false, length = 45)
    private String lastname;
    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(length = 20)
    private String phone;
    @Column
    private String address;
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private transient Cart cart;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(this.role);
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
