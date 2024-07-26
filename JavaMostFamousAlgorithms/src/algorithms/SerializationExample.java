import java.io.*;

public class SerializationExample {
    public static void main(String[] args) {
        UserDetails ud = new UserDetails(1, "Suresh", "Hyderabad");
        System.out.println("Before serialization the object contains: ");
        ud.getDetails();
        String fpath = "D:\\Test.txt";

        // Check if file exists
        File file = new File(fpath);
        if (file.exists()) {
            file.delete();
        }

        // Opens a file and serializes the object into it in binary format.
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fpath))) {
            oos.writeObject(ud);
            System.out.println("\nSerialization Successful");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class UserDetails implements Serializable {
    private int userId;
    private String userName;
    private String location;

    public UserDetails(int id, String name, String place) {
        this.userId = id;
        this.userName = name;
        this.location = place;
    }

    public void getDetails() {
        System.out.println("UserId: " + userId);
        System.out.println("UserName: " + userName);
        System.out.println("Location: " + location);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
