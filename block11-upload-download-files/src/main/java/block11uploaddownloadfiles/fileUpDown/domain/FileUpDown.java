package block11uploaddownloadfiles.fileUpDown.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class FileUpDown {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private long size;

    private Date uploadDate;

    private byte[] content;


}
