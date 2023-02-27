import java.util.ArrayList;

class Document {
    String name;
    String type;

    Document(String name, String type){
        this.name = name;
        this.type = type;
    }
}

class Folder {
    int folderId;
    String name;
    ArrayList<Folder> subFolders;

    Folder(int folderId, String name){
        this.folderId = folderId;
        this.name = name;
        this.subFolders = new ArrayList<Folder>();
    }
}

class FolderDirectory {
    Folder root;

    void createFolder(int id, String name){
        return new Folder(id, name);
    }

}

public class FolderTree {
    
}
