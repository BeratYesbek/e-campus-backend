package com.mb.software.ecampus.core.entities;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mb.software.ecampus.core.crossCuttingConcerns.logging.details.LogDetail;
import com.mb.software.ecampus.core.crossCuttingConcerns.logging.details.LogErrorDetail;
import com.mb.software.ecampus.core.entities.abstracts.DbEntity;
import lombok.*;
import org.springframework.boot.logging.LogLevel;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Data
@Builder
@Table(name = "db_logs")
@AllArgsConstructor
public class DbLog extends DbEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "db_log_id")
    private int id;
    private String logDetail;
    private String message;
    private LogLevel logLevel;
    private Date createdAt;

    public DbLog() {

    }


    public void setCreatedAt() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.createdAt = dateFormat.getCalendar().getTime();
    }


    /**
     * This method must change in the future because it is not suitable SOLID principles
     * @param logErrorDetail
     */

    @SneakyThrows
    public void setLogErrorDetail(LogErrorDetail logErrorDetail) {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        this.logDetail = ow.writeValueAsString(logErrorDetail);
    }

    @SneakyThrows
    public void setLogDetail(LogDetail log) {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        this.logDetail = ow.writeValueAsString(log);
    }

}
