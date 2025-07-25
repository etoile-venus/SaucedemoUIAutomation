package saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import saucedemo.asserts.ItemAssert;
import saucedemo.base.BasePage;
import saucedemo.utilities.Route;

public class ItemPage extends BasePage {

    public ItemPage(WebDriver driver) {
        super(driver);
        super.url += Route.ITEM;
    }

    @Override
    public void waitForPageToLoad() {
        getPrice();
    }

    public ItemAssert assertThat() {
        return new ItemAssert(driver, this);
    }

    private final By backToProducts = By.id("back-to-products");
    private final By image = By.className("inventory_details_img");
    private final By title = By.className("inventory_details_name");
    private final By description = By.className("inventory_details_desc");;
    private final By price = By.className("inventory_details_price");;
    private final By addButton = By.id("add-to-cart");
    private final By removeButton = By.id("remove");

    public WebElement getBackToProducts(){
        return wait.until(ExpectedConditions.elementToBeClickable(backToProducts));
    }
    public WebElement getImage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(image));
    }
    public WebElement getTitle(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title));
    }
    public WebElement getDescription(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(description));
    }
    public WebElement getPrice(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(price));
    }
    public WebElement getAddButton(){
        return wait.until(ExpectedConditions.elementToBeClickable(addButton));
    }
    public WebElement getRemoveButton() {return wait.until(ExpectedConditions.elementToBeClickable(removeButton));}

    public String getTitleText(){
        return getTitle().getText().trim();
    }
    public String getDescriptionText(){
        return getDescription().getText().trim();
    }
    public String getPriceText(){
        return getPrice().getText();
    }
    public double getPriceValue(){
        return Double.parseDouble(getPriceText().substring(1));
    }
    public String getImageSrc(){
        return getImage().getAttribute("src");
    }
    public String getAddButtonName(){
        return getAddButton().getText().trim();
    }
    public String getRemoveButtonName(){
        return getRemoveButton().getText().trim();
    }

    public ItemPage clickOnAddButton(){
        getAddButton().click();
        return this;
    }
    public ItemPage clickOnRemoveButton(){
        getRemoveButton().click();
        return this;
    }
    public String getId(){
        return driver.getCurrentUrl().split("=")[1];
    }
    public HomePage clickOnBackToProductsButton(){
        getBackToProducts().click();
        HomePage homePage = new HomePage(driver);
        homePage.waitForPageToLoad();
        return homePage;
    }


}
