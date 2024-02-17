/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class User {
    public String UserName;
    public String Image;
    public User() {}

    public String getUserName() {
        return UserName;
    }
    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
    public String getImage() {
        return Image;
    }
    public void setImage(String Image) {
        this.Image = Image;
    }
    public User(String UserName, String Image) {
        this.UserName = UserName;
        this.Image = Image;
    }
}
