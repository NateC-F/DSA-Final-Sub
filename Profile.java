import java.util.Queue;

public class Profile {
    private String accountName;
    private String accountPassword;
    private  Tasks tasks; // Beau Implements

    public Profile(String accountName, String accountPassword, Tasks tasks)
    {
        setAccountName(accountName);
        setAccountPassword(accountPassword);
        setTasks(tasks);

    }

    public boolean logIn(String passAttempt)
    {
        if (passAttempt==accountPassword)
            return true;
        else
            return false;
    }


    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountName) {
        if (accountName!=null)
            this.accountName = accountName;
    }


    public String getAccountPassword() {
        return accountPassword;
    }
    public void setAccountPassword(String accountPassword) {
        if (accountPassword!=null)
            this.accountPassword = accountPassword;
    }


    public Tasks getTasks() {
        return tasks;
    }
    public void setTasks(Tasks tasks) {
        if (tasks != null)
            this.tasks = tasks;
    }
    public String toString()
    {
            return "Username: " + getAccountName() + "\nPassword: "+getAccountPassword() +"\nTasks: "+getTasks();
    }
}
