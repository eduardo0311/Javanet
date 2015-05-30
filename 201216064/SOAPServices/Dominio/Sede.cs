using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace SOAPServices.Dominio
{
    [DataContract]
    public class Sede
    {
        [DataMember]
        public int Codigo { get; set; }

        [DataMember]
        public string Nombre { get; set; }
       
    }
}