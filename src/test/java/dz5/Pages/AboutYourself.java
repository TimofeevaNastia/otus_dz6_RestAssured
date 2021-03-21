package dz5.Pages;
import dz5.Driver.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;


@Component
public class AboutYourself extends BaseClass {
    private String cssTabList="[class='nav-sidebar'] a";
    private String cssTabName=cssTabList+"[title='%s']";
    private By by_tabList=By.cssSelector(cssTabList);
    private By by_titleInTab=By.cssSelector("h3.text_pad");

    //получение количества вкладок вертикальных
    public int getCountTab(){
        return driver.findElements(by_tabList).size();
    }

    //переход на вкладку с указанным именем
    public void clickTab(String tabName){
        cssTabName=String.format(cssTabName,tabName);
        By by_tabName=By.cssSelector(cssTabName);
        click(by_tabName);
    }
    //получение заголовка внутри вкладки
    public String getTitleInTab(){
        return getText(by_titleInTab);
    }

}
