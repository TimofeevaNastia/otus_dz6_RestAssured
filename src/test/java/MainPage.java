import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MainPage{
    private By user_menu_css=By.cssSelector(".header2-menu__item-wrapper__username");
    private WebDriver driver;
    private Actions action;

    public MainPage(WebDriver driver) {
        this.driver = driver; }

    public MainPage personalAccount(){
        //переход в личный кабинет
        action =new Actions(driver);
        action.moveToElement(driver.findElement(user_menu_css)).build().perform();
        driver.findElement(By.linkText("Личный кабинет")).click();
        return this;
    }
    public AboutYourself aboutYourself(){
        //переход на вкладку О себе
        driver.findElement(By.linkText("О себе")).click();
        return new AboutYourself(driver);
    }


}
