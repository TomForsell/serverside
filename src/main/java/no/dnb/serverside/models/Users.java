package no.dnb.serverside.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
@Getter
@Setter
@ToString
@Entity
@Table(name="USERS")
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = -1;
   private  String userName;
   private  String password;
   private boolean isadmin;

    public Users() {
    }
}
