package com.EasyHome.taskmanager.commons.constants;

public interface IEndpointUserApi {

    String BASE_URL = "/managerProducts/api/client";

    String CREATE_CLIENT = "/createClient";

    String GET_CLIENT_INFO = "/getClient/{idClient}";

    String GET_CLIENTS = "/getClients";

    String UPDATE_CLIENT = "/updateClient";

    String DELETE_CLIENT = "/deleteClient";
}
