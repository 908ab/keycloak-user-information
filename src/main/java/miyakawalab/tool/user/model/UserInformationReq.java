package miyakawalab.tool.user.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import miyakawalab.tool.user.base.UserInformationInterface;
import miyakawalab.tool.user.domain.UserInformation;

import javax.validation.constraints.NotNull;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.InternalServerErrorException;
import java.io.UnsupportedEncodingException;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInformationReq implements UserInformationInterface {
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
        return encode(this.userId);
    }

    public String getFirstName() {
        return encode(this.firstName);
    }

    public String getLastName() {
        return encode(this.lastName);
    }

    public UserInformation toUserInformation() {
        return new UserInformation(this.getUserId(), this.getFirstName(), this.getLastName());
    }

    public UserInformationRes toUserInformationRes() {
        return new UserInformationRes(this.getUserId(), this.getFirstName(), this.getLastName());
    }

    private static String encode(String str) {
        try {
            byte[] bytes = str.getBytes("ISO_8859-1");
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new InternalServerErrorException("can't encoding from ISO_8859-1 to UTF-8.");
        }
    }
}
