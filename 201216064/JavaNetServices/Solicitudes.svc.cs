using JavaNetServices.Dominio;
using JavaNetServices.Persistencia;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace JavaNetServices
{
   
    public class Solicitudes : ISolicitudes
    {
    
        private SolicitudDAO solicitudDAO = null;
        private SolicitudDAO SolicitudDAO {
            get
                {
                    if (solicitudDAO == null)
                        solicitudDAO = new Persistencia.SolicitudDAO();
                    return solicitudDAO;
                }
         }

        private SolicitudDetalleDAO solicitudDetalleDAO = null;
        private SolicitudDetalleDAO SolicitudDetalleDAO
        {
            get
            {
                if (solicitudDetalleDAO == null)
                    solicitudDetalleDAO = new Persistencia.SolicitudDetalleDAO();
                return solicitudDetalleDAO;
            }
        }

        private ProyectoDAO proyectoDAO = null;
        private ProyectoDAO ProyectoDAO
        {
        
            get
            {
                if (proyectoDAO == null)
                    proyectoDAO = new Persistencia.ProyectoDAO();
                return proyectoDAO;
            }
        }

        private PerfilDAO perfilDAO = null;
        private PerfilDAO PerfilDAO
        {
            get
            {
                if (perfilDAO == null)
                    perfilDAO = new Persistencia.PerfilDAO();
                return perfilDAO;
            }
        }

        private TecnologiaDAO tecnologiaDAO = null;
        private TecnologiaDAO TecnologiaDAO
        {
            get
            {
                if (tecnologiaDAO == null)
                    tecnologiaDAO = new Persistencia.TecnologiaDAO();
                return tecnologiaDAO;
            }
        }

        private ExperienciaDAO experienciaDAO = null;
        private ExperienciaDAO ExperienciaDAO
        {
            get
            {
                if (experienciaDAO == null)
                    experienciaDAO = new Persistencia.ExperienciaDAO();
                return experienciaDAO;
            }
        }

        public Solicitud CrearSolicitud(int codProyecto)
        {
            Proyecto proyectoExistente = ProyectoDAO.Obtener(codProyecto);
           
            Solicitud solicitudACrear = new Solicitud()
            {
                Proyecto = proyectoExistente,
                
            };
            return SolicitudDAO.Crear(solicitudACrear);
        }

        public SolicitudDetalle CrearSolicitudDetalle(int codigo, int cantidadColabor, int codPerfil, int codTecnologia, int codExperienciaRubro, string comentario)
        {
            Perfil perfilExistente = PerfilDAO.Obtener(codPerfil);
            Tecnologia tecnologiaExistente = TecnologiaDAO.Obtener(codTecnologia);
            ExperienciaRubro experienciaExistente = ExperienciaDAO.Obtener(codExperienciaRubro);
            SolicitudDetalle solicitudDetalleACrear = new SolicitudDetalle()
            {
                Codigo = codigo,
                CantidadColabor = cantidadColabor,
                Perfil = perfilExistente,
                Tecnologia = tecnologiaExistente,
                ExperienciaRubro = experienciaExistente,
                Comentario = comentario
            };
            return SolicitudDetalleDAO.Crear(solicitudDetalleACrear);

        }
        public Solicitud ObtenerSolicitud(int codigo)
        {
            return SolicitudDAO.Obtener(codigo);
        }

        public Solicitud ModificarSolicitud(int codigo, int codProyecto, int cantidadColabor, int codPerfil, int codTecnologia, int codExperienciaRubro, string comentario)
        {
            
            Proyecto proyectoExistente = ProyectoDAO.Obtener(codProyecto);
            Perfil perfilExistente = PerfilDAO.Obtener(codPerfil);
            Tecnologia tecnologiaExistente = TecnologiaDAO.Obtener(codTecnologia);
            ExperienciaRubro experienciaExistente = ExperienciaDAO.Obtener(codExperienciaRubro);
            Solicitud solicitudAModificar = new Solicitud()
            {
                Codigo = codigo,
                Proyecto = proyectoExistente,
              
            };
            return SolicitudDAO.Modificar(solicitudAModificar);
        }

        public void EliminarSolicitud(int codigo)
        {
            Solicitud solicitudExistente = SolicitudDAO.Obtener(codigo);
            SolicitudDAO.Eliminar(solicitudExistente);

        }

        public List<Solicitud> ListarSolicitudes()
        {
            return SolicitudDAO.ListarTodos().ToList();
        }

    }
}
 