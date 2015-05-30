using JavaNetServices.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace JavaNetServices
{
    
    [ServiceContract]
    public interface IGestionarSolicitud
    {
        [OperationContract]
        Solicitud GenerarSolicitud(int codCliente, int codProyecto, List<SolicitudDetalle> detalleSolicitud);
    }
}
