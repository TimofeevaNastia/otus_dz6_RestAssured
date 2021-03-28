import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class UserService {

    private static String URI="https://petstore.swagger.io/v2";
    private static String basePath="/user";
    private RequestSpecification reqSpec;
    private ResponseSpecification respSpec;

    public UserService( ){
        reqSpec=given()  //вынесены повторяющиеся спецификация для post запроса
                .baseUri(URI) //адрес, куда отправляется запрос
                .basePath(basePath)
                .contentType(ContentType.JSON); //тип Json, XML  т.д
        //respSpec=new ResponseSpecBuilder().expectStatusCode(200).build();// вынесена повторяющаяся проверка на код 200 (1-ый вариант)
        respSpec=given().then().statusCode(200);// вынесена повторяющаяся проверка на код 200 (2-ой вариант)
    }

    //получение спецификации
    public ResponseSpecification getResponseSpec(){
        return this.respSpec;
    }

    //post запрос создания пользователя
    public Response createUser(User user) {
        return
                given(reqSpec)
                        .body(user)
                        .when()
                        .post(); //вид запроса
    }
    //get запрос получения пользователя по username
    public Response getUser(String username){
        return
                given().
                        baseUri(URI) //адрес, куда отправляется запрос
                        .basePath(basePath+"/"+username)
                        .when() //куда отправляем
                        .get();//вид запроса
    }

}
