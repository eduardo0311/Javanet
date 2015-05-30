using JavaNetServices.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace JavaNetServices
{
    
    public class GestionarSolicitud : IGestionarSolicitud
    {

        public Solicitud GenerarSolicitud(int codCliente, int codProyecto, List<Dominio.SolicitudDetalle> detalleSolicitud)
        {
            Solicitud solicitudACrear = new Solicitud();
            //validar estado de cliente

            //validar estado de Proyecto

            //crear solicitud
            //obtener solicitud

            //crear detalle de solicitud

            return solicitudACrear;
        }
    }
}
