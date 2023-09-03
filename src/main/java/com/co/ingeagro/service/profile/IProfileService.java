package com.co.ingeagro.service.profile;

import com.co.ingeagro.model.Profile;

public interface IProfileService {

    /**
     *
     * @param userId to search the profiles
     * @return profile given criteria
     */
    Profile getProfileById(Long userId);

}
