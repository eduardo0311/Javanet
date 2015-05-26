using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace JavaNetServices.Dominio
{
    [DataContract]
    public class Solicitud
    {
        [DataMember]
        public int Codigo { get; set; }
        [DataMember]
        public Proyecto Proyecto { get; set; }

        [DataMember]
        public List<SolicitudDetalle> detalle { get; set; }
      
    }
}