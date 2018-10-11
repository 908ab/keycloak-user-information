package miyakawalab.tool.user.base;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.util.ArrayList;
import java.util.List;

public interface UserInformationInterface {
    String getUserId();
    String getFirstName();
    String getLastName();

    default List<Header> toHeaders() {
        List<Header> headers = new ArrayList<>();
        headers.add(new BasicHeader("oidc_claim_preferred_username", this.getUserId()));
        headers.add(new BasicHeader("oidc_claim_given_name", this.getFirstName()));
        headers.add(new BasicHeader("oidc_claim_family_name", this.getLastName()));
        return headers;
    }
}
