import java.util.ArrayList;
import java.util.Scanner;

// interface SongDetails {
//     String genre;
//     String artistName;
//     String releaseDate; 

//     void displayDetails();
//     void addDetails(String genre, String artistName, String releaseDate);
// }

class Song {
    int songId;
    String name;
    Song next;
    Song prev;

    Song(int songId, String name){
        this.songId = songId;
        this.name = name;
        this.next = null;
        this.prev = null;
    }

}

class MusicPlayer {
    Song head = null;
    Song state = null;

    Song createSongObject(int id, String name){
        return new Song(id, name);
    }

    Song getBySongId(int songId){
        Song current = head;
        while(current.next != null){
            if(current.songId == songId){
                return current;
            }
            current = current.next;
        }
        return null;
    }

    Song prevSong(Song songObj){
        Song current = songObj;
        if(current.prev != null){
            return current.prev;
        }
        return null;
    }

    Song nextSong(Song songObj){
        Song current = songObj;
        if(current.next != null){
            return current.next;
        }
        return null;
    }

    void musicList(){
        Song current = head;
        while(current != null){
            System.out.println(current.songId + " " + current.name);
            current = current.next;
        }
    }

    void addSongToList(Song songObj){
        if(head == null){
            head = songObj;
        }
        else {
            Song current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = songObj;
            songObj.prev = current;
            current = songObj;
        }
    }

    void addSongAtPos(Song songObj, int songId){
        if(head == null){
            head = songObj;
        }
        else {
            Song current = getBySongId(songId);
            Song saveNext = current.next;
            current.next = songObj;
            songObj.prev = current;
            songObj.next = saveNext;
            saveNext.prev = songObj;
        }
    }

    void playSong(int songId){
        Song currentSong = this.getBySongId(songId);
        if(currentSong != null) {
            this.setSongState(currentSong);
        }
        else System.out.print("No song found");
    }

    /* Current Song Playing */
    void setSongState(Song songObj){
        state = songObj;
        System.out.println("Currently Playing : " +  songObj.songId + songObj.name);
    }

    void playNext(){
        this.setSongState(this.nextSong(state));
    }

    void playPrev(){
        this.setSongState(this.prevSong(state));
    }

}

public class DoublyLinkedList {

    public static void main(String[] args) {
        MusicPlayer musicPlayerObj = new MusicPlayer();
        musicPlayerObj.addSongToList(musicPlayerObj.createSongObject(1, "kahani suno"));
        musicPlayerObj.addSongToList(musicPlayerObj.createSongObject(2, "mere humsafar"));
        musicPlayerObj.addSongToList(musicPlayerObj.createSongObject(3, "jo tu na mila"));
        musicPlayerObj.addSongToList(musicPlayerObj.createSongObject(4, "ishqiya"));
        musicPlayerObj.addSongToList(musicPlayerObj.createSongObject(5, "pasoori"));
        musicPlayerObj.addSongToList(musicPlayerObj.createSongObject(6, "chidiya"));
        musicPlayerObj.addSongToList(musicPlayerObj.createSongObject(7, "dil nu"));
        musicPlayerObj.musicList();
        // Scanner sc = new Scanner(System.in);
        // int i = sc.nextInt();
        musicPlayerObj.playSong(3);
        musicPlayerObj.playNext();
        musicPlayerObj.playPrev();
        musicPlayerObj.playPrev();
        musicPlayerObj.playNext();
        System.out.println("Completed Process");
        musicPlayerObj.musicList();
    }

}
