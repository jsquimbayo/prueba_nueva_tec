package com.EasyHome.taskmanager.commons.constants;

public interface ResponseMassage {

    String CREATE_SUCCESS = "OK. Se creo correctamente";

    String GET_SUCCESS= "OK. Se encontraron los elementos";

    String UPDATE_SUCCESS = "Bad Request. actualizo correctamente";

    String DELETE_SUCCESS = "Se elimino correctamente";

    String CREATE_FAIL = "No se creo correctamente";

    String GET_FAIL= "No Se encontraron los elementos";

    String UPDATE_FAIL = "No se actualizo correctamente";

    String DELETE_FAIL = "No se elimino correctamente";

    String NO_IDENTIFICATION = "error al validar credeciales, revise los datos e intente nuevamente";

    String INTERNAL_SERVER = "Internal Server error. Error inesperado del sistema";
}
