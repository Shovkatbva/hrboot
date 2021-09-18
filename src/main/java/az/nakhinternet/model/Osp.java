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
public class Osp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "org_id")
    private Organization organization;
    @ManyToOne
    @JoinColumn(name = "sector_id")
    private Sector sector;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;
    @CreationTimestamp
    private Date data_date;
    @ColumnDefault(value = "1")
    private int active;

}
