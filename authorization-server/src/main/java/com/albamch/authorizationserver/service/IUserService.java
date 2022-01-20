package com.albamch.authorizationserver.service;

import com.albamch.modelscommons.models.users.User;

public interface IUserService {

    User findByUsername (String name);

}
