package csi.master.gestion_des_formations.services.impl;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import csi.master.gestion_des_formations.services.SecurityServiceI;

@Service
public class SecurityServiceImpl implements SecurityServiceI{


    @Override
    public String findLoggedInUsername() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof UserDetails) {
            return ((UserDetails)userDetails).getUsername();
        }

        return null;
    }

}
