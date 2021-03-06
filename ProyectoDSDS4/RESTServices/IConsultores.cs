﻿using RESTServices.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace RESTServices
{
   
    [ServiceContract]
    public interface IConsultores
    {

        [OperationContract]
        [WebInvoke(Method = "POST", UriTemplate = "Consultores", ResponseFormat = WebMessageFormat.Json)]
        Consultor CrearConsultor(Consultor consultorACrear);
        
        [OperationContract]
        [WebInvoke(Method = "GET", UriTemplate = "Consultores/{codigo}", ResponseFormat = WebMessageFormat.Json)]
        Consultor ObtenerConsultor(String codigo);

        [OperationContract]
        [WebInvoke(Method = "PUT", UriTemplate = "Consultores", ResponseFormat = WebMessageFormat.Json)]
        Consultor ModificarConsultor(Consultor consultorAModificar);

        [OperationContract]
        [WebInvoke(Method = "DELETE", UriTemplate = "Consultores", ResponseFormat = WebMessageFormat.Json)]
        void EliminarConsultor(Consultor consultorAEliminar);
        
        [OperationContract]
        List<Consultor> ListarConsultores();

               
    }
}
