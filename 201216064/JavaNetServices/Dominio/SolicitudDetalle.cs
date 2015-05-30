using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace JavaNetServices.Dominio
{
    [DataContract]
    public class SolicitudDetalle
    {
        [DataMember]
        public int Codigo { get; set; }
        [DataMember]
      
        public int CantidadColabor { get; set; }
        [DataMember]
        public Perfil Perfil { get; set; }
        [DataMember]
        public Tecnologia Tecnologia { get; set; }
        [DataMember]
        public ExperienciaRubro ExperienciaRubro { get; set; }
        [DataMember]
        public string Comentario { get; set; }
    }
}