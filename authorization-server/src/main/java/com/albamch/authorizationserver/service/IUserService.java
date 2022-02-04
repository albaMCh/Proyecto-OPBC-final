package com.albamch.authorizationserver.service;

import com.albamch.modelcommons.models.users.User;

public interface IUserService {

    User findByUsername (String name);

}
