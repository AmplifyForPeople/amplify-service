package fanout.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fanout.dto.PlayList;
import fanout.dto.Song;
import fanout.services.MusicService;

import java.util.List;

/**
 * Song + Playlist
 */

@RestController
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private MusicService service;

    @GetMapping(value = "/songs/{id}", produces = "application/json")
    public Song getSong(@PathVariable("id") int id) {
        return service.getSong(id);
    }

    @GetMapping(value = "/songs/all", produces = "application/json")
    public List<Song> getAllSongs() {
        return service.getAllSongs();
    }

    @GetMapping(value = "/songs/similar/{id}", produces = "application/json")
    public Song getSimilarSong(@PathVariable("id") int id) {
        return service.getSimilarSong(id);
    }

    @GetMapping(value = "/songs/similarList/{id}", produces = "application/json")
    public List<Song> getSimilarListSong(@PathVariable("id") int id) {
        return service.getSimilarListSong(id);
    }



    @GetMapping(value = "/playlist/{id}", produces = "application/json")
    public PlayList getPlaylist(@PathVariable("id") int id) {
        return service.getPlaylist(id);
    }

    @GetMapping(value = "/playlist/all", produces = "application/json")
    public List<PlayList> getAllPlaylist() {
        return service.getAllPlaylist();
    }

    @GetMapping(value = "/playlist/similar/{id}", produces = "application/json")
    public PlayList getSimilarPlaylist(@PathVariable("id") int id) {
        return service.getSimilarPlaylist(id);
    }

    @GetMapping(value = "/playlist/similarList/{id}", produces = "application/json")
    public List<PlayList> getSimilarPlaylists(@PathVariable("id") int id) {
        return service.getSimilarListPlaylist(id);
    }



}
