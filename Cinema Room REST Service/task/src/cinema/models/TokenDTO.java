package cinema.models;


//  author:  ValitovGaziz
//  date:    21.02.2022
//  project: Cinema Room REST Service

public class TokenDTO {

    String token;

    public TokenDTO() {
    }

    public TokenDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
