import org.junit.*;
import org.junit.rules.ErrorCollector;
import static org.hamcrest.CoreMatchers.is;


public class TestClass extends BaseClass{
    private String name="Иван";
    private String last_name="Иванов";
    private String name_lat="Ivan";
    private String last_name_lat="Ivanov";
    private String data_birth="01.12.1995";
    private String country="Россия";
    private String city="Самара";
    private String english="Начальный уровень (Beginner)";
    private String contact_vk_value="https://vk.com/";
    private String contact_vk="VK";
    private String contact_ok_value="https://ok.ru/";
    private String contact_ok="OK";
    private String company="OAO ИТ";
    private String post="QA";
    private String gender_set="f";
    private String gender_get="Женский";

    @Test
    public void test(){
        setPersonalData();//ввод данных
        setDown();
        setUp();
        getPersonalData();//проверка введенных данных
    }

    private void setPersonalData() {
        AboutYourself aboutYourself=new Authorization(driver).auth(cfg.login(),cfg.passwors())
        .personalAccount().aboutYourself();
        logger.info("Вход и Переход на вкладку О себе");
        logger.info("Заполнение данных о себе и сохранение");
        aboutYourself.setName(name);//ввод имени
        aboutYourself.setLastName(last_name);//ввод фамилли
        aboutYourself.setBlogName(name);//ввод имени для блока
        aboutYourself.setNameLat(name_lat);//ввод имени латиницей
        aboutYourself.setLastNameLat(last_name_lat);//ввод фамилии латиницей
        aboutYourself.setDateBirth(data_birth);//ввод даты рождения
        aboutYourself.setCountry(country);//выбор страны
        aboutYourself.setCity(city);//выбор города
        aboutYourself.setLang(english);//выбор уровня языка
        aboutYourself.setFormatJob(0);//отметка формата работы "полный день"
        aboutYourself.setFormatJob(2);//отметка формата работы "удалённо"
        aboutYourself.setContact("0",contact_ok,contact_ok_value);//выбор и ввод первого контакта
        aboutYourself.setContact("1",contact_vk,contact_vk_value);//выбор и ввод второго контакта
        aboutYourself.setGender(gender_set);//выбор пола
        aboutYourself.setComppany(company);//ввод компании
        aboutYourself.setPost(post);//ввод должности
        logger.info("Данные о себе заполнены");
        aboutYourself.save();
        logger.info("Изменения сохранены");
    }

    private void getPersonalData(){
        AboutYourself aboutYourself=new Authorization(driver)
                .auth(cfg.login(),cfg.passwors())
                .personalAccount()
                .aboutYourself();
        logger.info("Вход и Переход на вкладку О себе");
        logger.info("Проверка данных о себе");
        collector.checkThat(aboutYourself.getName(),is(name));//проверка имени
        collector.checkThat(aboutYourself.getLastName(),is(last_name));//проверка фамилли
        collector.checkThat(aboutYourself.getBlogName(),is(name));//проверка имени блога
        collector.checkThat(aboutYourself.getNameLat(),is(name_lat));//проверка имени латиницей
        collector.checkThat(aboutYourself.getLastNameLat(),is(last_name_lat));//проверка фамилли латиницей
        collector.checkThat(aboutYourself.getDateBirth(),is(data_birth));//проверка даты рождения
        collector.checkThat(aboutYourself.getCountry(),is(country));//проверка страны
        collector.checkThat(aboutYourself.getCity(),is(city));//проверка города
        collector.checkThat(aboutYourself.getLang(),is(english));//проверка уровня языкка
        collector.checkThat(aboutYourself.getFormatJob(0),is(true));//проверка, что отмечен первый формат работы
        collector.checkThat(aboutYourself.getFormatJob(1),is(false));//проверка, что не отмечен второй формат работы
        collector.checkThat(aboutYourself.getFormatJob(2),is(true));//проверка, что отмечен третий формат работы
        collector.checkThat(aboutYourself.getTypeContact("0"),is(contact_ok));//проверка типа первого контакта
        collector.checkThat(aboutYourself.getValueContact("0"),is(contact_ok_value));//проверка значения первого контакта
        collector.checkThat(aboutYourself.getTypeContact("1"),is(contact_vk));//проверка типа второго контакта
        collector.checkThat(aboutYourself.getValueContact("1"),is(contact_vk_value));//проверка значения второго контакта
        collector.checkThat(aboutYourself.getGender(),is(gender_get));//проверка пола
        collector.checkThat(aboutYourself.getComppany(),is(company));//проверка компании
        collector.checkThat(aboutYourself.getPost(),is(post));//проверка должности
        logger.info("Данные проверены");
    }

    @Rule
    public ErrorCollector collector = new ErrorCollector();

}
