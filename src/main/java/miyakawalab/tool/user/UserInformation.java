package miyakawalab.tool.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miyakawalab.tool.mongo.domain.DocumentConvertible;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInformation implements DocumentConvertible {
    private String userId;
    private String firstName;
    private String lastName;
}
