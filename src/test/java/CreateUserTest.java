import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateUserTest  {
    protected UserService userService = new UserService();


    @Test//первый вариант: проверка успешного создания пользователя и проверка поля type в ответе
    public void createUserTest(){
        User userSet = User.builder()
                .email("test@email.ru")
                .firstName("Иван")
                .lastName("Иванов")
                .username("UserName")
                .build();
        userService.createUser(userSet)
                .then()
                .spec(userService.getResponseSpec()) //повторящая проверка на код 200 вынесена в ResponseSpecification
                .body("type",equalTo("unknown"));
    }

    @Test//второй вариант:  проверка успешного создания с помощью преобразования ответа json в класс
    public void createUserTest2(){
        User userSet = User.builder()
                .email("test@email.ru")
                .firstName("Иван")
                .lastName("Иванов")
                .username("UserNameTest")
                .userStatus(10L)
                .build();
       Long outMessage=userService.createUser(userSet)
                .then()
                .extract()
                .body()
        .as(UserOut.class)
        .getCode();
        assertEquals(200,outMessage);
    }


}
