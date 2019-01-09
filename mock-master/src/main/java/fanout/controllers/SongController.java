package fanout.controllers;

import com.google.gson.Gson;
import fanout.dto.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fanout.dto.PlayList;
import fanout.dto.Song;
import fanout.services.MusicService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


@RestController
@RequestMapping("/songs")
public class SongController {

    @GetMapping(value = "/{id}", produces = "application/json")
    public Song getId(@PathVariable("id") int id) {
        URL url = null;
        StringBuilder result = null;
        try {
            result = new StringBuilder();
            url = new URL("http://brain.3utilities.com/AmplifyWeb/rest/songs/"+ id);
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
        return new Gson().fromJson(result.toString(), Song.class);
    }

    @GetMapping(value = "/most_voted", produces = "application/json")
    public String getMostvoted() {
        URL url = null;
        StringBuilder result = null;
        try {
            result = new StringBuilder();
            url = new URL("http://brain.3utilities.com/AmplifyWeb/rest/songs/most_voted");
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
        return result.toString();
    }


}
