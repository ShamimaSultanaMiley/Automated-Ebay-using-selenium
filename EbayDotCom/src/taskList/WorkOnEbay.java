package taskList;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import base.Base;

public class WorkOnEbay extends Base {
	public static void main(String[] args) throws InterruptedException {
		setUp();
//	Go to ebay.com
		navigateTo("https://www.ebay.com/");

//	Check the search box exist or not		
		WebElement isSerachBoxExists = driver.findElement(By.cssSelector("input#gh-ac")); // tag#id
		Boolean existenceOfSerachBox = isSerachBoxExists.isDisplayed();
		System.out.println("Search Box exists? " + existenceOfSerachBox);

//If search Box exists, search mobile phones in the search box
		if (existenceOfSerachBox == true) {

			// isSerachBoxExists.sendKeys("Mobile Phones");
			sendKeys(By.cssSelector("input#gh-ac"), "mobile phones");
		}

//Check if there is a combo box named all categories
		WebElement allCategoriesComboBox = driver.findElement(By.cssSelector("select#gh-cat")); // tag#id
		Boolean existenceOfAllCategoriesComboBox = allCategoriesComboBox.isDisplayed();
		System.out.println("All Categories DropDown exists? " + existenceOfAllCategoriesComboBox);

//If combo box exists, check how many categories are there?
		if (existenceOfAllCategoriesComboBox == true) {
			allCategoriesComboBox.click();
			List<WebElement> allCategoriesList = driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
			System.out.println("Number of Categories = " + allCategoriesList.size());

//Also check if there is a category named Cell phones & accessories	
//if there is a category named Cell phones & accessories, select it			
			Select select = new Select(driver.findElement(By.xpath("//select[@id='gh-cat']")));
			select.selectByVisibleText("Cell Phones & Accessories");
			System.out.println("Cell Phones & Accessories Category Found. ");

//			for (WebElement category : allCategoriesList) {
//				String categoryText = category.getText();
//				if (categoryText.equals("Cell Phones & Accessories")) {
//					System.out.println("Cell Phones & Accessories Found. ");
//					category.click();
//					break;
//				}

//			}
//Upper code also works fine
		}

//Also check if there is a search button or not 
		Boolean existenceOfSerachButton = driver.findElement(By.cssSelector("input#gh-btn")).isDisplayed();
		System.out.println("Search Button exists? " + existenceOfSerachButton);

//If search button exists, click on the search button		
		if (existenceOfSerachButton == true) {

			click(By.cssSelector("input#gh-btn"));
			System.out.println("Search Button clicked");
		}

//Check if there shows any search result or not
		Boolean existenceOfSerachResult = driver.findElement(By.cssSelector("h1.srp-controls__count-heading"))
				.isDisplayed();
		System.out.println("Search Result exists? " + existenceOfSerachResult);

//Get total result showing for the search tag		
		String totalSearchResult = driver.findElement(By.cssSelector("h1.srp-controls__count-heading span:first-child"))
				.getText();
		System.out.println("Total Search Result =" + totalSearchResult);

//Check if there exists an option Shipping to 		
		WebElement shippingToButton = driver.findElement(By.cssSelector("button.x-flyout__button"));
		Boolean existenceOfShippingToButton = shippingToButton.isDisplayed();
		System.out.println("Shipping To Button exists? " + existenceOfShippingToButton);

//If shipping to exists ,click on that		
		shippingToButton.click();

//There you can update your shipping location and check if there is a text “update your shipping location”
		String updateLocation = driver.findElement(By.cssSelector("p.srp-shipping-location__header")).getText();
		System.out.println("Update your shipping location text = " + updateLocation);

//Check if there exists a combo box for  country selection
		WebElement countrySelectionComboBox = driver
				.findElement(By.cssSelector("div.srp-shipping-location form div:first-of-type"));
		Boolean existenceOfCountry = countrySelectionComboBox.isDisplayed();
		System.out.println("Country selection Box exists? " + existenceOfCountry);
		countrySelectionComboBox.click();

//Also, check how many countries are available in the combo box		
		List<WebElement> countriesList = driver
				.findElements(By.cssSelector("div.srp-shipping-location form div:first-of-type select option"));
		System.out.println("Total Number of Countries = " + countriesList.size());

//Also check ,if there exists “United States – USA”
//If exists ,Select United States – USA		
		Select select = new Select(
				driver.findElement(By.cssSelector("div.srp-shipping-location form div:first-of-type select")));
		select.selectByVisibleText("United States - USA");
		System.out.println("United States - USA Found.");

//	WebElement zipCodeBox =driver.findElement(By.cssSelector("div.srp-shipping-location form div:last-of-type"));
//	Boolean existenceOfzipCodeBox = zipCodeBox.isDisplayed();
//	System.out.println("Zip Code Box exists? " + existenceOfzipCodeBox);
//	if(existenceOfzipCodeBox==true) {
//		Thread.sleep(1000);
//		zipCodeBox.sendKeys("11432");
//		
//	}
//	Thread.sleep(2000);
//	WebElement goButton =driver.findElement(By.cssSelector("input[value='Go']"));
//	Boolean existenceOfGoButton = goButton.isDisplayed();
//	System.out.println("Go Button exists? " + existenceOfGoButton);
//	if(existenceOfGoButton==true) {
//        
//		System.out.println("Go button is clicked");
//	}

//		Now check if there exists textbox for zip code
		WebElement zipCodeBox = driver
				.findElement(By.cssSelector("div.srp-shipping-location form div:last-of-type input"));
		Boolean existenceOfZipCodeBox = zipCodeBox.isDisplayed();
		System.out.println("Zip Code Box exists? " + existenceOfZipCodeBox);

//If exists , type the zip code in that textbox 
		if (existenceOfZipCodeBox) {
			zipCodeBox.click();
			Thread.sleep(1000);

			// Use JavascriptExecutor to set the value directly
			String zipCode = "11432";
			String script = "arguments[0].setAttribute('value', '" + zipCode + "');";

			// Create a JavascriptExecutor instance
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(script, zipCodeBox);

			System.out.println("Zip code is entered");
		}

//Then check if there exists a Button named go
		WebElement goButton = driver.findElement(By.cssSelector("input[value='Go']"));
		Boolean existenceOfGoButton = goButton.isDisplayed();
		System.out.println("Go Button exists? " + existenceOfGoButton);

//If exists ,Click on Go button
		if (existenceOfGoButton) {
			goButton.click();
			System.out.println("Go button is clicked");
		}

	}

}
