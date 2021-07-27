package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Attributes 
{
	
@FindBy(id="inputEmail")
public static WebElement emailid;

@FindBy(id="inputPassword")
public static WebElement password;


@FindBy(id="submitLogin")
public static WebElement submit;




}
