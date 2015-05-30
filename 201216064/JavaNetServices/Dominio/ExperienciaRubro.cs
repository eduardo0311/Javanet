using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace JavaNetServices.Dominio
{
    [DataContract]
    public class ExperienciaRubro
    {
        [DataMember]
        public int CodExperiencia { get; set; }
        [DataMember]
        public string NombreExperiencia { get; set; }
    }
}