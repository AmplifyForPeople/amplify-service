package fanout.controllers;

import com.google.gson.Gson;
import fanout.dto.User;
import messaging.Messaging;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping(value = "/{id}", produces = "application/json")
    public User getId(@PathVariable("id") int id) {
        URL url = null;
        StringBuilder result = null;
        try {
            result = new StringBuilder();
            url = new URL("http://brain.3utilities.com/AmplifyWeb/rest/users/"+ id);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept","application/json");

            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
            con.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        };

        try {
            Messaging.sendCommonMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Gson().fromJson(result.toString(), User.class);
    }

}
