package miyakawalab.tool.user.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInformation {
    private String userId;
    private String firstName;
    private String lastName;
}
