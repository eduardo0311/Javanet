using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace JavaNetServices.Dominio
{
    [DataContract]
    public class Proyecto
    {
        [DataMember]
        public int CodProyecto { get; set; }
        [DataMember]
        public string NombreProyecto { get; set; }
        [DataMember]
        public Cliente Cliente { get; set; }
        
    }
}