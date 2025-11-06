package in.glorious.dto;

import com.mongodb.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterRequest {
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String scholar;
}
