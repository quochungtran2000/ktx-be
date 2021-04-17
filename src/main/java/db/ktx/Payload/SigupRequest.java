package db.ktx.Payload;

import lombok.Data;

import java.util.Set;

@Data
public class SigupRequest {
    private String username;
    private String password;
    private Set<String> role;
}
