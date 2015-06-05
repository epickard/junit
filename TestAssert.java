package junitAssert;

import org.junit.*;
import org.junit.internal.runners.statements.Fail;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;

//Checkpoint checkin; dev in progress
public class TestAssert {
	
	
	//Create instance of Firefox driver
	WebDriver driver = new FirefoxDriver();
	
	//Create Class variables
	String id;
	
	@Before
	public void setup() {
		//Navigate to News home
		driver.get("http://news.google.com");
	}
	
	@Test
	public void searchVanillaTerm_shouldReturnResult() {
		//Search for vanilla case
		driver.findElement(By.id("gbqfq")).sendKeys("galette des rois");
		//Click enter
		driver.findElement(By.id("gbqfb")).click();
		
		//Wait for page to load
		//WebDriverWait wait = new WebDriverWait(driver, 5);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
		
		//Assert search results found
		id = driver.findElement(By.id("resultStats")).getAttribute("id");
		assertThat(id, is("resultStats"));
	}
	
	@Test
	public void searchBoundaryNoTerm_shouldNotExecuteSearch() {
		//Search for vanilla case
		driver.findElement(By.id("gbqfq")).sendKeys("");
		//Click enter
		driver.findElement(By.id("gbqfb")).click();
		
		//Assert that URL of current page is still news.google.com
		id = driver.getCurrentUrl();
		assertThat(id, is("http://news.google.com/"));
	}
	
	@Test
	public void searchBoundaryWordLimit_shouldSearchWithNoTruncationMsg() {
		//Search with max words allowable (32)
		driver.findElement(By.id("gbqfq")).sendKeys("one two three four five six seven eight nine ten eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen twenty twentyone twentytwo twentythree twentyfour twentyfive twentysix twentyseven twentyeight twentynine thirty thirtyone thirtytwo");
		//Click enter
		driver.findElement(By.id("gbqfb")).click();
		
		//Assertion here
	}
	
	@Test
	public void searchBoundaryWordLimitPlusOne_shouldSearchWithTruncationMsg() {		
		//Search with max words allowable plus one (33)
		driver.findElement(By.id("gbqfq")).sendKeys("one two three four five six seven eight nine ten eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen twenty twentyone twentytwo twentythree twentyfour twentyfive twentysix twentyseven twentyeight twentynine thirty thirtyone thirtytwo thirtythree");
		//Click enter
		driver.findElement(By.id("gbqfb")).click();
		
		//Assertion here
		id = driver.findElement(By.xpath("//div[contains(@class, 'std uc card-section f ucm')]")).getText();
		String strOut = id.substring(14);
		assertThat(strOut, is("(and any subsequent words) was ignored because we limit queries to 32 words."));
	}
	
	@Test
	public void searchBoundaryWordLimitBeforeError_shouldSearchWithTruncationMsg() {
		//Search with max words allowable before error message (113)
		driver.findElement(By.id("gbqfq")).sendKeys("one two three four five six seven eight nine ten eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen twenty twentyone twentytwo twentythree twentyfour twentyfive twentysix twentyseven twentyeight twentynine thirty thirtyone thirtytwo thirtythree thirtyfour thirty-five thirty-six thirty-seven thirty-eight thirtynine forty fourteen forty-two forty-three fortyfour forty-five one two three four five six seven eight nine ten eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen twenty twentyone twentytwo twentythree twentyfour twentyfive twentysix twentyseven twentyeight twentynine thirty thirtyone thirtytwo thirtythree thirtyfour thirty-five thirty-six thirty-seven thirty-eight thirtynine forty fourteen forty-two forty-three fortyfour forty-five one two three four five six seven eight nine ten eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen onehundrednine onehundredten eleven twelve onehundredthirteen");
		//Click enter
		driver.findElement(By.id("gbqfb")).click();
		
		//Assertion here
	}
	
	@Test
	public void searchBoundaryWordLimitBeforeErrorPlusOne_shouldDisplayErrorMsg() {
		//Search with max words allowable before error message (114)
		driver.findElement(By.id("gbqfq")).sendKeys("one two three four five six seven eight nine ten eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen twenty twentyone twentytwo twentythree twentyfour twentyfive twentysix twentyseven twentyeight twentynine thirty thirtyone thirtytwo thirtythree thirtyfour thirty-five thirty-six thirty-seven thirty-eight thirtynine forty fourteen forty-two forty-three fortyfour forty-five one two three four five six seven eight nine ten eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen twenty twentyone twentytwo twentythree twentyfour twentyfive twentysix twentyseven twentyeight twentynine thirty thirtyone thirtytwo thirtythree thirtyfour thirty-five thirty-six thirty-seven thirty-eight thirtynine forty fourteen forty-two forty-three fortyfour forty-five one two three four five six seven eight nine ten eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen onehundrednine onehundredten eleven twelve thirteen onehundredfourteen");
		//Click enter
		driver.findElement(By.id("gbqfb")).click();
		
		//Assertion here
	}
}
