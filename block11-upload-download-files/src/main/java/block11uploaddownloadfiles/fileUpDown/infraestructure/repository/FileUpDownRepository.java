package block11uploaddownloadfiles.fileUpDown.infraestructure.repository;



import block11uploaddownloadfiles.fileUpDown.domain.FileUpDown;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FileUpDownRepository extends JpaRepository<FileUpDown, Long> {
    FileUpDown getByName(String name);
}
