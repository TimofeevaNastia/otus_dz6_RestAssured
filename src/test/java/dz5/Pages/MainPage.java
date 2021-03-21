package dz5.Pages;
import dz5.Driver.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;

@Component
public class MainPage extends BaseClass {
    private By user_menu_css=By.cssSelector(".header2-menu__item-wrapper__username");
    private String  xpathtab_menu="//*[contains(@class,'header2-menu_main')]//p[text()='%s']";
    private String  xpathSubtab_menu="//a[@title='%s']/div";
    private String  xpathSubtab_menuAdd="/parent::*/parent::*//*[@title='Еще курсы']/div";
    private String  cssListTabMenu=".header2-menu_main>div:nth-of-type(%d) a.header2-menu__dropdown-link";
    private By user_menu_list=By.cssSelector(".header2-menu__dropdown_right>a.header2-menu__dropdown-link_no-wrap");
    private By user_tab_list=By.xpath("//*[@class='nav nav_mobile-fix no-print js-overflow-scroll']//a");
    private By by_titleH1=By.cssSelector("h1.title__text");
    private By by_activeTab=By.cssSelector(".nav__items>a.nav__item_active");
    private By  enter=By.cssSelector(".js-open-modal");
    private By login_field=By.cssSelector("[action='/login/'] [name='email']");
    private By password_field=By.name("password");
    private String xpathListCoursesOfTab="//a[@title='%s']/following-sibling::div[@class='header2-menu__subdropdown']//a";
    private String btn_enter=".new-input-line_relative .new-button_md";
    private Actions action;


    //переход по ссылке с указанным именем
    public void goToLink(String section){
        click(By.linkText(section));
    }

    //навигация на профиль пользователя
    public MainPage moveInpersonalAccount(){
        action =new Actions(driver);
        action.moveToElement(driver.findElement(user_menu_css)).build().perform();
        return this;
    }
    //навигация на вкладку с разделами
    public MainPage moveInTabMenu(String nameTab){
        xpathtab_menu=String.format(xpathtab_menu,nameTab);
        By by_tab_menu=By.xpath(xpathtab_menu);
        action =new Actions(driver);
        action.moveToElement(driver.findElement(by_tab_menu)).build().perform();
        return this;
    }

    //навигация на вкладку внутри вкладки с разделами
    public MainPage moveInSubTabMenu(String nameTab){
        xpathSubtab_menu=String.format(xpathSubtab_menu,nameTab);
        By by_tab_menu=By.xpath(xpathSubtab_menu);
        action =new Actions(driver);
        action.moveToElement(driver.findElement(by_tab_menu)).build().perform();
        return this;
    }

    //навигация на "Еще" внутри вложенной вкладки
    public MainPage moveInSubTabMenuAdd(){
        xpathSubtab_menu+=xpathSubtab_menuAdd;
        By by_tab_menu=By.xpath(xpathSubtab_menu);
        action =new Actions(driver);
        action.moveToElement(driver.findElement(by_tab_menu)).build().perform();
        return this;
    }
    //получение количества ссылок вкладки
    public int getCountItemInTabInMainForm(int number){
        cssListTabMenu=String.format(cssListTabMenu,number);
        By byListTabMenu=By.cssSelector(cssListTabMenu);
        return driver.findElements(byListTabMenu).size();
    }

    //подсчет количества курсов в разделе
    public int getCountOfCourseListOfTab(String text){
        xpathListCoursesOfTab=String.format(xpathListCoursesOfTab,text);
        return driver.findElements(By.xpath(xpathListCoursesOfTab)).size();
    }

    public AboutYourself aboutYourself(){
        //переход на вкладку О себе
        driver.findElement(By.linkText("О себе")).click();
        return new AboutYourself();
    }
    public String getTitle(){
        return driver.getTitle();
    }


//получение количества пунктов выпадающем списке пользователя
    public int getCountListtUserMenu(){
        return driver.findElements(user_menu_list).size();
    }
    //получение количества вкладок в личном кабинете
    public int getCountPersonalTab(){
        return driver.findElements(user_tab_list).size();
    }
    //получение заголовка над вкладками
    public String getMainTitle(){
        return driver.findElement(by_titleH1).getText();
    }

    //получение заголовка над вкладками
    public String activeTab(){
        return driver.findElement(by_activeTab).getAttribute("title");
    }

    public MainPage clickEnter(){
        //клик на вход
        driver.findElement(enter).click();
        return this;
    }

    public MainPage auth(String login, String password){
        //ввод логина и пароля
        driver.findElement(login_field).sendKeys(login);
        driver.findElement(password_field).sendKeys(password);
        //нажатие кнопки Войти
        driver.findElement(By.cssSelector(btn_enter)).click();
        return this;
    }


}
