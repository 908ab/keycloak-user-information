package miyakawalab.tool.user.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miyakawalab.tool.user.base.UserInformationInterface;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInformation implements UserInformationInterface {
    private String userId;
    private String firstName;
    private String lastName;
}
