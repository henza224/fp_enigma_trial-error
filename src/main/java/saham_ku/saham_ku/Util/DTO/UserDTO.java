package saham_ku.saham_ku.Util.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    String username;
    Integer balance;
    String role;
}
