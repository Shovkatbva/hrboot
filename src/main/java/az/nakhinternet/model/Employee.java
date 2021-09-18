package az.nakhinternet.model;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@DynamicInsert
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String father_name;
    private Date dob;
    private String note;
    @ManyToOne
    @JoinColumn(name = "osp_id")
    private Osp osp;
    private String picture;
    @CreationTimestamp
    private Date data_date;
    @ColumnDefault(value = "1")
    private int active;


}
