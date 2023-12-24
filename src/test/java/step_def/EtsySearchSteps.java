package step_def;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import Pages.etsyHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Driver;

public class EtsySearchSteps {
	etsyHomePage etsyhp = new etsyHomePage();
	SoftAssert softAssert = new SoftAssert();

	@Given("I am on the homepage")
	public void i_am_on_the_homepage() {
		Driver.getDriver().get("https://www.etsy.com/");
	}

	@When("I search {string}")
	public void i_search(String item) {
		etsyhp.searchBar.sendKeys(item);
		etsyhp.searchBtn.click();
	}

	@Then("I should see the search item {string} on the result page")
	public void i_should_see_the_search_item_on_the_result_page(String item) {
		List<WebElement> titleElements = Driver.getDriver().findElements(By.cssSelector(".v2-listing-card__title"));
		// Limit to the first 10 elements or fewer if there are fewer than 10
		int numberOfTitlesToCheck = Math.min(titleElements.size(), 10);
		
		// Iterate through the first 3 elements and extract the title
		for (int i = 0; i < numberOfTitlesToCheck; i++) {
			WebElement titleElement = titleElements.get(i);
			String listingTitle = titleElement.getText().trim();
			
			listingTitle = listingTitle.toLowerCase();
//			Assert.assertTrue("this is the item titles: " + listingTitle + " and it doesnt have: "+item,
//					listingTitle.contains(item));
			softAssert.assertTrue(listingTitle.contains(item.toLowerCase()),
					"this is the item titles: " + listingTitle + " and it doesnt have: "+item.toLowerCase());
			
		}
		 softAssert.assertAll();
	}

	@And("the page title should contain the searched item {string}")
	public void the_page_title_should_contain_the_searched_item(String item) {
		String pagetitle = Driver.getDriver().getTitle();
		pagetitle = pagetitle.toLowerCase();
//		Assert.assertTrue("this is the page title: "+pagetitle, pagetitle.contains(item));
		softAssert.assertTrue(pagetitle.contains(item.toLowerCase()), "this is the page title: "+pagetitle.toLowerCase());
		 softAssert.assertAll();
		 
	}

}
