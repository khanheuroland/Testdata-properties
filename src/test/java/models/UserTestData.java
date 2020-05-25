package models;

public class UserTestData {
    public String Email;
    public String Password;
    public String Message;
    public UserTestData(String email, String password, String message)
    {
        this.Email = email;
        this.Password = password;
        this.Message = message;
    }

    public static UserTestData Load(String data)
    {
        String[] dataParts = data.split("\\|");
        return UserTestData.email(dataParts[0]).password(dataParts[1]).message(dataParts[2]);
    }

    public static UserTestDataBuilder email(String email)
    {
        return new UserTestDataBuilder(email);
    }

    public static class UserTestDataBuilder
    {
        private String Email;
        private String Password;
        private String Message;

        public UserTestDataBuilder(String email)
        {
            this.Email = email;
        }

        public UserTestDataBuilder password(String password)
        {
            this.Password = password;
            return this;
        }

        public UserTestData message(String message)
        {
            return new UserTestData(this.Email, this.Password, message);
        }

    }
}
