package xyz.morlotti.virtualbookcase.userwebsite.beans.forms;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FullUserInfo implements java.io.Serializable
{
     private String password;

     private String firstname;

     private String lastname;

     private String streetNb;

     private String streetName;

     private int postalCode;

     private String city;

     private String country;

     private String email;

     private String sex;
}
