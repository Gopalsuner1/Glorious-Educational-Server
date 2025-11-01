package in.glorious.model;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.annotations.NotThreadSafe;
import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reciep {
    @Id
    private String id;
    @NonNull
    private String reciepNumber;
    @NonNull
    private String session;
    @NonNull
    private String mode;
    @NonNull
    private String utr;
    private String bank;
    private String remark;
    private LocalDate date;
    private Map<String,Integer> heads;
    private int amount;
}
