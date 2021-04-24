package me.timur.patterns;

/**
 * Created by Timur on 24.04.2021
 */

public class Adapter {
    public static void main(String[] args) {

        Mp3Player mp3Player = new Mp3Player();

        mp3Player.play(AudioType.MP3, "Stairway to heaven");
        mp3Player.play(AudioType.MP4, "Bohemian Rhapsody");
        mp3Player.play(AudioType.VLC, "Gulbadan");
    }
}

interface AdvancedMediaPlayer {
    void playVlc(String file);
    void playMp4(String file);
}

interface MediaPlayer {
    void play(AudioType type, String file);
}

class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String file) { }

    @Override
    public void playMp4(String file) { System.out.println("Play mp4 file: " + file); }
}

class VlcPlayer implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String file) { System.out.println("Play vlc file: " + file);}

    @Override
    public void playMp4(String file) { }
}

class MediaAdapter implements MediaPlayer{

    AdvancedMediaPlayer advancedMediaPlayer;

    @Override
    public void play(AudioType type, String file) {
        switch (type) {
            case MP4:
                advancedMediaPlayer = new Mp4Player();
                advancedMediaPlayer.playMp4(file);
                break;
            case VLC:
                advancedMediaPlayer = new VlcPlayer();
                advancedMediaPlayer.playVlc(file);
                break;
        }
    }

}

class Mp3Player implements MediaPlayer {

    MediaAdapter adapter = new MediaAdapter();

    @Override
    public void play(AudioType type, String file) {
        if (type == AudioType.MP3)
            System.out.println("Play mp3 file: " + file);
        else
            adapter.play(type, file);
    }
}

enum AudioType {
    MP3,
    MP4,
    VLC
}
