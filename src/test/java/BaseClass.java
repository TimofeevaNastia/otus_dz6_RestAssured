import config.ServerConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class BaseClass {

    protected static WebDriver driver;
    public Logger logger = LogManager.getLogger(TestClass.class);
    public ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    //ввод данных в поле (с предварительной очисткой), где text - вводимое значениее, by - локатор поля ввода
    public void setValue(String text,By by){
        WebElement element =  driver.findElement(by);
        element.click();
        element.clear();
        element.sendKeys(text);

    }

    //Выбор значения из выпадающего списка, где field - раскрытие выпадащего списка, data - выбор значения в выпадающем списке
    public void setValueSelect(By field,By data){
        click(field);
        click(data);
    }

    //получение значения атрибута value
    public String getAttributeValue(By by){
       return driver.findElement(by).getAttribute("value");

    }
    //получение текста элемента
    public String getText(By by){
        return driver.findElement(by).getText();

    }

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        logger.info("Драйвер поднят");
        /*//если появляется капча
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=~AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("--profile-directory=Default");
        driver = new ChromeDriver(options);
        */
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(cfg.url1());
        driver.manage().window().maximize();
    }

    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Драйвер закрыт");
        }

    }

    //клик на элемент
    public void click(By element){
        WebElement element2 = new WebDriverWait(driver, 10).until(elementToBeClickable(element));
        int attempts = 0;
        while(attempts < 3) {
            try {
                element2.click();
                break;
            }
            catch(ElementClickInterceptedException e) {
                logger.error("Ошибка ElementClickInterceptedException клика на " + element2);
            }
            catch(StaleElementReferenceException e) {
                logger.error("Ошибка StaleElementReferenceException клика на " + element2);
            }
            attempts++;
        }
    }
}
