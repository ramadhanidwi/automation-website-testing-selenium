package testData;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
    @DataProvider(name = "loginData")
    public Object[] loginData(){
        return new Object[]{"standard_user", "secret_sauce"};
    }    
}
