using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using RESTServices.Dominio;
using RESTServices.Persistencia;

namespace RESTServices
{
    public class Consultores : IConsultores
    {
        private ConsultorDAO dao = new ConsultorDAO();

        public Consultor CrearConsultor(Consultor consultorACrear)
        {
            return dao.Crear(consultorACrear);
        }

        public Consultor ObtenerConsultor(string codigo)
        {
            return dao.Obtener(codigo);  
        }

        public Consultor ModificarConsultor(Consultor consultorAModificar)
        {
            return dao.Modificar(consultorAModificar);
        }

        public void EliminarConsultor(Consultor consultorAEliminar)
        {
            dao.Eliminar(consultorAEliminar);
        }

        public List<Consultor> ListarConsultores()
        {
            return null;

        }
    }
}
