using SOAPServices.Dominio;
using SOAPServices.Persistencia;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace SOAPServices
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "Asesores" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select Asesores.svc or Asesores.svc.cs at the Solution Explorer and start debugging.
    public class Asesores : IAsesores
    {
        private AsesorDAO asesorDAO = null;
        private AsesorDAO AsesorDAO {
          get
            {
             if (asesorDAO == null)
                 asesorDAO = new Persistencia.AsesorDAO();
                return asesorDAO;    
            }
            
        }
        private SedeDAO sedeDAO = null;
        private SedeDAO SedeDAO
            {
               get
                {
                if (sedeDAO == null)
                     sedeDAO = new Persistencia.SedeDAO();
                    return sedeDAO;    
                }
            }

        public Asesor CrearAesor(string nombre, string correo, int sede)
        {
            Sede sedeExistente = SedeDAO.Obtener(sede);
            //Sede sedeExistente = new Sede();
            //sedeExistente.Codigo = 11;
            //sedeExistente.Nombre = "Monterrico";

            Asesor asesorACrear = new Asesor()
            {
                Nombre = nombre,
                Correo = correo,
                Sede = sedeExistente
            };
            return AsesorDAO.Crear(asesorACrear);
        }

        public Asesor ObtenerAesor(int codigo)
        {
            return AsesorDAO.Obtener(codigo);
        }

        public Asesor ModificarAesor(int codigo, string nombre, string correo, int sede)
        {
            Sede sedeExistente = SedeDAO.Obtener(sede);
            Asesor asesorAModificar = new Asesor()
            {
                Codigo = codigo,
                Nombre = nombre,
                Correo = correo,
                Sede = sedeExistente
            };
            return AsesorDAO.Modificar(asesorAModificar);
        }

        public void EliminarAsesor(int codigo)
        {
            Asesor asesorExistente = AsesorDAO.Obtener(codigo);
            AsesorDAO.Eliminar(asesorExistente);
        }

        public List<Asesor> ListarAsesores()
        {
            return AsesorDAO.ListarTodos().ToList();
        }
    }
}
