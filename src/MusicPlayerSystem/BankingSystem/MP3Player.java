package Day7.MusicPlayerSystem.BankingSystem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MP3Player extends AudioPlayer{
    Queue<String> songList;
    Scanner sc = new Scanner(System.in);
    public MP3Player(int volume, Queue<String> songList){
        super(volume);
        this.songList = songList;
    }
    @Override
    public void volumeControl() {
        System.out.println("Please press + to increment volume, - to decrement it, either to choose the value");
        String choice = sc.nextLine();
        if (choice.equals("-")){
            setVolume(getVolume()-1);
        } else if (choice.equals("+")) {
            setVolume(getVolume()+1);
        }else{
            int newVolume;
            do{
                System.out.println("please enter the volume value from 1 to 50");
                newVolume = sc.nextInt();
                sc.nextLine();
            }while (newVolume<0||newVolume>50);
            setVolume(newVolume);
        }
        System.out.println("The volume in your mp3 player now is "+getVolume());
    }

    @Override
    public void play() {
        setSongStatus(SongStatus.PLAY);
        System.out.println("The song "+songList.peek()+" is now on "+getSongStatus());
    }

    @Override
    public void pause() {
        setSongStatus(SongStatus.PAUSE);
        System.out.println("The song "+songList.peek()+" is now on "+getSongStatus());
    }

    @Override
    public void skip() {
        String skippedSong = this.songList.remove();
        System.out.println("You've skipped "+skippedSong+", now you're playing "+songList.peek());
        setSongStatus(SongStatus.PLAY);
    }

    public void addSong(){
        String songName;
        do{
            System.out.println("Please enter song name");
            songName = sc.nextLine();
        }while (songName==null||songName.isEmpty());
        this.songList.add(songName);
    }
    public void showPlaylist(){
        int i =1;
        for (String str : this.songList){
            System.out.println("Song number "+i+" is "+str);
            i++;
        }
    }
}
