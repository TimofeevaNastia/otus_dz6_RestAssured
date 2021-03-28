import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //для get и set
@AllArgsConstructor // генерирует конструктор для всех полей класса
@NoArgsConstructor // для создания конструктора без переменных
@Builder //для создания конструктора с разным количеством переменных
public class User {
    private String email;
    private String firstName;
    private Long id;
    private String lastName;
    private String password;
    private String phone;
    private Long userStatus;
    private String username;
}
