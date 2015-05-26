using JavaNetServices.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace JavaNetServices
{
    [ServiceContract]
    public interface ISolicitudes
    {

        [OperationContract]
        Solicitud CrearSolicitud(int codProyecto);

        [OperationContract]
        SolicitudDetalle CrearSolicitudDetalle(int codigo, int cantidadColabor, int codPerfil, int codTecnologia, int codExperienciaRubro, string comentario);

        [OperationContract]
        Solicitud ObtenerSolicitud(int codigo);

        [OperationContract]
        Solicitud ModificarSolicitud(int codigo, int codProyecto, int cantidadColabor, int codPerfil, int codTecnologia, int codExperienciaRubro, string comentario);

        [OperationContract]
        void EliminarSolicitud(int codigo);

        [OperationContract]
        List<Solicitud> ListarSolicitudes();
        
    }

}
