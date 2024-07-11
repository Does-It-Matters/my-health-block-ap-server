//package com.example.myhealthblock.api.healthdata.specific;
//
///**
// * <pre>
// * io.codef.easycodef
// *   |_ EasyCodefProperties.java
// * </pre>
// *
// * Desc : 코드에프의 쉬운 사용을 위한 프로퍼티 클래스
// * @Company : ©CODEF corp.
// * @Author  : notfound404@codef.io
// * @Date    : Jun 26, 2020 3:36:51 PM
// */
//public class EasyCodefProperties {
//
//    //	데모 엑세스 토큰 발급을 위한 클라이언트 아이디
//    private String demoClientId 	= "b1b4bb49-08ff-49dc-b100-32cea483eefc";
//
//    //	데모 엑세스 토큰 발급을 위한 클라이언트 시크릿
//    private String demoClientSecret 	= "8786768b-0568-4f5c-aee6-830bb5ab7f33";
//
//    //	OAUTH2.0 데모 토큰
//    private String demoAccessToken = "";
//
//    //	정식 엑세스 토큰 발급을 위한 클라이언트 아이디
//    private String clientId 	= "";
//
//    //	정식 엑세스 토큰 발급을 위한 클라이언트 시크릿
//    private String clientSecret 	= "";
//
//    //	OAUTH2.0 토큰
//    private String accessToken = "";
//
//    //	RSA암호화를 위한 퍼블릭키
//    private String publicKey 	= "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsawBL3wTTzEcuwKOErR0CDcfj0UPvS/611KguADoL3vbUz3k7Rhf8cT2L0iRUAwOnM8IVNX40vi2K13oJRR1PAd5ibvjxrTSNfnHibmoULPIC08ZBPG/REhxve+BSi7YX+DF+FR6dskvKV5F+VE+OKz5di2GFbiYGMHxQd4Ar3x8BHFYE2JdG74KNKfmmjeQlWa//pVYGowbND1sywUsIZvKg68SKeP28VeYVCybmRyBzhY3OYjQzpOtwZH5r4y4XpwTn9+dZ5zNhEOx+il3YpJkzrGowbYNI7cSCNLTATZKTgXr2sFImwJNCne5d3kejZzHj5x0ewNkT6rpfv9MKwIDAQAB\n";
//
//
//    /**
//     * Desc : 정식서버 사용을 위한 클라이언트 정보 설정
//     * @Company : ©CODEF corp.
//     * @Author  : notfound404@codef.io
//     * @Date    : Jun 26, 2020 3:37:02 PM
//     * @param clientId
//     * @param clientSecret
//     */
//    public void setClientInfo(String clientId, String clientSecret) {
//        this.clientId = clientId;
//        this.clientSecret = clientSecret;
//    }
//
//    /**
//     * Desc : 데모서버 사용을 위한 클라이언트 정보 설정
//     * @Company : ©CODEF corp.
//     * @Author  : notfound404@codef.io
//     * @Date    : Jun 26, 2020 3:37:10 PM
//     * @param demoClientId
//     * @param demoClientSecret
//     */
//    public void setClientInfoForDemo(String demoClientId, String demoClientSecret) {
//        this.demoClientId = demoClientId;
//        this.demoClientSecret = demoClientSecret;
//    }
//
//    /**
//     * Desc : 데모 클라이언트 아이디 반환
//     * @Company : ©CODEF corp.
//     * @Author  : notfound404@codef.io
//     * @Date    : Jun 26, 2020 3:37:17 PM
//     * @return
//     */
//    public String getDemoClientId() {
//        return demoClientId;
//    }
//
//    /**
//     * Desc : 데모 클라이언트 시크릿 반환
//     * @Company : ©CODEF corp.
//     * @Author  : notfound404@codef.io
//     * @Date    : Jun 26, 2020 3:37:23 PM
//     * @return
//     */
//    public String getDemoClientSecret() {
//        return demoClientSecret;
//    }
//
//    /**
//     * Desc : 데모 접속 토큰 반환
//     * @Company : ©CODEF corp.
//     * @Author  : notfound404@codef.io
//     * @Date    : Jun 26, 2020 3:37:30 PM
//     * @return
//     */
//    public String getDemoAccessToken() {
//        return demoAccessToken;
//    }
//
//    /**
//     * Desc : 데모 클라이언트 시크릿 반환
//     * @Company : ©CODEF corp.
//     * @Author  : notfound404@codef.io
//     * @Date    : Jun 26, 2020 3:37:36 PM
//     * @Version : 1.0.1
//     * @return
//     */
//    public String getClientId() {
//        return clientId;
//    }
//
//    /**
//     * Desc : API 클라이언트 시크릿 반환
//     * @Company : ©CODEF corp.
//     * @Author  : notfound404@codef.io
//     * @Date    : Jun 26, 2020 3:37:44 PM
//     * @return
//     */
//    public String getClientSecret() {
//        return clientSecret;
//    }
//
//    /**
//     * Desc : API 접속 토큰 반환
//     * @Company : ©CODEF corp.
//     * @Author  : notfound404@codef.io
//     * @Date    : Jun 26, 2020 3:37:50 PM
//     * @Version : 1.0.1
//     * @return
//     */
//    public String getAccessToken() {
//        return accessToken;
//    }
//
//    /**
//     * Desc : RSA암호화를 위한 퍼블릭키 반환
//     * @Company : ©CODEF corp.
//     * @Author  : notfound404@codef.io
//     * @Date    : Jun 26, 2020 3:37:59 PM
//     * @return
//     */
//    public String getPublicKey() {
//        return publicKey;
//    }
//
//    /**
//     * Desc : RSA암호화를 위한 퍼블릭키 설정
//     * @Company : ©CODEF corp.
//     * @Author  : notfound404@codef.io
//     * @Date    : Jun 26, 2020 3:38:07 PM
//     * @Version : 1.0.1
//     * @param publicKey
//     */
//    public void setPublicKey(String publicKey) {
//        this.publicKey = publicKey;
//    }
//
//    /**
//     * Desc : 데모 접속 토큰 설정
//     * @Company : ©CODEF corp.
//     * @Author  : notfound404@codef.io
//     * @Date    : Jun 26, 2020 3:38:14 PM
//     * @param demoAccessToken
//     */
//    public void setDemoAccessToken(String demoAccessToken) {
//        this.demoAccessToken = demoAccessToken;
//    }
//
//    /**
//     * Desc : API 접속 토큰 설정
//     * @Company : ©CODEF corp.
//     * @Author  : notfound404@codef.io
//     * @Date    : Jun 26, 2020 3:38:21 PM
//     * @param accessToken
//     */
//    public void setAccessToken(String accessToken) {
//        this.accessToken = accessToken;
//    }
//
//
//}
