package fanout.services;

import org.springframework.stereotype.Service;
import fanout.dto.PlayList;
import fanout.dto.Song;

import java.util.Arrays;
import java.util.List;

@Service
public class MusicService {
    public List<Song> getAllSongs() {
        return Arrays.asList(Mocker.mockSong(),Mocker.mockSong(),Mocker.mockSong(),Mocker.mockSong(),Mocker.mockSong(),Mocker.mockSong(),Mocker.mockSong());
    }

    public List<PlayList> getAllPlaylist() {
        return Arrays.asList(Mocker.mockPlaylist(),Mocker.mockPlaylist(),Mocker.mockPlaylist(),Mocker.mockPlaylist(),Mocker.mockPlaylist(),Mocker.mockPlaylist());
    }

    public Song getSong(int id) {
        return Mocker.mockSong();
    }

    public PlayList getPlaylist(int id) {
        return Mocker.mockPlaylist();
    }

    public PlayList getSimilarPlaylist(int id) {
        return Mocker.mockPlaylist();
    }

    public List<PlayList> getSimilarListPlaylist(int id) {
        return Arrays.asList(Mocker.mockPlaylist(),Mocker.mockPlaylist(),Mocker.mockPlaylist());
    }

    public Song getSimilarSong(int id) {
        return Mocker.mockSong();
    }

    public List<Song> getSimilarListSong(int id) {
        return Arrays.asList(Mocker.mockSong(), Mocker.mockSong(), Mocker.mockSong(), Mocker.mockSong());
    }
}
