package miyakawalab.tool.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miyakawalab.tool.user.base.UserInformationInterface;
import miyakawalab.tool.user.domain.UserInformation;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInformationRes implements UserInformationInterface {
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

    public UserInformation toUserInformation() {
        return new UserInformation(this.userId, this.firstName, this.lastName);
    }
}
