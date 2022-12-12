package block11uploaddownloadfiles.fileUpDown.aplication;


import block11uploaddownloadfiles.fileUpDown.domain.FileUpDown;

public interface FileUpDownServiceInter {
    //this method is for add a new file from petition
    FileUpDown addFile (FileUpDown fileUpDown) throws Exception;
    //this method is for get a file from database by id
    FileUpDown getFile(Long id) throws Exception;
    //this method is for get a file from database by name
    FileUpDown getFileByName(String name) throws Exception;
}
