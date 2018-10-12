package miyakawalab.tool.user.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import miyakawalab.tool.user.domain.UserInformation;
import miyakawalab.tool.user.util.StringCodeUtil;

import javax.validation.constraints.NotNull;
import javax.ws.rs.HeaderParam;
import java.nio.charset.StandardCharsets;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInformationReq {
    @HeaderParam("oidc_claim_preferred_username")
    @NotNull
    private String userId;
    @HeaderParam("oidc_claim_given_name")
    @NotNull
    private String firstName;
    @HeaderParam("oidc_claim_family_name")
    @NotNull
    private String lastName;

    public String getUserId() {
        return StringCodeUtil.encode(this.userId, StandardCharsets.ISO_8859_1, StandardCharsets.UTF_8);
    }

    public String getFirstName() {
        return StringCodeUtil.encode(this.firstName, StandardCharsets.ISO_8859_1, StandardCharsets.UTF_8);
    }

    public String getLastName() {
        return StringCodeUtil.encode(this.lastName, StandardCharsets.ISO_8859_1, StandardCharsets.UTF_8);
    }

    public UserInformation toUserInformation() {
        return new UserInformation(this.getUserId(), this.getFirstName(), this.getLastName());
    }

    public UserInformationRes toUserInformationRes() {
        return new UserInformationRes(this.getUserId(), this.getFirstName(), this.getLastName());
    }
}
