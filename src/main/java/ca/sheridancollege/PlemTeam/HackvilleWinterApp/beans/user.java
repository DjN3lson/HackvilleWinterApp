package ca.sheridancollege.PlemTeam.HackvilleWinterApp.beans;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@NoArgsConstructor
@Data


@Document("Users")
public class user {

    @Id
    private String id;

    @Field
    private String fname;

    @Field
    private String lname;

    @Field
    private int age;

    @Field
    private String country;

    @Field
    private String email;

    @Field
    private String password;

    @Transient
    private String[] spanishSpeakingCountries = {
            "Spain", "Mexico", "Colombia", "Argentina", "Peru", "Venezuela",
            "Chile", "Ecuador", "Guatemala", "Cuba", "Dominican Republic",
            "Honduras", "Paraguay", "El Salvador", "Nicaragua", "Costa Rica",
            "Puerto Rico", "Panama", "Uruguay", "Equatorial Guinea",
            "Bolivia", "Equatorial Guinea", "Andorra", "Western Sahara"
    };

    public user(String fname, String lname, int age, String country, String email, String password) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.country = country;
        this.email = email;
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSpanishSpeakingCountries(String[] spanishSpeakingCountries) {
        this.spanishSpeakingCountries = spanishSpeakingCountries;
    }

    public String getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String[] getSpanishSpeakingCountries() {
        return spanishSpeakingCountries;
    }
}
