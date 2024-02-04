package Day7.MusicPlayerSystem.BankingSystem;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class MusicLibrary {
    Scanner sc = new Scanner(System.in);
    public void start(){
        String choice;
        do {
            System.out.println("Welcome to the music library! Press m to play with mp3 or c to play with a cd player");
            choice=sc.nextLine();
        }while (!Objects.equals(choice, "m") && !choice.equals("c"));
        if (choice.equals("m")){
            Queue<String> queue = new LinkedList<>();
            int volume;
            int songs;
            do {
                System.out.println("Please enter volume digit");
                volume=sc.nextInt();
            }while (volume<1);
            do {
                System.out.println("Please enter the number of songs you want in this playlist");
                songs=sc.nextInt();
                sc.nextLine();
            }while (songs<1);
            for (int i=0;i<songs;i++){
                System.out.println("Please enter "+(i+1)+" song name");
                queue.add(sc.nextLine());
            }
            MP3Player mp3Player = new MP3Player(volume,queue);
            int secondChoice;
            do {
                do {
                    System.out.println("menu of music library");
                    System.out.println("1 to control volume");
                    System.out.println("2 to pause");
                    System.out.println("3 to play");
                    System.out.println("4 to skip");
                    System.out.println("5 to to add a song to the playlist");
                    System.out.println("6 to to show playlist");
                    System.out.println("7 to exit");
                    secondChoice = sc.nextInt();
                    sc.nextLine();
                } while (secondChoice < 0 || secondChoice > 7);
                switch (secondChoice) {
                    case 1:
                        mp3Player.volumeControl();
                        break;
                    case 2:
                        mp3Player.pause();
                        break;
                    case 3:
                        mp3Player.play();
                        break;
                    case 4:
                        mp3Player.skip();
                        break;
                    case 5 :
                        mp3Player.addSong();
                        break;
                    case 6 :
                        mp3Player.showPlaylist();
                        break;
                    default:
                        return;
                }
                System.out.println("please press enter to continue");
                sc.nextLine();
            }while (true);
        } else {
            String cdName;
            do {
                System.out.println("Please enter the cdName");
                cdName = sc.nextLine();
            }while (cdName == null || cdName.isEmpty());
            int volume;
            do {
                System.out.println("Please enter volume digit");
                volume=sc.nextInt();
            }while (volume<1);
            CDPlayer cdPlayer = new CDPlayer(volume,cdName,CDStatus.INSERTED);
            int secondChoice;
            do {
                do {
                    System.out.println("menu of music library");
                    System.out.println("1 to control volume");
                    System.out.println("2 to pause");
                    System.out.println("3 to play");
                    System.out.println("4 to skip");
                    System.out.println("5 to remove cd");
                    System.out.println("6 to insert a cd");
                    System.out.println("7 to exit");
                    secondChoice = sc.nextInt();
                    sc.nextLine();
                } while (secondChoice < 0 || secondChoice > 7);
                switch (secondChoice) {
                    case 1:
                        cdPlayer.volumeControl();
                        break;
                    case 2:
                        cdPlayer.pause();
                        break;
                    case 3:
                        cdPlayer.play();
                        break;
                    case 4:
                        cdPlayer.skip();
                        break;
                    case 5 :
                        cdPlayer.removeCD();
                        break;
                    case 6 :
                        cdPlayer.insertCD();
                        break;
                    default:
                        return;
                }
                System.out.println("please press enter to continue");
                sc.nextLine();
            }while(true);
        }
    }
}
