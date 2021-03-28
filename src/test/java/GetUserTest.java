import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetUserTest {
    protected UserService userService = new UserService();

    @Test //первый вариант: получение пользователя по username и сравнение полученного пользователя с ожидаемым
    public void getUserTest1(){
        User  userExpected = User.builder()
                .id(78917849L)
                .email("test@email.ru")
                .firstName("Иван")
                .lastName("Иванов")
                .username("UserNameTest")
                .userStatus(10L)
                .build();

        User user=userService.getUser(userExpected.getUsername())
                .then()
                .spec(userService.getResponseSpec())//проверка, что код ответа 200
                .extract()
                .body()
                .as(User.class); //преобразование ответа в класс User

        assertEquals(userExpected.toString(),user.toString()); //сравнение полуенного пользователя с ожидаемым
    }

    @Test//второй вариант: получение пользователя по username и проверка lastName полученного пользователя
    public void getUserTest2(){
        userService.getUser("UserNameTest")
                .then()
                .spec(userService.getResponseSpec())//проверка, что код ответа 200
                .body("lastName",is("Иванов"));//проверка поля lastName в ответе

    }


    @Test//третий вариант: получение пользователя по username и проверка lastName полученного пользователя путём извлечения username из json
    public void getUserTest3() {
        String lastName = userService.getUser("UserNameTest")
                .jsonPath()
                .get("lastName");
        assertEquals("Иванов", lastName);
    }

}
