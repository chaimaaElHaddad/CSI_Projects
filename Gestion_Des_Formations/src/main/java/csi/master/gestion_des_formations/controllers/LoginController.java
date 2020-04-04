package csi.master.gestion_des_formations.controllers;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class LoginController {
	

    private static String authorizationRequestBaseUri= "oauth2/authorize-client";
    Map<String, String> oauth2AuthenticationUrls= new HashMap<>();
 
    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;
    
    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;
	
    @GetMapping("/oauth_login")
	public ModelAndView getLoginPage(Model model) {	
    	 Iterable<ClientRegistration> clientRegistrations = null;
    	    ResolvableType type = ResolvableType.forInstance(clientRegistrationRepository)
    	      .as(Iterable.class);
    	    if (type != ResolvableType.NONE && 
    	      ClientRegistration.class.isAssignableFrom(type.resolveGenerics()[0])) {
    	        clientRegistrations = (Iterable<ClientRegistration>) clientRegistrationRepository;
    	    }
    	 
    	    clientRegistrations.forEach(registration -> 
    	      oauth2AuthenticationUrls.put(registration.getClientName(), 
    	      authorizationRequestBaseUri + "/" + registration.getRegistrationId()));
    	    model.addAttribute("urls", oauth2AuthenticationUrls);
	    
		return new ModelAndView("oauth_login");
	}
    
    
    
    
    @GetMapping("/loginSuccess")
    public ModelAndView getLoginInfo(Model model, OAuth2AuthenticationToken authentication) {

        OAuth2AuthorizedClient client = authorizedClientService.loadAuthorizedClient(authentication.getAuthorizedClientRegistrationId(), authentication.getName());

        String userInfoEndpointUri = client.getClientRegistration()
            .getProviderDetails()
            .getUserInfoEndpoint()
            .getUri();

        if (!StringUtils.isEmpty(userInfoEndpointUri)) {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + client.getAccessToken()
                .getTokenValue());

            HttpEntity<String> entity = new HttpEntity<String>("", headers);

            ResponseEntity<Map> response = restTemplate.exchange(userInfoEndpointUri, HttpMethod.GET, entity, Map.class);
            Map userAttributes = response.getBody();
            model.addAttribute("name", userAttributes.get("name"));
            model.addAttribute("email", userAttributes.get("email"));
            model.addAttribute("photo", userAttributes.get("picture"));
        }

        return new ModelAndView("loginSuccess");
    }

}
