package miyakawalab.tool.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInformationRes {
    private String userId;
    private String firstName;
    private String lastName;

    public static UserInformationRes valueOf(UserInformation userInformation) {
        return new UserInformationRes(
            userInformation.getUserId(),
            userInformation.getFirstName(),
            userInformation.getLastName()
        );
    }
}
