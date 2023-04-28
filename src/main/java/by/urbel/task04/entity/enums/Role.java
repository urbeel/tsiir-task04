package by.urbel.task04.entity.enums;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.springframework.security.core.GrantedAuthority;

@FieldNameConstants
@RequiredArgsConstructor
public enum Role implements GrantedAuthority {
    ROLE_ADMIN(Constants.ADMIN_ROLE),
    ROLE_CUSTOMER(Constants.CUSTOMER_ROLE);

    private final String value;

    @Override
    public String getAuthority() {
        return this.value;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Constants {
        public static final String ADMIN_ROLE = "ROLE_ADMIN";
        public static final String CUSTOMER_ROLE = "ROLE_CUSTOMER";
    }
}
