using SOAPServices.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace SOAPServices
{

    [ServiceContract]
    public interface IAsesores
    {
        [OperationContract]
        Asesor CrearAesor(string nombre, string correo, int sede);

        [OperationContract]
        Asesor ObtenerAesor(int codigo);

        [OperationContract]
        Asesor ModificarAesor(int codigo, string nombre, string correo, int sede);

        [OperationContract]
        void EliminarAsesor(int codigo);

        [OperationContract]
        List<Asesor> ListarAsesores();
    }
}
