package testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Assert.*;
import utils.TokenManager;

public class AuthAccessTest
{
	//to get access token and validtae it
	@Test(description="To get access_token with valid credentials")
	public static void getAccessToken()
	{
		String access_token = TokenManager.getToken();
		Assert.assertNotNull(access_token , "Check access_token is not null");
	}
}
