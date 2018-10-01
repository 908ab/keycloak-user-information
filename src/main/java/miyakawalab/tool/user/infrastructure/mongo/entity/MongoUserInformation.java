package miyakawalab.tool.user.infrastructure.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miyakawalab.tool.mongo.entity.DocumentConvertible;
import miyakawalab.tool.user.domain.UserInformation;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MongoUserInformation implements DocumentConvertible {
    private String userId;
    private String firstName;
    private String lastName;

    public UserInformation toDomain() {
        return new UserInformation(this.userId, this.firstName, this.lastName);
    }

    public static MongoUserInformation fromDomain(UserInformation userInformation) {
        return new MongoUserInformation(
            userInformation.getUserId(),
            userInformation.getFirstName(),
            userInformation.getLastName()
        );
    }
}
