using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace RESTServices.Dominio
{
    [DataContract]
    public class Consultor
    {
        
        [DataMember]
        public string Codigo { get; set; }

        [DataMember]
        public string Nombre { get; set; }

        [DataMember]
        public string Apellido { get; set; }

        [DataMember]
        public string Especialidad { get; set; }

        [DataMember]
        public string Categoria { get; set; }
    }
}