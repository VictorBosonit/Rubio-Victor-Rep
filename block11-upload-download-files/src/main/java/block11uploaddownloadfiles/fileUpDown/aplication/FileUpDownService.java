package block11uploaddownloadfiles.fileUpDown.aplication;

import block11uploaddownloadfiles.fileUpDown.domain.FileUpDown;
import block11uploaddownloadfiles.fileUpDown.infraestructure.repository.FileUpDownRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FileUpDownService implements FileUpDownServiceInter {

    @Autowired
    FileUpDownRepository fileUpDownRepository;
    //this method is for add a new file from petition
    @Override
    public FileUpDown addFile(FileUpDown fileUpDown) throws Exception {
        return fileUpDownRepository.save(fileUpDown);
    }
    //this method is for get a file from database by id
    @Override
    public FileUpDown getFile(Long id) throws Exception {
        return fileUpDownRepository.getReferenceById(id);
    }
    //this method is for get a file from database by name
    @Override
    public FileUpDown getFileByName(String name) throws Exception {
        return fileUpDownRepository.getByName(name);
    }
}
