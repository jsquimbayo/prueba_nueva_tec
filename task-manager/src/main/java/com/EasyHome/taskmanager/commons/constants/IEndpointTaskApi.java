package com.EasyHome.taskmanager.commons.constants;

public interface IEndpointTaskApi {

    String BASE_URL = "/managerTask/api/ts";

    String CREATE_PRODUCT = "/createProduct";

    String GET_PRODUCTS = "/getProducts";

    String GET_PRODUCT_INFO ="/getProduct/{idProduct}";

    String UPDATE_PRODUCT_CODE_PRODUCT = "/updateProduct";

    String DELETE_PRODUCT_CODE_PRODUCT = "/deleteProduct/{codProduct}";

}
