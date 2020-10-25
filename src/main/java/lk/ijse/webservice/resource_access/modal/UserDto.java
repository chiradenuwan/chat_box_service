package lk.ijse.webservice.resource_access.modal;

public class UserDto {
    private int id;
    private String username;
    private String date;

    public UserDto() {
    }

    public UserDto(int id, String username, String date) {
        this.id = id;
        this.username = username;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ChatDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
