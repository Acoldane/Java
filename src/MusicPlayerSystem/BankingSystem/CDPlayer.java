package Day7.MusicPlayerSystem.BankingSystem;

import java.util.Scanner;

public class CDPlayer extends AudioPlayer{
    Scanner sc = new Scanner(System.in);
    private String cdName;
    private CDStatus cdStatus;

    public String getCdName() {
        return cdName;
    }

    public void setCdName(String cdName) {
        this.cdName = cdName;
    }

    public CDStatus getCdStatus() {
        return cdStatus;
    }

    public void setCdStatus(CDStatus cdStatus) {
        this.cdStatus = cdStatus;
    }

    public CDPlayer(int volume, String cdName, CDStatus cdStatus) {
        super(volume);
        this.cdName=cdName;
        this.cdStatus=cdStatus;
        System.out.println(this.cdName+" "+this.cdStatus);
    }

    @Override
    public void volumeControl() {
        System.out.println("Welcome to cd player");
        System.out.println("Please press + to increment volume, - to decrement it, either to choose the value");
        String choice = sc.nextLine();
        if (choice.equals("-")){
            setVolume(getVolume()-1);
        } else if (choice.equals("+")) {
            setVolume(getVolume()+1);
        }else{
            int newVolume;
            do{
                System.out.println("please enter the volume value");
                newVolume = sc.nextInt();
                sc.nextLine();
            }while (newVolume<0);
            setVolume(newVolume);
        }
        System.out.println("The volume in your cd player now is "+getVolume());
    }

    @Override
    public void play() {
        if(cdStatus.equals(CDStatus.INSERTED)) {
            setSongStatus(SongStatus.PLAY);
            System.out.println(cdName + "is on " + getSongStatus());
        }else System.out.println("Please insert a cd");
    }

    @Override
    public void pause() {
        if (getSongStatus().equals(SongStatus.PLAY)) {
            setSongStatus(SongStatus.PAUSE);
            System.out.println(cdName + "is on " + getSongStatus());
        }
    }

    @Override
    public void skip() {
        this.cdStatus=CDStatus.EMPTY;
        System.out.println("Please remove the cd and insert another one if you want to play");
    }
    public  void removeCD(){
        this.cdStatus=CDStatus.EMPTY;
        System.out.println("You've removed the cd, Please insert another one if you want to play");
    }
    public void insertCD(){
        if(cdStatus.equals(CDStatus.EMPTY)) {
            System.out.println("Name of cd you've inserted");
            this.cdName=sc.nextLine();
            this.cdStatus=CDStatus.INSERTED;
        }else System.out.println("Please remove the cd");
    }
}
