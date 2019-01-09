package fanout.services;

import fanout.dto.*;

import java.util.concurrent.ThreadLocalRandom;

public class Mocker {

    private static int mockId() {
        return ThreadLocalRandom.current().nextInt(999);
    }

    private static float mockFloat() {
        return 12.5f;
    }

    private static String mockPhone() {
        return String.format("%s%s%s%s%s%s",
                mockId(),
                mockId(),
                mockId(),
                mockId(),
                mockId(),
                mockId());
    }

    private static String mockName() {
        return "Name " + String.valueOf(mockId());
    }

    private static String mockEmail() {
        return "email" + String.valueOf(mockId()) + "@email.com";
    }


    public static Client mockClient() {
        Client c = new Client();
        c.id = mockId();
        c.email = mockEmail();
        c.name = mockName();
        c.phone = mockPhone();
        c.establishment = mockEstablishment();
        return c;
    }

    public static Establishment mockEstablishment() {
        Establishment e = new Establishment();
        e.id = mockId();
        e.name = mockName();
        //e.genres = new Genre[]{mockGenre(),mockGenre(),mockGenre(),mockGenre(),mockGenre()};
        e.imatge = "image.jpg";
        e.info = "info";
        //e.playlists = new PlayList[]{mockPlaylist(), mockPlaylist()};
        e.position_lat = mockFloat();
        e.position_lng = mockFloat();
        //e.userinestablishments = new UserInEstablishment[]{mockUserInEstablishment(e.id)};
        return e;
    }

    public static UserInEstablishment mockUserInEstablishment(int id) {
        UserInEstablishment u = new UserInEstablishment();
        u.id = mockId();
        u.user = mockUser();
        return u;
    }

    public static User mockUser() {
        User u = new User();
        u.id = mockId();
        u.age = mockId();
        u.city = mockName();
        u.email = mockEmail();
        u.genres = new Genre[]{mockGenre(), mockGenre()};
        u.name = mockName();
        u.password = mockName();
        u.songs = new Song[]{mockSong(),mockSong(),mockSong(),mockSong(),mockSong(),mockSong(),mockSong(),mockSong(),mockSong()};
        u.votes = new Vote[]{mockVote(),mockVote(),mockVote(),mockVote(),mockVote(),mockVote(), mockVote()};
        return u;
    }

    public static Vote mockVote() {
        Vote v = new Vote();
        v.id = mockId();
        v.like_point = mockId();
        return v;
    }

    public static Song mockSong() {
        Song s = new Song();
        s.id = mockId();
        s.name = mockName();
        s.album = mockName();
        s.author = mockName();
        s.image = "image.jpg";
        s.votes = new Vote[]{mockVote(), mockVote(),mockVote(),mockVote(),mockVote(),mockVote(),mockVote()};
        return s;
    }

    public static PlayList mockPlaylist() {
        PlayList p = new PlayList();
        p.id = mockId();
        p.current = false;
        p.songs = new Song[]{mockSong(),mockSong(),mockSong(),mockSong(),mockSong(),mockSong(),mockSong(),mockSong(),mockSong()};
        return p;
    }


    public static Genre mockGenre() {
        Genre g = new Genre();
        g.id = mockId();
        g.name = mockName();
        return g;
    }


}
