public class ProfileFactory {
    public static Profile createProfile(String userName, String passWord)
    {
            return new Profile(userName, passWord, new Tasks() {
            });
    }
}
