package miyakawalab.tool.user.infrastructure.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miyakawalab.tool.user.domain.UserInformation;
import miyakawalab.tool.user.util.StringCodeUtil;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiUserInformation {
    private String userId;
    private String firstName;
    private String lastName;

    public List<Header> toHeaders() {
        List<Header> headers = new ArrayList<>();
        headers.add(new BasicHeader("oidc_claim_preferred_username", this.userId));
        headers.add(new BasicHeader("oidc_claim_given_name", this.firstName));
        headers.add(new BasicHeader("oidc_claim_family_name", this.lastName));
        return headers;
    }

    public UserInformation toDomain() {
        return new UserInformation(this.userId, this.firstName, this.lastName);
    }

    public static ApiUserInformation fromDomain(UserInformation userInformation) {
        return new ApiUserInformation(
            StringCodeUtil.encode(userInformation.getUserId(), StandardCharsets.UTF_8, StandardCharsets.ISO_8859_1),
            StringCodeUtil.encode(userInformation.getFirstName(), StandardCharsets.UTF_8, StandardCharsets.ISO_8859_1),
            StringCodeUtil.encode(userInformation.getLastName(), StandardCharsets.UTF_8, StandardCharsets.ISO_8859_1)
        );
    }
}
