package com.ysh.auth.controller;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Irving on 2014/11/24.
 * OAuth2 客户端实现
 */
@Controller
@RequestMapping("/client")
public class ClientController {

    private static Logger logger = LoggerFactory.getLogger(ClientController.class);


    /*
        grant_type：表示使用的授权模式，必选项，此处的值固定为"authorization_code"
        code：表示上一步获得的授权码，必选项。
        redirect_uri：表示重定向URI，必选项，且必须与A步骤中的该参数值保持一致
        client_id：表示客户端ID，必选项
    */
    /**
     * 获得令牌
     * @return oauth_callback?code=1234
     */
    @RequestMapping(value = "/oauth_callback" ,method = RequestMethod.GET)
    public String getToken(HttpServletRequest request,Model model) throws Exception {
    	System.out.println("into oauth_callback");
    	return "success";
       /* OAuthAuthzResponse oauthAuthzResponse = null;
        try {
            oauthAuthzResponse = OAuthAuthzResponse.oauthCodeAuthzResponse(request);
            String code = oauthAuthzResponse.getCode();
            OAuthClientRequest oauthClientRequest = OAuthClientRequest
                                                    .tokenLocation(ConstantKey.OAUTH_CLIENT_ACCESS_TOKEN)
                                                    .setGrantType(GrantType.AUTHORIZATION_CODE)
                                                    .setClientId(ConstantKey.OAUTH_CLIENT_ID)
                                                    .setClientSecret(ConstantKey.OAUTH_CLIENT_SECRET)
                                                    .setRedirectURI(ConstantKey.OAUTH_CLIENT_CALLBACK)
                                                    .setCode(code)
                                                    .buildQueryMessage();
            OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());

            //Facebook is not fully compatible with OAuth 2.0 draft 10, access token response is
            //application/x-www-form-urlencoded, not json encoded so we use dedicated response class for that
            //Custom response classes are an easy way to deal with oauth providers that introduce modifications to
            //OAuth 2.0 specification

            //获取access token
            OAuthJSONAccessTokenResponse oAuthResponse = oAuthClient.accessToken(oauthClientRequest, OAuth.HttpMethod.POST);
            String accessToken = oAuthResponse.getAccessToken();
            String refreshToken= oAuthResponse.getRefreshToken();
            Long expiresIn = oAuthResponse.getExpiresIn();
            //获得资源服务
            OAuthClientRequest bearerClientRequest = new OAuthBearerClientRequest(ConstantKey.OAUTH_CLIENT_GET_RESOURCE)
                                                     .setAccessToken(accessToken).buildQueryMessage();
            OAuthResourceResponse resourceResponse = oAuthClient.resource(bearerClientRequest, OAuth.HttpMethod.GET, OAuthResourceResponse.class);
            String resBody = resourceResponse.getBody();
            logger.info("accessToken: "+accessToken +" refreshToken: "+refreshToken +" expiresIn: "+expiresIn +" resBody: "+resBody);
            model.addAttribute("accessToken",  "accessToken: "+accessToken + " resBody: "+resBody);
            return "oauth2/token";
        } catch (OAuthSystemException ex) {
            logger.error("getToken OAuthSystemException : " + ex.getMessage());
            model.addAttribute("errorMsg",  ex.getMessage());
            return  "/oauth2/error";
        }*/
    }

    /*
    @RequestMapping(value = "/oauth2_login" ,method = RequestMethod.POST)
    public String oauth2_login(String returnUrl) {
        //获得令牌
        logger.info("LoginController oauth2_login ");
        return "oauth2/login";
    }
    */
}
