# keycloak-user-information
maven repository


## Description
* Jerseyのアプリケーションでユーザ情報を取得する
* ドメイン層にはUserInformationクラスを使用（MongoDBでUserInformationのドキュメントをネストできます）
* レスポンスにはUserInformationResクラスを使用

## Usage
```
@Path("subjects")
public class SubjectResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BffSubjectRes> getSubjectList(@BeanParam @Valid UserInformationReq userInformationReq) {
        return null;
    }
}
```

## Version
> 1.0