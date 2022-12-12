package block11uploaddownloadfiles.fileUpDown.infraestructure.controller.controller;



import block11uploaddownloadfiles.fileUpDown.aplication.FileUpDownService;
import block11uploaddownloadfiles.fileUpDown.domain.FileUpDown;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@RestController
@RequestMapping("/file")
@AllArgsConstructor


public class FileUpDownController {

    @Autowired
    FileUpDownService fileUpDownService;

    //this method is for add a new file from petition
    @PostMapping
    public ResponseEntity addFile (@RequestParam("file") MultipartFile multipartFile, RedirectAttributes redirectAttributes) throws Exception {


        FileUpDown fileUpDown = new FileUpDown();
        Date date =new Date();

        fileUpDown.setName(multipartFile.getOriginalFilename());
        fileUpDown.setSize(multipartFile.getSize());
        fileUpDown.setUploadDate(date);
        fileUpDown.setContent(multipartFile.getBytes());

        return new ResponseEntity<>(fileUpDownService.addFile(fileUpDown), HttpStatus.CREATED);
    }

    //this method is for get a file from database by id
    @GetMapping("/{id}")
    public ResponseEntity getFileById (@PathVariable("id") Long id, FileUpDown fileUpDown) throws Exception {
       String nameFolder = ".//src//main//resources//files//";
        fileUpDown = fileUpDownService.getFile(id);


        if (!(fileUpDown==null)) {
            byte [] file = fileUpDown.getContent();
            Path patch = Paths.get(nameFolder + fileUpDown.getName());
            Files.write(patch,file);
            return  ResponseEntity.status( HttpStatus.OK).body("{\"\":\"Archivo encontrado con exito\"}");

        } else { throw new FileNotFoundException("File not found");

        }

    }

    //this method is for get a file from database by name
    @GetMapping("/name/{name}")
    public ResponseEntity getFileByName (@PathVariable("name") String name, FileUpDown fileUpDown) throws Exception {
        String nameFolder = ".//src//main//resources//files//";
        fileUpDown = fileUpDownService.getFileByName(name);


        if (!(fileUpDown==null)) {
            byte [] file = fileUpDown.getContent();
            Path patch = Paths.get(nameFolder + fileUpDown.getName());
            Files.write(patch,file);
            return ResponseEntity.status( HttpStatus.OK).body("{\"\":\"Archivo encontrado con exito\"}");
        } else { throw new FileNotFoundException("File not found");}


    }

}

