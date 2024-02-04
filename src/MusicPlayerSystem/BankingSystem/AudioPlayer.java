package Day7.MusicPlayerSystem.BankingSystem;

public abstract class AudioPlayer implements Playable{
    private SongStatus songStatus;
    private int volume;


    public AudioPlayer(int volume) {
        this.volume = volume;
    }
    public SongStatus getSongStatus() {
        return this.songStatus;
    }

    public void setSongStatus(SongStatus songStatus) {
        this.songStatus = songStatus;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public abstract void volumeControl();
}
