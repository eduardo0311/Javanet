using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace JavaNetServices.Dominio
{
    [DataContract]
    public class Perfil
    {
        [DataMember]
        public int CodPerfil { get; set; }
        [DataMember]
        public string NombrePerfil { get; set; }
    }
}