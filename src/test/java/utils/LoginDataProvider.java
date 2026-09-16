package utils;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"standard_user", "wrong_password"},
                {"invalid_user", "secret_sauce"},
                {"invalid_user", "wrong_password"}
        };
    }
}