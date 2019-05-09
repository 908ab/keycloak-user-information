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

## Install
* maven
```
<dependencies>
    <dependency>
        <groupId>miyakawalab.tool</groupId>
        <artifactId>keycloak-user-information</artifactId>
        <version>${version}</version>
    </dependency>
</dependencies>
<repositories>
    <repository>
        <id>keycloak-user-information</id>
        <url>https://raw.github.com/908ab/keycloak-user-information/mvn-repo/</url>
    </repository>
</repositories>
```

## Version
> 1.0
