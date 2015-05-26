using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace JavaNetServices.Dominio
{
    [DataContract]
    public class Tecnologia
    {
        [DataMember]
        public int CodTecnologia { get; set; }
        [DataMember]
        public string NombreTecnologia { get; set; }
    }
}